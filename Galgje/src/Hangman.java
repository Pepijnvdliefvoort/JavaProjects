import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
	// Variables
	private ArrayList<Player> players;
	public boolean playing = true;

	// Methods
	public void start() {
		Match match;
		while (playing) {
			initMatch();
			match = new Match(players);

			//Play the match
			match.play();
			

			// Determine whether to keep playing or not
			playing = match.again();
		}
		System.out.println("\nBedankt voor het spelen van Galgje.");
		System.out.println("Hopelijk tot een volgende keer!");
	}

	/**
	 * Initialize match 
	 */
	@SuppressWarnings("resource")
	public void initMatch() {
		// Get player names / computer
		Scanner scanner = new Scanner(System.in);
		players = new ArrayList<>();
		System.out.print("Geef de naam van speler 1 (of een C voor computer): ");
		String player1 = scanner.nextLine();

		System.out.print("Geef de naam van speler 2 (of een C voor computer): ");
		String player2 = scanner.nextLine();

		// Player 1
		if (player1.equalsIgnoreCase("C")) {
			players.add(new PlayerComputer());
		} else {
			players.add(new PlayerHuman(player1));
		}

		// Player 2
		if (player2.equalsIgnoreCase("C")) {
			players.add(new PlayerComputer());
		} else {
			players.add(new PlayerHuman(player2));
		}
	}
}
