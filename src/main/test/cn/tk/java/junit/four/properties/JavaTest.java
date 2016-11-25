package cn.tk.java.junit.four.properties;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @Company: 泰康在线财产保险股份有限公司
 * @Author: 李晋龙
 * @Title: JavaTest.java
 * @Package: cn.tk.junitDemo
 * @Time: 2016年5月26日下午4:53:41
 *
 * @description: Junit特性: 测试工具
 */
public class JavaTest extends TestCase{
	protected int value1, value2;
	protected void setUp()
	{
		value1 = 3;
		value2 = 3;
	}
	
	@Test
	public void testAdd()
	{
		double result = value1 + value2;
		assertTrue(result == 6);
	}
}
