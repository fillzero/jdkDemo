package cn.tk.java.reflect.proxy.simpleProxy;


/**
 * @Author: lijl85
 * @Title: SimpleProxyDemo.java
 * @Package: cn.tk.java.reflect.proxy
 * @Time: 2016年8月31日下午4:57:34
 *
 * @description:代理可以用于监测代码的性能， 现在显示的是静态代理， 编译阶段完成代理， 用 SimpleProxy 代理 RealObject 做事情。
 */
public class TestSimpleProxyDemo {
	public static void consumer(Interface iface)
	{
		iface.doSomething();
		iface.somethingElse("banana");
	}
	
	public static void main(String[] args) {
		System.out.println("直接执行： ");
		consumer(new RealObject());
		System.out.println("\n****************\n");
		System.out.println("通过代理执行：");
		consumer(new SimpleProxy(new RealObject()));
	}
}
