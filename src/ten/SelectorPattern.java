package ten;

interface Selector {
	boolean end();
	Object current();
	void next();
}

class Sequence {
	private Object[] items;
	private int next;
	public Sequence(int size) {
		items = new Object[size];
	}
	public void add(Object item) {
		if (next < items.length) {
			items[next++] = item;
		}
	}
	private class SequenceSelector implements Selector {
		private int i = 0;
		public boolean end() {
			return i == items.length;
		}
		public Object current() { 
			return items[i];
		}
		public void next() { 
			if (i < items.length) {
				++i;
			}
		}
	}	
	private class ReverseSelector implements Selector {
		private int i = items.length-1;
		public boolean end() { 
			return i == -1;
		}
		public Object current() {
			return items[i];
		}
		public void next() {
			if (i > -1) {
				--i;
			}
		}
	}
	

	public Selector selector() {
		return new SequenceSelector();
	}
	
	public Selector reverse() {
		return new ReverseSelector();
	}
}
public class SelectorPattern {

	public static void main(String[] args) {
		Sequence seq = new Sequence(10);
		seq.add(1);
		seq.add(3);
		seq.add(5);
		Selector selector = seq.reverse();
		while (!selector.end()) {
			System.out.println(selector.current());
			selector.next();
		}
	}

}
