package cn.tk.java.util.date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateUtilsTest {

	/**
	 * @description:字符串按特殊格式转日期
	 * @description:特殊格式日期转字符串
	 * 字符串日期相互转换
	 */
	@Test
	public void testStr2Date()
	{
		Date loveDay = DateUtils.str2Date("2016-02-14", DateUtils.yy_MM_dd);
		System.out.println(loveDay.toString());
	}
	@Test
	public void testDate2Str()
	{
		String today = DateUtils.date2Str(new Date(), DateUtils.yy_MM_dd);
		System.out.println(today);
		assertThat(today, equalTo("2016-07-14"));
	}
	@Test
	public void Long2Date()
	{
		Long currentTime = new Long(System.currentTimeMillis());
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(currentTime);
		Date date = DateUtils.str2Date(dateStr, DateUtils.standard);
		System.out.println(date);
	}

	/**
	 * @description:计算当前时间的毫秒值： System.currentTimeMillis
	 */
	@Test
	public void testGetMillis()
	{
		System.out.println(DateUtils.getMillis());
	}

	/**
	 * @description:将 Date 格式化
	 */
	@Test
	public void testFormatDate()
	{
		System.out.println(DateUtils.formatDate(new Date()));
	}
	@Test
	public void testFromatYYYY()
	{
		System.out.println(DateUtils.formatYYYY());
	}
	@Test
	public void testFormatYYYYMM()
	{
		System.out.println(DateUtils.formatYYYYMM());
	}
	@Test
	public void testFormatYYYYMMddHHmmssSSS()
	{
		System.out.println(DateUtils.formatYYYYMMddHHmmssSSS());
	}
	@Test
	public void testFormatYYYYWW()
	{
		System.out.println(DateUtils.formatYYYYWW());
	}

	/**
	 * @description: Unix 时间戳, 1970年至今的秒数, Date --> Unix时间戳
	 */
	@Test
	public void testGetUnixTimestamp()
	{
		System.out.println(DateUtils.getUnixTimestamp());
	}
	@Test
	public void testGetUnixTimestampByDate()
	{
		System.out.println(DateUtils.getUnixTimestamp(new Date()));
	}
	@Test
	public void testGetUnixTimestampWithFormat()
	{
		System.out.println(DateUtils.getUnixTimestamp("2016-07-14", DateUtils.yy_MM_dd));
	}
	/**
	 * @description: Unix时间戳 --> Date
	 */
	@Test
	public void testUnixTimestampToDate()
	{
		System.out.println(DateUtils.unixTimestampToDate(1468425600, DateUtils.yy_MM_dd));
	}
	@Test
	public void testUnixTimestampToDateDefault()
	{
		System.out.println(DateUtils.unixTimestampToDate(1468425600));
	}

	/**
	 * @description:计算两个时间点之间的差距
	 */
	@Test
	public void testDateDiff()
	{
		Date today = DateUtils.str2Date("2016-07-14", DateUtils.yy_MM_dd);
		Date yesterday = DateUtils.str2Date("2016-07-13", DateUtils.yy_MM_dd);
		System.out.println("startTime: " + DateUtils.date2Str(yesterday, DateUtils.standard));
		System.out.println("endTime: " + DateUtils.date2Str(today, DateUtils.standard));
		System.out.println("diff between year: " + DateUtils.dateDiff('y', yesterday, today) + " 年");
		System.out.println("diff between month: " + DateUtils.dateDiff('M', yesterday, today) + " 个月");
		System.out.println("diff between day: " + DateUtils.dateDiff('d', yesterday, today) + " 天");
		System.out.println("diff between hour: " + DateUtils.dateDiff('h', yesterday, today) + " 小时");
		System.out.println("diff between mimute: " + DateUtils.dateDiff('m', yesterday, today) + " 分钟");
		System.out.println("diff between second: " + DateUtils.dateDiff('s', yesterday, today) + " 秒");
	}

	/**
	 * @description:根据时间戳或者 Date 获取 UTC 标准时间
	 */
	@Test
	public void testGetUTCTimeByDate()
	{
		System.out.println(DateUtils.getUTCTime(new Date()));
	}
	@Test
	public void getUTCTime()
	{
		System.out.println(DateUtils.getUTCTime(1468425600));
	}

	/**
	 * @description: 获取今天零点的时间戳
	 */
	@Test
	public void testGetTodayZeroSeconds()
	{
		System.out.println(DateUtils.getTodayZeroSeconds());
		System.out.println(DateUtils.getUTCTime(DateUtils.getTodayZeroSeconds()));
	}

	/**
	 * @description:加减时间， scope: y 是减， 其余是加
	 */
	@Test
	public void testGetDate()
	{
		long minusdate = DateUtils.getDate(5, "s", "y");
		long plusdate = DateUtils.getDate(5, "s", "");
		System.out.println(DateUtils.unixTimestampToDate(minusdate, DateUtils.yy_MM_dd));
		System.out.println(DateUtils.unixTimestampToDate(plusdate, DateUtils.yy_MM_dd));
	}

	/**
	 * @description:获取两个日期之间的所有日期， 包含 startTime, 不包含 endTime
	 */
	@Test
	public void testGetRangeDates()
	{
		long startTime = DateUtils.getUnixTimestamp("2016-07-10", DateUtils.yy_MM_dd);
		long endTime = DateUtils.getUnixTimestamp("2016-07-15", DateUtils.yy_MM_dd);
		System.out.println(DateUtils.getRangeDates(startTime, endTime));
	}

	/**
	 * @description:格式化时间戳， 获取 Time， String 类型的
	 */
	@Test
	public void testGetTime()
	{
		System.out.println(DateUtils.getTime(1468425600, DateUtils.yy_MM_dd));
	}

	/**
	 * @description:获取当月第一天的时间戳
	 */
	@Test
	public void testGetCurrentMonthZeroTimestamp()
	{
		System.out.println(DateUtils.getCurrentMonthZeroTimestamp());
		System.out.println(DateUtils.getTime(DateUtils.getCurrentMonthZeroTimestamp(), DateUtils.yy_MM_dd));
	}

	/**
	 * @description:返回相隔天数
	 */
	@Test
	public void testGetDateDiff()
	{
		long beginTime = DateUtils.getUnixTimestamp("2016-07-10", DateUtils.yy_MM_dd);
		long endTime = DateUtils.getUnixTimestamp("2016-07-15", DateUtils.yy_MM_dd);
		Date beginDate = DateUtils.str2Date("2016-07-10", DateUtils.yy_MM_dd);
		Date endDate = DateUtils.str2Date("2016-07-15", DateUtils.yy_MM_dd);
		System.out.println(DateUtils.getDateDiff(beginTime, endTime));
		System.out.println(DateUtils.dateDiff('d', beginDate, endDate));
	}

	/**
	 * @description:当前时间的前 day 天零时
	 */
	@Test
	public void testGetBeforeDay()
	{
		System.out.println(DateUtils.getBeforeDay(5));
	}

	/**
	 * @description:传入参数与当前时间毫秒差
	 */
	@Test
	public void testDiffSecondNow()
	{
		System.out.println(DateUtils.diffSecondNow(1468425600));
	}
}
