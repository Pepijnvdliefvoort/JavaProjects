public class Product {
	private boolean hasHole;
	private boolean isBroken;
	private String color;
	private String shape;
	private int weight;

	public Product(boolean hasHole, boolean isBroken, String color, String shape, int weight) {
		this.hasHole = hasHole;
		this.isBroken = isBroken;
		this.color = color;
		this.shape = shape;
		this.weight = weight;
	}

	public boolean hasHole() {
		return hasHole;
	}

	public boolean isBroken() {
		return isBroken;
	}

	public String getColor() {
		return color;
	}

	public String getShape() {
		return shape;
	}

	public int getWeight() {
		return weight;
	}
}
