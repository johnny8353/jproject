package com.johnny.monitor.common.data;
/**
 * 类 编 号：BL_PU2010101_SysDataConfig
 * 类 名 称：SysDataConfig
 * 内容摘要：定义系统字典 
 * 完成日期：2014-11-18
 * 编码作者：JohnnyHuang 黄福强
 */
public class SysDataDictionary {
	
	//线程状态 新建/排队/取消/活动/成功/错误/挂起
	public static final String THREAD_STATUS_NEW="新建";
	public static final String THREAD_STATUS_WATI="排队";
	public static final String THREAD_STATUS_ACTIVE="活动";
	public static final String THREAD_STATUS_SUCCESS="成功";
	public static final String THREAD_STATUS_ERROR="错误";
	public static final String THREAD_STATUS_PENDING="挂起";
	public static final String THREAD_STATUS_CANCEL="取消";
	
	//siebel服务器停止返回的错误
	public static final String MSG_SERVER_500="(500)Internal Server Error";
	public static final String MSG_SERVER_404="404";
	public static final String MSG_SERVER_CONN_REFUSED="Connection refused";
	
	public final static String ENV_PROD_NAME = "生产";
	public final static String ENV_REC_NAME = "仿真";
	public final static String ENV_TEST_NAME = "测试";
	public final static String ENV_DEV_NAME = "开发";
	public final static String ENV_PROD_CODE = "PROD";
	public final static String ENV_REC_CODE = "REC";
	public final static String ENV_TEST_CODE = "TEST";
	public final static String ENV_DEV_CODE = "DEV";
	
	public final static String MONITOR_RESULT_SUCCESS_NAME = "正常";
	public final static String MONITOR_RESULT_SKIP_NAME = "暂不监控";
	public final static String MONITOR_RESULT_FAIL_NAME = "错误";
	
	public final static String MONITOR_SYS_TYPE_DB = "DataBase";
	public final static String MONITOR_SYS_TYPE_APP = "Application";
	
	
}
