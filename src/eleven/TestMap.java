package eleven;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class TestMap {
	public static void testRandom() { 
		Random rand = new Random();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 1000; ++i) {
			int num = rand.nextInt(20);
			Integer cnt = map.get(num);
			map.put(num, cnt == null ? 1 : cnt+1);
		}
		System.out.println(map);
	}

	public static void testMap() { 
		Map<String, Integer> map = new HashMap<>();
		
		//增
		map.put("yjh", 0);
		map.put("qsh", 1);
		map.put("yj8", 2);
		map.put("lj", 3);
		map.put("yjh", 4);
		System.out.println(map);
		
		//删
		map.remove("yjh");
		map.remove("yj8", 2);
		System.out.println(map);
		
		//改
		Map<String, Integer> map1 = new HashMap<>();
		map1.putAll(map);
		map1.put("hb", 78);
		System.out.println(map1);
		System.out.println(map1.replace("lj", 9));
		System.out.println(map1);
		
		//查询
		System.out.println(map.containsKey("qsh"));
		Set<Map.Entry<String, Integer>> set = map1.entrySet();
		System.out.println(set);
		System.out.println(map1.get("lj"));
		Set<String> set1 = map1.keySet();
		System.out.println(set1);
		System.out.println(map1.values());
		
		for (String s : map1.keySet()) {
			System.out.println(s + " = " + map1.get(s));
		}
	}
	public static void main(String[] args) {
		testRandom();
		testMap();
	}
}
