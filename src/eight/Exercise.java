package eight;

class Father {
	private int i;
	public Father() {
		i = 47;
	}
	public void test() { 
		System.out.println(i);
	}
	public void f() { 
		g();
	}
	public void g() { 
		System.out.println("father g()");
	}
	public int get() { 
		return i;
	}
}

class Son extends Father {
	public Son() {
	}
	
	
	@Override
	public void g() { 
		System.out.println("son g()");
	}
}
public class Exercise {

	public static void main(String[] args) {
		Father f = new Son();
		System.out.println(f.get());
	}

}
