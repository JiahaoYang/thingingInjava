package eleven;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class PrintCollection {
	public static Collection fill(Collection<String> c) {
		c.add("rat");
		c.add("cat");
		c.add("dog");
		c.add("dog");
		return c;
	}
	public static Map fill(Map<String, String> m) {
		m.put("rat", "ss");
		m.put("cat", "rs");
		m.put("dog", "bsa");
		m.put("dog", "sad");
		return m;
	}
	public static void main(String[] args) {
		System.out.println(fill(new ArrayList<>()));
		System.out.println(fill(new LinkedList<>()));
		System.out.println(fill(new HashSet<>()));		
		System.out.println(fill(new TreeSet<>()));
		System.out.println(fill(new LinkedHashSet<>()));
		System.out.println(fill(new HashMap<>()));
		System.out.println(fill(new TreeMap<>()));
		System.out.println(fill(new LinkedHashMap<>()));
	}

}
