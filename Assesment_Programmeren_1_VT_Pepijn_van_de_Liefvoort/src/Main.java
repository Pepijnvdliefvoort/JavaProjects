import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		SeaBattle seaBattle = new SeaBattle();
		
		System.out.println("Welkom bij Zeeslag!");
		//main.welcomeMessage();
		seaBattle.play();		
	}

	public void welcomeMessage() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print("Met hoeveel spelers wilt u spelen? (1/2): ");
		int aantalSpelers = scanner.nextInt();
		if (aantalSpelers > 2) {
			System.err.println("Je mag niet met meer dan 2 spelers spelen!");
			welcomeMessage();
		}
	}

}
