package twentyOne;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLock {
	private ReentrantLock lock = new ReentrantLock();
	public void untimed() {
		boolean capture = lock.tryLock();
		try {
			System.out.println("try lock" + capture);
		} finally {
			if (capture)
				lock.unlock();
		}
	}
	
	public void timed() {
		boolean capture = false;
		try {
			capture = lock.tryLock(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("try lock(...)" + capture);
		} finally {
			if (capture)
				lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final AttemptLock attemptLock = new AttemptLock();
		attemptLock.timed();
		attemptLock.untimed();
		
		new Thread(() -> { attemptLock.lock.lock();}).start();
		Thread.yield();
	
		attemptLock.timed();
		attemptLock.untimed();
	}
}
