package cn.tk.java.junit.four.parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * @Company: 泰康在线财产保险股份有限公司
 * @Author: 李晋龙
 * @Title: FibonacciTest.java
 * @Package: cn.tk.junitDemo.wordDealUtil.parameterized
 * @Time: 2016年5月30日下午3:14:45
 *
 * @Description: 参数化测试, 用域直接注入, 域的可见性变为 public, 而不是 private
 */
@RunWith(Parameterized.class)
public class FibonacciTest1 {
	
	//value = 0, Parameters 参数里面的第一个参数, 默认从 0 开始, 可以不写
	@Parameter(value = 0)
	public int fInput;//输入参数得到实际结果
	
	//value = 1, Parameters 参数里面的第二个参数
	@Parameter(value = 1)
	public int fExpected;//预期结果
	
	/**
	 * @Description:方法加注解用于传入需要的参数
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
