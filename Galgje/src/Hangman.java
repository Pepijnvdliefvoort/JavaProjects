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

			// Play the match
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

		for (int j = 0; j < 2; j++) {
			while (true) {
				System.out.print("Geef de naam van speler " + (j + 1) + " (of een C voor computer): ");
				String player = scanner.nextLine().trim();

				if (player.isEmpty()) {
					continue;
				}

				if(player.equalsIgnoreCase("C")) {
					players.add(new PlayerComputer());
					break;
				}
				else {
					players.add(new PlayerHuman(player));
					break;
				}
			}
		}
	}
}
