package ten;

public class InnerClass {
	private int i = 0;
	private void test() {
		System.out.println("outer class test");
	}
	public class Inner{
		 public void add() { 
			 ++i;
		 }
		 public void teach() { 
			 System.out.println("Inner class teach");
			 test();
		 }
	}
	public void out() {
		new Inner().teach();
	}
	public static void main(String[] args) {
		InnerClass in = new InnerClass();
		in.out();
	}

}
