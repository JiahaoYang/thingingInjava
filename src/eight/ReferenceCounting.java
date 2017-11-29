package eight;

class Shared {
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;
	
	public Shared() {
		System.out.println("creating" + this);
	}
	public void addref() { 
		refcount++;
	}
	
	public void dispose() { 
		if (--refcount == 0) {
			System.out.println("dispose" + this);
		}
	}
	@Override
	public String toString() {
		return "Shared" + id;
	}
}

class Composing {
	private static long counter = 0;
	private final long id = counter++;
	private Shared shared;
	
	public Composing(Shared shared) {
		System.out.println("creating" + this);
		this.shared = shared;
		this.shared.addref();
	}
	
	public void dispose() {
		System.out.println("disposing" + this);
		shared.dispose();
	}
	
	@Override
	public String toString() {
		return "composing" + id;
	}
}
public class ReferenceCounting {

	public static void main(String[] args) {
		Shared shared = new Shared();
		Composing[] composings = {new Composing(shared), new Composing(shared), new Composing(shared)};
		for (Composing c : composings) {
			c.dispose();
		}
	}

}
