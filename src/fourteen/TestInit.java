package fourteen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Father1 {
	static final int staticFinal = 1;
	static final int staticFinal2 = TestInit.rand.nextInt(100);
	
	static {
		System.out.println("Inside static block Father1");
	}
}

class Father2 {
	static int staticFinal = 2;
	
	static {
		System.out.println("Inside static block Father2");
	}
}

class Father3 {
	final int staticFinal = 3;
	
	static {
		System.out.println("Inside static block Father3");
	}
}

class Son1 extends Father1 {
	static final int staticFinal1 = 4;
	
	static {
		System.out.println("inside static block Son1");
	}
}

class FillList<T> {
	private Class<T> type;
	public FillList(Class<T> type) {
		this.type = type;
	}
	public List<T> create(int n) { 
		List<T> result = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			try {
				result.add(type.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}

public class TestInit {
	public static Random rand = new Random();
	
	public static void main(String[] args) throws Exception {
		Class<?> fa1 = Son1.class;
		System.out.println(Son1.staticFinal2);
		
		Class<? extends Number> c = int.class;
		FillList<Father1> fa = new FillList(Father1.class);
		System.out.println(fa.create(10));
	}
}
