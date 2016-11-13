package cn.tk.java.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import org.junit.Test;

/**
 * @author: lijl85
 * @date：2016年11月13日下午3:13:29
 * @description:不同的 Set 为了实现自己的特性,必须内置一些方法
 * HashSet必须有 hashCode
 * TreeSet必须有 compareTo
 * Set 必须有 equals
 */
public class TypesForSetsTest {

	/**
	 * 测试容器填充, 没有 hashCode, equals 方法也失效了,没有办法去重
	 * (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	 * Map.put() 方法中, key的获取要使用 hashCode 方法, 所有如果没有 hashCode 方法就无法完成去重操作
	 * equals 方法与 hashCode 方法必须结合使用才能完成去重操作.
	 *
	 * HashSet: 按照特殊顺序维护
	 * LinkedHashSet: 按照输入顺序维护
	 * TreeSet: 按照 compareTo 比较顺序维护
	 */
	@Test
	public void testExecute() {
		TypesForSets.execute(new HashSet<HashType>(), HashType.class);
		TypesForSets.execute(new LinkedHashSet<HashType>(), HashType.class);
		TypesForSets.execute(new TreeSet<TreeType>(), TreeType.class);

		System.out.println("Things don't work!");

		TypesForSets.execute(new HashSet<SetType>(), SetType.class);//SetType 没有 hashCode 方法
		TypesForSets.execute(new HashSet<TreeType>(), TreeType.class);//没有 hashCode 方法
		TypesForSets.execute(new LinkedHashSet<SetType>(), SetType.class);//没有 hashCode 方法
		TypesForSets.execute(new LinkedHashSet<TreeType>(), TreeType.class);//没有 hashCode 方法
	}
}
