package com.johnny.javase.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/*
 * java.io.File类
 * 1.凡是与输入、输出相关的类、接口等都定义在java.io包下
 * 2.File是一个类，可以有构造器创建其对象。此对象对应着一个文件（.txt .avi .doc .ppt .mp3 .jpg）或文件目录
 * 3.File类对象是与平台无关的。
 * 4.File中的方法，仅涉及到如何创建、删除、重命名等等。只要涉及文件内容的，File是无能为力的，必须由io流来完成。
 * 5.File类的对象常作为io流的具体类的构造器的形参。
 */
public class TestFile {
	/*
	 *  createNewFile()
		delete()
		mkDir():创建一个文件目录。只有在上层文件目录存在的情况下，才能返回true
		mkDirs():创建一个文件目录。若上层文件目录不存在，一并创建
		list()
		listFiles()
	 */
	@Test
	public void test3() throws IOException{
		File file1 = new File("d:/io/helloworld.txt");
		System.out.println(file1.delete());
		
		if(!file1.exists()){
			boolean b = file1.createNewFile();
			System.out.println(b);
		}
		
		File file2 = new File("d:\\io1\\io2");
		if(!file2.exists()){
			boolean b = file2.mkdirs();
			System.out.println(b);
		}
		
		File file3 = new File("d:\\teach");
		String[] strs = file3.list();
		for(int i = 0;i < strs.length;i++){
			System.out.println(strs[i]);
		}
		
		System.out.println();
		
		File[] files = file3.listFiles();
		for(int i = 0;i < files.length;i++){
			System.out.println(files[i].getName());
		}
	}
	
	/*
	 *  exists()
		canWrite()
		canRead()
		isFile()
		isDirectory()
		lastModified()
		length()

	 */
	@Test
	public void test2(){
		File file1 = new File("d:/io/helloworld.txt");
		File file2 = new File("d:\\io\\io1");
		
		System.out.println(file1.exists());
		System.out.println(file1.canWrite());
		System.out.println(file1.canRead());
		System.out.println(file1.isFile());
		System.out.println(file1.isDirectory());
		System.out.println(new Date(file1.lastModified()));
		System.out.println(file1.length());
		
		System.out.println();
		
		System.out.println(file2.exists());
		System.out.println(file2.canWrite());
		System.out.println(file2.canRead());
		System.out.println(file2.isFile());
		System.out.println(file2.isDirectory());
		System.out.println(new Date(file2.lastModified()));
		System.out.println(file2.length());
	
	}
	
	/*
	 * 路径：
	 * 绝对路径：包括盘符在内的完整的文件路径
	 * 相对路径：在当前文件目录下的文件的路径
	 * 
	 *  getName()
		getPath()
		getAbsoluteFile()
		getAbsolutePath()
		getParent()
		renameTo(File newName)

	 */
	@Test
	public void test1(){
		File file1 = new File("d:/io/helloworld.txt");
		File file2 = new File("hello1.txt");
		
		File file3 = new File("d:\\io\\io1");
		File file4 = new File("d:\\io2");
		
		System.out.println(file1.getName());
		System.out.println(file1.getPath());
		System.out.println(file1.getAbsoluteFile());
		System.out.println(file1.getParent());
		System.out.println(file1.getAbsolutePath());
		
		System.out.println();
		
		System.out.println(file3.getName());
		System.out.println(file3.getPath());
		System.out.println(file3.getAbsoluteFile());
		System.out.println(file3.getParent());
		System.out.println(file3.getAbsolutePath());
		
		//renameTo(File newName):重命名
		//file1.renameTo(file2):file1重命名为file2.要求：file1文件一定存在，file2一定不存在
		boolean b = file1.renameTo(file2);
		System.out.println(b);
		
		boolean b1 = file4.renameTo(file3);
		System.out.println(b1);
	}
}
