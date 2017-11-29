package fourteen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

interface Factory<T> {
	T create();
}

class Part {
	public String toString() {
		return getClass().getSimpleName();
	}
	static List<Factory<? extends Part>> factories = 
			new ArrayList<>();
	static {
		factories.add(new Apart.Factory());
		factories.add(new Bpart.Factory());
		factories.add(new Cpart.Factory());		
	}
	private static Random rand = new Random();
	public static Part createRand() { 
		int n = rand.nextInt(factories.size());
		return factories.get(n).create();
	}
}

class Apart extends Part {
	public static class Factory implements fourteen.Factory<Apart>{
		public Apart create(){
			return new Apart();
		}
	}
}

class Bpart extends Part {
	public static class Factory implements fourteen.Factory<Bpart>{
		public Bpart create(){
			return new Bpart();
		}
	}
}

class Cpart extends Part {
	public static class Factory implements fourteen.Factory<Cpart>{
		public Cpart create(){
			return new Cpart();
		}
	}
}


public class FactoryPattern {
	public static void main(String[] args) {
		for (int i = 0; i < 10; ++i) {
			System.out.println(Part.createRand());
		}
	}
}
