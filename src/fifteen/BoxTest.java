package fifteen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Box<T> {
	private T t;
	public void set(T t) {
		this.t = t;
	}
	
	public String toString() {
		return t.toString();
	}
}

public class BoxTest {
	public static <T> void addBox(T t, List<Box<T>> boxes) {
		Box<T> box = new Box<>();
		box.set(t);
		boxes.add(box);
	}
	
	public static <T> void outputBoxes(List<Box<T>> boxes) {
		for (Box<T> box : boxes)
			System.out.println(box);
	}
	
	public static void main(String[] args) {
		List<Box<Integer>> boxes = new ArrayList<>();
		BoxTest.addBox(1, boxes);
		BoxTest.addBox(2, boxes);
		BoxTest.addBox(2, boxes);
		
		BoxTest.outputBoxes(boxes);
		
		(String s) -> System.out.println(s);
	}
}
