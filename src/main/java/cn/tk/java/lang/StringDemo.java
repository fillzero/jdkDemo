package cn.tk.java.lang;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class StringDemo {
	/**
	 * @description:测试 lastIndexOf 获取最后一个匹配字符串的首字母下标
	 */
	@Test
	public void testLastIndexOf()
	{
		String str = "school.class.student.student";
		int lastIndexOfDot = str.lastIndexOf(".");
		assertThat(21, equalTo(str.lastIndexOf("student")));//最后一个匹配字符串的首字母下标
		assertThat(20, equalTo(lastIndexOfDot));
		assertThat("school.class.student", equalTo(str.substring(0, lastIndexOfDot)));
	}
	@Test
	public void testLstIndexOf()
	{
		String str = "woshinibabadebaba";
		assertThat(str.substring(0, str.length()-6), equalTo("woshinibaba"));
	}

	@Test
	public void testStringFormat()
	{
		String htmlTemplate   = "<tr><td>%s:%s</td></tr>";
		String id = "name";
		String content = "lijinlong";
		String html = String.format(htmlTemplate, id, content);
		System.out.println(html);
	}

	@Test
	public void testReplace()
	{
		String demo = "calculateModule";
		demo = demo.replace("Module", "Data");
		System.out.println(demo);
	}
}
