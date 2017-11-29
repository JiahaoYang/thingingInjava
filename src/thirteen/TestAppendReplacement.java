package thirteen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*!   Here's a block of  text to use as input to
the regular expression  matcher. Note that we'll
first extract the  block of text by looking for
the special delimiters, then process the
extracted block.   !*/

public class TestAppendReplacement {
	public static String read(String file) { 
		StringBuilder sb = new StringBuilder();
		try(BufferedReader in = new BufferedReader(new FileReader(new File(file).getAbsolutePath()))) {
			String string;
			while ((string=in.readLine()) != null) {
				sb.append(string);
				sb.append("\n");
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = read("c:/users/jiahao yang/desktop/a.txt");
		//匹配开头注释
		Matcher m = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
		if (m.find()) {
			s = m.group(1);	//获得注释内容
			s = s.replaceAll(" {2,}", " ");	//删除多余的空格
			s = s.replaceAll("(?m)^ +", ""); //删除每行开头的空格
			System.out.println(s);
			
			s = s.replaceFirst("[aeiou]", "我是第一个元音字母");
			StringBuffer buf = new StringBuffer();
			Matcher mm = Pattern.compile("[aeiou]").matcher(s);
			while (mm.find()) {
				mm.appendReplacement(buf, mm.group().toUpperCase());
			}
			mm.appendTail(buf);
			System.out.println(buf);
		}
	}
}
