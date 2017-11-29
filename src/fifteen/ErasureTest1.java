package fifteen;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Factory<T> {
	T create();
}

class Foo<T> {
	private T item;
	public <F extends Factory<T>> Foo(F factory) {
		item = factory.create();
	}
	public String toString() {
		return item.toString();
	}
}

class A {
	public String toString() {
		return "haha";
	}
}

class BV extends A {}

public class ErasureTest1 {
	static Foo<Integer>[] foo;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Factory<Integer> intFac = () -> new Integer(0);
		Factory<A> aFactory = () -> new A();
		System.out.println(new Foo<>(intFac));
		System.out.println(new Foo<>(aFactory));
		
	//	foo = (Foo<Integer>[]) new Object[100]; runtimeError
		foo = (Foo<Integer>[])new Foo[100];
		System.out.println(foo.getClass().getName());
		
		List<? super A> aList = new ArrayList<>();
		Object o = aList.get(0);
	}
}
