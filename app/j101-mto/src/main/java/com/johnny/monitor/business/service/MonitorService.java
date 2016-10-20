package com.johnny.monitor.business.service;

import java.util.HashMap;
import java.util.Map;

import com.johnny.common.util.HttpClientUtil;

public abstract class MonitorService {
	protected String sMessage;
	public abstract void execute(String url);
	
	public String getsMessage() {
		return sMessage;
	}
	
	public void setsMessage(String sMessage) {
		this.sMessage = sMessage;
	}

	/**
	 * @Description: 发送Http请求
	 * @param @param reqUrl
	 * @param @param ms
	 * @param @return
	 * @param @throws Exception   
	 * @return String  
	 * @throws
	 * @author JohnnyHuang 黄福强
	 * @date 2016-5-28
	 */
	public String HttpPost(String reqUrl,String ms,String encode) throws Exception{
		Map<String, String> maps = new HashMap<String, String>();
		
		String result = HttpClientUtil.getInstance().sendHttpPostJson(reqUrl, maps);
		maps.put("OBJ", ms);
		System.out.println(result);
		
		return result;
		
//		HttpClient client = new HttpClient();
//		PostMethod method = new PostMethod(reqUrl);
//		method.setRequestHeader("Content-type",
//				"application/json;charset="+encode);
//		method.addParameter("OBJ", ms);
//		method.setRequestBody(ms);
//		try {
//			// 请求发送
//			client.executeMethod(method);
//			// 打印服务器返回的状态
////			System.out.println(method.getStatusLine());
//			// 打印返回的信息
//			InputStream stream = method.getResponseBodyAsStream();
//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					stream, "UTF-8"));
//			StringBuffer buf = new StringBuffer();
//			String line;
//			while (null != (line = br.readLine())) {
//				buf.append(line).append("\n");
//			}
//			returnString = buf.toString();
//			
//			// 释放连接
//			if(returnString.indexOf("404")!=-1){
//				throw new Exception("404 Error");
//			}
//			if(returnString.indexOf("java.io.FileNotFoundException")!=-1){
//				throw new Exception("404 Error");
//			}
//			
//		} catch (Exception e) {
//			throw e;
//		}finally{
//			method.releaseConnection();
//		}
//System.out.println("返回结果："+returnString);
//		return returnString;
	}
}
