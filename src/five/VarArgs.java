package five;


public class VarArgs {
	public static void printArray(Object...args) {
		for (Object arg : args) {
			System.out.println(arg);
		}
	}
	
	public static void main(String[] args) {
		printArray("a","b","c");
		printArray(1,2,3);
		printArray((Object[]) new Double[] {3.2, 4.3});
	}

}
