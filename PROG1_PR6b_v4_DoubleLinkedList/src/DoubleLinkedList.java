public class DoubleLinkedList {
	DoubleLinkedInt[] listStart;

	public DoubleLinkedList() {
		listStart = new DoubleLinkedInt[5];
	}
	
	void add(int value) {			
		if (listStart[0] == null) {
			listStart[0] = new DoubleLinkedInt(value);
		} else {
			if (!contains(value)) {
				add(value);
			}
		}
	}

	boolean contains(int value) {
		return findValue(listStart[0], value) != null;
	}

	void remove(int value) {
		if (contains(value)) {
			@SuppressWarnings("unused")
			DoubleLinkedInt dlInt = findValue(listStart[0], value);
			dlInt = null;
		}
	}

	void printList() {
		printItem(listStart[0]);
	}

//	private DoubleLinkedInt getLast(DoubleLinkedInt item) {
//		if (item.nextItem != null) {
//			return getLast(item.nextItem);
//		} else {
//			return item;
//		}
//	}

	private DoubleLinkedInt findValue(DoubleLinkedInt item, int value) {
		System.out.println(item.getValue());
		if (item.getValue() == value) {
			return item;
		} else {
			return findValue(item.nextItem, value);
		}
	}

	private void printItem(DoubleLinkedInt item) {
		if (item != null) {
			System.out.println(item.getValue());
			
			if (item.nextItem != null) {
				printItem(item.nextItem);
			}
		}
	}

}