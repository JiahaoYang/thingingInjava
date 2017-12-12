package net.nio;

public class Client {
	private static ClientHandle clientHandle;
	
	public static synchronized void start(String ip, int port) {
		if (clientHandle != null)
			clientHandle.stop();
		clientHandle = new ClientHandle(ip, port);
		new Thread(clientHandle, "client").start();
	}
	
	public static boolean send(String msg) {
		if ("bye".equals(msg))
			return false;
		clientHandle.send(msg);
		return true;
	}
}
