
public class IntClass {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public IntClass copy() {
		int value = getValue();		
		
		IntClass newIntClass = new IntClass();
		newIntClass.setValue(value);
		
		return newIntClass;
	}
	
	public boolean equals(Object object) {
		return this.getClass() == object.getClass();
	}
}
