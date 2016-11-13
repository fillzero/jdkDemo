package cn.tk.java.junit.four.assumption;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assume.assumeThat;

import java.io.File;

import org.junit.Test;

/**
 * @Company: 泰康在线财产保险股份有限公司
 * @Author: 李晋龙
 * @Title: AssumptionTest.java
 * @Package: cn.tk.junitDemo.assumption
 * @Time: 2016年6月2日上午10:10:18
 *
 * @Description: 假设机制: 让失败的测试样例不影响其它测试样例的执行, 让整个测试进程继续进行
 * 
 * assumeThat, assumeTrue, assumeNotNull, assumeNoException
 */
public class AssumptionTest {
	/**
	 * @Description:1. 利用假设机制做挡板跳过不通过的测试案例
	 */
	@Test
	public void testAssumptions()
	{
		assumeThat("10", is("0"));//无论如何测试都会通过, 但是测试结果正确会打印一行字
		System.out.println("assumption is true!");
	}
	
	/**
	 * @Description:控制测试用例的运行时间, 在自己期望的时间运行
	 * 当系统变量获取到 "DEV" 时运行
	 */
	@Test
	public void veryLongTest() throws InterruptedException
	{
		assumeThat(System.getProperty("DEV"), nullValue());
		System.out.println("running a long test");
		Thread.sleep(90 * 1000);
	}
	
	/**
	 * @Description:假设文件 path 以 "/" 分隔, 真实的是 "\", 所以文字不会打印出来
	 * Junit 默认的运行器遇到假设失败直接跳过改单元测试, 不会报错, 可以自己编写运行器处理假设失败的情况
	 */
	@Test
	public void filenameIncludeUsername()
	{
		assumeThat(File.separatorChar, is('/'));
		System.out.println(File.separatorChar);
	}
}
