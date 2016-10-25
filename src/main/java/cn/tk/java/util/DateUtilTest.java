package cn.tk.java.util;

import java.util.Date;

import org.junit.Test;

import cn.tk.java.util.commonUtils.DateUtil;

public class DateUtilTest {
	
	/**
	 * @Description: Date 转换成字符串
	 */
	@Test
	public void testToString()
	{
		System.out.println(DateUtil.toString(new Date(), "yyyy-MM-dd HH:mm:ss"));
	}
	
	/**
	 * @Description:获取给定日期的凌晨零点零分的日期对象
	 */
	@Test
	public void testGetTimeOf12()
	{
		Date date12 = DateUtil.getTimeOf12(new Date());
		System.out.println(DateUtil.toString(date12, "yyyy-MM-dd HH:mm:ss"));
	}
	
	/**
	 * @Description:获取给定日期下个月的第一天凌晨零点零分的日期对象
	 */
	@Test
	public void testGetFirstDayOfNextMonth()
	{
		Date dateNextMonth = DateUtil.getFirstDayOfNextMonth(new Date());
		System.out.println(DateUtil.toString(dateNextMonth, "yyyy-MM-dd HH:mm:ss"));
	}
}
