package cn.tk.java.util.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Lists;

public class SetsDemo {
	
	private static Set<String> diviSet = new HashSet<String>();
	private static List<String> diviList = new ArrayList<String>();
	
	static{
		for (int i = 0; i < 123; i++) {
			diviSet.add("openId" + i);
		}
		diviList.addAll(diviSet);
	}
	
	/**
	 * @description:集合分块测试： 使用 Arrays.copyOfRange(array, from, to)
	 */
	@Test
	public void testDivision()
	{
		Set<String> newSet = new HashSet<String>();
		
		int parts = diviSet.size() / 10 + 1;
		String[] openIdInArray = diviSet.toArray(new String[0]);
		 
		for (int i=0; i<parts-1; i++) { // 循环 parts-1 次， 最后一次在外面执行，因为最后一个 parts 不满 10 个数
			ArrayList<String> subList = Lists.newArrayList(Arrays.copyOfRange(openIdInArray, i * 10, i * 10 + 10));//0~9, 10~19 ... 110~119
			newSet.addAll(subList);//可以对分块进行数据库操作
		}
		ArrayList<String> subList = Lists.newArrayList(Arrays.copyOfRange(openIdInArray, (parts-1) * 10, openIdInArray.length)); //120~122
		newSet.addAll(subList);

		System.out.println(newSet.size());//新集合自动去重，最后发现将分块加起来还是 123，分块成功
	}
	
	/**
	 * @description:集合分块测试： 使用 list.subList(from, to)
	 */
	@Test
	public void testDivisionBySublist()
	{
		Set<String> newSet = new HashSet<String>();
		
		int length = diviSet.size();
		int parts = length / 10 + 1;//123, 分成 13 块
		
		for (int i=0; i <parts-1; i++) {//处理前 12 块
			List<String> subList = diviList.subList(i*10, i * 10 + 10);
			newSet.addAll(subList);
		}
		List<String> subList = diviList.subList(parts * 10, length); //处理最后一块
		newSet.addAll(subList);
		
		System.out.println(newSet.size());
	}
	
	/**
	 * @description:测试集合是否能够去重复
	 * 结论： 集合确实有自动去重复功能： 内部实际是一个 HashMap，将 add 的值当作 key 放入 map，所以会自动覆盖去重
	 */
	@Test
	public void testSetDelDulplicate()
	{
		Set<String> set = new HashSet<String>();
		set.add("lijinlong");
		Set<String> set2 = new HashSet<String>();
		set2.add("lijinlong");
		set2.add("wangwenchao");
		set2.add(null);//null 也可以成为集合的一个元素
		set.addAll(set2);
		System.out.println(set.toString());
	}
	
	/**
	 * @description:subList(from, to) 截取的是 from ~ (to-1) 的数
	 * 这种截取子链表的方式取不到最后一位，一定要特别注意
	 * ArrayList 内部是一个数组实现， 所以数据是有序的
	 */
	@Test
	public void testSublist()
	{
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 13; i++) {
			list.add("openId" + i);
		}
		
		System.out.println(list.get(0));
		System.out.println(list.subList(0, 10).size());
		System.out.println(list.subList(0, 10).toString()); //截取 0～9 的 10 个数
	}
	
	/**
	 * @description: copyOfRange(array, from, to) 截取的是 from ~ (to-1) 的数
	 * 这种截取子数组的方式取不到最后一位，一定要特别注意
	 */
	@Test
	public void testCopyOfRange()
	{
		String[] array = {"openId_1", "openId_2", "openId_3", "openId_4", "openId_5", "openId_6", "openId_7", "openId_8", "openId_9", "openId_10", "openId_11"};
		ArrayList<String> list = Lists.newArrayList(Arrays.copyOfRange(array, 0, 10));
		System.out.println(list.toString());
	}
	
	/**
	 * @description:负荷系数, 满载率 0.75, 16 是初始大小, 超过 16 * 0.75 = 12 以后就会自动扩容
	 */
	@Test
	public void testLoadFactor()
	{
		int max = Math.max((int) (11 /.75f) + 1, 16);
		System.out.println(max);
	}
	
	/**
	 * @description:初始化 HashSet, 通过 HashMap 内部去重复
	 */
	@Test
	public void testCreateHashSet()
	{
		Set<Integer> oldSet = new HashSet<Integer>();
		for(int i=0; i<21; i++)
		{
			oldSet.add(i);
		}
		Set<Integer> set = new HashSet<Integer>(oldSet);
		System.out.println(set);
	}
	
	/**
	 * @description: 测试 add 方法, AbstractCollection 重写 toString() 方法， 所有集合都使用这个 toString() 方法打印元素
	 */
	@Test
	public void testAdd()
	{
		Set<String> set = new HashSet<String>();
		set.add("lijinlong");
		System.out.println(set.toString());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lijinlong", new Object());
		System.out.println(map.get("lijinlong"));
	}
	
	/**
	 * @description:测试删除方法，按元素删除
	 */
	@Test
	public void testRemove()
	{
		Set<String> set = new HashSet<String>();
		set.add("lijinlong");
		boolean removeStatus = set.remove("lijinlong");
		System.out.println(set.toString());
		System.out.println(removeStatus);
	}
	
	/**
	 * @description:克隆集合对象
	 */
	@Test
	public void testClone()
	{
		HashSet<String> set = new HashSet<String>();
		set.add("lijinlong");
		HashSet<String> set2 = new HashSet<String>();
		set2.add("lijinlong");
		
		Object clone = set.clone();
		System.out.println(clone.toString());
		System.out.println(set.equals(clone));
		System.out.println(set.equals(set2));
	}
	
	/**
	 * @description:集合数据无序，但是可以存放空元素，但会自动去重， 所以由此可看到 HashMap 的 key 值同样可以为空
	 */
	@Test
	public void testAddNull()
	{
		Set<String> set = new HashSet<String>();
		set.addAll(Lists.newArrayList("lijinlong", "wangwenchao", "guodegang", "xijinping", "hujintao", "wenjiabao", null, null));
		System.out.println(set.toString());
		
		System.out.println(set.size());
		System.out.println(set.contains("lijinlong"));
		System.out.println(set.containsAll(Lists.newArrayList("wenjiabao", null)));
	}
	
	/**
	 * @throws InterruptedException 
	 * @description:避免线性不安全问题
	 */
	@Test
	public void testSecureSet() throws InterruptedException
	{
		Set<String> secureSet = Collections.synchronizedSet(new HashSet<String>());
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					secureSet.add("openId" + i);
				}
			}
		});
		thread.start();
		Thread.currentThread();
		Thread.sleep(1000);
		System.out.println(secureSet.size());
	}
	
	/**
	 * @description:使用 HashSet 是不安全的，多线程访问数据会出错
	 */
	@Test
	public void testUnSecureSet() throws InterruptedException
	{
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < 10000; i++) {
			set.add("openId" + i);
		}
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					set.remove("openId" + i);
				}
			}
		});
		thread.start();
		Thread.currentThread();
		Thread.sleep(1000);
		System.out.println(set.size());
	}
}
