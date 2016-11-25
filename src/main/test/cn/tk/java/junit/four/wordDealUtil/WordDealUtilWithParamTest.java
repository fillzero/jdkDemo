package cn.tk.java.junit.four.wordDealUtil;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class WordDealUtilWithParamTest {
	private String expected;
	private String target;

	/**
	 * @description:用一组参数搞定一个方法的所有测试
	 * 是 WordDealUtilTest.java 的简化版本, 去除重复的代码, 让代码变的更加简洁
	 * 
	 * @Parameters: 提供构造函数的参数
	 */
	@Parameters
	public static Collection<Object[]> words() {
		return Arrays.asList(
				new Object[][] {
				{ "employee_info", "employeeInfo" }, 		// 测试一般的处理情况
				{ null, null }, 					 		// 测试 null 时的处理情况
				{ "", "" }, 								// 测试空字符串时的处理情况
				{ "employee_info", "EmployeeInfo" }, 		// 测试当首字母大写时的情况
				{ "employee_info_a", "employeeInfoA" }, 	// 测试当尾字母为大写时的情况
				{ "employee_a_info", "employeeAInfo" } 		// 测试多个相连字母大写时的情况
				});
	}
	
	/**
	 * @description: 参数化测试必须的构造函数
	 * @param expected: 期望的测试结果, 对应参数集中的第一个参数
	 * @param target: 测试数据, 对应参数集中的第二个参数
	 */
	public WordDealUtilWithParamTest(String expected, String target)
	{
		this.expected = expected;
		this.target = target;
	}
	
	/**
	 * @description:测试将 java 对象名称到数据库名称的转换
	 */
	@Test
	public void wordFormat4DB()
	{
		assertEquals(expected, WordDealUtil.wordFormat4DB(target));
	}
}
