package net.bio;

import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;

public class TestBio {

	
	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {Server.start();}).start();
		Thread.sleep(100);
		Client.send("yjh");
		ServerSocketChannel
	}
}
