package fourteen;

import java.lang.reflect.*;
import java.util.regex.Pattern;

public class ShowMethodsWithReflect {
	private static Pattern pattern = Pattern.compile("\\w+\\.");
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("usage:...");
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor<?>[] constructors = c.getConstructors();
			for (Method m : methods) {
				System.out.println(pattern.matcher(m.toString()).replaceAll(""));
			}
			for (Constructor<?> cc : constructors) {
				System.out.println(pattern.matcher(cc.toString()).replaceAll(""));
			}
			lines = methods.length + constructors.length;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
