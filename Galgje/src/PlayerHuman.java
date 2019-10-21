import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayerHuman extends Player {
	// Variables

	// Constructor
	public PlayerHuman(String name) {
		super(name);
	}

	@SuppressWarnings("resource")
	public char guess(Game game) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Geef de letter die je wilt raden: ");
		String current = scanner.nextLine();
		current = current.toUpperCase();

		// check if no value has been entered
		if (current.equals("")) {
			System.out.println("Vul een waarde in!");
			return 0;
		}

		// check if given letter is valid
		if (current.length() == 1) {
			char c = current.charAt(0);
			// if character is a letter
			if (Character.isLetter(c)) {
				// check if character already exists in guesses
				if (!game.getGuesses().contains(c)) {
					game.getGuesses().add(c);
					return c;
				} else {
					System.out.println("De " + c + " is al geraden!");
					return 0;
				}
			} else {
				System.out.println("Graag alleen een letter opgeven!");
				return 0;
			}
		} else {
			System.out.println("Graag maar 1 letter opgeven!");
			return 0;
		}
	}

	@SuppressWarnings("resource")
	public void process(Game game, char c) {
		// Check if no value has been entered
		if (c == 0) {
			return;
		}

		// Initial values
		Scanner scanner = new Scanner(System.in);

		System.out.print(game.getGuesser().getName() + " raad een " + c + ". Op welke plaats(en) staat die letter? ");
		String positions = scanner.nextLine().trim();

		// Check if nothing has been entered
		if (positions.equals("")) {
			System.out.println("Vul een waarde in!");
			process(game, c);
			return;
		}

		if (positions.trim().equals("*")) {
			game.getWrong_guesses().add(c);
			game.setMistakes(game.getMistakes() + 1);
		} else {
			List<String> strPositions = Arrays.asList(positions.split(" "));
			List<Integer> intPositions = new ArrayList<>();

			// Convert string to integers
			try {
				for (String str : strPositions) {
					intPositions.add(Integer.parseInt(str.trim()));
				}
			} catch (NumberFormatException e) {
				System.out.println("Ongeldige plaats(en) opgegeven!");
				process(game, c);
			}

			char[] word = game.getWord();
			for (int i = 0; i < word.length; i++) {
				for (int j = 0; j < intPositions.size(); j++) {

					// Check if any position is out of range ( > 12 || < 1)
					if (intPositions.get(j) > 12 || intPositions.get(j) < 1) {
						System.out.println("Vul een getal in tussen de 1 en 12!");
						process(game, c);
						return;
					}

					// Check if position in word is equal to given position
					if (i == (intPositions.get(j) - 1)) {

						// Check if all positions are available first
						// if not, stop looping and give message
						if (word[i] != 0) {
							System.out.println("Op de opgegeven positie(s) is al een letter ingevoerd!");
							process(game, c);
							return;
						}

						// if positions are available, set current character in word array
						word[i] = c;
					}
				}
			}
		}
	}

	public void printWord(Game game) {
		for (int i = 0; i < game.getWord().length; i++) {

			if (game.getWord()[i] == 0) {
				System.out.print(".");
			} else {
				System.out.print(game.getWord()[i]);
			}
		}
		System.out.println();
	}

	public boolean isFinished(Game game) {
		// if mistakes reaches maximum mistakes
		if (game.getMistakes() >= game.getMAX_MISTAKES()) {
			game.getGuesser().setPoints(0);
			game.printHangman(game.getMistakes());
			System.out.println("Helaas! Het woord is niet correct geraden!");
			return true;
		}

		for (int i = 0; i < game.getWord().length; i++) {
			if (game.getWord()[i] == 0) {
				return false;
			}

		}
		System.out.println("Het woord is geraden.");
		game.getGuesser().setPoints(10 - game.getMistakes());
		return true;
	}
}
