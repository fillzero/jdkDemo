package cn.tk.java.reflect.proxy.proxySelector;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MethodSelectorHandler implements InvocationHandler {

	private Object proxied;
	
	public MethodSelectorHandler(Object proxied) {
		super();
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (method.getName().equals("interesting")) {
			System.out.println("Proxy detected the interesting method!");
		}
		return method.invoke(proxied, args);
	}

}
