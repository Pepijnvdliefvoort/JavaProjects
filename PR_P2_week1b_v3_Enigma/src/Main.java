import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Enigma enigma = new Enigma();

		System.out.print("Welk bericht moet gecodeerd worden?: ");
		String code = scanner.nextLine();
		
		System.out.println(enigma.code(code));

	}

}
