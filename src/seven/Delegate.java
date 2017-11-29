package seven;

class SpaceshipControls {
	void up(int velocity) {}
	void down(int velocity) {}
	void left(int velocity) {}
	void right(int velocity) {}
}

class Space {
	private String name;
	private SpaceshipControls controls = new SpaceshipControls();
	public Space(String name) {
		this.name = name;
	}
	//代理方法，不通过继承暴露了成员变量的所有方法
	public void up(int velocity) {
		controls.up(velocity);
	}
	public void down(int velocity) {
		controls.down(velocity);
	}
	public void left(int velocity) {
		controls.left(velocity);
	}
	public void right(int velocity) {
		controls.right(velocity);
	}
	
}
public class Delegate {

	public static void main(String[] args) {
		Space ship = new Space("yjh");
		ship.down(100);
	}

}
