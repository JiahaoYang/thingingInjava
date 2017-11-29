package seven;

//子类显示调用父类带参数的构造器
class Game {
	public Game(int i) {
		System.out.println("Game");
	}
}

class BoardGame extends Game {
	public BoardGame(int i) {
		super(i);
		System.out.println("boardGame");
	}
}

class Chess extends BoardGame {
	public Chess(int i) {
		super(i);
		System.out.println("chess");
	}
}

public class Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
