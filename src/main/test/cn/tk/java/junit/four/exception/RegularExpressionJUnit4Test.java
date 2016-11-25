package cn.tk.java.junit.four.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @description:@Test有两个参数可以完成异常测试和超时测试
 * 抛出异常的情况下测试通过, 如果没有抛出改异常, 测试失败
 */
public class RegularExpressionJUnit4Test {
	private static String zipRegEx = "^\\d{5}([\\-]\\d{4})?$";
	private static Pattern pattern;
	
	@BeforeClass
	public static void setUpBeforeClass()
	{
		pattern = Pattern.compile(zipRegEx);
	}
	
	@Test(expected=IndexOutOfBoundsException.class, timeout=1000)
	public void verifyZipCodeGroupException()
	{
		Matcher matcher = RegularExpressionJUnit4Test.pattern.matcher("22101-5051");
		boolean isValid = matcher.matches();
		matcher.group(2);
	}
}
