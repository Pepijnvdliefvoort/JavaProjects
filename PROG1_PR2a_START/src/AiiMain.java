public class AiiMain {

	public static void main(String[] args) {
		int windowWidth = 400;
		int windowHeight = 400;
		AiiCanvas c = new AiiCanvas("Playfield", windowWidth, windowHeight);
		@SuppressWarnings("unused")
		PlayBall playing = new PlayBall(c);
	}
}