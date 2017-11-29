package eleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AddElements {

	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3));
		collection.addAll(Arrays.asList(3,5));
		Integer[] array = {1,4,9};
		Collections.addAll(collection, 78,-1);
		for (Integer integer : collection) {
			System.out.println(integer);
		}
		//底层用数组表示，无法改变大小
		List<Integer> list = Arrays.asList(1,0,4);
		list.add(9);
	}

}
