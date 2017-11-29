package twenty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import eleven.ArraysASList;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)	//运行时通过反射获得相关信息
@interface Usecase {
	public int id() default -1;
	public String description() default ""; 
}

public class TestAnnotation {
	@Usecase(id = 46)
	public void a() {}
	
	@Usecase(id = 48, description = "i am b")
	protected void b() {}
	
	@Usecase(id = 50, description = "i am c")
	private void c() {}
	
	public static void trackUsecase(List<Integer> list, Class<?> type) {
		for (Method m : type.getDeclaredMethods()) {
			Usecase usecase = m.getAnnotation(Usecase.class);
			if (usecase != null) {
				System.out.println("foundcase" +  usecase.id() + " " + usecase.description());
				list.remove(new Integer(usecase.id()));
			}
		}
		for (int i : list)
			System.out.println("warming missing " + i);
	}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(45,46,47,48,49,59));
		trackUsecase(list, TestAnnotation.class);
	}
}
