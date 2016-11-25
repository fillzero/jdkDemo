package cn.tk.java.lang.string;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StringSubStringDemo {
	@Test
	public void testSubstring()
	{
		List<String> handler = new ArrayList<String>();
		for(int i=0; i<10000; i++)
		{
			HugeStr hugeStr = new HugeStr();
			ImprovedHugeStr hugeStr2 = new ImprovedHugeStr();
			handler.add(hugeStr.getSubString(1,  5));
			handler.add(hugeStr2.getSubString(1, 5));
		}
	}
	
	/**
	 * @description:可以存放 80 万个字符的字符串
	 */
	static class HugeStr{
		private String string = new String(new char[800000]);
		public String getSubString(int begin, int end)
		{
			return string.substring(begin, end);
		}
	}
	
	/**
	 * @description:可以存放 1000 万个字符的字符串
	 */
	static class ImprovedHugeStr{
		private String string = new String(new char[10000000]);
		public String getSubString(int begin, int end)
		{
			return new String(string.substring(begin, end));
		}
	}
}
