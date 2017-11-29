package eleven;

import java.util.AbstractCollection;
import java.util.Iterator;


class CollectionSequence extends AbstractCollection<Integer> {
	private int[] a = {2,3,4};

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < a.length;
			}
			@Override
			public Integer next() {
				return a[index++];
			}
		};
	}

	@Override
	public int size() {
		return a.length;
	}
	
}
public class CollectionAndIterator {

	public static void main(String[] args) {
		CollectionSequence collectionSequence = new CollectionSequence();
		for (int i : collectionSequence) {
			System.out.print(i + "   ");
		}
	}

}
