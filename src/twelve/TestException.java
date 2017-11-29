package twelve;

class SimpleException extends Exception {}

public class TestException {
	public void f() throws SimpleException { 
		System.out.println("Before Exception");
		throw new SimpleException();
	}
	
	public static void main(String[] args) {
		TestException testException = new TestException();
		try {
			testException.f();
		} catch (SimpleException e) {
			System.out.println("Got it");
			e.printStackTrace();			//默认打印到system.err
		}
	}
}
