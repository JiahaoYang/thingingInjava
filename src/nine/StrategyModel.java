package nine;

import java.util.Arrays;

//策略对象
class Processor {
	public String name() { 
		return getClass().getName();
	}
	public Object process(Object obj) {
		return obj;
	}
}

class Upcase extends Processor {
	public String process(Object input) {
		return ((String)input).toUpperCase();
	}
}

class Lowercase extends Processor {
	public String process(Object input) {
		return ((String)input).toLowerCase();
	}
}

class Splitter extends Processor {
	public String process(Object input) {
		return Arrays.toString(((String)input).split(" "));
	}
}

//stragety.process和Processor耦合过紧
public class StrategyModel {
	public static void process(Processor p, Object s) {
		System.out.println("use" + p.name());
		p.process(s);
	}
	public static String string = "we are family";
	public static void main(String[] args) {
		process(new Upcase(), string);
		process(new Lowercase(), string);
		process(new Splitter(), string);		
	}

}
