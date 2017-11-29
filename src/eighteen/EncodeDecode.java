package eighteen;

import java.io.UnsupportedEncodingException;

public class EncodeDecode {
	public static void display(byte[] bytes) {
		for (byte b : bytes) {
			int high = (b>>4) & 0x0f;
			int low = b & 0x0f;
			char[] chars = new char[2];
			
			chars[0] = (high>9 ? (char)(high-10+'a') : (char)(high+'0'));
			chars[1] = (low>9 ? (char)(low-10+'a') : (char)(low+'0'));
			
			System.out.print(new String(chars) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "I am 君山";
		char[] chars = s.toCharArray();
		for (char c : chars)
			System.out.print(Integer.toHexString(c)+ " ");
		System.out.println();
		
		byte[] iso8859 = s.getBytes("iso8859-1");
		byte[] gb2312 = s.getBytes("gb2312");
		byte[] gbk = s.getBytes("gbk");
		byte[] utf16 = s.getBytes("utf-16");
		byte[] utf8 = s.getBytes("utf-8");
		
		display(iso8859);
		display(gb2312);
		display(gbk);
		display(utf16);
		display(utf8);
	}
}
