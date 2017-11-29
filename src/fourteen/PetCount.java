package fourteen;

import java.util.HashMap;
import java.util.Map;

public class PetCount {
	private static HashMap<String, Integer> map = new HashMap<>();
	
	public static void countPets(PetCreater creater) {
		for (Pet pet : creater.createArray(10)) {
			System.out.print(pet.getClass().getSimpleName() + " ");
			if (pet instanceof Dog1)
				map.put("Dog1", map.get("Dog1") == null ? 1 : map.get("Dog1")+1);
			if (pet instanceof Dog2)
				map.put("Dog2", map.get("Dog2") == null ? 1 : map.get("Dog2")+1);
			if (pet instanceof Cat1)
				map.put("Cat1", map.get("Cat1") == null ? 1 : map.get("Cat1")+1);
			if (pet instanceof Cat2)
				map.put("Cat2", map.get("Cat2") == null ? 1 : map.get("Cat2")+1);
			if (pet instanceof Monkey)
				map.put("Monkey", map.get("Monkey") == null ? 1 : map.get("Monkey")+1);
		}
		System.out.println();
		System.out.println(map);
	}
	
	public static void main(String[] args) {
		countPets(new ForNameCreater());
	}
}
