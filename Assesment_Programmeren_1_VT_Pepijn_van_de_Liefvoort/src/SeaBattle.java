import java.util.Scanner;

public class SeaBattle {
	Field field;
	public SeaBattle() {
		field = new Field();
		field.initShips();		
	}
	
	public void play() {
		//Testing purposes only
		
		field.shoot("A1");
		field.shoot("B2");
		field.shoot("C3");
		field.shoot("D4");
		field.shoot("E5");
		field.shoot("F6");
		field.shoot("G7");
		field.shoot("H8");
		field.shoot("I9");
		field.shoot("J10");
		field.printField();
		
		//Start sequence to ask for a field to shoot at
		guessSquare();
	}
	

	public void guessSquare() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print("Kies een vak om op te schieten: ");
		String chosenSquare = scanner.next();
		chosenSquare = chosenSquare.toUpperCase();

		//Check if given position exists and is not yet shot
		if(field.validateGuess(chosenSquare)) {
			field.shoot(chosenSquare);
		}
		
		//Restart guessing sequence
		guessSquare();
	}
}
