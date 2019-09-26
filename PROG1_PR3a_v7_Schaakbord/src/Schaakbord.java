public class Schaakbord {

	String[][] pieces = new String[8][8];

	public static void main(String[] args) {
		Schaakbord sb = new Schaakbord();
		sb.initializeBoard();
		sb.printBoard();
		sb.move("b2", "b3");
	}

	void initializeBoard() {
		pieces[0][0] = "T";
		pieces[0][1] = "R";
		pieces[0][2] = "B";
		pieces[0][3] = "Q";
		pieces[0][4] = "K";
		pieces[0][5] = "B";
		pieces[0][6] = "R";
		pieces[0][7] = "T";

		pieces[7][0] = "t";
		pieces[7][1] = "r";
		pieces[7][2] = "b";
		pieces[7][3] = "q";
		pieces[7][4] = "k";
		pieces[7][5] = "b";
		pieces[7][6] = "r";
		pieces[7][7] = "t";

		for (int i = 0; i < 8; i++) {
			pieces[1][i] = "P";
			pieces[6][i] = "p";
		}
	}

	void printBoard() {
		for (int i = 0; i < pieces.length; i++) {
			// Print numbers on the side
			System.out.print(i + 1 + "|");
			for (int j = 0; j < pieces.length; j++) {
				// if no piece is on position then print SPACE
				if (pieces[i][j] == null) {
					pieces[i][j] = " ";
				}
				// If and the end of a line, ENTER
				if (j == 7) {
					System.out.println(" " + pieces[i][j]);
				} else {
					System.out.print(" " + pieces[i][j]);
				}

			}

		}

		System.out.println(" +----------------");
		System.out.println("   A B C D E F G H");
	}

	// Move piece function
	void move(String oldLocation, String newLocation) {
		System.out.println("\nMoving piece.. \n");
		String characters = "abcdefgh";

		char oldPos = oldLocation.charAt(0);
		String oldstr = oldLocation.replaceAll("\\D+","");
		int old1 = Integer.parseInt(oldstr) - 1;
		int old2 = characters.indexOf(oldPos);

		char newPos = newLocation.charAt(0);
		String newstr = newLocation.replaceAll("\\D+","");
		int new1 = Integer.parseInt(newstr) - 1;
		int new2 = characters.indexOf(newPos);

		
		
		pieces[new1][new2] = pieces[old1][old2];
		pieces[old1][old2] = " ";
		
		
		printBoard();
	}

}
