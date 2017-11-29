package thirteen;

public class TestStringBuilder {
	public String implicit(String[] fields) {
		String result = "";
		for (String s : fields) {
			result += s;
		}
		return result;
	}
	public String explicit(String[] fields) {
		StringBuilder result = new StringBuilder();
		for (String s : fields) {
			result.append(s);
		}
		return result.toString();
	}
	public static void main(String[] args) {
		
	}
}
