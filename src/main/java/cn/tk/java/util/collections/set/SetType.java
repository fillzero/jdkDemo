package cn.tk.java.util.collections.set;

/**
 * @author: lijl85
 * @date：2016年11月13日下午2:54:27
 * @description:Set要保证集合元素不重复, 必须内置 equals方法
 */
public class SetType {
	int value;

	public SetType() {

	}

	public SetType(int n) {
		super();
		this.value = n;
	}

	/**
	 * equals方法,先比较两个对象是否指向同一个引用, 然后判断存储的值是否一致.
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof SetType && (value == ((SetType)obj).value);
	}

	/**
	 * 打印对象默认调用类中的 toString方法, 打印对象的属性值.
	 */
	@Override
	public String toString() {
		return Integer.toString(value);
	}
}
