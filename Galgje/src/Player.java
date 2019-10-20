
public abstract class Player {
	// Variables
	private String name;
	private int points;

	// Constructor
	public Player(String name) {
		this.name = name;
	}

	// Methods

	/**
	 * Return a single char, will validate character input for human
	 * if the character given by a human is incorrect return 0
	 */
	public abstract char guess(Game game);

	/**
	 * @param Logic for processing a char
	 */
	public abstract void process(Game game, char c);

	/**
	 * Print word after every guess, if parts of the have been guessed, show the
	 * letter instead
	 */
	public abstract void printWord(Game game);

	/**
	 * Check if game is finished or not
	 * Return true if it has finished
	 * Return false if it has not finished yet
	 */
	public abstract boolean isFinished(Game game);

	// Get & setters
	public String getName() {
		return name;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

}
