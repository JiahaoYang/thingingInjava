package fifteen;

import java.lang.reflect.Array;

public class GenericArray<T> {
	private T[] array;
	@SuppressWarnings("unchecked")
	public GenericArray(Class<T> type, int size) {
		array = (T[]) Array.newInstance(type, size);
	}
	public void put(int index, T item) {
		array[index] = item;
	}
	public T get(int index) {
		return array[index];
	}
	public T[] rep() {
		return array;
	}
	
	public static void main(String[] args) {
		GenericArray<Integer> g = new GenericArray<>(Integer.class, 10);
		Integer[] array = g.rep();
		System.out.println(array);
	}
}
