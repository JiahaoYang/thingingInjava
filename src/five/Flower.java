package five;

public class Flower {
	private int petalCount = 0;
	private String s = "init val";
	
	public Flower(int petals) {
		this.petalCount = petals;
		System.out.println("int arg only");
	}
	
	public Flower(String s) {
		this.s = s;
		System.out.println("string arg only");
	}
	
	public Flower(int petals, String s) {
		this(petals);
		this.s = s;
		System.out.println("two args");
	}
	
	public Flower() {
		this(47, "hi");
	}
	
	public static void main(String[] args) {
		Flower f = new Flower();
	}

}
