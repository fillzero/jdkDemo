package cn.tk.java.innerClass.extendsInner;


/**
 * @author: lijl85
 * @date：2016年11月6日下午4:55:12
 * @description: 继承内部类:
 * 内部类默认存在指向外部类对象的引用, 而子类中这个关系被中断了, 必须显式写出来.
 * 外部类一定是先于内部类的, 外部类是内部类存在的前提.
 */
public class SubClass extends Outer.Inner{
	
	/**
	 * @description: 特殊子类构造器
	 */
	public SubClass(Outer outer) {
		outer.super();
		System.out.println("Constructor SubClass");
	}
	
	/**
	 * @description: 构造器构造顺序: 外部类 --> 内部类 --> 子类
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Outer outer = new Outer();
		SubClass subClass = new SubClass(outer);
	}
}
