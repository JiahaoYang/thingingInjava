package thirteen;

import java.util.Formatter;

class MyFormat {
	private String name;
	private Formatter formatter;
	
	public MyFormat(String name, Formatter formatter) {
		this.name = name;
		this.formatter = formatter;
	}
	
	public void move(int x, int y) {
		formatter.format("%s is move to (%d,%d) ", name, x, y);
	}
	
	public void test() {
		Formatter f = new Formatter(System.out);
		
		char c = 'u';
		f.format("%d", c);
		f.format("%c", c);
		f.format("%b", c);
		f.format("%s", c);
		f.format("%f", c);
		f.format("%e", c);
		f.format("%x", c);
		f.format("%h", c);
		
 	}
}
public class TestFormat {
	public static void main(String[] args) {

		
		MyFormat f = new MyFormat("yjh", new Formatter(System.out));

		System.out.println(String.format("yjh%d qsh%f %s", 12,78.9,"s"));
	}
}
