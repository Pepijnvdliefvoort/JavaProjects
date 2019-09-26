
public class Main {
	public static void main(String[] args) {
		Matrix matrix = new Matrix(4);
		
		matrix.maakDiagonaal();
		matrix.schakel(4, 4, true);
		matrix.schuifInRij(1, 1, true);
//		matrix.clear();
		matrix.printMatrix();
	}

}
