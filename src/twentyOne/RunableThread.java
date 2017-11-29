package twentyOne;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

class LiftOff implements Runnable {
	protected int cntDown = 10;
	private static int taskCnt = 0;
	private final int id = taskCnt++;
	public LiftOff(int cntDown) {
		this.cntDown = cntDown;
	}
	
	public LiftOff() {
	}

	@Override
	public String toString() {
		return "#" + id + "(" + cntDown + ")";
	}

	@Override
	public void run() {
		while (cntDown-- > 0) {
			System.out.print(this);
			Thread.yield();
		}	
	}
}

class TaskWithResult implements Callable<String> {
	private final int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		return "id=" + id;
	}
}

class SimplePriority implements Runnable {
	private int id;
	private volatile double d;
	private int priority;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

class SimpleDaemons implements Runnable {
	
	@Override
	public void run() {
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(10);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch (Exception e) {
		}
	}
	
}

class SleepTask extends LiftOff {
	public void run() {
		try {
			while (cntDown-- > 0) {
				System.out.println(this);
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class RunableThread {
	
	@Test
	public void testFactory() {
		ExecutorService exec = Executors.newCachedThreadPool(new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				thread.setDaemon(true);
				return thread;
			}
		});
		for (int i = 0; i < 3; ++i) {
			exec.execute(new LiftOff());
		}
	}
	@Test
	public void testdaemon() throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; ++i) {
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("All start");
		TimeUnit.MILLISECONDS.sleep(100);
	}
	
	@Test
	public void testThread() {
		for (int i = 0; i < 3; ++i)
		new Thread(new LiftOff()).start();
		System.out.println("waitiing");
	}
	
	@Test
	public void testExecutor() {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 3; ++i)
			exec.execute(new LiftOff());
		exec.shutdown();	
	}
	
	@Test
	public void testCallable() {
		List<Future<String>> results = new ArrayList<>();
		ExecutorService  exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; ++i)
			results.add(exec.submit(new TaskWithResult(i)));
		for (Future<String> f : results) {
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} finally {
				exec.shutdown();
			}
		}
	}
	
	@Test
	public void testSleep() {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; ++i)
			exec.execute(new SleepTask());
		exec.shutdown();
	}
	
	public static void main(String[] args) {


	}
}
