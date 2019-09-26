import java.util.ArrayList;

public class Order {
	private int tableNumber;
	private ArrayList<Coffee> coffeeArray;
	private ArrayList<Cake> cakeArray;

	// Constructor
	public Order(int tableNumber) {
		this.setTableNumber(tableNumber);
		coffeeArray = new ArrayList<Coffee>();
		cakeArray = new ArrayList<Cake>();
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		if (tableNumber > 0) {
			this.tableNumber = tableNumber;
		} else {
			System.out.println("Het tafelnummer moet minimaal 0 zijn!");
		}
	}

	// Methods
	public void addCake(Cake newCake) {
		cakeArray.add(newCake);
	}

	public void addCoffee(String name, int size) {
		coffeeArray.add(new Coffee(name, size));
	}

	public String listSugarFreeCake() {
		String list;
		ArrayList<String> sugarFreeCakes = new ArrayList<String>();
		for (Cake item : cakeArray) {
			if (item != null) {

				if (item.isSugarFree()) {
					sugarFreeCakes.add(item.getName());
				}
			}
		}
		list = String.join(", ", sugarFreeCakes);

		return list;
	}

	public void showOrder() {
		System.out.println("Tafelnummer: " + getTableNumber());

		// Print alle coffees
		for (Coffee item : coffeeArray) {
			System.out.println(item.getName() + " - " + item.getSize());
		}
		System.out.println("\n" + "Totaal: " + coffeeArray.size() + "\n");

		// Print alle cakes
		for (Cake item : cakeArray) {
			if (item.isSugarFree()) {
				System.out.println(item.getName() + " suikervrij");
			} else {
				System.out.println(item.getName());
			}
		}
		System.out.println("\n" + "Totaal: " + cakeArray.size() + "\n");
	}

}
