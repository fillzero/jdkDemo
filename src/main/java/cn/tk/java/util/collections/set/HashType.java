package cn.tk.java.util.collections.set;

/**
 * @author: lijl85
 * @date：2016年11月13日下午2:55:02
 * @description:HashSet类型要保证使用高效的哈希算法,必须内置 hashCode 方法
 */
public class HashType extends SetType {

	public HashType(int n) {
		super(n);
	}

	/**
	 * hashCode: 给出一个线性函数,同一个数的hashCode一定是不变的, LinkedHashSet中的对象必须有 hashCode 方法
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}
}
