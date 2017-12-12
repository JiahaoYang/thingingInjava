package net.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable{
	private Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	//刷新！！！
	public void run() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) { 
			while (true) {
				String s = in.readLine();
				System.out.println("服务器收到" + s);
				if ("bye".equals(s))
					break;
				out.println("echo " + s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
