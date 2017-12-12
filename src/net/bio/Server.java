package net.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	private static int PORT = 1246;
	private static ServerSocket server;	//单例服务器
	private static ExecutorService executorService = Executors.newFixedThreadPool(100);
	
	public static void start() {
		start(PORT);
	}
	
	public static synchronized void start(int port) {
		if (server != null) 
			return;
		try {
			server = new ServerSocket(port);
			System.out.println("服务器已启动，端口号" + port);
			while (true) {
				Socket socket = server.accept();
				executorService.execute(new ServerThread(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) {				
				System.out.println("服务器已关闭");
				server = null;
			}
		}
	}
	
}
