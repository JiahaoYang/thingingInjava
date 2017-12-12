package net.nio;

import java.util.Scanner;

import org.junit.Test;

public class TestNio {
	@Test
	public void test() throws InterruptedException {
		Server.start(1236);
		Thread.sleep(100);
		Client.start("127.0.0.1", 1236);
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			Client.send(scan.nextLine());
		}
	}
}
