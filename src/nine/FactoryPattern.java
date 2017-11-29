package nine;

interface Animal {
	void action();
}

interface Factory {
	Animal getAnimal(); 
}

class Dog implements Animal {
	public void action() { 
		System.out.println("wangwang");
	}
}

class Cat implements Animal {
	public void action() {
		System.out.println("miaomiao");
	}
}

class DogFactory implements Factory {
	public Dog getAnimal() { 
		return new Dog();
	}
}

class CatFactory implements Factory {
	public Cat getAnimal() {
		return new Cat();
	}
}


public class FactoryPattern {
	public static void palyWithAnimal(Factory factory) {
		Animal animal = factory.getAnimal();
		animal.action();
	}
	public static void main(String[] args) {
		palyWithAnimal(new DogFactory());
		palyWithAnimal(new CatFactory());
	}

}
