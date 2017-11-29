package fifteen;

class Fruit {
}

class Apple extends Fruit {
}

class Orange extends Fruit{}

class Holder<T> {
	private T item;
	public Holder() {}
	public Holder(T item) {
		this.item = item;
	}
	public T getItem() {
		return item;
	}
	public void setItem(T item) {
		this.item = item;
	}
	public boolean equals(Object obj) {
		return item.equals(obj);
	}
}
public class FruitTest {
	public static void main(String[] args) {
		Holder<Apple> hApple = new Holder<>();
		Apple a = hApple.getItem();
		hApple.setItem(a);
		
		Holder<? extends Fruit> hFruit = hApple;
		Fruit f = hFruit.getItem();
		a = (Apple)hFruit.getItem();
		
		Orange o = (Orange)hFruit.getItem();
		
		System.out.println(hFruit.equals(a));
	}
}
