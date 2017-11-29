package eleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysASList {

	public static void main(String[] args) {
		String[] strings = "to be or not to be".split(" ");
		ArrayList<String> list1 = new ArrayList<>(Arrays.asList(strings));
		System.out.println(list1);
		Collections.shuffle(list1);
		System.out.println(list1);
		System.out.println(Arrays.toString(strings));
		
		System.out.println();
		
		List<String> list2 = Arrays.asList(strings);
		System.out.println(list2);
		Collections.shuffle(list2);
		System.out.println(list2);
		System.out.println(Arrays.toString(strings));
	}

}
