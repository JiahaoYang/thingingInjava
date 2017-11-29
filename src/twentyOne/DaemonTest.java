package twentyOne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

class DaemonThreadFactory implements ThreadFactory{
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setDaemon(true);
		return thread;
	}
}

public class DaemonTest{
	private Thread[] threads = new Thread[10];
	
	@Test
	public void test1() throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for (int i = 0; i < 3; ++i)
			exec.execute(() -> {while (true) {System.out.println("dsa");}});
		System.out.println("all start");
		TimeUnit.SECONDS.sleep(1);
	}


}
