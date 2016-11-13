package cn.tk.java.collection.demo;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author: lijl85
 * @date：2016年11月13日下午4:36:11
 * @description:TreeSet 是 SortedSet 的实现类
 * SortedSet: 按对象的比较函数对元素排序
 */
public class SortedSetDemo {

	private static final SortedSet<String> sortedSet = new TreeSet<String>();
	public static void main(String[] args) {
		Collections.addAll(sortedSet, "one two three four five six seven eight nine ten".split(" "));
		System.out.println(sortedSet);

		String low = sortedSet.first();
		String high = sortedSet.last();
		System.out.println(low);
		System.out.println(high);

		Iterator<String> iterator = sortedSet.iterator();
		for (int i=0; i<10; i++) {
			if(i==3) {
				low = iterator.next();
			}
			else if(i==6)
			{
				high = iterator.next();
			}
			else {
				iterator.next();
			}
		}

		System.out.println(low);
		System.out.println(high);
		System.out.println(sortedSet.subSet(low, high));//截取 low ~ high-1
		System.out.println(sortedSet.headSet(high));//0 ~ high-1
		System.out.println(sortedSet.tailSet(low));//low ~ last
	}

}
