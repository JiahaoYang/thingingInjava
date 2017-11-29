package twentyOne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomTest implements Runnable{
	private int i = 0;
	public synchronized int getVal() {
		return i;
	}
	public synchronized void add() {
		++i;
		i++;
	}
	@Override
	public void run() {
		while (true) {
			add();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomTest atomTest = new AtomTest();
		exec.execute(atomTest);
		while (true) {
			int val = atomTest.getVal();
			if (val%2 != 0) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}
	
}
