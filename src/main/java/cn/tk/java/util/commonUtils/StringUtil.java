package cn.tk.java.util.commonUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

import org.joda.time.DateTime;

/**
 * 字符串工具类
 */
@Slf4j
public class StringUtil {

	/**
	 * 空值
	 */
	public static final String EMPTY = "";

	/**
	 * 判断字符串是否为空
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * 判断字符串不为空
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * 从右往左每隔interval位插入一个分隔符seperator
	 */
	public static String addSeperator(String str, int interval, String seperator)
	{
		String temp = new StringBuilder(str).reverse().toString();
		String result = "";
		for (int i = 0; i < temp.length(); i++) {
			if (i * interval + interval > temp.length()) {
				result += temp.substring(i * interval, temp.length());
				break;
			}
			result += temp.substring(i * interval, i * interval + 3)
					+ seperator;
		}
		if (result.endsWith(seperator)) {
			result = result.substring(0, result.length() - 1);
		}
		return new StringBuilder(result).reverse().toString();
	}

	/**
	 * 得到指定分割符之前的str（str中左起第一个分割符之前）
	 * 
	 * @param str源字符串
	 * @param separator分割符
	 * @return 指定分割符之前的str
	 * @author zhaopuqing
	 */
	public static String substringBefore(String str, String separator) {
		if (isEmpty(str) || separator == null)
			return str;
		if (separator.length() == 0)
			return EMPTY;
		int pos = indexOfIgnoreCase(str, separator);
		if (pos == -1)
			return str;
		return str.substring(0, pos);
	}

	/**
	 * 得到指定分割符之后的str（str中左起第一个分割符之后）
	 * 
	 * @param str源字符串
	 * @param separator分割符
	 * @return 指定分割符之后的str
	 * @author zhaopuqing
	 */
	public static String substringAfter(String str, String separator) {
		if (str == null || str.trim().equals(EMPTY))
			return str;
		if (separator == null)
			return EMPTY;
		int pos = indexOfIgnoreCase(str, separator);
		if (pos == -1)
			return EMPTY;
		return str.substring(pos + separator.length());
	}

	/**
	 * 得到搜索字符在str中的位置下标（左起第一个，大小写不敏感）
	 * 
	 * @param str
	 *            源字符串
	 * @param searchStr
	 *            要搜索的字符串
	 * @return 搜索字符在str中的位置下标（左起第一个）
	 * @author zhaopuqing
	 */
	public static int indexOfIgnoreCase(String str, String searchStr) {
		return indexOfIgnoreCase(str, searchStr, 0);
	}

	/**
	 * 得到搜索字符在str中的位置下标（左起startPos个字符之后，大小写不敏感）
	 * 
	 * @param str
	 *            源字符串
	 * @param searchStr
	 *            要搜索的字符串
	 * @param startPos
	 *            搜索开始位置
	 * @return 得到搜索字符在str中的位置下标（左起startPos个字符之后）
	 * @author zhaopuqing
	 */
	public static int indexOfIgnoreCase(String str, String searchStr,
			int startPos)
	{
		int spos = startPos;
		if (str == null || searchStr == null)
			return -1;
		if (spos < 0) {
			spos = 0;
		}
		int endLimit = (str.length() - searchStr.length()) + 1;
		if (spos > endLimit)
			return -1;
		if (searchStr.length() == 0)
			return spos;
		for (int i = spos; i < endLimit; i++) {
			if (str.regionMatches(true, i, searchStr, 0, searchStr.length()))
				return i;
		}
		return -1;
	}

	/**
	 * 将字符串数组拼接成字符串
	 * 
	 * @param strArray
	 *            字符串数组
	 * @param separator
	 *            分隔符
	 * @return
	 * @author zhaopuqing
	 * 
	 */
	public static String combineToString(String[] strArray, String separator) {
		StringBuilder result = new StringBuilder();
		for (String str : strArray) {
			result.append(str).append(separator);
		}
		if (result.length() > 0) {
			result.setLength(result.length() - 1);
		}
		return result.toString();
	}

	/**
	 * 将字符串List拼接成字符串
	 * 
	 * @param strList
	 *            字符串List
	 * @param separator
	 *            分隔符
	 * @return
	 * @author zhaopuqing
	 * 
	 */
	public static String combineToString(List<String> strList, String separator)
	{
		return combineToString(strList.toArray(new String[strList.size()]),
				separator);
	}

	/**
	 * 异常转成字符串,并带有详细的堆栈信息
	 * 
	 * @param throwable
	 * @return
	 * @author zhaopuqing
	 */
	public static String toStringFromThrowableWithStackTrace(Throwable throwable)
	{

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		throwable.printStackTrace(pw);
		pw.flush();
		sw.flush();
		return sw.toString();

	}

	public static String nvl(String expr1) {
		return expr1 == null ? "" : expr1;
	}

	public static String nvl(String expr1, String expr2) {
		return expr1 == null ? expr2 : expr1;
	}

