package two;
	


public class VampireNum {
	static int a(int i) {
		return i/1000;
	}
	static int b(int i) {
		return (i%1000)/100;
	}
	static int c(int i) {
		return (i%1000%100)/10;
	}
	static int d(int i) {
		return i%10;
	}
	static int com(int i, int j) {
		return i*10+j;
	}
	static void test(int i, int j, int k) {
		if (j*k == i) {
			System.out.println(i + "=" + j + " * " + k);
		}
	}
	public static void main(String[] args) {
		for (int i = 1001; i < 10000; ++i) {
			test(i, com(a(i), b(i)), com(c(i), d(i)) );
			test(i, com(a(i), b(i)), com(d(i), c(i)) );
			test(i, com(a(i), c(i)), com(b(i), d(i)) );
			test(i, com(a(i), c(i)), com(d(i), b(i)) );
			test(i, com(a(i), d(i)), com(b(i), c(i)) );
			test(i, com(a(i), d(i)), com(c(i), b(i)) );
			test(i, com(b(i), a(i)), com(c(i), d(i)) );
			test(i, com(b(i), a(i)), com(d(i), c(i)) );
			test(i, com(c(i), a(i)), com(b(i), d(i)) );
			test(i, com(c(i), a(i)), com(d(i), b(i)) );
			test(i, com(d(i), a(i)), com(c(i), b(i)) );
			test(i, com(d(i), a(i)), com(b(i), c(i)) );
			
		}
	}

}
