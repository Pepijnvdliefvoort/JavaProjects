import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Match {
	//Variables
	public ArrayList<Game> games;
	public ArrayList<Player> players;

	// Constructor
	public Match(ArrayList<Player> players) {
		games = new ArrayList<>();
		this.players = players;
	}

	/**
	 * Chooses a random player and starts 2 games
	 */
	public void play() {
		// Choose random player to start with
		Collections.shuffle(players);
		System.out.println("De loting is verricht: " + players.get(0).getName() + " begint met raden.");
		// Play game 1
		games.add(new Game(players.get(0), players.get(1)));

		// Play game 2
		System.out.println("Nu is het de beurt om te raden aan: " + players.get(1).getName());
		games.add(new Game(players.get(1), players.get(0)));

		// Determine the winner
		if (players.get(0).getPoints() > players.get(1).getPoints()) {
			System.out.println(players.get(0).getName() + " heeft gewonnen met " + players.get(0).getPoints() + "-"
					+ players.get(1).getPoints());
		} 
		else if (players.get(0).getPoints() < players.get(1).getPoints()) {
			System.out.println(players.get(1).getName() + " heeft gewonnen met " + players.get(1).getPoints() + "-"
					+ players.get(0).getPoints());
		} 
		else {
			System.out.println("Het is een gelijkspel geworden met " + players.get(0).getPoints() + "-"
					+ players.get(1).getPoints());
		}

	}

	/**
	 * @return Choose to play again or not
	 */
	@SuppressWarnings("resource")
	public boolean again() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Wil je nog een keer spelen (ja/nee)? ");
		String answer = scanner.next().toLowerCase();

		switch (answer) {
		case "ja":
			return true;
		case "nee":
			return false;
		default:
			// if something else has been entered other than "ja" "nee"
			return again();
		}
	}
}
