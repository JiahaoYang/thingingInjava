package twelve;

public class FinallyTest {
	public static void f() {
		System.out.println("enter first try block");
		try {
			System.out.println("enter second try block");
			try {
				throw new NullPointerException();
			} finally {
				System.out.println("finally");
			}
		} catch (Exception e) {
			System.out.println("catch it");
		}
	}
	
	public static void g() { 
		try {
			throw new RuntimeException();
		} finally {
			return;
		}
	}
	public static void main(String[] args) {
		g();
	}
}
