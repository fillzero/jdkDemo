package cn.tk.java.collection.set;

public class TreeType extends SetType implements Comparable<TreeType>{

	public TreeType(int n) {
		super(n);
	}

	/**
	 * 定制比较器,比较两个TreeType类型对象的大小,因为TreeSet要保证元素的顺序,必须进行比较
	 * 不能使用 (value - o.value) 判断正副的方式, 有符号整型, 一个正数减一个负数超过整型最大值可能变成负数.
	 */
	@Override
	public int compareTo(TreeType o) {
		return o.value < value ? -1 : (o.value == value ? 0 : 1);
	}
}
