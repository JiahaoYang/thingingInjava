package net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerHandle implements Runnable{
	
	private Selector selector;
	private ServerSocketChannel serverChannel;
	private volatile boolean started;
	
	
	public ServerHandle(int port) {
		try {
			selector = Selector.open();	//打开选择器
			serverChannel = ServerSocketChannel.open();	//打开通道
			serverChannel.configureBlocking(false);	//设置为非阻塞
			serverChannel.socket().bind(new InetSocketAddress(port));	//绑定指定地址端口
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);	//注册到选择器上，对接受请求感兴趣
			started = true;
			System.out.println("服务器已启动" + port);
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
		while (started) {
			try {
				selector.select(100); //selector每隔一秒轮询一次
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = keys.iterator();
				SelectionKey key = null;
				while (iterator.hasNext()) {
					key = iterator.next();
					iterator.remove();
					handleInput(key);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void handleInput(SelectionKey key) {
		if (key.isValid()) {
			//处理客户端连接请求
			if (key.isAcceptable()) {
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				try {
					//通过TCP三次握手建立与客户端连接，accept返回一个新的通道
					SocketChannel sc = ssc.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if (key.isReadable()) {
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer buf = ByteBuffer.allocate(1024);
				try {
					int cnt = sc.read(buf);
					if (cnt > 0) {
						buf.flip();
						byte[] bytes = new byte[buf.remaining()];
						buf.get(bytes);
						String result = new String(bytes, "utf8");
						System.out.println("服务器接收到信息" + result);
						doWrite(sc, "echo " + result);
					}
					else {
						key.cancel();
						sc.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void doWrite(SocketChannel sc, String result) {
		byte[] bytes = result.getBytes();
		ByteBuffer buf = ByteBuffer.allocate(bytes.length);
		buf.put(bytes);
		buf.flip();
		try {
			sc.write(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
