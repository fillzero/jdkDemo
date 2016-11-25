package cn.tk.java.util.collections;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;

/**
 * @Author: lijl85
 * @Title: TreeMapDemo.java
 * @Package: cn.tk.java.util.collections
 * @Time: 2016年10月21日下午4:05:11
 *
 * @description:排序平衡二叉树（红黑树）
 * 1、添加节点（重新调整）
 * 2、删除节点（重新调整）
 * 3、修改节点
 * 4、查找节点
 * 5、调整平衡： fixAfterInsertion
 * 6、遍历结构
 * 
 * 注： 排序树如果只有左结点或者只有右结点的时候相当于一个链表，检索性能可能会变低，所以引入红黑树，在排序树的基础上进行平衡调整
 * 
 * 红黑树性质：
 * 	性质 1：每个节点要么是红色，要么是黑色。
 *	性质 2：根节点永远是黑色的。 
 *	性质 3：所有的叶节点都是空节点（即 null），并且是黑色的。 
 *	性质 4：每个红色节点的两个子节点都是黑色。（从每个叶子到根的路径上不会有两个连续的红色节点）
 *	性质 5：从任一节点到其子树中每个叶子节点的路径都包含相同数量的黑色节点。 
 */
public class TreeMapDemo {
	/**
	 * @description:添加节点
	 * 插入元素然后调整红黑树， TreeMap 内部维护了一颗红黑树（自动调整平衡）
	 */
	@Test
	public void testAdd()
	{
		TreeMap<String, Double> map = new TreeMap<String, Double>();
		map.put("ccc", 89.0);
		map.put("aaa", 80.0);
		map.put("zzz", 80.0);
		map.put("bbb", 89.0);
		System.out.println(map);
		System.out.println(map.get("aaa"));
	}
	
	/**
	 * @description: 更新节点
	 * Delete the node, and then rebalance the tree.
	 * 删除节点，并且自动调整红黑树至平衡状态， 返回被删除元素
	 */
	@Test
	public void testDelete()
	{
		TreeMap<String, Double> map = new TreeMap<String, Double>();
		map.put("zzz", 80.0);
		map.put("ccc", 89.0);
		map.put("aaa", 80.0);
		Double removeValue = map.remove("aaa");
		System.out.println("removeValue is: " + removeValue);
		System.out.println(map);
	}
	
	/**
	 * @description:更新节点
	 * 更新节点不需要调整位置，因为只是修改值不会改变树的结构（树的排序是以 key 为主要依据的， 所以 value 的修改不会影响排序）
	 */
	@Test
	public void testUpdate()
	{
		TreeMap<String, Double> map = new TreeMap<String, Double>();
		map.put("ccc", 89.0);
		map.put("aaa", 80.0);
		map.put("zzz", 80.0);
		map.put("bbb", 89.0);
		System.out.println(map);
		map.put("zzz", 89.0);
		System.out.println(map); //修改元素 value，树结构不变，排序以 key 为依据
	}
	
	/**
	 * @description:TreeMap 本身是非同步的，不是线程安全的， 如果要在多线程环境中使用， 需要手动同步
	 */
	@Test
	public void testSynchronizedTreeMap()
	{
		SortedMap<String, Double> map = Collections.synchronizedSortedMap(new TreeMap<String, Double>());
		map.put("ccc", 89.0);
		map.put("aaa", 80.0);
		map.put("zzz", 80.0);
		System.out.println(map);
	}
}
