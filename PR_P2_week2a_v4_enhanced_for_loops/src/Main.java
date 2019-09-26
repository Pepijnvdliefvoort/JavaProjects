import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		GridNumber grid = new GridNumber();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		String readString = scanner.nextLine();

		grid.initGrid();

		while (readString != null) {
			if (readString.isEmpty()) {
				grid.upGridByOne();
				grid.printGrid();
			}

			if (scanner.hasNextLine()) {
				readString = scanner.nextLine();
			}
		}
	}

}
