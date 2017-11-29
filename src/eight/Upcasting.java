package eight;


enum Note {
	MIDDLE_C, B_FLAT
}

class Instrcment {
	public void play(Note n){ 
		System.out.println("instryment play()");
	}
}

class Wind extends Instrcment {
	@Override
	public  void play(Note n) {
		System.out.println("wind paly()" + n);
	}
}


public class Upcasting {
	public static void tune(Instrcment i ) {
		i.play(Note.B_FLAT);
	}
	public static void main(String[] args) {
		Wind wind = new Wind();
		tune(wind);
	}

}
