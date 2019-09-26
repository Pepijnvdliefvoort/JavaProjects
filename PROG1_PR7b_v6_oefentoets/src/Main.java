
public class Main {
	public static void main(String[] args) {
		Order order = new Order(15);
		
		Cake appeltaart = new Cake("Appeltaart", true);
		Cake bosbes = new Cake("Bosbes", false);
		Cake chocolade = new Cake("Chocolade", true);
		order.addCake(appeltaart);
		order.addCake(bosbes);
		order.addCake(chocolade);
		
		
		order.addCoffee("Koffie zwart", 3);
		order.addCoffee("Chocolademelk", 1);
		order.addCoffee("Thee", 2);
		order.addCoffee("cappucino", 4);
		

		order.showOrder();
	}
}
