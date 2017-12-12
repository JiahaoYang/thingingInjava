package net.nio;

public class Server {
	private static ServerHandle serverHandle;
	
	public static synchronized void start(int port) {
		if (serverHandle != null)
			serverHandle.stop();
		serverHandle = new ServerHandle(port);
		new Thread(serverHandle, "Server").start();
	}
}
