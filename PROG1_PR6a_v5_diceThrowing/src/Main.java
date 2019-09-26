public class Main {

	public static void main(String[] args) {
		Hand hand = new Hand(10	);
		System.out.println("*** Throw ***");
		
		hand.addDie(6);
		hand.addDie(8);
		hand.addDie(10);
		hand.addDie(6);
		hand.addDie(10);
		hand.addDie(10);
		
//		hand.empty();
		hand.throwDice();
		hand.showThrow();
		
		System.out.println("Totaal: " + hand.total() + " Average: " + hand.average());
		
	}
}
