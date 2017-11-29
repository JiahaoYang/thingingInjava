package eleven;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		Collections.addAll(set, "a b c d f g h j k".split(" "));
		System.out.println(set.contains("c"));
		System.out.println(set.contains("J"));
		set.add("Z");
		System.out.println(set);
		Set<String> set1 = new HashSet<>();
		Collections.addAll(set1, "a b c".split(" "));
		System.out.println(set.containsAll(set1));
		set.removeAll(set1);
		System.out.println(set);
	}

}
