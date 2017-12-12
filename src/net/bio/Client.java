package net.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private static int PORT = 1246;
	private static String HOST = "127.0.0.1";
	
	public static void send(String s) {
		send(PORT, s);
	}
	
	public static void send(int port, String s) {
		try {
			Socket client = new Socket(HOST, port);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			out.println(s);
			System.out.println(in.readLine());
			System.out.println("hah");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
