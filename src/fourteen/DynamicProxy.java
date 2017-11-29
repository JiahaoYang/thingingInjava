package fourteen;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Proxy: " + proxy.getClass() + ", method: " + method + ", args" + args);
		return method.invoke(proxied, args);
	}
}


public class DynamicProxy {
	public static void main(String[] args) {
		RealObj obj = new RealObj();
		//i为代理对象
		Interface i = (Interface)Proxy.newProxyInstance(
				Interface.class.getClassLoader(), 
				new Class[]{Interface.class}, 
				new DynamicProxyHandler(obj));
		TestProxy.consumer(i);
	}
}
