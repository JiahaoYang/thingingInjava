package fifteen;

import java.util.ArrayList;
import java.util.List;

class A {}
interface B {}
interface C {}
class E extends A implements B {}

class D<T extends A & B> {}
public class BonusTest {
	public static void main(String[] args) {
		List<? extends A> lists = new ArrayList<>();
		A a = lists.get(0);
	}
}
