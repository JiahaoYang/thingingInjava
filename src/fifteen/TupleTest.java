package fifteen;

class Tuple<A,B> {
	public final A first;
	public final B second;
	
	public Tuple(A a, B b) { 
		first = a;
		second = b;
	}
	
	public String toString() {
		return first + " " + second;
	}
}

public class TupleTest {
	public static void main(String[] args) {
		Tuple<String, Integer> tuple = new Tuple<>("yjh", 12);
		System.out.println(tuple);
	}
}
