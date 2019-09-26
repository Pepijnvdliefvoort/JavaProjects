public class LedRij {
	private final Led[] ledArray;

	public LedRij(int size) {
		ledArray = new Led[size];

		for (int i = 0; i < ledArray.length; i++) {
			ledArray[i] = new Led();
		}
	}

	public void schakel(int positie, boolean aanUit) {
		ledArray[positie - 1].setState(aanUit);
	}

	public void schuif(boolean naarRechts) {
		Led[] temp = new Led[ledArray.length];

		if (naarRechts) {
			for (int i = ledArray.length - 1; i > 0; i--) {
				temp[i] = ledArray[i];
				ledArray[i] = ledArray[i - 1];
			}
			ledArray[0] = temp[ledArray.length - 1];
		}
		else {
			Led temp1 = ledArray[0];
			for (int j = 0; j < ledArray.length - 1; j++) {
				ledArray[j] = ledArray[j + 1];
			}		
			ledArray[ledArray.length - 1] = temp1;
		}
	}

	public void toText() {
		for (int i = 0; i < ledArray.length; i++) {
			if (ledArray[i].isState()) {
				System.out.print("|O|");
			} else {
				System.out.print("|-|");
			}
		}
		System.out.println();
	}

	public void length() {
		int length = ledArray.length;
		System.out.println(length);
	}

	public void clear() {
		for (int i = 0; i < ledArray.length; i++) {
			ledArray[i].setState(false);
		}
	}
}
