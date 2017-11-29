package fourteen;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import fourteen.Robot.Test;

interface Null {
}

interface Operation {
	String description();

	void command();
}

interface Robot {
	String name();

	String model();

	List<Operation> operations();

	// 嵌套类用作测试
	class Test {
		public static void test(Robot r) {
			if (r instanceof Null)
				System.out.println("[Null Robot]");
			System.out.println("name: " + r.name());
			System.out.println("model: " + r.model());
			for (Operation operation : r.operations()) {
				System.out.println(operation.description());
				operation.command();
			}
		}
	}
}

class SnowRobot implements Robot {
	private String name;

	public SnowRobot(String name) {
		this.name = name;
	}

	public String name() {
		return name;
	}

	public String model() {
		return "SnowRobot Version 1.0";
	}

	public List<Operation> operations() {
		return Arrays.asList(new Operation() {

			@Override
			public String description() {
				return name + " can watch snow";
			}

			@Override
			public void command() {
				System.out.println(name + " is watching snow");
			}
		}, new Operation() {

			@Override
			public String description() {
				return name + " can make snow";
			}

			@Override
			public void command() {
				System.out.println(name + " is making snow");
			}
		});
	}
}

class NullRobotProxyHandler implements InvocationHandler {
	private String nullName;
	private Robot proxied = new NullRobot();
	public NullRobotProxyHandler(Class<? extends Robot> type) {
		nullName = type.getSimpleName() + " NullRobot";
	}
	private class NullRobot implements Robot, Null {
		public String name() {
			return nullName;
		}
		public String model() {
			return nullName;
		}
		public List<Operation> operations() {
			return Collections.emptyList();
		}
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(proxied, args);
	}
	
}

public class RobotTest {
	public static Robot newNullRobot(Class<? extends Robot> type) {
		return (Robot)Proxy.newProxyInstance(
				RobotTest.class.getClassLoader(), 
				new Class[]{Null.class, Robot.class}, 
				new NullRobotProxyHandler(type));
	}
	public static void main(String[] args) {
		Robot[] robots = {
				new SnowRobot("yjh"),
				newNullRobot(SnowRobot.class)
		};
		for (Robot robot : robots)
			Robot.Test.test(robot);
	}
}
