package six;


class Soup1 {
	
	private Soup1() {
		System.out.println("constructor soup1");
	}
	public static Soup1 makeSoup(){
		return new Soup1();
	}
}

// 单例模式
class Soup2 {
	private Soup2() {
		System.out.println("constructor soup2");
	}
	private static Soup2 s2 = new Soup2();
	public static Soup2 access(){ 
		return s2;
	}
}

public class Singleton {
	public static void main(String[] args) {
//		Soup1 s1 = Soup1.makeSoup();
		System.out.println(Soup2.access().access());
	}

}
