package thirteen;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public static String string = "to be or not   to be...   ";
	public static void split(String regex) {
		System.out.println(string.split(regex).length);
		System.out.println(Arrays.toString(string.split(regex)));
	}
	public static void testRegex(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage:\njava Regex " + "CharSequence Regex");
			System.exit(0);
		}
		System.out.println("Input: \"" + args[0] + "\"\n");
		for (String arg : args) {
			System.out.println("Regex Expression: " + arg);
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			System.out.println("All expression match: " + m.matches());
			System.out.println("Start expression match " + m.lookingAt());
			while (m.find()) {
				System.out.println("Match \"" + m.group() + "\" at position" + m.start() + "-" + (m.end()-1));
			}
			System.out.println();
		}
	}
	public static void testGroup(String[] args) {
		String s = " Prints an Object and then terminate the line.  This method calls\n" + 
      "at first String.valueOf(x) to get the printed object's string value,\n" + 
      "then behaves as\n" + 
      "though it invokes <code>{@link #print(String)}</code> and then\n" + 
      "<code>{@link #println()}</code>.\n";
		
		Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(s);
		while (m.find()) {
			for (int i = 0; i <= m.groupCount(); ++i) {
				System.out.print("[" + m.group(i) + "]");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		//testRegex(args);
		//testGroup(args);
	}
}