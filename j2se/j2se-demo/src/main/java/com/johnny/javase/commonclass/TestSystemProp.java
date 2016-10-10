package com.johnny.javase.commonclass;

import org.junit.Test;

public class TestSystemProp {

	/**
	 * 类 编 号：
	 * 类 名 称：TestSystemProp
	 * 内容摘要：<说明该类的目前已经实现的主要功能>
	 * 完成日期：2016年9月6日
	 * 编码作者：JohnnyHuang 黄福强
	 */
	@Test
	public void test() {
		/*
		 * java.version Java 运行时环境版本 java.vendor Java 运行时环境供应商 java.vendor.url
		 * Java 供应商的 URL java.home Java 安装目录 java.vm.specification.version Java
		 * 虚拟机规范版本 java.vm.specification.vendor Java 虚拟机规范供应商
		 * java.vm.specification.name Java 虚拟机规范名称 java.vm.version Java 虚拟机实现版本
		 * java.vm.vendor Java 虚拟机实现供应商 java.vm.name Java 虚拟机实现名称
		 * java.specification.version Java 运行时环境规范版本 java.specification.vendor
		 * Java 运行时环境规范供应商 java.specification.name Java 运行时环境规范名称
		 * java.class.version Java 类格式版本号 java.class.path Java 类路径
		 * java.library.path 加载库时搜索的路径列表 java.io.tmpdir 默认的临时文件路径 java.compiler
		 * 要使用的 JIT 编译器的名称 java.ext.dirs 一个或多个扩展目录的路径 os.name 操作系统的名称 os.arch
		 * 操作系统的架构 os.version 操作系统的版本 file.separator 文件分隔符（在 UNIX 系统中是“/”）
		 * path.separator 路径分隔符（在 UNIX 系统中是“:”） line.separator 行分隔符（在 UNIX
		 * 系统中是“/n”） user.name 用户的账户名称 user.home 用户的主目录 user.dir 用户的当前工作目录
		 */
		System.out.println("java_vendor:" + System.getProperty("java.vendor"));
		System.out.println("java_vendor_url:"
				+ System.getProperty("java.vendor.url"));
		System.out.println("java_home:" + System.getProperty("java.home"));
		System.out.println("java_class_version:"
				+ System.getProperty("java.class.version"));
		System.out.println("java_class_path:"
				+ System.getProperty("java.class.path"));
		System.out.println("os_name:" + System.getProperty("os.name"));
		System.out.println("os_arch:" + System.getProperty("os.arch"));
		System.out.println("os_version:" + System.getProperty("os.version"));
		System.out.println("user_name:" + System.getProperty("user.name"));
		System.out.println("user_home:" + System.getProperty("user.home"));
		System.out.println("user_dir:" + System.getProperty("user.dir"));
		System.out.println("java_vm_specification_version:"
				+ System.getProperty("java.vm.specification.version"));
		System.out.println("java_vm_specification_vendor:"
				+ System.getProperty("java.vm.specification.vendor"));
		System.out.println("java_vm_specification_name:"
				+ System.getProperty("java.vm.specification.name"));
		System.out.println("java_vm_version:"
				+ System.getProperty("java.vm.version"));
		System.out.println("java_vm_vendor:"
				+ System.getProperty("java.vm.vendor"));
		System.out
				.println("java_vm_name:" + System.getProperty("java.vm.name"));
		System.out.println("java_ext_dirs:"
				+ System.getProperty("java.ext.dirs"));
		System.out.println("file_separator:"
				+ System.getProperty("file.separator"));
		System.out.println("path_separator:"
				+ System.getProperty("path.separator"));
		System.out.println("line_separator:"
				+ System.getProperty("line.separator"));

	}

}
