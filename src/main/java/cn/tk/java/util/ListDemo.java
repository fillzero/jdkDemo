package cn.tk.java.util;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.google.common.collect.Lists;

public class ListDemo {
	/**
	 * @description: 3 没有删除掉，list 删除一个元素，后面整体前移一个位置， 所以下一个元素不会被删除掉。
	 * @return: [1, 3, 4, 5]
	 */
	@Test
	public void testDeleteByIndex()
	{
		ArrayList<String> list = Lists.newArrayList("1", "2", "3", "4", "5");
		for (int i = 0; i < list.size(); i++) {
			if ("2".equals(list.get(i)) || "3".equals(list.get(i))) {
				list.remove(list.get(i));
			}
		}
		System.out.println(list);
	}
	
	/**
	 * @description:ConcurrentModificationException
	 * 迭代器不允许遍历的时候删除，因为存在隐含风险，所以会 fast-fail
	 */
	@Test
	public void testDeleteByForeach()
	{
		ArrayList<String> list = Lists.newArrayList("1", "2", "3", "4", "5");
		for (String value : list) {
			if ("2".equals(value) || "3".equals(value)) {
				list.remove(value);
			}
		}
		System.out.println(list);
	}
	
	/**
	 * @description:成功删除，这种方法可以实现 for 循环过程中删除元素
	 */
	@Test
	public void testDeleteByIterator()
	{
		ArrayList<String> list = Lists.newArrayList("1", "2", "3", "4", "5");
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String value = (String) iterator.next();
			if ("2".equals(value) || "3".equals(value)) {
				iterator.remove();
			}
		}
		System.out.println(list);
	}
}
