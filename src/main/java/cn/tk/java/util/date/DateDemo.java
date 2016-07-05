package cn.tk.java.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class DateDemo {
	/**
	 * @Description:时间戳转 Date
	 */
	@Test
	public void testTimestampToDate() throws ParseException
	{
		Long currentTime = new Long(1467027632423L);  
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String date = format.format(currentTime);
		System.out.println(date);
		System.out.println(System.currentTimeMillis());
	}
}
