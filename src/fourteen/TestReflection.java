package fourteen;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

interface AA {
	void f();
}

class BB implements AA {
	public void f() { 
		System.out.println("B.f()");
	}
	public void h() { 
		System.out.println("B.h()");
	}
	private void g() { 
		System.out.println("B.g()");
	}
	public static AA makeAA() {
		return new BB();
	}
}

class InnerAA {
	public static AA makeA() {
		return new AA() {
			@Override
			public void f() {
				System.out.println("Anonymous A");
			}
			private void g() {
				System.out.println("lalala g()");
			}
		};
	}
}

class TestField {
	private int i = 1;
	private final String s1 = "I am safe";		//修改无效
	private String s2 = "am I?";
	public String toString() {
		return i + s1 + s2;
	}
}

public class TestReflection {
	//通过反射可以调用对象的任何方法
	static void callHiddenMethods(Object a, String methodName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method g = a.getClass().getDeclaredMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}
	
	public static void main(String[] args) throws Exception {
		AA aa = InnerAA.makeA();
		aa.f();
		callHiddenMethods(aa, "g");
		
		TestField tf = new TestField();
		System.out.println(tf);
		Field f = tf.getClass().getDeclaredField("i");
		f.setAccessible(true);
		System.out.println(f.getInt(tf));
		f.setInt(tf, 47);
		System.out.println(tf);
		f = tf.getClass().getDeclaredField("s1");
		f.setAccessible(true);
		f.set(tf, "haha");
		System.out.println(tf);
		
		f = tf.getClass().getDeclaredField("s2");
		f.setAccessible(true);
		f.set(tf, "haha");
		System.out.println(tf);
	}
}
