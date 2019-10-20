public class Main {

	public static void main(String[] args) {
		//Initialize game
		welcomeMessage();
	}
	

	/**
	 * Show welcome message and start hangman
	 */
	public static void welcomeMessage() {
		System.out.println("Welkom bij Galgje!");
				
		Hangman hangman = new Hangman();
		//Start hangman game
		hangman.start();
		
	}

}
