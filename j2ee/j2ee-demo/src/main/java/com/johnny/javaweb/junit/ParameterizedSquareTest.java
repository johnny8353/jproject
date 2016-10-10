package com.johnny.javaweb.junit;

import   static  org.junit.Assert.assertEquals;
import  org.junit.Test;
import  org.junit.runner.RunWith;
import  org.junit.runners.Parameterized;
import  org.junit.runners.Parameterized.Parameters;
import  java.util.Arrays;
import  java.util.Collection;
/**
 * 
 * 类 编 号：
 * 类 名 称：ParameterizedSquareTest
 * 内容摘要：
	首先，你要为这种测试专门生成一个新的类，而不能与其他测试共用同一个类，此例中我们定义了一个ParameterizedSquareTest类。
	然后，你要为这个类指定一个Runner，而不能使用默认的Runner了，因为特殊的功能要用特殊的Runner嘛。
	@RunWith(Parameterized.class)这条语句就是为这个类指定了一个ParameterizedRunner。
	
	第二步，定义一个待测试的类，并且定义两个变量，一个用于存放参数，一个用于存放期待的结果。
	接下来，定义测试数据的集合，也就是上述的data()方法，该方法可以任意命名，但是必须使用@Parameters标注进行修饰。
	这个方法的框架就不予解释了，大家只需要注意其中的数据，是一个二维数组，数据两两一组，每组中的这两个数据，一个是参数，一个是你预期的结果。
	比如我们的第一组{2,4}，2就是参数，4就是预期的结果。这两个数据的顺序无所谓，谁前谁后都可以。
	之后是构造函数，其功能就是对先前定义的两个参数进行初始化。 在这里你可要注意一下参数的顺序了，要和上面的数据集合的顺序保持一致。
	如果前面的顺序是{参数，期待的结果}，那么你构造函数的顺序也要是“构造函数(参数， 期待的结果)”，反之亦然。
	
	最后就是写一个简单的测试例了，和前面介绍过的写法完全一样
 * 完成日期：2016年7月26日
 * 编码作者：JohnnyHuang 黄福强
 */
@RunWith(Parameterized. class )
public   class  ParameterizedSquareTest
{
	private   static  Calculator calculator  =   new  Calculator();
	private   int  param;
	private   int  result;
	private   String  msg;
	@Parameters
	public   static  Collection data()
	{
		return  Arrays.asList( new  Object[][] 
		{
			{2 ,  5, "1="},
			{0 ,  0, "2="},
			{-3 , 9, "3="},
		}
		);
	}
	// 构造函数，对变量进行初始化
	public  ParameterizedSquareTest( int  param,  int  result ,String msg)
	{
		this.param  =  param;
		this.result  =  result;
		this.msg = msg;
	}
	@Test
	public   void  square()
	{
		calculator.square(param);
		assertEquals(msg,result, calculator.getResult());
	}
}
