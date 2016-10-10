package com.johnny.javase.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/*
 * 1.流的分类：
 * 按照数据流向的不同：输入流  输出流
 * 按照处理数据的单位的不同：字节流  字符流（处理的文本文件）
 * 按照角色的不同：节点流（直接作用于文件的）  处理流
 * 
	按操作数据单位不同分为：字节流(8 bit)，字符流(16 bit)  
		字节流：以byte为单位传输
		字符流：以char为单位传输
	按数据流的流向不同分为：输入流，输出流
	按流的角色的不同分为：节点流，处理流
		字节流			字符流
		InputStream		Reader
		OutputStream	Writer
		
 * 2.IO的体系
 * 抽象基类			节点流（文件流）                                缓冲流（处理流的一种）
 * InputStream		FileInputStream			BufferedInputStream
 * OutputStream		FileOutputStream		BufferedOutputStream
 * Reader			FileReader				BufferedReader
 * Writer			FileWriter				BufferedWriter
 * 
 * 	注  意
		定义文件路径时，注意：可以用“/”或者“\\”。
		在写入一个文件时，如果目录下有同名文件将被覆盖。
		在读取文件时，必须保证该文件已存在，否则出异常。
 */
public class TestFileInputOutputStream {
	@Test
	public void testCopyFile(){
		long start = System.currentTimeMillis();
//		String src = "C:\\Users\\shkstart\\Desktop\\1.avi";
//		String dest = "C:\\Users\\shkstart\\Desktop\\2.avi";
		String src = "dbcp.txt";
		String dest = "dbcp2.txt";
		copyFile(src,dest);
		long end = System.currentTimeMillis();
		System.out.println("花费的时间为：" + (end - start));//3198
	}
	
	// 实现文件复制的方法
	public void copyFile(String src, String dest) {
		// 1.提供读入、写出的文件
		File file1 = new File(src);
		File file2 = new File(dest);
		// 2.提供相应的流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// 3.实现文件的复制
			byte[] b = new byte[1024];
			int len;
			while ((len = fis.read(b)) != -1) {
				// fos.write(b);//错误的写法两种： fos.write(b,0,b.length);
				fos.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	// 从硬盘读取一个文件，并写入到另一个位置。（相当于文件的复制）
	@Test
	public void testFileInputOutputStream() {
		// 1.提供读入、写出的文件
		File file1 = new File("C:\\Users\\shkstart\\Desktop\\1.jpg");
		File file2 = new File("C:\\Users\\shkstart\\Desktop\\2.jpg");
		// 2.提供相应的流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// 3.实现文件的复制
			byte[] b = new byte[20];
			int len;
			while ((len = fis.read(b)) != -1) {
				// fos.write(b);//错误的写法两种： fos.write(b,0,b.length);
				fos.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	// FileOutputStream
	@Test
	public void testFileOutputStream() {
		// 1.创建一个File对象，表明要写入的文件位置。
		// 输出的物理文件可以不存在，当执行过程中，若不存在，会自动的创建。若存在，会将原有的文件覆盖
		File file = new File("hello2.txt");
		// 2.创建一个FileOutputStream的对象，将file的对象作为形参传递给FileOutputStream的构造器中
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			// 3.写入的操作
			fos.write(new String("I love China！中国").getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4.关闭输出流
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testFileInputStream3() { // abcdefgcde
		FileInputStream fis = null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			byte[] b = new byte[5];// 读取到的数据要写入的数组。
			int len;// 每次读入到byte中的字节的长度
			while ((len = fis.read(b)) != -1) {
				// for (int i = 0; i < len; i++) {
				// System.out.print((char) b[i]);
				// }
				String str = new String(b, 0, len);
				System.out.print(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

	// 使用try-catch的方式处理如下的异常更合理:保证流的关闭操作一定可以执行
	@Test
	public void testFileInputStream2() {
		// 2.创建一个FileInputStream类的对象
		FileInputStream fis = null;
		try {
			// 1.创建一个File类的对象。
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			// 3.调用FileInputStream的方法，实现file文件的读取。
			int b;
			while ((b = fis.read()) != -1) {
				System.out.print((char) b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.关闭相应的流
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 从硬盘存在的一个文件中，读取其内容到程序中。使用FileInputStream
	// 要读取的文件一定要存在。否则抛FileNotFoundException
	@Test
	public void testFileInputStream1() throws Exception {
		// 1.创建一个File类的对象。
		File file = new File("hello.txt");
		// 2.创建一个FileInputStream类的对象
		FileInputStream fis = new FileInputStream(file);
		// 3.调用FileInputStream的方法，实现file文件的读取。
		/*
		 * read():读取文件的一个字节。当执行到文件结尾时，返回-1
		 */
		// int b = fis.read();
		// while(b != -1){
		// System.out.print((char)b);
		// b = fis.read();
		// }
		int b;
		while ((b = fis.read()) != -1) {
			System.out.print((char) b);
		}
		// 4.关闭相应的流
		fis.close();
	}
}
