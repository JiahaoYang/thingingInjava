package thirteen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStartEns {
	public static String exp =     "As long as there is injustice, whenever a\n" +
		    "Targathian baby cries out, wherever a distress\n" +
		    "signal sounds among the stars ... We'll be there.\n" +
		    "This fine ship, and this fine crew ...\n" +
		    "Never give up! Never surrender!";
	private static class Display {
		private boolean regexPrinted = false;
		private String regex;
		Display(String regex) {
			this.regex = regex;
		}
		void display(String message) { 
			if (!regexPrinted) {
				System.out.println(regex);
				regexPrinted = true;
			}
			System.out.println(message);
		}
	}
	static void examine(String exp, String regex) {
		Display d = new Display(regex);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(exp);
		while (m.find()) {
			d.display("find '" + m.group() + "' from " + m.start() + "to" + (m.end()-1));
		}
		if (m.lookingAt()) {
			d.display("lookingAt '" + m.group() + "' from " + m.start() + "to" + (m.end()-1));
		}
		if (m.matches()) {
			d.display("matches '" + m.group() + "' from " + m.start() + "to" + (m.end()-1));
		}
	}
	public static void main(String[] args) {
		for (String in : exp.split("\n")) {
			System.out.println("input: " + in);
			for (String regex : new String[]{"\\w*ere\\w*",
			        "\\w*ever", "T\\w+", "Never.*?!"}) {
				examine(in, regex);
			}
		}
	}
}
