package com.johnny.jdbc.jdbc4;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * Commons-dbcp.jar：连接池的实现
	Commons-pool.jar：连接池实现的依赖库
	DBCP和C3P0，都是Java开源的，都必须直接或间接实现javax.sql.DataSource接口
 * 完成日期：2016年8月10日
 * 编码作者：JohnnyHuang 黄福强
 */
public class JDBCPoolsTest {
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String JDBCURL = "jdbc:mysql://10.88.144.239:3306/test2";
	private final String USER = "mcrm";
	private final String PASSWORD = "2015_mcrm";
	
	@Test
	public void testJdbcTools() throws Exception{
		Connection connection = JDBCTools.getConnection();
		System.out.println(connection); 
	}
	
	/**.
	 * C3P0连接池需要在/WEB-INF/classes/目录下存放c3p0-config.xml文件，该类ComboPooledDataSource在创建时会自动在指定的目录下找xml文件，并加载默认设置
	 * 1. 创建 c3p0-config.xml 文件, 
	 * 参考帮助文档中 Appendix B: Configuation Files 的内容
	 * 2. 创建 ComboPooledDataSource 实例；
	 * DataSource dataSource = 
	 *			new ComboPooledDataSource("helloc3p0");  
	 * 3. 从 DataSource 实例中获取数据库连接. 
	 */
	@Test
	public void testC3poWithConfigFile() throws Exception{
		DataSource dataSource = 
				new ComboPooledDataSource("helloc3p0");  
		
		System.out.println(dataSource.getConnection()); 
		
		ComboPooledDataSource comboPooledDataSource = 
				(ComboPooledDataSource) dataSource;
		System.out.println(comboPooledDataSource.getMaxStatements()); 
	}
	
	@Test
	public void testC3P0() throws Exception{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass(DRIVER ); //loads the jdbc driver            
		cpds.setJdbcUrl( JDBCURL );
		cpds.setUser(USER);                                  
		cpds.setPassword(PASSWORD);   
		
		System.out.println(cpds.getConnection()); 
	}
	
	/**
	 * 1. 加载 dbcp 的 properties 配置文件: 配置文件中的键需要来自 BasicDataSource
	 * 的属性.
	 * 2. 调用 BasicDataSourceFactory 的 createDataSource 方法创建 DataSource
	 * 实例
	 * 3. 从 DataSource 实例中获取数据库连接. 
	 */
	@Test
	public void testDBCPWithDataSourceFactory() throws Exception{
		
		Properties properties = new Properties();
		InputStream inStream = JDBCPoolsTest.class.getClassLoader()
				.getResourceAsStream("com\\johnny\\jdbc\\jdbc4\\dbcp.properties");
		properties.load(inStream);
		
		DataSource dataSource = 
				BasicDataSourceFactory.createDataSource(properties);
		
		System.out.println(dataSource.getConnection()); 
		
//		BasicDataSource basicDataSource = 
//				(BasicDataSource) dataSource;
//		
//		System.out.println(basicDataSource.getMaxWait()); 
	}
	
	/**
	 * 使用 DBCP 数据库连接池
	 * 1. 加入 jar 包(2 个jar 包). 依赖于 Commons Pool
	 * 2. 创建数据库连接池
	 * 3. 为数据源实例指定必须的属性
	 * 4. 从数据源中获取数据库连接
	 * @throws SQLException 
	 */
	@Test
	public void testDBCP() throws SQLException{
		final BasicDataSource dataSource = new BasicDataSource();
		
		//2. 为数据源实例指定必须的属性
		dataSource.setUsername(USER);
		dataSource.setPassword(PASSWORD);
		dataSource.setUrl(JDBCURL);
		dataSource.setDriverClassName(DRIVER);
		
		//3. 指定数据源的一些可选的属性.
		//1). 指定数据库连接池中初始化连接数的个数
		dataSource.setInitialSize(5);
		
		//2). 指定最大的连接数: 同一时刻可以同时向数据库申请的连接数
		dataSource.setMaxActive(5);
		
		//3). 指定小连接数: 在数据库连接池中保存的最少的空闲连接的数量 
		dataSource.setMinIdle(2);
		
		//4).等待数据库连接池分配连接的最长时间. 单位为毫秒. 超出该时间将抛出异常. 
		dataSource.setMaxWait(1000 * 5);
		
		//4. 从数据源中获取数据库连接
		Connection connection = dataSource.getConnection();
		System.out.println(connection.getClass()); 
		
		connection = dataSource.getConnection();
		System.out.println(connection.getClass()); 
		
		connection = dataSource.getConnection();
		System.out.println(connection.getClass()); 
		
		connection = dataSource.getConnection();
		System.out.println(connection.getClass()); 
		
		Connection connection2 = dataSource.getConnection();
		System.out.println(">" + connection2.getClass()); 
		
		new Thread(){
			public void run() {
				Connection conn;
				try {
					conn = dataSource.getConnection();
					System.out.println(conn.getClass()); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			};
		}.start();
		
		try {
			Thread.sleep(5500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		connection2.close();
	}
	
}
