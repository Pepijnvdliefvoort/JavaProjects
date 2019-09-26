public class Main {

	public static void main(String[] args) {
		Guest alice = new Guest();
		alice.setName("Alice");

		Tea rosehipTea = new Tea();
		rosehipTea.setName("Rosehip Tea");
		rosehipTea.setMilk(true);

		Cake chocolateSponge = new Cake();
		chocolateSponge.setName("Chocolate Sponge");

		alice.giveTea(rosehipTea);
		alice.giveCake(chocolateSponge);
		
		
		Guest MadHatter = new Guest();
		MadHatter.setName("The Mad Hatter");
		
		Tea LapsangSouchong = new Tea();
		LapsangSouchong.setName("Lapsang Souchong");
		LapsangSouchong.setMilk(true);
		LapsangSouchong.setSugar(true);
		
		Cake CarrotCake = new Cake();
		CarrotCake.setName("Carrot Cake");
		
		MadHatter.giveCake(CarrotCake);
		MadHatter.giveTea(LapsangSouchong);
		
		//Print alle gegevens
		Table table = new Table();
		table.addGuest(alice);
		table.addGuest(MadHatter);
		table.printTeaParty();
	}

}
