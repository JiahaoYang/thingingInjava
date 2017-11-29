package fifteen;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class SetUtil {
	
	public static <T> Set<T> union(Set<T> a, Set<T> b) { 
		Set<T> result = new HashSet<>(a);
		result.addAll(b);
		return result;
	}
	
	public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<>(a);
		result.retainAll(b);
		return result;
	}
	
	public static <T> Set<T> difference(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<>(a);
		result.removeAll(b);
		return result;
	}
	
	public static Set<String> allMethods(Class<?> type) {
		Set<String> result = new TreeSet<>();
		for (Method method : type.getMethods())
			result.add(method.getName());
		return result;
	}
	
	public static List<String> interfaces(Class<?> type) {
		List<String> result = new ArrayList<>();
		for (Class<?> c : type.getInterfaces())
			result.add(c.getSimpleName());
		return result;
	}
	
	private static Set<String> object = allMethods(Object.class);
	
	public static void main(String[] args) {
		TupleList<Integer, Long, Double, String> tupleList = new TupleList<>();
		tupleList.add(new FourTuple<>(1, (long)2, (double)3, "4"));
		tupleList.add(new FourTuple<>(1, (long)2, (double)3, "4"));
		
		tupleList.stream().forEach(System.out::println);
	}
}

class A1{}
class B2{}
class C3{}
class D4{}

class FourTuple<A,B,C,D> {
	public final A a;
	public final B b;
	public final C c;
	public final D d;
	
	public FourTuple(A a, B b, C c, D d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	@Override
	public String toString() {
		return "FourTuple [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
	}
	
}

class TupleList<A,B,C,D> extends ArrayList<FourTuple<A,B,C,D>> {}
