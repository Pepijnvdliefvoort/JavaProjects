
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sorter sorter = new Sorter();
		
		sorter.addProduct(new Product(true, false, "red", "round", 53));
		sorter.addProduct(new Product(false, false, "blue", "square", 53));
		sorter.addProduct(new Product(true, false, "red", "round", 83));
		sorter.addProduct(new Product(false, true, "red", "round", 83));
		sorter.addProduct(new Product(true, false, "red", "square", 63));
		sorter.addProduct(new Product(true, false, "yellow", "square", 40));
		sorter.addProduct(new Product(true, false, "blue", "round", 40));
		sorter.addProduct(new Product(false, false, "blue", "round", 40));
		sorter.addProduct(new Product(true, false, "blue", "round", 79));
		sorter.addProduct(new Product(true, false, "yellow", "round", 40));

		sorter.printInfo();
	}

}
