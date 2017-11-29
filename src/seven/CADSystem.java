package seven;

class Shape {
	Shape(int i) {
		System.out.println("shape constructor");
	}
	void dispose() {
		System.out.println("shape dispose");
	}
}

class Circle extends Shape{
	Circle(int i) {
		super(i);
		System.out.println("Circle constructor");
	}
	void dispose(){ 
		System.out.println("circle dispose");
		super.dispose();
	}
}

class Line extends Shape {
	private int start, end;
	Line(int start, int end) {
		super(start);
		this.start = start;
		this.end = end;
		System.out.println("line constructor");
	}
	void dispose() {
		System.out.println("lien dispose");
		super.dispose();
	}
}
public class CADSystem extends Shape{
	private Circle circle;
	private Line[] lines = new Line[3];
	public CADSystem(int i) {
		super(i+1);
		circle = new Circle(1);
		for (int j = 0; j < 3; ++j) {
			lines[j] = new Line(j, j*j);
		}
		System.out.println("cad constructor");
	}
	//按初始化相反的顺序清理
	public void dispose(){ 
		for (int i = lines.length-1; i >= 0; --i) {
			lines[i].dispose();
		}
		circle.dispose();
		super.dispose();
		System.out.println("cad dispose");
	}
	
	public static void main(String[] args) {
		CADSystem cadSystem = new CADSystem(47);
		try {
			System.out.println("start");
		} finally {
			cadSystem.dispose();
		}
	}

}
