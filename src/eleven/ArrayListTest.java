package eleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Fruit {
	private String name;
	public String getName() {
		return name;
	}
}

class Apple extends Fruit{
}

class Orange extends Fruit{
}

public class ArrayListTest {

	public static void main(String[] args) {
/*		List<Fruit> list = new ArrayList<>();
		list.add(new Apple());
		list.add(new Orange());
		list.add(new Orange());
		for (int i = 0; i < list.size(); ++i) {
			list.get(i);
		}*/
		List<Integer> list = Arrays.asList(0,1,2,3,4,5);
		System.out.println(list);
		list.add(10);
		System.out.println(list);
	}

}
