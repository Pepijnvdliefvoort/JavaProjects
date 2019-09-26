import java.util.Random;

public class Die {
	//Variables
	private int numberOfSides;
	private int lastThrow;
	
	//Get & setters
	int getNumberOfSides() {
		return numberOfSides;
	}
	
	int getThrow() {
		return lastThrow;
	}
	
	void setNumberOfSides(int number) {
		numberOfSides = number;
	}
	
	
	//Behavior // methods
	void throwDie() {
		int max = getNumberOfSides();
		Random r = new Random();
		lastThrow = r.nextInt((max - 1) + 1) + 1;
		
	}
	
}
