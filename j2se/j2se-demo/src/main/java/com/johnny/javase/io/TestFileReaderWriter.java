package com.johnny.javase.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * 使用FileReader、FileWriter 可以实现文本文件的复制。
 * 对于非文本文件（视频文件、音频文件、图片），只能使用字节流！
 */
public class TestFileReaderWriter {
	@Test
	public void testFileReaderWriter(){
		//1.输入流对应的文件src一定要存在，否则抛异常。输出流对应的文件dest可以不存在，执行过程中会自动创建
		FileReader fr = null;
		FileWriter fw = null;
		try{
			//不能实现非文本文件的复制
//			File src = new File("C:\\Users\\shkstart\\Desktop\\1.jpg");
//			File dest = new File("C:\\Users\\shkstart\\Desktop\\3.jpg");
			File src = new File("dbcp.txt");
			File dest = new File("dbcp1.txt");
			//2.
			fr = new FileReader(src);
			fw = new FileWriter(dest);
			//3.
			char[] c = new char[24];
			int len;
			while((len = fr.read(c)) != -1){
				fw.write(c, 0, len);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testFileReader(){
		FileReader fr = null;
		try {
			File file = new File("dbcp.txt");
			fr = new FileReader(file);
			char[] c = new char[24];
			int len;
			while((len = fr.read(c)) != -1){
				String str = new String(c, 0, len);
				System.out.print(str);
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
