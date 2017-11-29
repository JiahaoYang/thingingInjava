package fourteen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Pet {}
class Dog extends Pet {}
class Cat extends Pet {}
class Monkey extends Pet {}
class Dog1 extends Dog {}
class Dog2 extends Dog {}
class Cat1 extends Cat {}
class Cat2 extends Cat {}

public abstract class PetCreater {
	private static Random rand = new Random();
	public abstract List<Class<? extends Pet>> types();
	public Pet randPet() {
		int n = rand.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException();
		}
	}
	public Pet[] createArray(int size) {
		Pet[] result = new Pet[size];
		for (int i = 0; i < size; ++i)
			result[i] = randPet();
		return result;
	}
	public ArrayList<Pet> createList(int size) {
		ArrayList<Pet> list = new ArrayList<>();
		Collections.addAll(list, createArray(size));
		return list;
	}
}
