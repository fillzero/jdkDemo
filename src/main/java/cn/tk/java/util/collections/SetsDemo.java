package cn.tk.java.util.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Lists;

public class SetsDemo {
	/**
	 * @Description:subList 每次按范围取数是否都是不同的
	 */
	@Test
	public void testDivision()
	{
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < 11; i++) {
			set.add("openId" + i);
		}
		
		int parts = (set.size() / 1000) + 1;
		for (int i = 0; i < parts; i++) {
			List<String> subList = Lists.newArrayList(set).subList(i * 1000, i * 1000 + 1000);
			System.out.println("第" + (i+1) + "个集合的大小是： " + subList.size());
		}
	}
}
