package cn.tk.java.junit.four.wordDealUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;

public class WordDealUtilTest {
	/**
	 * @Description:判断运行结果是否达到预期效果
	 */
	@Test
	public void testWordFormat4DB()
	{
		String target = "employeeInfo";
		String result = WordDealUtil.wordFormat4DB(target);
		assertEquals("employee_info", result);
	}
	
	/**
	 * @Description:测试 null 时的处理情况 -- 抛异常(error)
	 */
	@Test
	public void wordFormat4DBNull()
	{
		String target = null;
		String result = WordDealUtil.wordFormat4DB(target);
		assertNull(result);
	}
	
	/**
	 * @Description:测试空字符串的处理情况
	 */
	@Test
	public void wordFormat4DBEmpty()
	{
		String target = "";
		String result = WordDealUtil.wordFormat4DB(target);
		assertEquals("", result);
	}
	
	/**
	 * @Description:测试首字母大写时的情况 --> 失败(failure)
	 */
	@Test
	public void wordFormat4DBBegin()
	{
		String target = "EmployeeInfo";
		String result = WordDealUtil.wordFormat4DB(target);
		assertEquals("employee_info", result);
	}
	
	/**
	 * @Description:测试尾字母为大写的情况
	 */
	@Ignore
	public void wordFormat4DBEnd()
	{
		String target = "employeeInfoA";
		String result = WordDealUtil.wordFormat4DB(target);
		assertEquals("employee_info_a", result);
	}
	
	/**
	 * @Description:测试多个相连字母大写的情况
	 */
	@Test
	public void wordFormat4DBTogether()
	{
		String target = "employeeAInfo";
		String result = WordDealUtil.wordFormat4DB(target);
		assertEquals("employee_a_info", result);
	}
}
