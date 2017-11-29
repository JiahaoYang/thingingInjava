package ten;

interface Animal {
	void action();
}

interface AnimalFactory {
	Animal getAnimal();
}

class Dog implements Animal {
	private Dog() {}
	public void action() { 
		System.out.println("wangwang");
	}
	public static AnimalFactory factory = 
			new AnimalFactory() {
				@Override
				public Animal getAnimal() {
					return new Dog();
				}
			};
}

class Cat implements Animal {
	private Cat() {}
	public void action() { 
		System.out.println("miaomiao");
	}
	public static AnimalFactory factory = 
			new AnimalFactory() {
				@Override
				public Animal getAnimal() {
					return new Cat();
				}
			};
}


public class AnonymousInnerClass {
	public static void play(AnimalFactory f) {
		Animal a = f.getAnimal();
		a.action();
	}
	
	public static void main(String[] args) {
		play(Cat.factory);
		play(Dog.factory);
	}
}
