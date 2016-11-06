package cn.tk.java.innerClass.anonymous;

/**
 * @author: lijl85
 * @date：2016年11月4日上午7:49:57
 * @description:匿名类构造器要实现的接口
 */
public abstract class Base {
	public Base(int i) {
		System.out.println("Base constructor, i = " + i);
	}
	
	public abstract void func();
}
