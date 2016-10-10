package com.johnny.javaweb.junit;
import  org.junit.runner.RunWith;
import  org.junit.runners.Suite;

/**
 * 类 编 号：
 * 类 名 称：AllTests
 * 内容摘要：将所有需要运行的测试类集中起来，一次性的运行完毕
 * 这个功能也需要使用一个特殊的 Runner ，因此我们需要向 @RunWith 标注传递一个参数 Suite.class 。
 * 同时，我们还需要另外一个标注 @Suite.SuiteClasses ，来表明这个类是一个打包测试类。我们把需要打包的类作为参数传递给该标注就可以了。
 * 有了这两个标注之后，就已经完整的表达了所有的含义，因此下面的类已经无关紧要，随便起一个类名，内容全部为空既可。 
 * 完成日期：2016年7月26日
 * 编码作者：JohnnyHuang 黄福强
 */
@RunWith(Suite.class )
 @Suite.SuiteClasses(  {
        CalculatorTest.class ,
        ParameterizedSquareTest.class 
        } )
public class AllTests {


}
