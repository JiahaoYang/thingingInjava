package net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ClientHandle implements Runnable{
	private Selector selector;
	private SocketChannel clientChannel;
	private String ip;
	private int port;
	private volatile boolean started;
	
	public ClientHandle(String ip, int port) {
		this.ip = ip;
		this.port = port;
		
		try {
			selector = Selector.open();
			clientChannel = SocketChannel.open();
			clientChannel.configureBlocking(false);
			started = true;
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void stop() {
		started = false;
	}

	@Override
	public void run() {
		doConnect();
		while (started) {
			try {
				selector.select(100);
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = keys.iterator();
				SelectionKey key = null;
				while (iterator.hasNext()) {
					key = iterator.next();
					iterator.remove();
					handleInput(key);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void handleInput(SelectionKey key) {
		if (key.isValid()) {
			SocketChannel sc = (SocketChannel) key.channel();
			try {
				if (key.isConnectable())
					if (!sc.finishConnect())
						System.exit(1);
				if (key.isReadable()) {
					ByteBuffer buf = ByteBuffer.allocate(1024);
					int cnt = sc.read(buf);
					if (cnt > 0) {
						buf.flip();
						byte[] bytes = new byte[buf.remaining()];
						buf.get(bytes);
						String result = new String(bytes, "utf8");
						System.out.println("接收到服务器端数据" + result);
					}
				}	
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private void doConnect() {
		try {
			clientChannel.connect(new InetSocketAddress(ip, port));
			clientChannel.register(selector, SelectionKey.OP_CONNECT); 	//注册连接服务
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void doWrite(SocketChannel sc, String s) {
		byte[] bytes = s.getBytes();
		ByteBuffer buf = ByteBuffer.allocate(bytes.length);
		buf.put(bytes);
		buf.flip();
		try {
			sc.write(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String s) {
		try {
			clientChannel.register(selector, SelectionKey.OP_READ);
		} catch (ClosedChannelException e) {
			e.printStackTrace();
		}
		doWrite(clientChannel, s);
	}
}
