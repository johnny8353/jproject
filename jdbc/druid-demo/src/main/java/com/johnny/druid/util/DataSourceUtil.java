package com.johnny.druid.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.AbstractDataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

//TODO: Auto-generated Javadoc
/**
 * The Class DataSourceUtil.
 */
public class DataSourceUtil {

	/** 使用配置文件dbconfig.properties构建Druid数据源. */
	public static final int DRUID_MYSQL_SOURCE = 0;

	/** The duird mysql source. */
	private static DataSource duirdMysqlSource;

	/** 使用配置文件dbconfig2.properties构建Druid数据源. */
	public static final int DRUID_MYSQL_SOURCE2 = 1;

	/** The druid mysql source2. */
	private static DataSource druidMysqlSource2;

	/** 使用配置文件dbconfig.properties构建Dbcp数据源. */
	public static final int DBCP_SOURCE = 4;

	/** The dbcp source. */
	private static DataSource dbcpSource;

	/**
	 * 根据类型获取数据源.
	 * 
	 * @param sourceType
	 *            数据源类型
	 * @return druid或者dbcp数据源
	 * @throws Exception
	 *             the exception
	 * @NotThreadSafe
	 */
	public static final DataSource getDataSource(int sourceType)
			throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		DataSource dataSource = null;
		switch (sourceType) {
		case DRUID_MYSQL_SOURCE:

			if (duirdMysqlSource == null) {
				duirdMysqlSource = (DataSource) ctx.getBean("dataSource");
			}
			dataSource = duirdMysqlSource;
			break;
		case DRUID_MYSQL_SOURCE2:
			if (druidMysqlSource2 == null) {
				druidMysqlSource2 = (DataSource) ctx.getBean("dataSourceDbcp");
			}
			dataSource = druidMysqlSource2;
			break;
		case DBCP_SOURCE:
			if (dbcpSource == null) {
				dbcpSource = (DataSource) ctx.getBean("dataSourceDbcp");
			}
			dataSource = dbcpSource;
			break;
		}
		return dataSource;
	}
//
//	/**
//	 * 根据数据库类型标示获取DataSource对象，跟
//	 * {@link com.whyun.util.db.DataSourceUtil#getDataSource(int)}
//	 * 不同的是，这里DataSource获取的时候使用了单体模式
//	 * 
//	 * @param sourceType
//	 *            数据源类型
//	 * @return 获取到的DataSource对象
//	 * @throws Exception
//	 *             the exception
//	 */
//	public static final DataSource getDataSource2(int sourceType)
//			throws Exception {
//
//		AbstractDataSource abstractDataSource = null;
//		switch (sourceType) {
//		case DRUID_MYSQL_SOURCE:
//			abstractDataSource = DruidSourceMysql.getInstance();
//			break;
//		case DRUID_MYSQL_SOURCE2:
//			abstractDataSource = DruidSourceMysql2.getInstance();
//			break;
//		case DBCP_SOURCE:
//			abstractDataSource = DbcpSourceMysql.getInstance();
//			break;
//		}
//		return abstractDataSource == null ? null : abstractDataSource
//				.getDataSource();
//	}
}
