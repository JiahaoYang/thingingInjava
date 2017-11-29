package thirteen;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class TestScanner {
	static String data = "58.27.82.161@02/10/2005\n" +
		    "204.45.234.40@02/11/2005\n" +
		    "58.27.82.161@02/11/2005\n" +
		    "58.27.82.161@02/12/2005\n" +
		    "58.27.82.161@02/12/2005\n" +
		    "[Next log section with different data format]";
	
	void testDelimiter() {
		Scanner scan = new Scanner("12 , 21 ,   21, 321,   321");
		scan.useDelimiter("\\s*,\\s*");
		while (scan.hasNextInt()) {
			System.out.println(scan.nextInt());
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(data);
		String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" +
						"(\\d{2}/\\d{2}/\\d{4})";
		while (scan.hasNext(pattern)) {
			scan.next(pattern);
			MatchResult result = scan.match();
			String ip = result.group(1);
			String date = result.group(2);
			System.out.format("Threat on %s from %s\n", ip, date);
		}
	}
}

