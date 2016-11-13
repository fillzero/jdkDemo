package cn.tk.java.util.collections.set;

import java.util.Set;

/**
 * @author: lijl85
 * @date：2016年11月13日下午3:50:19
 * @description: HashType, SetType, TreeType 三个类分别描述了放入对应容器的元素应当实现的方法和接口.
 * 自定义类如果要放入容器中, 并且发挥出容器的特性, 就必须实现指定的方法.
 */
public class TypesForSets {
	/**
	 * @description:通过 clazz 构造 10 个 T 类型的对象放到 Set 里面
	 * fill: 使用对象填充容器
	 * @param: set 要填充的容器
	 * @param: type: 要填充容器的元素类型
	 * 用反射的方式构造元素的对象放到容器中, 多次调用 fill 方法,引入重复的对象, 验证容器特性.
	 */
	static <T> Set<T> fill(Set<T> set, Class<T> type){
		try {
			for (int i = 0; i < 10; i++) {
				set.add(type.getConstructor(int.class).newInstance(i));
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return set;
	}

	/**
	 * @description:执行填充, 填充 3 遍
	 */
	static <T> void execute(Set<T> set, Class<T> type){
		fill(set, type);
		fill(set, type);//尝试重复加入
		fill(set, type);
		System.out.println(set);
	}
}
