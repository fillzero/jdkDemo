package cn.tk.java.innerClass.anonymous;

/**
 * @author: lijl85
 * @date：2016年11月4日上午7:49:23
 * @description:通过实例初始化创建匿名类的构造器
 */
public class AnonymousConstructor {
	/**
	 * @description:匿名内部类的构造器
	 * 思考为什么可以不写成 final 的参数
	 */
	public static Base getBase(int i)
	{
		{
			System.out.println("Inside instance initializer");	
		}
		return new Base(i) {
			@Override
			public void func() {
				System.out.println("AnonymousConstructor's constructor! i = " + i);
			}
		};
	}
	
	public static void main(String[] args) {
		Base base = getBase(10);
		base.func();
	}
}
