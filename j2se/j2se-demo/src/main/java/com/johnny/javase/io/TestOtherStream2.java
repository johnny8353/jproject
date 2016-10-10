package com.johnny.javase.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class TestOtherStream2 {
	/*
	 * 标准的输入输出流：
	 * 标准的输出流：System.out
	 * 标准的输入流：System.in
	 * 
	 * 题目：
	 * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
	 * 直至当输入“e”或者“exit”时，退出程序。

	 */
	@Test
	public void test2(){
		BufferedReader br = null;
		try {
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String str;
			while(true){
				System.out.println("请输入字符串：");
				str = br.readLine();
				if(str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")){
					break;
				}
				String str1 = str.toUpperCase();
				System.out.println(str1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	/* 转换流提供了在字节流和字符流之间的转换
	 * 字节流中的数据都是字符时，转成字符流操作更高效。
	 * 如何实现字节流与字符流之间的转换：
	 * 转换流：InputStreamReader  OutputStreamWriter
	 * 编码：字符串  --->字节数组
	 * 解码：字节数组--->字符串
	 * 
	 * 使用FileOutputStream序列化可以直接向文件写入文本内容
	 * 但这里的字符串如果包含中文，就会出现乱码，这是因为FileOutputStream是字节流，将文本按字节写入文件，而一个汉字是两个字节，
	 * 无法一次写入，就会出现乱码，解决方法是使用OutputStreamWriter将字节流转换为字符流写入，同时指定utf-8编码。代码如下：
；		OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
		oStreamWriter.append(str);
		oStreamWriter.close();
	 */
	@Test
	public void test1(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			//解码	用于将字节流中读取到的字节按指定字符集解码成字符。需要和InputStream“套接”
			File file = new File("dbcp.txt");
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, "GBK");
			br = new BufferedReader(isr);
			//编码
			File file1 = new File("dbcp4.txt");
			FileOutputStream fos = new FileOutputStream(file1);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
			bw = new BufferedWriter(osw);
			String str;
			while((str = br.readLine()) != null){
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
}
