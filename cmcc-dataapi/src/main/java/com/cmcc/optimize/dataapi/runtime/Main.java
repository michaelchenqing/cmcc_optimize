/**  
 * Main.java
 * com.cmcc.optimize.dataapi.runtime
 * 
 * @author gaoqs
 * @date 2014年6月21日 下午5:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.runtime;

import java.io.IOException;
import java.net.URI;
import java.util.Timer;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataapi.resources.AppApiResource;
import com.cmcc.optimize.dataapi.resources.ExpVolReductionResource;
import com.cmcc.optimize.dataapi.resources.GetDataService;
import com.cmcc.optimize.dataapi.resources.MockResource;
import com.cmcc.optimize.dataapi.resources.OptimizelResource;
import com.cmcc.optimize.dataapi.resources.ReportResource;
import com.cmcc.optimize.dataapi.resources.SpeedResource;
import com.cmcc.optimize.dataapi.runtime.filter.AccessHttpFilter;

/**
 * dataapi主启动类
 * 
 * @author gaoqs
 * @date 2014年6月21日 下午5:07:39
 */

public class Main {

    public static final String BASE_URI = "http://0.0.0.0:8000/";// 服务发布地址

    private final static CmccLogger logger = CmccLogger.getLogger(Main.class);// 日志

    /**
     * 启动 glassfish HTTP server，发布JAX-RS资源
     * 
     * @return glasshfish服务器对象
     */
    public static HttpServer startServer(String url) {

        /**
         * 指定JAX-RS资源配置
         */
        final ResourceConfig rc = new ResourceConfig();
        rc.packages("com.cmcc.optimize.dataapi").registerClasses(OptimizelResource.class, MockResource.class,AppApiResource.class,ReportResource.class,SpeedResource.class,ExpVolReductionResource.class);
        rc.packages("com.cmcc.optimize.dataapi.runtime.filter").registerClasses(AccessHttpFilter.class);

        /**
         * 创建reset服务
         */
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(url), rc);
    }

    /**
     * main函数，启动服务器
     * 
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = BASE_URI;

        // 通过参数指定地址和端口
        if (args.length == 2) {
            String host = args[0];
            int port = Integer.parseInt(args[1]);
            url = "http://" + host + ":" + port + "/";
        }

        final HttpServer server = startServer(url);
        //定时器
        Timer timer=new Timer();
        timer.schedule(new GetDataService(), 0, 2*60*60*1000);
        //timer.sched(new GetDataService(), 0,2*60*60*1000);
        if (logger.isDebugEnabled()) {
        	
        	
            logger.debug(String.format("Jersey app started with WADL available at " + "%sapplication.wadl", url));
        }
        Thread.currentThread().join();
        
        server.stop();
    }

}
