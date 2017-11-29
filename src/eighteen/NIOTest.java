package eighteen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.ShortBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.SortedMap;


public class NIOTest {
	private static final int BUFFSIZE = 4096;
	
	public static void allCharSets() {
		SortedMap<String, Charset> charSets = Charset.availableCharsets();
		for (String key : charSets.keySet()) {
			System.out.print(key + ": ");
			for (String charset : charSets.get(key).aliases()) 
				System.out.print(charset + " ");
			System.out.println();
		}
	}
	public static void testChannel(String file) {
		try (FileChannel fc = new FileOutputStream(file).getChannel()) {
			ByteBuffer buffer = ByteBuffer.allocate(24);
//			buffer.asCharBuffer().put("杨家浩");
//			buffer.asLongBuffer().put(1000000000);
			buffer.asDoubleBuffer().put(3.14);
			fc.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (FileChannel fc = new FileInputStream(file).getChannel()) {
			ByteBuffer buff = ByteBuffer.allocate(BUFFSIZE);
			fc.read(buff);
			buff.flip();
//			System.out.println(buff.asCharBuffer());
//			System.out.println(buff.getLong());
			System.out.println(buff.getDouble());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void transform(String src, String dest) {
		try (FileChannel in = new FileInputStream(src).getChannel();
				FileChannel out = new FileOutputStream(dest).getChannel()) {
			in.transferTo(0, in.size(), out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void bufferView() {
		ByteBuffer buff = ByteBuffer.wrap(new byte[] {0,0,0,0,0,0,0,'a'});
		buff.rewind();
		while (buff.hasRemaining())
			System.out.print(buff.position() + "->" + buff.get() + " ");
		System.out.println();
		
		CharBuffer cb = ((ByteBuffer)buff.rewind()).asCharBuffer();
		while (cb.hasRemaining())
			System.out.print(cb.position() + "->" + cb.get() + " ");
		System.out.println();
		
		ShortBuffer sb = ((ByteBuffer)buff.rewind()).asShortBuffer();
		while (sb.hasRemaining())
			System.out.print(sb.position() + "->" + sb.get() + " ");
		System.out.println();
	}
	
	public static void swap(CharBuffer cb) {
		while (cb.hasRemaining()) {
			cb.mark();
			char c1 = cb.get();
			char c2 = cb.get();
			cb.reset();
			cb.put(c2).put(c1);
		}
	}
	
	public static void mapFile() throws FileNotFoundException, IOException {
		int length = 0x8fffff;
		MappedByteBuffer out = new RandomAccessFile("test.txt", "rw")
				.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
		for (int i = 0; i < length; ++i)
			out.put((byte)'x');
		System.out.println("Finish");
		for (int i = length/2; i < length/2+10; ++i)
			System.out.println(out.get(i));
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
	//	testChannel("test.txt");
	//	transform("test.txt", "test0.txt);
	//	allCharSets();
	//	bufferView();
//		char[] chars = "杨家浩的yjh".toCharArray();
//		ByteBuffer bb = ByteBuffer.allocate(BUFFSIZE);
//		CharBuffer cb = bb.asCharBuffer();
//		cb.put(chars);
//		System.out.println(cb.rewind());
//		swap(cb);
//		System.out.println(cb.rewind());
//		mapFile();
	}
}
