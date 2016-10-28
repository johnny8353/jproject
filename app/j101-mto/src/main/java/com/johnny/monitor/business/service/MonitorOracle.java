package com.johnny.monitor.business.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.johnny.common.util.ExceptionUtil;
import com.johnny.monitor.common.data.SysDataDictionary;

public class MonitorOracle extends MonitorService{
	protected Log log = LogFactory.getLog(getClass());
	
	/**
	 * @Description: 监控Oracle数据库是否可用
	 * @param @param wsUrl
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author JohnnyHuang 黄福强
	 * @date 2016-4-26
	 */
	@Override
	public void execute(Map<String,Object> params) {
		// TODO Auto-generated method stub
		try {
			String url = (String) params.get("url");
			String[] param = url.split(";");
			testResultSet("jdbc:oracle:thin:@"+param[0],param[1],param[2]);
		} catch (Exception e) {
//			e.printStackTrace();
			String error = ExceptionUtil.getExceptionMessage(e);
			log.debug("ERROR:"+error);
			sMessage = "ERROR:";
			if(error.indexOf(SysDataDictionary.MSG_SERVER_CONN_REFUSED)>-1){
				sMessage = "错误:"+"无法建立连接！";
			}
			if(error.indexOf("java.net.UnknownHostException")>-1){
				sMessage = "错误:"+"地址无法访问！";
			}
			if(error.indexOf("SID given in connect descriptor")>-1){
				sMessage = "错误:"+"SID无法访问！";
			}
			if(error.indexOf("ORA-01017")>-1){
				sMessage = "错误:"+"用户名密码错误！";
			}
			sMessage += error;
		}
	}
	
	public String testResultSet(String jdbcUrl,String user,String password) throws Exception{
		//获取 id=4 的 customers 数据表的记录, 并打印
		String id = "";
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			//1. 获取 Connection
			conn = getConnection(jdbcUrl,user,password);
			System.out.println(conn);
			
			//2. 获取 Statement
			statement = conn.createStatement();
			System.out.println(statement);
			
			//3. 准备 SQL
			String sql = "SELECT '1' from dual";
			
			//4. 执行查询, 得到 ResultSet
			rs = statement.executeQuery(sql);
			System.out.println(rs);
			
			//5. 处理 ResultSet
			while(rs.next()){
				id = (String) rs.getObject(1);
				System.out.println(id);
			}
			return id;
		} catch (Exception e) {
			throw e;
		} finally{
			//6. 关闭数据库资源. 
			release(rs, statement, conn);
		}
	}
	
	/**
	 * 1. 获取连接的方法. 通过读取配置文件从数据库服务器获取一个连接.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection(String jdbcUrl,String user,String password) throws Exception {
		// 1. 准备连接数据库的 4 个字符串.
		// 1). 创建 Properties 对象
//		Properties properties = new Properties();

		// 2). 获取 jdbc.properties 对应的输入流

		// 3). 加载 2） 对应的输入流

		// 4). 具体决定 user, password 等4 个字符串.
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 加载数据库驱动程序(对应的 Driver 实现类中有注册驱动的静态代码块.)
		Class.forName(driver);

		// 3. 通过 DriverManager 的 getConnection() 方法获取数据库连接.
		return DriverManager.getConnection(jdbcUrl, user, password);
	}

	public static void release(ResultSet rs, 
			Statement statement, Connection conn) {
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭 Statement 和 Connection
	 * @param statement
	 * @param conn
	 */
	public static void release(Statement statement, Connection conn) {
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
