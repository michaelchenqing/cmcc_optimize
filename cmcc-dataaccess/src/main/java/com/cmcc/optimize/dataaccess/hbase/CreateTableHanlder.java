/**  
 * CreateTableHanlder.java
 * com.cmcc.optimize.dataaccess.hbase
 * 
 * @author gaoqs
 * @date 2014年8月18日 上午9:29:49
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.hbase;

import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.regionserver.BloomType;

import cn.cas.dps.utils.CloseUtils;

/**
 * hbase表创建辅助类
 * 
 * @author gaoqs
 * @date 2014年8月18日 上午9:29:49
 */

public class CreateTableHanlder {

    /**
     * 创建单个hbase表
     * 
     * @param table 表对像
     * @param forceDeleteIfExist 存在是否强制删除
     */
    public static void createSingleTable(HTableCreator table, boolean forceDeleteIfExist) {
        table.create(forceDeleteIfExist);
    }

    /**
     * 创建多个hbase表
     * 
     * @param tables 多个表
     * @param forceDeleteIfExist 存在是否强制删除
     */
    public static void createHbaseTables(List<HTableCreator> tables, boolean forceDeleteIfExist) {
        for (HTableCreator hTableCreator : tables) {
            hTableCreator.create(forceDeleteIfExist);
        }
    }

    /**
     * 创建表
     * 
     * @param tableName 表名
     * @param forceDeleteIfExist 存在是否强制删除
     * @param maxVersion 是否设置最大版本数为Integer.MAX_VALUE
     * @param presplit128regions 是否预先分配128个region
     */
    public static void createTable(String tableName, boolean forceDeleteIfExist, boolean maxVersion, boolean presplit128regions) {
        String[] cfs = new String[] { "a" };
        Configuration conf = HBaseConfiguration.create();
        HBaseAdmin admin = null;
        try {
            admin = new HBaseAdmin(conf);
            boolean exist = admin.tableExists(tableName);
            if (exist && forceDeleteIfExist) {
                admin.disableTable(tableName);
                admin.deleteTables(tableName);
                exist = false;
            }

            if (!exist) {
                @SuppressWarnings("deprecation")
                HTableDescriptor desc = new HTableDescriptor(tableName);
                for (String cf : cfs) {
                    HColumnDescriptor hcd = new HColumnDescriptor(cf);
                    hcd.setBloomFilterType(BloomType.ROW);
                    if (maxVersion) {// 默认的版本数为3，如果有timestamp时，需要指定
                        hcd.setMaxVersions(Integer.MAX_VALUE);
                    } else {
                        hcd.setMaxVersions(1);
                    }
                    desc.addFamily(hcd);
                }
                if (presplit128regions) {
                    admin.createTable(desc, new byte[] { 1, 0, 0, 0, 0, 0, 0, 0, 0 }, new byte[] { 127, 0, 0, 0, 0, 0, 0, 0, 0 }, 128);
                } else {
                    admin.createTable(desc);
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException("create hbase table：" + tableName + " failed", e);
        } finally {
            CloseUtils.close(admin);
        }
    }
}
