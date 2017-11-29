package eleven;

import java.util.*;

public class TestIterator {
	public static void display(Iterator<Integer> iterator) {  
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
	
	public static void testIterator() { 
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
		LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(4,6,7));
		HashSet<Integer> set1 = new HashSet<>(Arrays.asList(3,4,5));
		TreeSet<Integer> set2 = new TreeSet<>(Arrays.asList(45,44,5));
		
		display(list1.iterator());
		display(list2.iterator());
		display(set1.iterator());
		display(set2.iterator());
	}
	
	public static void testListIterator() { 		
		ArrayList<Double> list1 = new ArrayList<>(Arrays.asList(2.4,3.9,4.8,0.0,-9.8));
		ListIterator<Double> iterator = list1.listIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next() + " " + iterator.nextIndex() + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		testListIterator();
	}

}
