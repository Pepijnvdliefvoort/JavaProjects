
public class Main {

	public static void main(String[] args) {
		Customer cust0 = new Customer(4);
		Customer cust1 = new Customer(1);
		Customer cust2 = new Customer(2);
		Customer cust3 = new Customer(3);
		Customer cust4 = new Customer(1);
		CashDesk cd = new CashDesk();
		
		cd.addCust(cust0);
		cd.addCust(cust1);
		cd.addCust(cust2);
		cd.addCust(cust3);
		cd.addCust(cust4);
		
		cd.printQueue();
		
		
	}

}
