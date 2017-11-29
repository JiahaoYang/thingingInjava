package fourteen;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetCount2 {
	private static LinkedHashMap<Class<? extends Pet>, Integer> map;
	static {
		for (Class<? extends Pet> c : LiteralCreater.allTypes) {
			map.put(c, (Integer)0);
		}
	}
	
	public void count(Pet pet) {
		for (Map.Entry<Class<? extends Pet>, Integer> pair : map.entrySet()) {
			if (pair.getKey().isInstance(pet))
				map.put(pair.getKey(), pair.getValue()+1);
		}
	}
	public String toString() {
		return map.toString();
	}
	public static void main(String[] args) {
		PetCount2 pt2 = new PetCount2();
		for (Pet pet : new LiteralCreater().createArray(20)) {
			System.out.print(pet.getClass().getSimpleName() + " ");
			pt2.count(pet);
		}
		System.out.println(pt2);
	}
}
