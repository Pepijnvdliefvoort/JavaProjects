import java.util.ArrayList;

public class SuperMarket {
	ArrayList<CashDesk> cashDesks;
	int maxNrOfCashDesks;
	int maxPreferredQueueSize;
	
	
	//Constructor
	public SuperMarket() {
		
	}
	
	
	//Methods
	void addCust(Customer newCust) {
		for( CashDesk cashdesk : cashDesks) {
			cashdesk.addCust(newCust);
		}
	}
	void doTimeTick() {
		
	}
	int getAverageQueueLength() {
		return 0;
	}
	int getCustomerTotal() {
		return 0;
	}
	int getAmountofCashDeskOpen() {
		return 0;
	}
	void setMaxNumberOfCashDesks(int nr) {
		
	}
}
