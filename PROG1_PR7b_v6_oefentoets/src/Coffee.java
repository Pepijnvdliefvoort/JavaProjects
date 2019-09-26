
public class Coffee {
	private String name;
	private int size;

	// Constructor
	public Coffee(String name, int size) {
		setName(name);
		setSize(size);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		String sizeName;
		if (size == 1) {
			sizeName = "klein";
		} else if (size == 2) {
			sizeName = "middel";
		} else {
			sizeName = "groot";
		}
		return sizeName;

	}

	public void setSize(int size) {
		if (size >= 1 && size <= 3) {
			this.size = size;
		} else {
			this.size = 3;
		}
	}

}
