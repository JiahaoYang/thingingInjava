package twentyOne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class IntGenerator {
	private boolean canceled = false;
	private int currentVal = 0;
	private Lock lock = new ReentrantLock();
	public  synchronized int next() {
		lock.lock();
		try {
			++currentVal;
			Thread.yield();
			++currentVal;
			return currentVal;	
		} finally {
			lock.unlock();
		}

	}
	public void cancel() {
		canceled = true;
	}
	public boolean getCancel() {
		return canceled;
	}
}

class EvenChecker implements Runnable {
	private IntGenerator intGenerator;
	private final int id;
	
	public EvenChecker(IntGenerator intGenerator, int id) {
		this.intGenerator = intGenerator;
		this.id = id;
	}

	@Override
	public void run() {
		while (!intGenerator.getCancel()) {
			int val = intGenerator.next();
			if (val%2 != 0) {
				System.out.println(val + " not evev");
				intGenerator.cancel();
			}
		}
	}
	
	public static void test(IntGenerator intGenerator) {
		System.out.println("ctrl+c exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; ++i)
			exec.execute(new EvenChecker(intGenerator, i));
		exec.shutdown();
	}
}
public class SharedRecourse {
	public static void main(String[] args) {
		EvenChecker.test(new IntGenerator());
	}
}
