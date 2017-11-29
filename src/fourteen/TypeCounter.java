package fourteen;

import java.util.HashMap;

public class TypeCounter extends HashMap<Class<?>, Integer>{
	private Class<?> baseType;
	public TypeCounter(Class<?> baseType) {
		this.baseType = baseType;
	}
	public void count(Object obj) {
		Class<?> type = obj.getClass();
		if (!baseType.isAssignableFrom(type)) {
			throw new RuntimeException("Incorrect Type");
		}
		countClass(type);
	}
	private void countClass(Class<?> type) {
		Integer quality = get(type);
		put(type, quality == null ? 1 : quality+1);
		Class<?> superClass = type.getSuperclass();
		if (superClass != null && baseType.isAssignableFrom(superClass))
			countClass(superClass);
	}
	public String toString() {
		return super.toString();
	}
	
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Pet.class);
		for (Pet pet : new LiteralCreater().createArray(10)) {
			System.out.print(pet.getClass().getSimpleName() + " ");
			counter.count(pet);
		}
		System.out.println();
		System.out.println(counter);
	}
}
