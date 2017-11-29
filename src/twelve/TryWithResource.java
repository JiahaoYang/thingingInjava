package twelve;

import java.io.BufferedReader;
import java.io.FileReader;

class InputFile {
	public InputFile(String path) throws Exception {
		try(BufferedReader in = new BufferedReader(new FileReader(path))) {
			System.out.println("inside try");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
public class TryWithResource {
	
	public static void main(String[] args) {
		
	}

}
