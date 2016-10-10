package com.johnny.javase.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * 抽象基类			节点流（文件流）                                缓冲流（处理流的一种,可以提升文件操作的效率）
 * InputStream		FileInputStream			BufferedInputStream
 * OutputStream		FileOutputStream		BufferedOutputStream  (flush())
 * Reader			FileReader				BufferedReader  (readLine())
 * Writer			FileWriter				BufferedWriter  (flush())
 */
public class TestBuffered {
	@Test
	public void testBufferedReader(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			File file = new File("dbcp.txt");
			File file1 = new File("dbcp3.txt");
			FileReader fr = new FileReader(file);
			
			FileWriter fw = new FileWriter(file1);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
//			char[] c = new char[1024];
//			int len;
//			while((len = br.read(c))!= -1){
//				String str = new String(c, 0, len);
//				System.out.print(str);
//			}
			
			String str;
			while((str = br.readLine()) != null){
//				System.out.println(str);
				bw.write(str + "\n");
//				bw.newLine();
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
	
	@Test
	public void testCopyFile(){
		long start = System.currentTimeMillis();
//		String src = "C:\\Users\\shkstart\\Desktop\\1.avi";
//		String dest = "C:\\Users\\shkstart\\Desktop\\3.avi";
		String src = "C:\\Users\\shkstart\\Desktop\\实验.doc";
		String dest = "C:\\Users\\shkstart\\Desktop\\实验1.doc";
		copyFile(src,dest);
		long end = System.currentTimeMillis();
		System.out.println("花费的时间为：" + (end - start));//746
	}
	
	//使用缓冲流实现文件的复制的方法
	public void copyFile(String src,String dest){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			//1.提供读入、写出的文件
			File file1 = new File(src);
			File file2 = new File(dest);
			//2.想创建相应的节点流：FileInputStream、FileOutputStream
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			//3.将创建的节点流的对象作为形参传递给缓冲流的构造器中
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			//4.具体的实现文件复制的操作
			byte[] b = new byte[1024];
			int len;
			while((len = bis.read(b)) != -1){
				bos.write(b, 0, len);
				bos.flush();
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5.关闭相应的流
			if(bos != null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(bis != null){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	}
	
	
	//使用BufferedInputStream和BufferedOutputStream实现非文本文件的复制
	@Test
	public void testBufferedInputOutputStream(){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			//1.提供读入、写出的文件
			File file1 = new File("1.jpg");
			File file2 = new File("2.jpg");
			//2.想创建相应的节点流：FileInputStream、FileOutputStream
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			//3.将创建的节点流的对象作为形参传递给缓冲流的构造器中
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			//4.具体的实现文件复制的操作
			byte[] b = new byte[1024];
			int len;
			while((len = bis.read(b)) != -1){
				bos.write(b, 0, len);
				bos.flush();
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5.关闭相应的流
			if(bos != null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(bis != null){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	}
	
}
