package cn.tk.java.reflect.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

import cn.tk.java.reflect.proxy.simpleProxy.Interface;
import cn.tk.java.reflect.proxy.simpleProxy.RealObject;

/**
 * @Author: lijl85
 * @Title: SimpleDynamicProxy.java
 * @Package: cn.tk.java.reflect.proxy
 * @Time: 2016年8月31日下午5:14:19
 *
 * @description:
 * Proxy.newProxyInstance 静态方法
 * ClassLoader loader： 类加载器， 从已经加载的对象中获取其类加载器
 * Class<?>[] interfaces： 希望实现的接口列表
 * InvocationHandler h：InvocationHandler 的一个实现
 * 动态代理将所有的调用重定向到调用处理器， 对接口的调用重定向为对代理的调用。
 */
public class TestSimpleDynamicProxy {
	public static void consumer(Interface iface)
	{
		iface.doSomething();
		iface.somethingElse("banana");
	}
	
	public static void main(String[] args) {
		RealObject realObject = new RealObject();
		consumer(realObject);
		
		Interface proxyObject = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(), 
				new Class[]{Interface.class}, 
				new DynamicProxyHandler(realObject));//创建动态代理对象， 代理 RealObject
		consumer(proxyObject);
	}
}
