package cn.tk.java.reflect.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {

	private Object proxied;
	
	
	public DynamicProxyHandler(Object proxied) {
		super();
		this.proxied = proxied;
	}

	/**
	 * @Author: lijl85
	 * @Time: 2016年8月31日下午5:04:30 
	 * @重载方法:利用反射技术，通过 invoke 方法，用 proxy 对象 调用 method 方法， 传入 args 作为参数。
	 * 执行方法三要素：
	 * 对象
	 * 方法
	 * 参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
		if (args != null) {
			for(Object arg : args)
				System.out.println("  " + arg);
		}
		return method.invoke(proxied, args);
	}
}
