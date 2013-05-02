package joe.game.sf;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Window(640, 480);
		ImageBank.init();
		ImageBank.loadImage("res/playerBlue.png", "blue");
	}
}
