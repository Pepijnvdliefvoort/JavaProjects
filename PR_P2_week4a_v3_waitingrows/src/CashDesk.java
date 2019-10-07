import java.util.ArrayList;

public class CashDesk {
	// Variables
	public ArrayList<Customer> queue;
	private int spendTimeHelping;
	private boolean opened;

	// Constructor
	public CashDesk() {
		setOpened(false);
		queue = new ArrayList<>();
	}

	// Methods
	void addCust(Customer newCust) {
		if (newCust != null) {
			queue.add(newCust);
		}
	}

	void helpCust() {
		if (getSpendTimeHelping() == queue.get(0).getHelpTime()) {
			queue.remove(0);
			setSpendTimeHelping(0);
		}
		setSpendTimeHelping(getSpendTimeHelping() + 1);
	}

	int getQueueSize() {
		return queue.size();
	}

	Customer getLastCust() {
		Customer lastCust = queue.get(queue.size() - 1);
		return lastCust;
	}

	public void printQueue() {
		for (Customer item : queue) {
			System.out.println(item.getHelpTime());
		}
	}

	// Get & setters
	public int getSpendTimeHelping() {
		return spendTimeHelping;
	}

	public void setSpendTimeHelping(int spendTimeHelping) {
		this.spendTimeHelping = spendTimeHelping;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}
}
