package cn.tk.java.reflect.proxy.proxySelector;

import java.lang.reflect.Proxy;

/**
 * @Author: lijl85
 * @Title: TestSelectingMethods.java
 * @Package: cn.tk.java.reflect.proxy.proxySelector
 * @Time: 2016年8月31日下午5:42:04
 *
 * @Description:动态代理类可以在真正的实现类前后加上相应的监控过滤代码， 这部分代码写在 invoke() 方法里
 * 
 * 本方法对实现类 Implementation 的  interesting 方法进行了过滤， 其它方法间接调用实现方法。
 * 
 * 由此可见， 动态代理是 AOP 的基础，是面向切面编程的基础， 可以很方便的在程序动态运行的时候对业务逻辑进行过滤或者监控。
 */
public class TestSelectingMethods {
	public static void main(String[] args) {
		ISomeMethods proxy = (ISomeMethods) Proxy.newProxyInstance(
				ISomeMethods.class.getClassLoader(), 
				new Class[]{ISomeMethods.class}, 
				new MethodSelectorHandler(new Implementation()));
		proxy.boring1();
		proxy.boring2();
		proxy.interesting("banana");
		proxy.boring3();
	}
}
