package eight;

class A {
	public void draw() { 
		System.out.println("A draw");
	}
	public A() {
		System.out.println("before draw");
		draw();
		System.out.println("after draw");
	}
}

class B extends A {
	private int id = 2;
	public void draw() {
		System.out.println("B" + id);
	}
	public B(int id) { 
		this.id = id;
		System.out.println("B constructor");
	}
}
public class ConstructorCallOtherFuc {

	public static void main(String[] args) {
		new B(5);
	}

}
