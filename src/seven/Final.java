package seven;

class A {
	public final void testFinal(){}
}





class WithFinal {
	private final void f() { 
		System.out.println("WithFinal f()");
	}
	private void g(){ 
		System.out.println("Withfianl g()");
	}
}

class Overriding1 extends WithFinal {
	//private方法不是基类接口的一部分，并没有覆盖基类中的方法，生成了一个新方法
	private final void f(){ 
		System.out.println("Over1 f()");
	}

	private void g(){ 
		System.out.println("over1 g()");
	}
}

class Overriding2 extends Overriding1 {
	public final void f() {
		System.out.println("over2 f()");
	}
	
	public void g(){ 
		System.out.println("over2 g()");
	}
}

public class Final {
	private final A a;
	public Final() {
		a = new A();
	}
	public void test(final int b){ 
	}
	public static void main(String[] args) {
		Overriding2 overriding2 = new Overriding2();
		overriding2.f();
		overriding2.g();
		
		Overriding1 overriding1 = overriding2;
//		overriding1.f();
	}

}
