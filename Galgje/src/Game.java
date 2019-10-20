	import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
	// Variables
	private final int MAX_MISTAKES = 10;
	private ArrayList<Character> guesses, wrong_guesses, alphabet;
	private String randomWord;	
	private char[] word;
	private int mistakes;
	
	private Player guesser;
	private Player thinker;

	// Constructor
	public Game(Player guesser, Player thinker) {
		// Declare players
		this.guesser = guesser;
		this.thinker = thinker;

		// Reset guesses, mistakes, random word and made up word
		guesses = new ArrayList<>();
		wrong_guesses = new ArrayList<>();
		word = new char[12];
		setMistakes(0);
		setRandomWord(getRandomWordFromFile());

		// Start game
		startGame();
	}

	// Methods

	/**
	 * Starts a game and keeps looping until the game is finished
	 */
	@SuppressWarnings("resource")
	public void startGame() {
		// Print different messages depending on if the guesser is a human or not
		if (thinker instanceof PlayerHuman) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Neem een woord van 12 letters in gedachten en druk op <ENTER>");
			scanner.nextLine();
		} else {
			System.out.println("De computer verzint woord.");
		}

		// Loop while a game is not finished
		while (!thinker.isFinished(this)) {
			thinker.printWord(this);
			printMistakes();
			printHangman(getMistakes());
			
			thinker.process(this, guesser.guess(this));
		}
	}

	/**
	 * Print amount of mistakes made and wrongly guessed letters
	 */
	public void printMistakes() {
		if (getMistakes() > 0) {
			String mistakesResult = "Aantal fouten: " + getMistakes();
			mistakesResult += " (";
			for (int i = 0; i < wrong_guesses.size(); i++) {
				mistakesResult += wrong_guesses.get(i);
			}
			mistakesResult += ")";

			System.out.println(mistakesResult);
		}
	}

	/**
	 * @return a random word from the text file
	 */
	public String getRandomWordFromFile() {
		ArrayList<String> words = new ArrayList<>();

		File path = new File("woordenlijst_12.txt");
		try {
			Scanner scanner = new Scanner(path);
			while (scanner.hasNextLine()) {
				words.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Collections.shuffle(words);
		return words.get(0);
	}

	/**
	 * @param faults = amount of mistakes made so far and print hangman ascii
	 *               accordingly
	 */
	public void printHangman(int faults) {
		switch (faults) {
		case 0:
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("|___");
			break;
		case 1:
			System.out.println();
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|___");
			break;
		case 2:
			System.out.println("____");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|___");
			break;
		case 3:
			System.out.println("____");
			System.out.println("|/");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|___");
			break;
		case 4:
			System.out.println("____");
			System.out.println("|/ |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|___");
			break;
		case 5:
			System.out.println("____");
			System.out.println("|/ |");
			System.out.println("|  O");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|___");
			break;
		case 6:
			System.out.println("____");
			System.out.println("|/ |");
			System.out.println("|  O");
			System.out.println("|  |");
			System.out.println("|");
			System.out.println("|___");
			break;
		case 7:
			System.out.println("____");
			System.out.println("|/ |");
			System.out.println("|  O");
			System.out.println("| /|");
			System.out.println("|");
			System.out.println("|___");
			break;
		case 8:
			System.out.println("____");
			System.out.println("|/ |");
			System.out.println("|  O");
			System.out.println("| /|\\ ");
			System.out.println("|");
			System.out.println("|___");
			break;
		case 9:
			System.out.println("____");
			System.out.println("|/ |");
			System.out.println("|  O");
			System.out.println("| /|\\ ");
			System.out.println("| /");
			System.out.println("|___");
			break;
		case 10:
			System.out.println("____");
			System.out.println("|/ |");
			System.out.println("|  O");
			System.out.println("| /|\\ ");
			System.out.println("| / \\");
			System.out.println("|___");
			break;
		default:
			System.out.println(faults);
		}
	}

//	Getter and setters	

	/**
	 * @param mistakes the mistakes to set
	 */
	public void setMistakes(int mistakes) {
		this.mistakes = mistakes;
	}

	/**
	 * @param randomWord the randomWord to set
	 */
	public void setRandomWord(String randomWord) {
		this.randomWord = randomWord;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(char[] word) {
		this.word = word;
	}

	/**
	 * @param wrong_guesses the wrong_guesses to set
	 */
	public void setWrong_guesses(ArrayList<Character> wrong_guesses) {
		this.wrong_guesses = wrong_guesses;
	}

	/**
	 * @return the word
	 */
	public char[] getWord() {
		return word;
	}

	/**
	 * @return the randomWord
	 */
	public String getRandomWord() {
		return randomWord;
	}

	/**
	 * @return the guesses
	 */
	public ArrayList<Character> getGuesses() {
		return guesses;
	}

	/**
	 * @return the wrong_guesses
	 */
	public ArrayList<Character> getWrong_guesses() {
		return wrong_guesses;
	}

	/**
	 * @return the mistakes
	 */
	public int getMistakes() {
		return mistakes;
	}

	/**
	 * @return the alphabet
	 */
	public ArrayList<Character> getAlphabet() {
		return alphabet;
	}

	/**
	 * @return the guesser
	 */
	public Player getGuesser() {
		return guesser;
	}

	/**
	 * @return the thinker
	 */
	public Player getThinker() {
		return thinker;
	}

	/**
	 * @return the mAX_MISTAKES
	 */
	public int getMAX_MISTAKES() {
		return MAX_MISTAKES;
	}
}