	public static String firstCharUpperCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String firstCharLowerCase(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	/**
	 * @Title 获取32位随即数，作为id @return @throws
	 */
	public static String getUUID() {
		String str = UUID.randomUUID().toString();
		String temp = str.replace("-", "");
		return temp;
	}

	/**
	 * @Title 获取20位随机数字，作为订单号 @return @throws
	 */
	public static String getBillNo() {
		String billno = "";
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < 13; i++) {
			int subNum = random.nextInt(9);
			billno = billno + subNum;
		}
		// for(int i=0;i<13;i++){
		// String zhi = (int)(10*Math.random())+"";
		// billno = billno+zhi;
		// }
		return billno;
	}

	/**
	 * @Title 根据身份证获取年龄
	 * @param cid
	 *            身份证号码
	 * @return age 年龄
	 */
	public static int getAgeByIdCard(String cid) {
		String year = "";
		String month = "";
		String data = "";
		if (cid.length() == 18) {
			year = cid.substring(6, 10);
			month = cid.substring(10, 12);
			data = cid.substring(12, 14);
			// birthday = cid.substring(6, 10)+"-"+cid.substring(10, 12)+"-"+
			// cid.substring(12, 14);//身份证上的日期
		} else {
			year = "19" + cid.substring(6, 8);
			month = cid.substring(8, 10);
			data = cid.substring(10, 12);
			// birthday = "19"+cid.substring(6, 8)+"-"+
			// cid.substring(8, 10)+"-"+cid.substring(10, 12);
		}
		int birth_year = Integer.parseInt(year);
		int birth_month = Integer.parseInt(month);
		int birth_date = Integer.parseInt(data);

		Calendar today = Calendar.getInstance();
		today.setTime(new java.util.Date());

		int today_year = today.get(1);
		int today_month = today.get(2) + 1;
		int today_date = today.get(5);

		if ((today_month > birth_month)
				|| ((today_month == birth_month) && (today_date >= birth_date)))
			return (today_year - birth_year);
		else
			return (today_year - birth_year - 1);

	}

