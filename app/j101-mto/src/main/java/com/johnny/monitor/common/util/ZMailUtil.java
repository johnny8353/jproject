package com.johnny.monitor.common.util;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.johnny.data.common.data.SysDataDictionary;


public class ZMailUtil {
	public static void main(String[] args) {
		String toMail = "6092002318@zte.com.cn";
		String title = "测试邮件";
		String bodyDetail = "顶顶顶顶顶顶顶顶顶顶";
		invokeDPGSendTestMail(toMail,title,bodyDetail,"点击查看","http://www.baidu.com");
	}
	/**
     * 邮件发送客户端程序，调用DPG邮件服务端发送邮件
     * @param object 邮件业务对象
     * @return 发送成功返回0000;发送失败返回0001
     */
    public static String invokeDPGSendTestMail(String toMail,String title,String bodyDetail,String ClickLook,String link) 
    {
    	String sendFlag = "0001";
		try 
		{
			// 这里使用org.apache.axis.client包中的service和call
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(SysDataDictionary.getSysPref("C_MAIL_URL"));

			// 设置需要调用的方法名称
			call.setOperationName("sendMail");
			// 构建一个前面例子中提到的xml文件作为调用邮件服务的参数
			String mailBody = patchMailXml(toMail,title,bodyDetail,ClickLook,link);
            //发送成功返回:0000 ,发送失败：0001
			sendFlag = (String)call.invoke(new Object[] {mailBody });
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			//程序报异常
			sendFlag="0001";
		}	
		return sendFlag;
	}
    
    /**
     * 
     * 新测试方式的邮件
     * 编码作者:JohnnyHuang 黄福强
     * 完成日期:2016-2-4
     * @param toMail
     * @param bodyDetail
     * @param failNum
     * @return
     */
    private static String patchMailXml(String toMail,String title,String bodyDetail,String ClickLook,String link)
    {
        String toCcMail="";
        String toBccMail="";
        
        String subject= title;
        String mailFrom="ecc_msm@zte.com.cn";
        
    	// 需要传输给DPG邮件服务的邮件xml字串
    	StringBuffer buffStr = new StringBuffer();
    	buffStr.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	buffStr.append("<mail-config>");
    	buffStr.append("<head><systemType>siebel</systemType></head>");
    	buffStr.append("<mails>");
    	buffStr.append("<mail>");
    	buffStr.append("<mailtoIsOne>true</mailtoIsOne>");
    	buffStr.append("<importance>0</importance><priority>0</priority>");
        
        buffStr.append("<title><![CDATA["+subject+"]]></title>");

    	buffStr.append("<mailfrom><![CDATA["+mailFrom+"]]></mailfrom>");
    	
    	//直接发送
    	buffStr.append("<mailto>"+toMail.trim()+"</mailto>");
    	//抄送
    	buffStr.append("<mailcc>"+toCcMail.trim()+"</mailcc>");
        //密送
        buffStr.append("<mailbcc>"+toBccMail.trim()+"</mailbcc>");
        
        //只发中文邮件
        buffStr.append("<mailBody id=\"zh_CN\">");
        buffStr.append("<WarmCall>温馨提醒：本邮件为系统自动发送，请不要回复本邮件。</WarmCall>");
//        buffStr.append("<MailSysName>siebel 通知</MailSysName>");
        buffStr.append("<MailSysName></MailSysName>");
        buffStr.append("<ClickLook>"+ClickLook+"</ClickLook>");
        buffStr.append("<LinkAdd>"+link+"</LinkAdd>");
        buffStr.append("<MainText><![CDATA["+bodyDetail+"]]></MainText>");
        buffStr.append("</mailBody>");

    	//结束标签
    	buffStr.append("</mail>");
    	buffStr.append("</mails>");
    	buffStr.append("</mail-config>");
    	
    	return buffStr.toString();
    }
}
