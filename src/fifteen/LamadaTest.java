package fifteen;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;



public class LamadaTest {
	
	public static <T> void myFilter(List<T> list, Predicate<T> p) {
		list.stream().filter(p).forEach(System.out::println);
	}
	
	public void testRunable() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("inner class run");
			}
		}).start();
		
		new Thread(() -> {System.out.println("lambda run");}).start(); 
	}
	
	public void testForeach() {
		List<String> list = Arrays.asList("yjh", "yjx", "ljx", "dxy", "hb", "lj");
		list.forEach((s) -> System.out.print(s + " "));
		list.forEach(System.out::print);
		
		System.out.println();
		myFilter(list, s -> s.endsWith("x"));
		myFilter(list, s -> s.length()>2);
		myFilter(list, s -> s.equals("yjh"));
	}
	
	public void testPredicate() {
		List<String> list = Arrays.asList("yjh", "yjx", "ljx", "dxy", "hb", "lj", "x");
		List<Integer> list2 = Arrays.asList(100, 200, 300, 400, 500);
		Predicate<String> p1 = s -> s.length()>2;
		Predicate<String> p2 = s -> s.endsWith("x");
		
		double bill = list2.stream().map(x -> x+x*.5).filter(x -> x>100).reduce((sum, cost) -> sum-cost).get();
		System.out.println(bill);
		
		List<String> endX = list.stream().filter(s -> s.endsWith("x")).collect(Collectors.toList());
		System.out.println(endX);
		
		System.out.println();
		
		IntSummaryStatistics intStatistics = list2.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println(intStatistics.getMax());
		System.out.println(intStatistics.getMin());
		System.out.println(intStatistics.getSum());	
	}
	
	
}
