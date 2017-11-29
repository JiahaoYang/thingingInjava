package eighteen;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class TestFileIO {
	private static final int NUMOFINTS = 4000000;
	private static final int NUMOFBUFFS = 200000;
	
	private abstract static class Tester {
		private String name;
		public Tester(String name) {
			this.name = name;
		}
		public void runTest() {
 			System.out.print(name + ":");
			try {
				long start = System.nanoTime();
				test();
				double during = System.nanoTime() - start;
				System.out.printf("%.2f\n", during/1.0e9);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		public abstract void test() throws IOException;
	}
	
	private static Tester[] testers = {
		new Tester("Stream Writer") {
			@Override
			public void test() throws IOException {
				DataOutputStream out = new DataOutputStream(
						new BufferedOutputStream(new FileOutputStream("test.txt")));
				for (int i = 0; i < NUMOFINTS; ++i)
					out.writeInt(i);
				out.close();
			}
		},
		new Tester("Mapped Writer") {
			@Override
			public void test() throws IOException {
				@SuppressWarnings("resource")
				FileChannel fc = new RandomAccessFile("test.txt", "rw").getChannel();
				IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
				for (int i = 0; i < NUMOFINTS; ++i)
					ib.put(i);
				fc.close();
			}
		},
		new Tester("Stream Read") {
			@Override
			public void test() throws IOException {
				DataInputStream in = new DataInputStream(
						new BufferedInputStream(new FileInputStream("test.txt")));
				for (int i = 0; i < NUMOFINTS; ++i)
					in.readInt();
				in.close();
			}
		},
		new Tester("Mapped Read") {
			@Override
			public void test() throws IOException {
				@SuppressWarnings("resource")
				FileChannel fc = new FileInputStream("test.txt").getChannel();
				IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
				while (ib.hasRemaining())
					ib.get();
				fc.close();
			}
		},
		new Tester("Stream read/write") {
			@Override
			public void test() throws IOException {
				RandomAccessFile ref = new RandomAccessFile("test.txt", "rw");
				ref.writeInt(1);
				for (int i = 0; i < NUMOFBUFFS; ++i) {
					ref.seek(ref.length()-4);
					ref.writeInt(ref.readInt());
				}
				ref.close();
			}
		},
		new Tester("Mapped read/write") {
			@Override
			public void test() throws IOException {
				@SuppressWarnings("resource")
				FileChannel fc = new RandomAccessFile("test.txt", "rw").getChannel();
				IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
				ib.put(0);
				for (int i = 1; i < NUMOFBUFFS; ++i) {
					ib.put(ib.get(i-1));
				}
				fc.close();
			}
		}
	};
	
	public static void main(String[] args) {
		for (Tester tester : testers)
			tester.runTest();
	}
}
