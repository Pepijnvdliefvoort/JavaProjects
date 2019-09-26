
public class Matrix {
	private final LedRij[] matrix;

	public Matrix(int aantal) {
		matrix = new LedRij[aantal];

		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new LedRij(4);
		}
	}

	public void schakel(int rij, int kolom, boolean aan) {
		if (matrix.length > rij - 1 && matrix[rij - 1] != null) {
			matrix[rij - 1].schakel(kolom, aan);
		} else {
			System.out.println("De schakel is niet mogelijk op deze rij!");
		}
	}

	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i].toText();
		}
	}

	public void schuifInRij(int rij, int aantalPosities, boolean naarRechts) {
		if (matrix.length > rij - 1 && matrix[rij - 1] != null) {
			for (int i = 0; i < aantalPosities; i++) {
				matrix[rij - 1].schuif(naarRechts);
			}
		} else {
			System.out.println("De schuif is niet mogelijk op deze rij!");
		}
	}

	public void clear() {
		for(int  i = 0; i < matrix.length; i++) {
			matrix[i].clear();
		}
	}
	
	public void maakDiagonaal() {
		clear();
		schakel(1, 1, true);
		schakel(2, 2, true);
		schakel(3, 3, true);
		schakel(4, 4, true);
	}
}
