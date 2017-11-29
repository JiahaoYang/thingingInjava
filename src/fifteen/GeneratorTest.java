package fifteen;

import java.util.ArrayList;
import java.util.Random;

class Product {
	private int id;
	private String name;
	private double price;
	
	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	public void priceChange(double change) {
		price += change;
	}
	
	private static Random r = new Random();
	
	public static Generator<Product> gen = () -> new Product(r.nextInt(100), "test", r.nextDouble());
}

public class GeneratorTest extends ArrayList<Product>{
	public static void main(String[] args) {
		GeneratorTest generatorTest =new GeneratorTest();
		for (int i = 0; i < 10; ++i)
			generatorTest.add(Product.gen.next());
		generatorTest.stream().forEach(System.out::println);
	}
}
