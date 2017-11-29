package eight;

class Actor {
	public void act() {} 
}

class HappyActor extends Actor {
	public void act() {
		System.out.println("happy");
	}
}

class SadActor extends Actor {
	public void act() {
		System.out.println("sad");
	}
}

//状态模式，运行期间的动态灵活性
class Stage {
	private Actor actor = new HappyActor();
	public void change() {
		actor = new SadActor();
	}
	public void perform() { 
		actor.act();
	}
}
public class StatePattern {

	public static void main(String[] args) {
		Stage stage = new Stage();
		stage.perform();
		stage.change();
		stage.perform();
	}

}
