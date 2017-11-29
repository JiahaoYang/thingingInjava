package eleven;

import java.util.*;

class ReverseList<T> extends ArrayList<T> {
	public ReverseList(Collection<T> c) {
		super(c);
	}
	public Iterable<T> reverse() { 
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					private int index = size()-1;
					@Override
					public boolean hasNext() {
						return index > -1;
					}
					@Override
					public T next() {
						return get(index--);
					}
				};
			}
		};
	}
}
public class IteratorPattern {
	
	public static void main(String[] args) {
		ReverseList<Integer> list = new ReverseList(Arrays.asList(1,3,0,-9,21));
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : list.reverse()) {
			System.out.print(i + " ");
		}
	}

}
