package fourteen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralCreater extends PetCreater{
	public static final List<Class<? extends Pet>> allTypes = 
			Collections.unmodifiableList(Arrays.asList(
					Dog.class, Pet.class, Cat.class, Monkey.class,
					Dog1.class, Dog2.class, Cat1.class, Cat2.class
					));
	private static final List<Class<? extends Pet>> types = 
			allTypes.subList(allTypes.indexOf(Dog1.class), allTypes.size());
	@Override
	public List<Class<? extends Pet>> types() {
		return types;
	}
	public static void main(String[] args) {
		PetCount.countPets(new LiteralCreater());
	}
}
