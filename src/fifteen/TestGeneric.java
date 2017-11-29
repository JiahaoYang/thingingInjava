package fifteen;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

class Fruit1 {}
class Apple1 extends Fruit1 {}
class Orange1 extends Fruit1 {}

class Plate<T> {
	private ArrayList<T> plates = new ArrayList<>();
	private T obj;
	public void set(T obj) {
		plates.add(obj);
	}
	
	public T get() {
		return obj;
	}
}

class ArrayMaker1<T> {
	private Plate<Integer>[] plates = new Plate[100];
	private Class<T> kind;
	public ArrayMaker1(Class<T> kind) {
		this.kind = kind;
	}
	
	@SuppressWarnings("unchecked")
	public T[] create() {
		return (T[])Array.newInstance(kind, 10);
	}
	
}


public class TestGeneric {
	private static Plate<Integer>[] p;
	static <T> void put(List<T> list, T item) {
		list.add(item);
	}
	@Test
	public void test() {
		List<Fruit1> llists = new ArrayList<>();
		put(llists, new Apple1());
	}
}
