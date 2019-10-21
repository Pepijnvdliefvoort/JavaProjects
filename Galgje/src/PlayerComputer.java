import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PlayerComputer extends Player {
	// Variables
	private static final int DELAY = 2000;

	// Constructor
	public PlayerComputer() {
		super("De computer");
	}

	public char guess(Game game) {
		// Alphabet
		ArrayList<Character> alphabet = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
		Collections.shuffle(alphabet);
		char c = 0;

		while (true) {
			Random random = new Random();
			int r = random.nextInt(alphabet.size());
			c = alphabet.get(r);

			if (!game.getGuesses().contains(c)) {
				break;
			}
		}

		// No need to validate if letter is correct
		// Computer only picks random letters which have not previously been guessed
		game.getGuesses().add(c);

		// Add delay to prevent game from being ended nearly instantly
		try {
			TimeUnit.MILLISECONDS.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return c;
	}

	public void process(Game game, char c) {
		//if a false char has been given do nothing
		if (c == 0) {
			return;
		}

		// If the opponent is a computer show the computer's guess
		if (game.getGuesser() instanceof PlayerComputer) {
			System.out.println(game.getGuesser().getName() + " raad een " + c + ".");
		}

		// Show how many times the given char occurs in string
		if (countOccurences(game.getRandomWord(), c) == 0) {
			System.out.println("De letter " + c + " komt niet in het woord voor.");
		} else {
			System.out.println("De letter " + c + " komt " + countOccurences(game.getRandomWord(), c)
					+ " keer in het woord voor.");
		}

		// check if letter not in random word
		if (game.getRandomWord().indexOf(c) < 0) {
			game.getWrong_guesses().add(c);
			game.setMistakes(game.getMistakes() + 1);
		}
	}

	public void printWord(Game game) {
		for (int i = 0; i < game.getRandomWord().length(); i++) {
			char c = game.getRandomWord().charAt(i);

			if (game.getGuesses().contains(c)) {
				System.out.print(c);
			} else {
				System.out.print(".");
			}
		}
		System.out.println();
	}

	public boolean isFinished(Game game) {
		// if mistakes reaches maximum mistakes
		if (game.getMistakes() >= game.getMAX_MISTAKES()) {
			game.getGuesser().setPoints(0);
			game.printHangman(game.getMistakes());
			System.out.println(
					"Helaas! Het woord is niet correct geraden, het juiste woord was: " + game.getRandomWord());
			return true;
		}

		// if word has been guessed correctly
		int correctAmount = 0;
		for (int i = 0; i < game.getRandomWord().length(); i++) {
			char c = game.getRandomWord().charAt(i);

			if (game.getGuesses().contains(c)) {
				correctAmount++;
			}

			if (game.getRandomWord().length() == correctAmount) {
				game.getGuesser().setPoints(10 - game.getMistakes());
				System.out.println("Het woord is geraden: " + game.getRandomWord());
				return true;
			}
		}
		// return true if mistakes hasn't reached maximum mistakes or if word hasn't
		// been guessed correctly yet
		return false;
	}

	/**
	 * @param string = the string that you want to filter on
	 * @param c      = the char to filter by
	 * @return the amount of times a character occurs in string
	 * 
	 *         iterate through every character in string until the end of the string
	 *         when c occurs, add counter by 1
	 */
	public int countOccurences(String string, char c) {
		int count = 0;

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == c)
				count++;
		}

		return count;
	}
}