	/**
	 * @Title: getDateAlter
	 * @Description: 计算指定时间的天数之前的时间 <br>
	 *               <i>正：向后；负：向前</i></br>
	 * @param dateStr
	 *            指定时间
	 * @param pattern
	 *            "2012-03-08 01:11:23"/"2012-03-08"
	 * @param yearNum
	 *            年数
	 * @param monthNum
	 *            月数
	 * @param dayNum
	 *            天数
	 * @param hourNum
	 *            时数
	 * @param minuteNum
	 *            分数
	 * @param secondNum
	 *            秒数
	 * @return pattern格式的结果时间串
	 * @throws ParseException
	 */
	public static String getDateAlter(String dateStr, String pattern,
			int yearNum, int monthNum, int dayNum, int hourNum, int minuteNum,
			int secondNum) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTime(sdf.parse(dateStr));
		cal.add(Calendar.YEAR, yearNum);
		cal.add(Calendar.MONTH, monthNum);
		cal.add(Calendar.DATE, dayNum);
		cal.add(Calendar.HOUR_OF_DAY, hourNum);
		cal.add(Calendar.MINUTE, minuteNum);
		cal.add(Calendar.SECOND, secondNum);
		return sdf.format(cal.getTime());
	}

	public static String getDateAlter(String dateTimeStr, int yearNum,
			int monthNum, int dayNum, int hourNum, int minuteNum, int secondNum)
			throws ParseException
	{
		return getDateAlter(dateTimeStr, "yyyy-MM-dd HH:mm:ss", yearNum,
				monthNum, dayNum, hourNum, minuteNum, secondNum);
	}

	/**
	 * @Title 检查参数是否为空 @return @throws
	 */
	public static boolean isNull(String par) {
		boolean flag = false;
		if (null == par || "".equals(par)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 计算日期的函数 author: HST 参照日期指当按照年月进行日期的计算的时候，参考的日期，如下例，结果返回2002-03-31
	 * 
	 * @param baseDate
	 *            起始日期
	 * @param interval
	 *            时间间隔
	 * @param unit
	 *            时间间隔单位
	 * @param compareDate
	 *            参照日期
	 * @return Date类型变量
	 */
	public static Date calDate(Date baseDate, int interval, String unit,
			Date compareDate)
	{
		Date returnDate = null;
		GregorianCalendar mCalendar = new GregorianCalendar();
		mCalendar.setTime(baseDate);
		if (unit.equals("Y")) {
			mCalendar.add(Calendar.YEAR, interval);
		} else if (unit.equals("M")) {
			mCalendar.add(Calendar.MONTH, interval);
		} else if (unit.equals("D")) {
			mCalendar.add(Calendar.DATE, interval);
		}
		if (compareDate != null) {
			GregorianCalendar cCalendar = new GregorianCalendar();
			cCalendar.setTime(compareDate);
			int mYears = mCalendar.get(Calendar.YEAR);
			int mMonths = mCalendar.get(Calendar.MONTH);
			int cMonths = cCalendar.get(Calendar.MONTH);
			int cDays = cCalendar.get(Calendar.DATE);

			if (unit.equals("Y")) {
				cCalendar.set(mYears, cMonths, cDays);
				if (cCalendar.before(mCalendar)) {
					mCalendar.set(mYears + 1, cMonths, cDays);
					returnDate = mCalendar.getTime();
				} else {
					returnDate = cCalendar.getTime();
				}
			} else if (unit.equals("M")) {
				cCalendar.set(mYears, mMonths, cDays);
				if (cCalendar.before(mCalendar)) {
					mCalendar.set(mYears, mMonths + 1, cDays);
					returnDate = mCalendar.getTime();
				} else {
					returnDate = cCalendar.getTime();
				}
			} else if (unit.equals("D")) {
				returnDate = mCalendar.getTime();
			}
		} else {
			returnDate = mCalendar.getTime();
		}
		return returnDate;
	}

	/**
	 * 获取20位大小写加数字随机串
	 * 
	 * @return
	 */
	public static String getRandomStr() {
		int length = 20;
		char[] ss = new char[length];
		int i = 0;
		while (i < length) {
			int f = (int) (Math.random() * 3);
			if (f == 0)
				ss[i] = (char) ('A' + Math.random() * 26);
			else if (f == 1)
				ss[i] = (char) ('a' + Math.random() * 26);
			else
				ss[i] = (char) ('0' + Math.random() * 10);
			i++;
		}
		String is = new String(ss);
		return is;
	}

	/**
	 * 将字符串进行非空判断，null转成“”并进行去除空格。
	 * 
	 * @param value
	 * @return
	 */
	public static String killNull(String value) {
		value = value == null ? "" : value.trim();
		return value;
	}

	/**
	 * 去除字符串中的换行
	 * 
	 * @param str
	 * @return
	 */
	public static String killEnter(String str) {
		str = killNull(str);
		if (!str.equals("")) {
			str = str.replace("\n", "");
		}
		return str;
	}

	public static int getAge(String birthday) {
		int age = 0;
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String svy = format.format(new Date());
		int bYear = Integer.parseInt(birthday.substring(0, 4));
		int vYear = Integer.parseInt(svy.substring(0, 4));
		age = vYear - bYear;
		String sbc = svy.substring(0, 4) + birthday.substring(4, 10);
		java.util.Date db = null;
		try {
			db = format.parse(sbc);
		} catch (ParseException e) {
			log.error("", e);
			return 0;
		}
		if (db.after(date)) {
			age = age - 1;
		}
		return age;
	}

	public static int getAgeNew(String cid) {
		String year = "";
		String month = "";
		String data = "";
		if (cid.length() == 18) {
			year = cid.substring(6, 10);
			month = cid.substring(10, 12);
			data = cid.substring(12, 14);
			// birthday = cid.substring(6, 10)+"-"+cid.substring(10, 12)+"-"+
			// cid.substring(12, 14);//身份证上的日期
		} else {
			year = "19" + cid.substring(6, 8);
			month = cid.substring(8, 10);
			data = cid.substring(10, 12);
			// birthday = "19"+cid.substring(6, 8)+"-"+
			// cid.substring(8, 10)+"-"+cid.substring(10, 12);
		}
		int birth_year = Integer.parseInt(year);
		int birth_month = Integer.parseInt(month);
		int birth_date = Integer.parseInt(data);

		Calendar today = Calendar.getInstance();
		today.setTime(new java.util.Date());

		int today_year = today.get(1);
		int today_month = today.get(2) + 1;
		int today_date = today.get(5);

		if ((today_month > birth_month)
				|| ((today_month == birth_month) && (today_date >= birth_date)))
			return (today_year - birth_year);
		else
			return (today_year - birth_year - 1);

	}

	/**
	 * 获取保险的生效起始日期，为购买第二天生效
	 * 
	 * @return
	 */
	public static long getStartDate() {
		DateTime beginDate = new DateTime();
		beginDate = beginDate.plusDays(1);// 获取当前日期的第二天日期
		return beginDate.getMillis();
	}

	/**
	 * 
	 * @param unit
	 *            单位 ,年:year 月：month
	 * @param number
	 *            保障期限
	 * @return 获取保障的结束日期
	 */
	public static long getEndDate(String unit, int number) {
		DateTime dateTime = new DateTime();
		if ("year".equals(unit)) {
			dateTime = dateTime.plusYears(number);
		} else if ("month".equals(unit)) {
			dateTime = dateTime.plusMonths(number);
		}
		return dateTime.getMillis();
	}

	/**
	 * 获取两个日期中间的间隔的所有月份
	 * 
	 * @param firstTime
	 * @param endTime
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getBetweenMonths(String beginTime, String endTime)
			throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateTime beginDate = new DateTime(format.parse(beginTime));// 开始日期
		DateTime endDate = new DateTime(format.parse(endTime));// 结束日期
		List<String> list = new ArrayList<String>();
		// 添加第一个月，即开始时间
		list.add(beginDate.toString("yyyy-MM"));
		while (beginDate.compareTo(endDate) < 0) {
			beginDate = beginDate.plusMonths(1);
			list.add(beginDate.toString("yyyy-MM"));
		}
		return list;
	}

}