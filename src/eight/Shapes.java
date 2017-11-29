package eight;

import java.util.Random;

class Shape {
	public void draw() {}
	public void erase() {} 
	public void test() { 
		System.out.println("shape");
	}
}

class Circle extends Shape {
	@Override
	public void draw() { 
		System.out.println("circle draw");
	}
	@Override
	public void erase() { 
		System.out.println("cirlce erase");
	}
}

class Triangle extends Shape {
	@Override
	public void draw(){ 
		System.out.println("triangle draw");
	}
	@Override
	public void erase() {
		System.out.println("triangle erase");
	}
}

class Square extends Shape {
	@Override
	public void draw() { 
		System.out.println("square draw");
	}
	@Override
	public void erase() { 
		System.out.println("square erase");
	}
	@Override
	public void test() { 
		System.out.println("square");
	}
}

class RandomShapeGenerator {
	private Random rand = new Random();
	public Shape next() { 
		switch(rand.nextInt(3)) {
			default:
			case 0 : return new Circle();
			case 1 : return new Triangle();
			case 2 : return new Square();
		}
	}
}


public class Shapes {

	public static void main(String[] args) {
		RandomShapeGenerator gen = new RandomShapeGenerator();
		Shape[] s = new Shape[9];
		for (int i = 0; i < 9; ++i) {
			s[i] = gen.next();
		}
		for (Shape shp : s) {
			shp.test();
		}
	}

}
