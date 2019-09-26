
public class GridNumber {
	String[][] gridnumbers;
	public static int SIZE = 5;
	public int row = 0;
	public int column = 0;

	// Constructor
	public GridNumber() {
		gridnumbers = new String[5][5];
	}

	// Methods

	public void initGrid() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				gridnumbers[i][j] = "0,0";
			}
		}
	}

	public void upGridByOne() {
		if(row > 16 || column > 16) {
			row = 0;
			column = 0;
		}
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				gridnumbers[i][j] = Integer.toString(i + row) + "," + Integer.toString(j + column);
			}
		}
		row++;
		column++;
	}

	public void printGrid() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(gridnumbers[i][j] + " ");
			}
			System.out.println();
		}
	}
}
