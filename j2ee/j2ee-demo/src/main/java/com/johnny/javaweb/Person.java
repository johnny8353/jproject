package com.johnny.javaweb;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Person {

	public String getInfo(){
		return "helloworld";
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String enstr = URLEncoder.encode("中国", "utf-8");
		System.out.println(enstr);
		
		String destr = URLDecoder.decode(enstr, "utf-8");
		System.out.println(destr);
	}

}
