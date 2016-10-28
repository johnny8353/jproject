package com.johnny.common.util;

import java.io.File;
import java.io.IOException;


/**
 * 类 编 号：
 * 类 名 称：FileDirUtil
 * 内容摘要：<说明该类的目前已经实现的主要功能>
 * 完成日期：2016年10月27日
 * 编码作者：JohnnyHuang 黄福强
 */
public class FileDirUtil {
	/**
	 * Enhancement of java.io.File#createNewFile()
	 * Create the given file. If the parent directory  don't exists, we will create them all.
	 * @param file the file to be created
	 * @return true if the named file does not exist and was successfully created; false if the named file already exists
	 * @see java.io.File#createNewFile
	 * @throws IOException
	 */
	public static boolean createFile(File file) throws IOException {
		if(! file.exists()) {
			makeDir(file.getParentFile());
		}
		return file.createNewFile();
	}
	
	/**
	 * Enhancement of java.io.File#mkdir()
	 * Create the given directory . If the parent folders don't exists, we will create them all.
	 * @see java.io.File#mkdir()
	 * @param dir the directory to be created
	 */
	public static void makeDir(File dir) {
		if(! dir.getParentFile().exists()) {
			makeDir(dir.getParentFile());
		}
		dir.mkdir();
	}
	
	public static void main(String args[]) {
		String filePath = "C:/temp/a/b/c/d/e/f/g.txt";
		File file = new File(filePath);
		try {
			System.out.println("file.exists()? " + file.exists());
			boolean created = createFile(file);
			System.out.println(created?"File created":"File exists, not created.");
			System.out.println("file.exists()? " + file.exists());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
