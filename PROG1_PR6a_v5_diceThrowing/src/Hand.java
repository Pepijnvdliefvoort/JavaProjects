import java.util.Arrays;

public class Hand {
	Die[] dice;

	public Hand(int amountOfDice) {
		// Create array of dices
		dice = new Die[amountOfDice];
	}

	// Methods

	// add die to hand
	void addDie(int sides) {
		for (int i = 0; i < dice.length; i++) {
			if (dice[i] == null) {
				dice[i] = new Die();
				dice[i].setNumberOfSides(sides);
				break;
			}
		}

	}

	// Empty hand from dice
	void empty() {
		for (int i = 0; i < dice.length; i++) {
			Arrays.fill(dice, null);
		}
	}

	//Show total of all dice
	int total() {
		//reset total
		int total = 0;
		for (int i = 0; i < dice.length; i++) {
			if (dice[i] != null) {
				total += dice[i].getThrow();
			}
		}
		return total;
	}

	// Show avarage of all dice
	float average() {
		// reset avg
		float avg = 0;

		for (int i = 0; i < dice.length; i++) {
			if (dice[i] != null) {
				avg += dice[i].getThrow();
			}
		}
		avg = avg / dice.length;

		return avg;
	}

	// Throw all dice in hand
	void throwDice() {
		for (int i = 0; i < dice.length; i++) {
			if (dice[i] != null) {
				dice[i].throwDie();
			}
		}
	}

	// Show all dice in hand
	void showThrow() {
		for (int i = 0; i < dice.length; i++) {
			if (dice[i] != null) {
				System.out.println("Die: " + "D" + dice[i].getNumberOfSides() + " Result: " + dice[i].getThrow());
			}
		}
	}
}
