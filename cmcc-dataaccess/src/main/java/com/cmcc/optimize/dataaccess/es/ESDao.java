/**  
 * ESDao.java
 * com.cmcc.optimize.dataaccess.es
 * 
 * @author gaoqs
 * @date 2014年9月1日 上午11:45:22
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.es;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.jackson.core.JsonGenerationException;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.jdom2.Document;
import org.jdom2.Element;

import cn.cas.common.io.FileUtils;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.xml.XmlFileLoader;
import com.cmcc.optimize.datamodel.signal.QueryRange;

/**
 * es同步查询操作实例dao
 * 
 * @author gaoqs
 * @param <T>
 */
public class ESDao<T> {

    Client client;// es客户端

    ESConf esConf;// es配置

    Class<T> clazz;// 数据实体

    private static final CmccLogger logger = CmccLogger.getLogger(ESDao.class);// 日志

    private static Map<String, Map<String, String>> esResultMap = new HashMap<String, Map<String, String>>();// es配置map

    static {
        // 加载es的配置
        try {
            Document ESConfigDoc = XmlFileLoader.getXmlFileDocument("elasticsearch-config.xml");

            List<Element> results = ESConfigDoc.getRootElement().getChildren("result");
            for (Element result : results) {
                List<Element> items = result.getChildren();
                Map<String, String> attrs = new HashMap<String, String>();
                for (Element item : items) {
                    attrs.put(item.getName().trim(), item.getValue().trim());
                    if (logger.isDebugEnabled()) {
                        logger.debug("es config:" + item.getName().trim() + " = " + item.getValue().trim());
                    }
                }
                esResultMap.put(result.getAttributeValue("name").trim(), attrs);
            }
        } catch (Exception e) {
            logger.error("load es config error", e);
        }
    }

    /**
     * esdao实例化
     * 
     * @param clazz 实体类
     * @param confName 配置文件中的key
     * @throws ESException
     */
    protected ESDao(Class<T> clazz, String confName) throws ESException {
        this.clazz = clazz;
        try {
            this.esConf = new ESConf(esResultMap.get(confName));
        } catch (IOException e) {
            logger.error("init es client error:" + clazz.getName() + "@" + confName, e);
        }
            

        Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", esConf.clusterName).build();
        List<InetSocketTransportAddress> addresses = new ArrayList<InetSocketTransportAddress>();
        for (Entry<String, Integer> entry : esConf.connectAddress.entrySet()) {
            addresses.add(new InetSocketTransportAddress(entry.getKey(), entry.getValue()));
        }
        client = new TransportClient(settings).addTransportAddresses(addresses.toArray(new InetSocketTransportAddress[0]));

        IndicesExistsResponse existRespond = client.admin().indices().prepareExists(esConf.indice).execute().actionGet();
        if (!existRespond.isExists()) {
            client.admin().indices().prepareCreate(esConf.indice).execute().actionGet();
        }
        client.admin().indices().preparePutMapping(esConf.indice).setType(esConf.type).setSource(esConf.mapping).execute();// .actionGet();
    }

    /**
     * 按id查询
     * 
     * @param id 索引id
     * @return
     */
    final protected T searchById(String id) {
        GetResponse respond = client.prepareGet(esConf.indice, esConf.type, id).setOperationThreaded(false).execute().actionGet();
        return new ObjectMapper().convertValue(respond.getSource(), clazz);
    }

    /**
     * 按字段完全匹配查询
     * 
     * @param querys 查询条件 key：字段名称，value：符合数据
     * @param start 分页开始
     * @param count 分页结束
     * @return
     */
    public List<T> searchByKeywords(Map<String, Object> querys, int start, int count) { // 按字段精准查询

        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(esConf.indice);
        searchRequestBuilder.setPreference(esConf.indice);
        searchRequestBuilder.setTypes(esConf.type);
        searchRequestBuilder.setSearchType(SearchType.QUERY_THEN_FETCH);

        searchRequestBuilder.setFrom(start);
        searchRequestBuilder.setSize(count);

        if (querys != null && querys.size() != 0) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            for (Entry<String, Object> query : querys.entrySet()) {
                boolQueryBuilder.must(QueryBuilders.termQuery(query.getKey(), query.getValue()));
            }
            searchRequestBuilder.setQuery(boolQueryBuilder);
        }
        
