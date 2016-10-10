package cn.tk.java.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @Author: lijl85
 * @Title: BatchUtil.java
 * @Package: cn.tk.java.util
 * @Time: 2016年10月10日下午4:40:52
 *
 * @Description: 批处理仿真
 * 1. while 循环截取子集： 创建两个索引直接截取子集
 * 2. for 循环创建临时列表： 小包不停的放到临时列表中
 */
public class BatchUtil {
	
	/**
	 * @Description: 批量插入数据库
	 */
	public void save(List<Integer> subList)
	{
		System.out.println("插入1000条数据");
	}
	/**
	 * @Description:批量更新数据库
	 */
	private int update(List<Integer> tempList) {
		System.out.println("更新1000条数据");
		return 1000;
	}
	
	/**
	 * @Description: while 循环截取子集
	 * listSize: 总数量
	 * stepSize； 操作步长，每次批量处理数量
	 * subList； 子列表，每次批量操作的数据
	 */
	public int saveBatch(List<Integer> lists)
	{
		List<Integer> subList = new ArrayList<Integer>();
		int listSize = lists.size();
		int stepSize = 1000;
		int startIndex = 0;
		int endIndex = 0;
		int saveCount = 0;
		while(listSize > 0) {
			if (listSize > 0 && listSize - stepSize > 0) {
				endIndex = startIndex + stepSize;
			}else {
				endIndex = startIndex + listSize;
			}
			lists.subList(startIndex, endIndex-1);
			save(subList);
			startIndex = endIndex;
			listSize = listSize - stepSize;
			saveCount ++;
		}
		return saveCount;
	}
	
	/**
	 * @Description: for 循环创建临时链表
	 * 注意 List 使用 ArrayList 不用 LinkedList， LinkedList 的  get() 方法很慢
	 */
	public int updateBatch(List<Integer> lists) {
		int updateCount = 0;
		int stepSize = 1000;
		int listSize = lists.size();
		List<Integer> tempList = new ArrayList<Integer>();
		for (int i = 0; i < listSize; i++) {
			tempList.add(lists.get(i));
			if (tempList.size() >= stepSize) {
				update(tempList);
				updateCount ++;
				tempList.clear();
			}
		}
		if (tempList.size() > 0) {
			update(tempList);
			updateCount ++;
			tempList.clear();
		}
		return updateCount;
	}
	
	@Test
	public void testSaveBatch()
	{
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10002311; i++) {
			list.add(i);
		}
		long startTime = System.currentTimeMillis();
		System.out.println("批量插入次数： " + saveBatch(list));
		long endTime = System.currentTimeMillis();
		System.out.println("总共花费时间： " + (endTime-startTime) / 1000 + "s");
	}
	@Test
	public void testUpdateBatch()
	{
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10002311; i++) {
			list.add(i);
		}
		long startTime = System.currentTimeMillis();
		System.out.println("批量更新次数： " + updateBatch(list));
		long endTime = System.currentTimeMillis();
		System.out.println("总共花费时间： " + (endTime-startTime) / 1000 + "s");
	}
}
