package ten;

interface Contents {
	int f();
}

class Parcel {
	private String label;
	//除了Parcel都不可见（名字也是），扩展接口没有意义
	private class Pconcents implements Contents {
		private int i = 3;
		public int f() {
			return i;
		}
	}
	//向上转型
	public Contents content() {
		return new Pconcents();
	}
}
public class InnerClassUpcasting {

	public static void main(String[] args) {
		Parcel parcel = new Parcel();
		Contents contents = parcel.content();
		System.out.println(contents.f());
	}

}
