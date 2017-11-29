package eleven;

import java.util.*;

class Person {
	private int id;
	
	public Person(int id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (obj.getClass() != Person.class)
			return false;
		Person otherPerson = (Person)obj;
		return otherPerson.id == this.id;
	}
	
	@Override
	public String toString() {
		return "Person" + id;
	}
	
	public int getId() { 
		return id;
	}
}

public class TestList {
	public static void testInteger() { 
		//初始化
		List<Integer> list = new ArrayList<>(Arrays.asList(0,1,2));
		Collections.addAll(list, 7,8,9);
		list.addAll(3, Arrays.asList(3,4,5,6));
		System.out.println(list);
		
		//增
		list.add(10);
		list.add(0, -1);
		System.out.println(list);
		
		//删除,与元素的equals方法相关
		list.remove(new Integer(9));
		list.remove(list.size()-1);
		list.removeAll(Arrays.asList(0,1,2));
		System.out.println(list);
		
		//改
		list.set(2, 22);
		List<Integer> copyList = list.subList(2,list.size()-1);  //左闭右开区间
		System.out.println(copyList);
		copyList.retainAll(Arrays.asList(5,6,7));	//sublist返回原list的视图，修改同步
		System.out.println(list);
		list.clear();
//		System.out.println(copyList);	//运行时异常
		System.out.println(list);
		
		//查
		list.addAll(Arrays.asList(0,1,2,3,4,5));
		System.out.println(list.isEmpty());
		System.out.println(list.get(3));
		System.out.println(list.indexOf(2));
		System.out.println(list.contains(5));
		ListIterator<Integer> iterator = list.listIterator(2);	//随机访问迭代器
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		list.addAll(3, Arrays.asList(23,-1,3,-999,1231,0));
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		System.out.println(Collections.binarySearch(list, 0));	
	}
	
	public static void testClass() { 
		List<Person> list = new ArrayList<>();
		Person p1 = new Person(0);
		Person p2 = new Person(1);
		Person p3 = new Person(-1);
		Person p4 = new Person(-999);
		Person p5 = new Person(212);
		list.addAll(Arrays.asList(p1,p2,p3,p4,p5));
		System.out.println(list);
		Collections.sort(list, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				if (p1.getId() == p2.getId())
					return 0;
				return p1.getId() < p2.getId() ? -1 : 1;
			}
		});
		System.out.println(list);
//		System.out.println(Collections.binarySearch(list,p1);
	}
	

	public static void main(String[] args) {
		testInteger();
		testClass();
	}
}
