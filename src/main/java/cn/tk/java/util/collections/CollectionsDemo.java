package cn.tk.java.util.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @Description:Collections 集合类
 */
public class CollectionsDemo {
	/**
	 * @Description:排序
	 */
	@Test
	public void testSort() {
		List<Double> list = new ArrayList<Double>();
		double array[] = { 112, 111, 23, 456, 231 };
		for (int i = 0; i < array.length; i++) {
			list.add(new Double(array[i]));
		}
		Collections.sort(list);
		for (int i = 0; i < array.length; i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * @Description:混排
	 */
	@Test
	public void testShuffle() {
		List<Double> list = new ArrayList<Double>();
		double array[] = { 112, 111, 23, 456, 231 };
		for (int i = 0; i < array.length; i++) {
			list.add(new Double(array[i]));
		}
		Collections.shuffle(list);
		for (int i = 0; i < array.length; i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * @Description:反转
	 */
	@Test
	public void testReverse() {
		List<Double> list = new ArrayList<Double>();
		double array[] = { 112, 111, 23, 456, 231 };
		for (int i = 0; i < array.length; i++) {
			list.add(new Double(array[i]));
		}
		Collections.reverse(list);
		for (int i = 0; i < array.length; i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * @Description:替换， 用指定元素替换容器中所有元素
	 */
	@Test
	public void testFill() {
		List<String> list = new ArrayList<String>();
		String str[] = { "dd", "aa", "bb", "cc", "ee" };
		for (int j = 0; j < str.length; j++) {
			list.add(new String(str[j]));
		}
		Collections.fill(list, "aaa");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list[" + i + "]=" + list.get(i));
		}
	}

	/**
	 * @Description:copy(List dest, List src): src > dest 越界异常
	 * copy 就是用小集合数据替换大集合数据前面的一部分
	 */
	@Test
	public void testCopy() {
		double array1[] = { 112, 111, 23, 456, 231 };
		List<Double> list1 = new ArrayList<Double>();
		List<Double> list2 = new ArrayList<Double>();
		for (int i = 0; i < array1.length; i++) {
			list1.add(new Double(array1[i]));
		}
		double array2[] = { 1131, 333 };
		for (int j = 0; j < array2.length; j++) {
			list2.add(new Double(array2[j]));
		}
		Collections.copy(list1, list2);
		for (int i = 0; i < list1.size(); i++) {
			System.out.println("list1[" + i + "]=" + list1.get(i));
		}
	}
}
