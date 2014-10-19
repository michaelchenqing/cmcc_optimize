/**  
 * SpringBeanContext.java
 * com.cmcc.optimize.dataaccess.spring
 * 
 * @author gaoqs
 * @date 2014年6月25日 下午1:50:12
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.spring;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.cas.common.io.FileUtils;

import com.cmcc.log4j.CmccLogger;

/**
 * 加载spring的ibatis及bean配置，提供bean获取
 * 
 * @author gaoqs
 * @date 2014年6月25日 下午1:50:12
 */

public class SpringBeanContext {

	private static ApplicationContext context;// spring ibatis上下文

	private static final CmccLogger logger = CmccLogger
			.getLogger(SpringBeanContext.class);// 日志

	private static final SpringBeanContext instance = new SpringBeanContext();// 单例对象

	/**
	 * 单例构造函数
	 */
	private SpringBeanContext() {
	}

	static {
		if (StringUtils.isBlank(System.getProperty("db.driverClassName"))) {
			// 需要加载默认的spring.properties文件
			InputStream input = null;
			try {
				input = FileUtils
						.getRealInputStream("default-spring.properties");
				if (input != null) {
					System.getProperties().load(input);
					if (logger.isInfoEnabled()) {
						logger.info("use dbconfig to link : ${db.url}="
								+ System.getProperty("db.url")
								+ ",${db.username}="
								+ System.getProperty("db.username"));
					}
				} else if (logger.isInfoEnabled()) {
					logger.info("no default-spring.properties ,${db.driverClassName} not found in System.properties,maybe not set db config now ");
				}
			} catch (IOException e) {
				logger.error("加载spring.properties文件出错：", e);
				logger.notice("加载spring.properties文件出错："+",exception:"+ e);
				
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						logger.error("关闭spring.properties文件流失败", e);
					}
				}
			}
		}

		// 加载spring ibatis相关的xml，构建spring上下文
		context = new ClassPathXmlApplicationContext(new String[] {
				"classpath:applicationContext.xml",
				"classpath:META-INF/spring/common-dal-dao.xml" });
	}

	/**
	 * 获取单例实例
	 * 
	 * @return
	 */
	public static SpringBeanContext getInstance() {
		return instance;
	}

	/**
	 * 获取ibatis指定的bean
	 * 
	 * @param entityClass
	 *            bean类
	 * @param beanName
	 *            　dao配置文件中的id名字
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <C> C getBean(Class<C> entityClass, String beanName) {
		if (entityClass == null || beanName == null
				|| "".equals(beanName.trim())) {
			logger.warn("bean class or bean name is empty:" + entityClass + "@"
					+ beanName);
			return null;
		}

		// 从spring中取出bean
		try {
			Object obj = context.getBean(beanName);
			if (logger.isDebugEnabled()) {
				logger.debug("get bean from spring context with class:"
						+ entityClass.getName() + ",beanName=" + beanName);
			}
			return (C) obj;
		} catch (Exception e) {
			logger.error(
					"get bean error:" + beanName + "@class:" + entityClass, e);
		}
		return null;
	}

	/**
	 * 获取数据库操作dao层父类
	 * 
	 * @return
	 */
	public SqlMapClientDaoSupport getBaseCasSqlMapClientDAO() {
		return getBean(SqlMapClientDaoSupport.class, "baseCasSqlMapClientDAO");
	}

	/**
	 * 获取数据库操作dao层工厂类
	 * 
	 * @return
	 */
	public SqlMapClientFactoryBean getSqlMapClient() {
		return getBean(SqlMapClientFactoryBean.class, "sqlMapClient");
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public BasicDataSource getDataSource() {
		return getBean(BasicDataSource.class, "dataSource");
	}

}
