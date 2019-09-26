public class Guest {
	private String name;
	private Tea tea;
	private Cake cake;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	void giveTea(Tea newTea) {
		tea = newTea;
	}

	void giveCake(Cake newCake) {
		cake = newCake;
	}

	void printInformation() {
		System.out.println("Hello I am " + getName());
		System.out.println("I am having a cup of " + tea.getName() + " with a piece of " + cake.getName() + ".");

		if (tea.isMilk()) {
			if (tea.isSugar()) {
				System.out.println("I'd like both milk and sugar, please");
			} else {
				System.out.println("I'd like some milk, please");
			}
		}
		else if(tea.isSugar()) {
			if(tea.isMilk()) {
				System.out.println("I'd like both milk and sugar, please");
			}
			else {
				System	.out.println("I'd like some sugar, please");
			}
		}
		else {
			System.out.println("No milk or sugar, please");
		}
		System.out.println();
	}
}
