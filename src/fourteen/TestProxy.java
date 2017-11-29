package fourteen;

import java.lang.reflect.Proxy;

interface Interface {
	void doSomething();
	void doOtherthing();
}

class RealObj implements Interface {
	public void doSomething() {
		System.out.println("realObj do something");
	}
	public void doOtherthing() {
		System.out.println("realObj do otherthing");
	}
}

class SimpleProxy implements Interface {
	private Interface proxied;
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}
	public void doSomething() {
		System.out.println("Proxy");
		proxied.doSomething();
	}
	public void doOtherthing() {
		System.out.println("Proxy");
		proxied.doOtherthing();
	}
}
public class TestProxy {
	public static void consumer(Interface i) {
		i.doSomething();
		i.doOtherthing();
	}
	public static void main(String[] args) {
		consumer(new RealObj());
		consumer(new SimpleProxy(new RealObj()));
	}
}
