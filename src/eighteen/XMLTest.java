package eighteen;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

class Person1 {
	private String first, last;
	public Person1(String first, String last) {
		this.first = first;
		this.last = last;
	}
	
	public Element getXML() {
		Element person = new Element("person");
		Element firstName = new Element("first");
		Element lastName = new Element("last");
		firstName.appendChild(first);
		lastName.appendChild(last);
		person.appendChild(firstName);
		person.appendChild(lastName);
		
		return person;
	}
	
	public Person1(Element person) {
		this.first = person.getFirstChildElement("first").getValue();
		this.last = person.getFirstChildElement("last").getValue();
	}
	
	public String toString() {
		return first + last;
	}
	
	public static void format(OutputStream out, Document doc) throws IOException {
		Serializer serializer = new Serializer(out, "utf-8");
		serializer.setIndent(4);
		serializer.setMaxLength(100);
		serializer.write(doc);
		serializer.flush();
	}
}

public class XMLTest {
	public static void main(String[] args) throws IOException {
		List<Person1> persons = Arrays.asList(
			new Person1("jiahao", "yang"),
			new Person1("杨", "家浩")
		);
		System.out.println(persons);
		
		Element root = new Element("people");
		for (Person1 person1 : persons) {
			root.appendChild(person1.getXML());
		}
		Document doc = new Document(root);
		Person1.format(System.out, doc);
		Person1.format(new BufferedOutputStream(new FileOutputStream("person.xml")), doc); 
	}
}
