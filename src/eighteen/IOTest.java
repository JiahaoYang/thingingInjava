package eighteen;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.TreeMap;


class OSExecute {
	public static void command(String cmd) {
		try {
			Process process = new ProcessBuilder(cmd.split(" ")).start();
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				String string;
				while ((string = reader.readLine()) != null)
					System.out.println(string);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
class CountChar extends TreeMap<Character, Integer> {
	public static String read(String fileName) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = in.readLine()) != null)
				sb.append(line + "\n ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public CountChar(String fileName) {
		char[] chars = new char[5000];
		String content = read(fileName);
		content.getChars(0, content.length()-1, chars, 0);
		for (char c : chars) 
			put(c, get(c) == null ? 1 : get(c)+1);
	}
}
public class IOTest {
	
	public static String readFile(String fileName) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader bd = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bd.readLine()) != null) {
				sb.append(line + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static void readString(String fileName) {
		try (StringReader sr = new StringReader(readFile(fileName))) {
			int c;
			while ((c = sr.read()) != -1)
				System.out.print((char)c);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testDataInput(String fileName) {
		try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(fileName));
				DataInputStream dataInput = new DataInputStream(new FileInputStream(fileName))) {
			dataOut.writeInt(12);
			dataOut.write("杨家浩".getBytes());
			
			System.out.println(dataInput.readInt());
			byte[] bs = new byte[9];
			System.out.println(dataInput.read(bs));
			System.out.println(new String(bs, 0, 9));
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	public static void copyFile(String src, String dest){
//		try (PrintWriter printWriter = new PrintWriter(dest) ) {
//			
//			printWriter.println("钱诗慧");
//			printWriter.println('a');
//			printWriter.println(12);
//			printWriter.println(12.34);
//			printWriter.println(true);
//			printWriter.println(213213213);
//			
//			try (BufferedReader reader = new BufferedReader(new FileReader(dest))) {
//				String line;
//				while ((line = reader.readLine()) != null)
//					System.out.println(line);
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try (BufferedReader reader = new BufferedReader(new FileReader(dest))) {
			String line;
			while ((line = reader.readLine()) != null) 
				System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void storeRecover(String fileName) {
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
			out.writeChar('a');
			out.writeInt(1);
			out.writeLong(100000000);
			out.writeDouble(3.14);
			out.writeUTF("杨家浩");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (DataInputStream in = new DataInputStream(new FileInputStream(fileName))) {
			System.out.println(in.readChar());
			System.out.println(in.readInt());
			System.out.println(in.readLong());
			System.out.println(in.readDouble());
			System.out.println(in.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		OSExecute.command("javap IOTest");
	}
}
