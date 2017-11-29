package ten;
interface Incrementable {
	void increment();
}

class Callee1 implements Incrementable {
	private int i = 0;
	public void increment() { 
		++i;
		System.out.println(i);
	}
}

class MyIncrement {
	void increment() { 
		System.out.println("Myincrement");
	}
	public static void f(MyIncrement m) {
		m.increment();
	}
}

class Callee2 extends MyIncrement {
	private int i = 0;
	public void increment() { 
		super.increment();
		++i;
		System.out.println(i);
	}
	private class Closure implements Incrementable {
		public void increment() { 
			Callee2.this.increment();
		}
	}
	Incrementable getCallBackReference() {
		return new Closure();
	}
}
public class CallBack {

}
