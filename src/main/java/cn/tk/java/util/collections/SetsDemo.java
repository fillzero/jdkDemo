package cn.tk.java.util.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
	 * @Description:集合分块测试： 使用 Arrays.copyOfRange(array, from, to)
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
	 * @Description:集合分块测试： 使用 list.subList(from, to)
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
	 * @Description:测试集合是否能够去重复
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
	 * @Description:subList(from, to) 截取的是 from ~ (to-1) 的数
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
	 * @Description: copyOfRange(array, from, to) 截取的是 from ~ (to-1) 的数
	 * 这种截取子数组的方式取不到最后一位，一定要特别注意
	 */
	@Test
	public void testCopyOfRange()
	{
		String[] array = {"openId_1", "openId_2", "openId_3", "openId_4", "openId_5", "openId_6", "openId_7", "openId_8", "openId_9", "openId_10", "openId_11"};
		ArrayList<String> list = Lists.newArrayList(Arrays.copyOfRange(array, 0, 10));
		System.out.println(list.toString());
	}
}
