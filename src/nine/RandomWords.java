package nine;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;



public class RandomWords implements Readable {
	private static final char[] capitals = 
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final char[] lowers = 
			"abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static Random random = new Random();
	private int count;
	public RandomWords(int count) {
		this.count = count;
	}
	@Override
	public int read(CharBuffer cb) throws IOException {
		if (count-- == 0)
			return -1;
		cb.append(capitals[random.nextInt(capitals.length)]);
		for (int i = 0; i < 4; ++i) {
			cb.append(lowers[random.nextInt(lowers.length)]);
		}
		cb.append(" ");
		return 6;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new RandomWords(10));
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
	}

}
