import java.util.ArrayList;

public class SuperMarket {
	ArrayList<CashDesk> cashDesks;
	int maxNrOfCashDesks;
	int maxPreferredQueueSize;

	// Constructor
	public SuperMarket(int maxNrOfCashDesks, int maxPreferredQueueSize) {
		setMaxNumberOfCashDesks(maxNrOfCashDesks);
		this.maxPreferredQueueSize = maxPreferredQueueSize;
		cashDesks = new ArrayList<>();
		
		for(int i = 0; i < this.maxNrOfCashDesks; i++) {
			cashDesks.add(new CashDesk());
		}
	}

	// Methods
	void addCust(Customer newCust) {
		
	}

	void doTimeTick() {
		
	}

	int getAverageQueueLength() {
		return 0;
	}

	int getCustomerTotal() {
		return 0;
	}

//	int getAmountofCashDeskOpen() {
//		return 0;
//	}

	void setMaxNumberOfCashDesks(int nr) {

	}
}
