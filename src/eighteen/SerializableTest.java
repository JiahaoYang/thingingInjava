package eighteen;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

class Data implements Serializable {
	private int n;
	public Data(int n) {
		this.n = n;
	}
	public String toString() {
		return Integer.toString(n);
	}
}

class Worm implements Serializable {
	private static Random rand = new Random();
	private Data[] datas = {
		new Data(rand.nextInt(10)),
		new Data(rand.nextInt(10)),
		new Data(rand.nextInt(10))
	};
	private Worm next;
	private char c;
	public Worm(int i, char c) {
		System.out.println("Worm constructor" + i);
		this.c = c;
		if (--i > 0)
			next = new Worm(i, (char)(c+1));
	}
	public Worm() {
		System.out.println("default constructor");
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(c);
		for (Data data : datas)
			sb.append(data + " ");
		if (next != null)
			sb.append(next);
		return sb.toString();
	}
}

class Person implements Serializable {
	private int id;
	private transient String name;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return id + name;
	}
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
//		out.writeObject(name);
	}
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
//		name = (String)in.readObject();
	}
}
class Blip implements Externalizable {
	private int i;
	private String string;
	
	public Blip() {
		System.out.println("default constructor");
	}
	
	public Blip(int i, String string) {
		System.out.println("not default");
		this.i = i;
		this.string = string;
	}
	
	public String toString() {
		return string + i;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("write Obj");
		out.writeObject(string);
		out.writeInt(i);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("read Obj");
		string = (String)in.readObject();
		i = (int)in.readInt();
	}
}


public class SerializableTest {
	public static void testWorm() throws FileNotFoundException, IOException, ClassNotFoundException {
		Worm worm = new Worm(5, 'a');
		System.out.println(worm);
		
		ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("text.txt")));
		out.writeObject("worm storage");
		out.writeObject(worm);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("text.txt")));
		String s = (String)in.readObject();
		Worm worm2 = (Worm)in.readObject();
		System.out.println(s + worm2);
	}
	
	public static void testAlien() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("alien.out"));
		Object alien = in.readObject();
		System.out.println(alien.getClass());
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		Blip blip = new Blip(32, "yjh");
//		System.out.println(blip);
//		ByteArrayOutputStream bout = new ByteArrayOutputStream(100);
//		ObjectOutputStream out = new ObjectOutputStream(bout);
//		out.writeObject(blip);
//		out.close();
//		System.out.println("recover");
//		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
//		blip = (Blip)in.readObject();
//		System.out.println(blip);
		
		Person person = new Person(1, "杨家浩");
		System.out.println(person);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bout);
		out.writeObject(person);
		
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
		person = (Person)in.readObject();
		System.out.println(person);
	}
}
