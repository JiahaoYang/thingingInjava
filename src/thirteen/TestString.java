package thirteen;

import java.util.Arrays;

public class TestString {
	public static void main(String[] args) {
		String s = " 16yjdsa16     ";
		System.out.println(s.compareTo("z"));
		System.out.println(s.contains("yjj"));
		System.out.println(s.concat("ss"));
		System.out.println(s.endsWith("jh"));
		byte[] bs = s.getBytes();
		System.out.println(Arrays.toString(bs));
		System.out.println(s.indexOf("i"));
		System.out.println(s.lastIndexOf("1"));
		System.out.println(s.replace("16", "78"));
		System.out.println(String.valueOf(7.8));
		System.out.println(s.trim());
	}
}
