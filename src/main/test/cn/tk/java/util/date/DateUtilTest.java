package cn.tk.java.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.tk.java.util.date.DateUtils;
import org.junit.Test;

import cn.tk.java.util.commonUtils.DateUtil;
import org.junit.jupiter.api.DisplayName;

/*
* @date: $DATE
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description:
* 日起类:
* 1. 字符串与时间戳互相转换
* 2. 字符串与Date互相转换
* 3. Date与时间戳互相转换
* 字符串与时间戳互相转换需要通过 Date, 核心在 字符串与 Date 之间的转换
* DateUtils.str2date(),  DateUtils.date2str
* date.getTime, new Date(timestamp)
*/
public class DateUtilTest {
	
	 /*
	 * @description: Date 与 格式化 String 互相转换
	 */
	@Test
	public void testDate2String()
	{
		// Date 转 格式化String
		System.out.println(DateUtil.toString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		System.out.println(DateUtils.date2Str(new Date(), DateUtils.standard));

		// 格式化String 转 Date
		Date standard = DateUtils.str2Date("2016-11-15 18:40:45", DateUtils.standard);
	}

	/*
	* @description: DateStamp 与 格式化 String 互相转换
	*/
	@Test
	public void testStamp2String()
	{
		// DateStamp 转 格式化 String
		long currentTime = System.currentTimeMillis();
		System.out.println(DateUtil.toString(new Date(currentTime), "yyyy-MM-dd HH:mm:ss"));
		System.out.println(DateUtils.date2Str(new Date(currentTime), DateUtils.standard));

		// 格式化 String 转 DateStamp
		Date today = DateUtils.str2Date("2016-11-15 18:49:59", DateUtils.standard);
		System.out.println(today.getTime());
	}

	/*
	* @description: Date 与 时间戳相互转换
	*/
	@Test
	public void testDate2Stamp()
	{
		// Date 转 时间戳
		Date date = new Date();
		System.out.println(date.getTime());

		// 时间戳转 Date
		long stamp = System.currentTimeMillis();
		Date today = new Date(stamp);
		System.out.println(DateUtils.date2Str(today, DateUtils.standard));
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
