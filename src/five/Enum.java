package five;

enum PPerson {
	YJH, QSH, LJ
}

public class Enum {
	
	public static void main(String[] args) {
		for (PPerson p : PPerson.values()) {
			System.out.println(p + " " + p.ordinal());
		}
	}

}
