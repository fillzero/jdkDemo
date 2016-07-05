package cn.tk.java.guava.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableCollection.Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * @Company: 泰康在线财产保险股份有限公司
 * @Author: 李晋龙
 * @Title: CollectionsDemo.java
 * @Package: cn.tk.java.guava.collections
 * @Time: 2016年7月5日下午4:35:49
 *
 * @Description: 
 * 1. Guava Collections 都是以 create 或者 of 等静态方法构造对象。
 * 因为构造函数种类较多， 需要传入不同的参数， 使用不便， 使用 create 或者 of 方法， 直观简洁，
 * 而且更利于创建泛型对象
 */
public class CollectionsDemo {
	/**
	 * @Description:UnsupportedOperationException
	 */
	@Test
	public void testUnmodifiableSet()
	{
		Set<String> set = new HashSet<String>(Arrays.asList(new String[]{"RED","GREEN"}));
		Set<String> unmodifiableSet = Collections.unmodifiableSet(set);
		unmodifiableSet.add("BLACK");
		System.out.println(set.toString());
	}
	
	/**
	 * @Description:使用 ImmutableSet 简化代码编写， 直接生成不可更改集合
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testImmuableSet()
	{
		ImmutableSet<String> immutableSet = ImmutableSet.of("RED", "GREEN");
		ImmutableSet<String> copyOfImmutableSet = ImmutableSet.copyOf(immutableSet);
		System.out.println(copyOfImmutableSet.toString());
		immutableSet.add("BLACK");
		System.out.println(immutableSet.toString());
	}
	
	/**
	 * @Description:不可变更集合的构造器, 可以通过构造器添加单个数据， 或者添加既有集合
	 */
	@Test
	public void ImmutableSetBuilder()
	{
		ImmutableSet<String> set = ImmutableSet.of("RED", "GREEN");
		Builder<String> builder = ImmutableSet.builder();
		ImmutableCollection<String> immutableSet = builder.add("BLACK").addAll(set).build();
		System.out.println(immutableSet.toString());
	}
	
	/**
	 * @Description:用普通方式统计每个字符在 List 中出现次数
	 * key 对应字符串， value 对应个数， 第一次放 1， 之后每次放 count + 1
	 */
	@Test
	public void testCount()
	{
		ImmutableList<String> wordList = ImmutableList.of("the", "jack", "what", "the");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String word : wordList)
		{
			Integer count = map.get(word);//每次进来获取之前的 count， 在之前 count 的基础上进行更新
			map.put(word, (count==null) ? 1 : count + 1);
		}
		System.out.println(map.get("the"));
		System.out.println(map.get("jack"));
		System.out.println(map.get("what"));
		System.out.println(map.get("test"));
	}
	
	/**
	 * @Description:用 Multiset 统计字符串在链表中出现的个数， 可重复集合
	 */
	@Test
	public void testCountWithMultiSet()
	{
		ImmutableList<String> wordList = ImmutableList.of("the", "jack", "what", "the");
		HashMultiset<String> multiset = HashMultiset.create();//初始化方法
		multiset.addAll(wordList);
		System.out.println(multiset.count("the"));//直接调用 count 方法进行计数
		System.out.println(multiset.count("jack"));
		System.out.println(multiset.count("what"));
		System.out.println(multiset.count("test"));
	}
}
