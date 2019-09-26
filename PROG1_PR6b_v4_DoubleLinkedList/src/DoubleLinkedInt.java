public class DoubleLinkedInt {

	DoubleLinkedInt previousItem;
	DoubleLinkedInt nextItem;
	private int value;

	public DoubleLinkedInt(int val) {
		value = val;
	}
	
	int getValue() {
		return value;
	}
}