        System.out.println(searchRequestBuilder.toString());
        SearchResponse respond = searchRequestBuilder.execute().actionGet();
        SearchHits hits = respond.getHits();
        List<T> res = new LinkedList<T>();
        for (SearchHit hit : hits) {
            res.add(new ObjectMapper().convertValue(hit.getSource(), clazz));
        }
        return res;
    }

    /**
     * 按字段精确统计
     * 
     * @param querys 查询条件 key：字段名称，value：符合数据
     * @return
     */
    public long countByField(Map<String, Object> querys) {

        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(esConf.indice);
        searchRequestBuilder.setPreference(esConf.indice);
        searchRequestBuilder.setTypes(esConf.type);
        searchRequestBuilder.setSearchType(SearchType.QUERY_THEN_FETCH);

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        for (Entry<String, Object> query : querys.entrySet()) {
            boolQueryBuilder.must(QueryBuilders.termQuery(query.getKey(), query.getValue()));
        }
        searchRequestBuilder.setQuery(boolQueryBuilder);
        SearchResponse respond = searchRequestBuilder.execute().actionGet();
        SearchHits hits = respond.getHits();
        return hits.getTotalHits();
    }   

    
    /**
     * 按字段精确统计
     * 
     * @param querys 查询条件 key：字段名称，value：符合数据
     * @return
     */
    public long searchCount(Map<String, Object> querys,QueryRange qRange) {
    	
    	SearchRequestBuilder searchRequestBuilder = client.prepareSearch(esConf.indice);
        searchRequestBuilder.setPreference(esConf.indice);
        searchRequestBuilder.setTypes(esConf.type);
        searchRequestBuilder.setSearchType(SearchType.QUERY_THEN_FETCH);

		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		//查询值
		if (querys != null && querys.size() != 0) {
			for (Entry<String, Object> query : querys.entrySet()) {
				boolQueryBuilder.must(QueryBuilders.termQuery(query.getKey(),
						query.getValue()));
			}
		}
		//查询范围
		if (qRange != null) {
			String timeField = qRange.getQueryField();
			String startPos = qRange.getQueryStartPos();
			String endPos = qRange.getQueryEndPos();
			boolQueryBuilder.must(QueryBuilders
					.rangeQuery(timeField.toString()).from(startPos).to(endPos)
					.includeLower(true).includeLower(false));
		}
		
		
		
        searchRequestBuilder.setQuery(boolQueryBuilder);
        SearchResponse respond = searchRequestBuilder.execute().actionGet();
        SearchHits hits = respond.getHits();
        return hits.getTotalHits();
    }
       
    /**
     * 按字段完全匹配查询
     * 
     * @param querys 查询条件 key：字段名称，value：符合数据
     * @return
     */
    public List<T> search(Map<String, Object> querys,int start, int count,String sortField,SortOrder sortOrder){        
    	return  searchApi(querys,null, start, count,sortField,sortOrder);
    }
    
    /**
     * 按范围完全匹配查询 
     * @param QueryRange 查询范围
     * @param start 分页开始
     * @param count 分页结束
     * @return
     */
    public List<T> search(QueryRange qRange, int start, int count,String sortField,SortOrder sortOrder){ 
        return  searchApi(null,qRange, start, count,sortField,sortOrder);      
    }
    /**
     * 按字段完全匹配查询
     * 
     * @param querys 查询条件 key：字段名称，value：符合数据
     * @return
     */
    public List<T> search(Map<String, Object> querys,QueryRange qRange,int start, int count,String sortField,SortOrder sortOrder){        
    	return  searchApi(querys,qRange, start, count,sortField,sortOrder);
    }
    
    //底层查询api
    public List<T> searchApi(Map<String, Object> querys,QueryRange qRange, int start, int count,String sortField,SortOrder sortOrder){
    	   SearchRequestBuilder searchRequestBuilder = client.prepareSearch(esConf.indice);
           searchRequestBuilder.setPreference(esConf.indice);
           searchRequestBuilder.setTypes(esConf.type);
           searchRequestBuilder.setSearchType(SearchType.QUERY_THEN_FETCH);

           searchRequestBuilder.setFrom(start);
           searchRequestBuilder.setSize(count);
           searchRequestBuilder.addSort(sortField,sortOrder);//排序
          /* if(sortBuilder !=null){
        	   searchRequestBuilder.addSort(sortBuilder);//排序
           }*/
           
          
           
           BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
           if (querys != null && querys.size() != 0) {            
               for (Entry<String, Object> query : querys.entrySet()) {
                   boolQueryBuilder.must(QueryBuilders.termQuery(query.getKey(), query.getValue()));
               }           
           }
           //判断是否有大小查询
           if(qRange !=null ){
           	String timeField = qRange.getQueryField();
           	String startPos =qRange.getQueryStartPos();
           	String endPos =qRange.getQueryEndPos();
           	 boolQueryBuilder.must(QueryBuilders.rangeQuery(timeField.toString()).from(startPos).to(endPos).includeLower(true).includeLower(false));
           }       	
                  
           searchRequestBuilder.setQuery(boolQueryBuilder);
           
           
            //System.out.println(searchRequestBuilder.toString());
            SearchResponse respond = searchRequestBuilder.execute().actionGet();
            SearchHits hits = respond.getHits();
            List<T> res = new LinkedList<T>();
            try{
            	 for (SearchHit hit : hits) {
                     res.add(new ObjectMapper().convertValue(hit.getSource(), clazz));
                 }
                 return res;
            }catch(Exception e){
            	return null;
            }           
    }
    
    

    /**
     * 批量插入
     * 
     * @param beans
     * @throws ESException
     */
    public void updateBulk(List<T> beans) throws ESException {
    }

    /**
     * @param data
     * @return
     * @throws ESException
     */
    protected BulkResponse bulkUpdate(Map<String, T> data) throws ESException {
        try {
            BulkRequestBuilder bulkRequest = this.client.prepareBulk();
            for (Entry<String, T> entry : data.entrySet()) {
                bulkRequest.add(this.client.prepareUpdate(esConf.indice, esConf.type, entry.getKey()).setDoc(new ObjectMapper().writeValueAsString(entry.getValue())).setDocAsUpsert(true));
            }
            return bulkRequest.execute().actionGet();
        } catch (JsonGenerationException e) {
            throw new ESException(e);
        } catch (JsonMappingException e) {
            throw new ESException(e);
        } catch (IOException e) {
            throw new ESException(e);
        }
    }

    /**
     * 按id删除索引
     * 
     * @param id 对象id
     * @return
     * @throws ESException
     */
    protected DeleteResponse delete(String id) throws ESException {
        return client.prepareDelete(esConf.indice, esConf.type, id).execute().actionGet();
    }

    /**
     * 批量删除索引
     * 
     * @param ids 多个id
     * @return
     * @throws ESException
     */
    protected BulkResponse bulkdelete(List<String> ids) throws ESException {
        BulkRequestBuilder bulkRequest = this.client.prepareBulk();
        for (String id : ids) {
            bulkRequest.add(this.client.prepareDelete(esConf.indice, esConf.type, id));
        }

        return bulkRequest.execute().actionGet();
    }

    /**
     * es的配置类
     * 
     * @author gaoqs
     * @date 2014年9月1日 下午2:42:53
     */
    static class ESConf {
        String clusterName;// 集群名称

        String type;

        String indice;

        Map<String, Integer> connectAddress = new HashMap<String, Integer>();

        String mapping;

        /**
         * 按elasticsearch-config中的节点配置实例化es
         * 
         * @param conf es-config的配置
         * @throws IOException
         */
        ESConf(Map<String, String> conf) throws IOException {
            this.clusterName = conf.get("es-cluster");
            this.type = conf.get("es-type");
            this.indice = conf.get("es-indice");
            String connectStr = conf.get("es-connect");
            String[] hostports = connectStr.split(",");
            for (String hostport : hostports) {
                String slices[] = hostport.split(":");
                if (slices.length == 2) {
                    connectAddress.put(slices[0], Integer.parseInt(slices[1]));
                } else {
                    connectAddress.put(slices[0], 9300);
                }
            }
            String path = conf.get("es-mapping");
            mapping = getMapping(path);
        }

        String getMapping(String resourceName) throws IOException {// 获取对应的es索引映射文件
            System.out.println(resourceName);
            return FileUtils.getRealPath(resourceName);
        }
    }    
    

}

