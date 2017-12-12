package other;

import com.sun.tools.*;
import com.sun.tools.javac.main.*;

public class GetBytes {
	public static void toHex(byte[] bytes) {
		for (byte b : bytes) {
			int low = b & 0xf;
		}
	}
	
	public static void main(String[] args) {
		Main compile = new Main(arg0);
	}
}
