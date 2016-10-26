package com.johnny.common.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ExceptionUtil {
	/**
     * 获取异常详细信息
     * @Description: TODO
     * @param @param e
     * @param @return   
     * @return String  
     * @throws
     * @author JohnnyHuang 黄福强
     * @date 2016-4-7
     */
	public static String getExceptionMessage(Throwable e){
		String message = "";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		e.printStackTrace(new PrintStream(baos));
		message = baos.toString();
		return message;
	}
}
