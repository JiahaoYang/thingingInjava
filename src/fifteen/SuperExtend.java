package fifteen;

import java.util.ArrayList;
import java.util.List;

class Animal {
	private String name;
	

	public Animal() {
		super();
	}

	public Animal(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
class Cat extends Animal {}
class Dog extends Animal {}
class Tom extends Cat {}

class HouseAnimal<T extends Cat> {
	T animal;
	public HouseAnimal(T animal) {
		this.animal = animal;
	}
	T get() {
		return animal;
	}
	void set(T animal) {
		this.animal = animal;
	}
}

public class SuperExtend {
	static List l1;
	static List<?> l2;
	static List<? extends Object> l3;
	
	static void assign1(List list) {
		l1 = list;
		l2 = list;
		l3 = list;  //unchecked conversion
	}
	
	static void assign2(List<?> list) {
		l1 = list;
		l2 = list;
		l3 = list;
	}
	
	static void assign3(List<? extends Object> list) {
		l1 = list;
		l2 = list;
		l3 = list;
	}
	
	public static void main(String[] args) {
		
	/*
	//	List<Animal> list = new ArrayList<Cat>();
		List<? extends Animal> list = new ArrayList<Cat>();
		
		List<? extends Animal> list1 = new ArrayList<>();
	//	list1.add(new Animal());
	//	list1.add(new Cat());
		Animal a1 = list1.get(0);
	//	Cat c1 = (Cat) list1.get(1);  //runtimeError
		
		List<? super Cat> list2 = new ArrayList<>();
		list2.add(new Cat());
		list2.add(new Tom());
	//	list2.add(new Animal());
	//	Cat c2 = (Cat) list2.get(2); //runtimeError
	//	Animal a2 = (Animal) list2.get(2);
		Object obj = list2.get(0); //类型信息丢失
		
		assign1(new ArrayList());
		assign2(new ArrayList());
		assign3(new ArrayList());
		
		assign1(new ArrayList<String>());
		assign2(new ArrayList<String>());
		assign3(new ArrayList<String>());
		
		List<?> wildList = new ArrayList<>();
		assign1(wildList);
		assign2(wildList);
		assign3(wildList);
	*/
		List<? super Cat> animalList = new ArrayList<>();
		animalList.add(new Cat());
	//	animalList.add(new Animal());
		animalList.add(new Tom());
		
		Cat cat1 = (Cat)animalList.get(0);
		Tom tom1 = (Tom)animalList.get(1);
	}
}
