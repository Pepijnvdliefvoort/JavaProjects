import java.util.ArrayList;

public class Sorter {
	private ArrayList<Product> containerA = new ArrayList<Product>();
	private ArrayList<Product> containerB = new ArrayList<Product>();
	private ArrayList<Product> containerC = new ArrayList<Product>();
	private ArrayList<Product> containerD = new ArrayList<Product>();
	private int notProcessed = 0;

	public void addProduct(Product prod) {
		//Container A
		if (prod.isBroken() || (prod.getWeight() > 80)) {
			containerA.add(prod);
		} 
		//Container B
		else if ((prod.getWeight() < 20) || ((prod.getColor().equals("red") && prod.getShape().equals("round"))
				|| (prod.getColor().equals("blue") && prod.getShape().equals("square")))) {
			containerB.add(prod);
		} 
		//Container C
		else if ((prod.getShape().equals("square")
				&& (prod.getColor().equals("red") || prod.getColor().equals("yellow")))
				&& (prod.getWeight() > 20 && prod.getWeight() < 80)) {
			containerC.add(prod);
		} 
		//Container D
		else if (prod.getColor().equals("blue") && prod.getShape().equals("round") && prod.hasHole()
				&& (prod.getWeight() > 20 && prod.getWeight() < 80)) {
			containerD.add(prod);
		} 
		//Not processed
		else {
			notProcessed++;
		}
	}

	public void printInfo() {
		System.out.println("Size of containerA: " + containerA.size());
		System.out.println("Size of containerB: " + containerB.size());
		System.out.println("Size of containerC: " + containerC.size());
		System.out.println("Size of containerD: " + containerD.size());
		System.out.println("Not processed: " + notProcessed);
	}
}
