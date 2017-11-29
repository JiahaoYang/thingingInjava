package fourteen;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreater extends PetCreater{
	private static List<Class<? extends Pet>> types = 
			new ArrayList<>();
	private static String[] typeNames = {
			"fourteen.Dog1",
			"fourteen.Dog2",
			"fourteen.Cat1",
			"fourteen.Cat2",
			"fourteen.Monkey"
	};
	@SuppressWarnings(value = { "unchecked" })  //不能直接置于static代码块上
	private static void load() {
		for(String name : typeNames) {
			try {
				types.add((Class<? extends Pet>)Class.forName(name));
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}   
		}
	}
	
	static {load();}
	@Override
	public List<Class<? extends Pet>> types(){
		return types;
	}
	
	public static void main(String[] args) {
		
	}
}
