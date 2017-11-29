package fifteen;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

class ArrayMaker<T> {
	private Class<T>  kind;
	public ArrayMaker(Class<T> kind) {
		this.kind = kind;
	}
	
	@SuppressWarnings("unchecked")
	public T[] arrayMaker(int size) {
		return (T[])Array.newInstance(kind, size);
	}
}

class Erasure<T> {
	private Class<T> kind;
	public Erasure(Class<T> kind) {
		this.kind = kind;
	}
}


class Building {}
class House extends Building {}

class ClassTypeCapture<T> {
	private Class<T> kind;
	public ClassTypeCapture(Class<T> kind) {
		this.kind = kind;
	}
	
	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}
}
public class ErasureTest {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
//		ArrayList<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.getClass().getMethod("add", Object.class).invoke(list, "asd");
//		System.out.println(list);
//		
//		ArrayMaker<String> maker = new ArrayMaker<>(String.class);
//		String[] strings = maker.arrayMaker(10);
//		System.out.println(Arrays.toString(strings));
		
		ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
		System.out.println(ctt1.f(new Building()));
		System.out.println(ctt1.f(new House()));
		
		
	}
	
}
