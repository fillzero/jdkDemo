package cn.tk.java.lang.string;

import org.junit.Test;

public class StringDemo {
	/**
	 * 找出 characters 首字符在 input 中第一次出现的位置， 从 pos 开始找
	 */
	public static int skipUntil(String input, int pos, String characters) {
		for (; pos < input.length(); pos++) {
			if (characters.indexOf(input.charAt(pos)) != -1) {
				break;
			}
		}
		return pos;
	}
	
	/**
	 * @Description: little 首字符 l 在字符串中第一次出现的位置是 7
	 */
	@Test
	public void testSkipUntil()
	{
		System.out.println(skipUntil("I am a little boy", 1, "little"));
	}

	/**
	 * 找出字符串中非空字符第一次出现的位置， 跳过空格
	 */
	public static int skipWhitespace(String input, int pos) {
		for (; pos < input.length(); pos++) {
			char c = input.charAt(pos);
			if (c != ' ' && c != '\t') {
				break;
			}
		}
		return pos;
	}
	
	@Test
	public void testSkipWhitespace()
	{
		System.out.println(skipWhitespace("  	I'm a cool boy", 0));
	}

	/**
	 * 将 Long 型数转化为 int 型的数	
	 * 大于  (2<sup>31</sup>-1) 的数：2147483647
	 * 小于 0 的数：0
	 * 大于 0 小于  (2<sup>31</sup>-1) 的正数：本身
	 * 无法转换的： 缺省值  defaultValue
	 */
	public static int parseSeconds(String value, int defaultValue) {
		try {
			long seconds = Long.parseLong(value);
			if (seconds > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			} else if (seconds < 0) {
				return 0;
			} else {
				return (int) seconds;
			}
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}
	
	@Test
	public void testParseSeconds()
	{
		System.out.println(parseSeconds("13241324132141431", 12));
		System.out.println(parseSeconds("-123", 12));
		System.out.println(parseSeconds("123", 12));
		System.out.println(parseSeconds("123.3", 12));
	}
}
