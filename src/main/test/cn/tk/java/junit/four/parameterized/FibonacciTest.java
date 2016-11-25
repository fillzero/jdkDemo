package cn.tk.java.junit.four.parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @Company: 泰康在线财产保险股份有限公司
 * @Author: 李晋龙
 * @Title: FibonacciTest.java
 * @Package: cn.tk.junitDemo.wordDealUtil.parameterized
 * @Time: 2016年5月30日下午3:14:45
 *
 * @description: 参数化测试, 构造函数注入参数
 */
@RunWith(Parameterized.class)
public class FibonacciTest {
	
	private int fInput;//输入参数得到实际结果
	private int fExpected;//预期结果
	
	/**
	 * @description:构造函数用于传入参数
	 */
	public FibonacciTest(int input, int expected) {
		this.fInput = input;
		this.fExpected = expected;
	}
	
	/**
	 * @description:方法加注解用于传入需要的参数
	 */
	@Parameters
	public static Collection<Object[]> data()
	{
		return Arrays.asList(
				new Object[][]{
					{0,0}, {1,1}, {2,1}, {3,2}, {4,3}, {5,5}, {6,8}
				}
			);
	}
	
	@Test
	public void testCompute()
	{
		assertEquals(fExpected, Fibonacci.compute(fInput));
	}
}
