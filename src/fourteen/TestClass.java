package fourteen;

interface A{}
interface B{}
interface C{}
class D{
	D() {}
	D(int i) {}
}

class Mix extends D implements A, B, C {
	Mix() {
		super(1);
	}
}

class E extends D{}

public class TestClass {
	public static void printClass(Class c) {
		if (c.getSuperclass() != null) {
			printClass(c.getSuperclass());
		}
		System.out.println(c.getName());
	}
	public static void printInfo(Class c) {
		System.out.println("Class name: " + c.getName());
		System.out.println("Is interface: " + c.isInterface());
		System.out.println("Simple Name: " + c.getSimpleName());
		System.out.println("Canonical Name" + c.getCanonicalName());
	}
	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("fourteen.Mix");
		} catch (ClassNotFoundException e) {
			System.out.println("class not Found");
			System.exit(1);
		}
		printInfo(c);
		for (Class<?> face : c.getInterfaces()) {
			printInfo(face);
		}
		Class<?> up = c.getSuperclass();
		Object obj = null;
		System.out.println();
		try {
			obj = up.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println("can not create obj");
			System.exit(1);
		}
		printInfo(obj.getClass());
		
		System.out.println();
		printClass(c);
		
		System.out.println();
		char[] arr = {'c','a','c'};
		Class<?> cc = arr.getClass();
		System.out.println(cc.getName());
	}
}
