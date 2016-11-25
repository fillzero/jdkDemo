package cn.tk.java.util.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import com.google.common.collect.Lists;

public class TreeSetDemo {
	/**
	 * @description:会自动排序， 所有插入元素必须实现 Comparable 接口
	 */
	@Test
	public void testAdd()
	{
		Set<String> treeSet = new TreeSet<String>();
		treeSet.addAll(Lists.newArrayList("lijinlong", "wangwenchao", "zhaoxiaoli", "zhaominzhe", "maxiaotiao", "bieshiren"));
		System.out.println(treeSet.toString());
	}
	
	/**
	 * @description:集合类都有迭代器用来遍历所有元素， iterator() 正向迭代
	 */
	@Test
	public void testIterator()
	{
		Set<String> treeSet = new TreeSet<String>();
		treeSet.addAll(Lists.newArrayList("lijinlong", "wangwenchao", "zhaoxiaoli", "zhaominzhe", "maxiaotiao", "bieshiren"));
		Iterator<String> iterator = treeSet.iterator();
		while(iterator.hasNext())
		{
			System.out.print(iterator.next() + " ");
		}
		System.out.println("\n" + iterator.hashCode());
	}
	
	/**
	 * @description:迭代器反向迭代
	 */
	@Test
	public void testDecendingIterator()
	{
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.addAll(Lists.newArrayList("lijinlong", "wangwenchao", "zhaoxiaoli", "zhaominzhe", "maxiaotiao", "bieshiren"));
		Iterator<String> descendingIterator = treeSet.descendingIterator();
		while(descendingIterator.hasNext())
		{
			System.out.print(descendingIterator.next() + " ");
		}
		System.out.println("\n" + descendingIterator.hashCode());
	}
	
	@Test
	public void testInstanceof()
	{
		TreeSet<String> treeSet = new TreeSet<String>();
		if (treeSet instanceof Set) {
			System.out.println("Treeset is a member of Java Collection Framework!");
		}
		System.out.println("lijinlong" instanceof Object);
		System.out.println(new Integer(123) instanceof Object);
		System.out.println(new RuntimeException() instanceof Exception);
	}
	
	/**
	 * @description:获取反向集合
	 */
	@Test
	public void testDecendingSet()
	{
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.addAll(Lists.newArrayList("lijinlong", "wangwenchao", "zhaoxiaoli", "zhaominzhe", "maxiaotiao", "bieshiren"));
		NavigableSet<String> descendingSet = treeSet.descendingSet();
		System.out.println(descendingSet.toString());
	}
	
	/**
	 * @description:线程安全的 TreeSet
	 */
	@Test
	public void testSecureTreeset()
	{
		SortedSet<String> set = Collections.synchronizedSortedSet(new TreeSet<String>());
		set.add("lijinlong");
	}
	
	/**
	 * @description:TreeSet 基本方法
	 */
	@Test
	public void testBasicMethod()
	{
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.addAll(Lists.newArrayList("lijinlong", "wangwenchao", "zhaoxiaoli", "zhaominzhe", "maxiaotiao", "bieshiren"));
		System.out.println(treeSet);
		System.out.println(treeSet.first());
		System.out.println(treeSet.last());
		System.out.println(treeSet.floor("wangwenchao"));
		System.out.println(treeSet.ceiling("wanwenchao"));
		
		SortedSet<String> subSet = treeSet.subSet("lijinlong", "zhaominzhe");
		System.out.println(subSet);
	}
}
