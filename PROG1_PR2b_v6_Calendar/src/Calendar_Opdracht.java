public class Calendar_Opdracht {

	public static void main(String[] args) {
		Calendar_Opdracht calendar = new Calendar_Opdracht();
		calendar.print("September");

	}

	void print(String month) {
		int startday;
		int days;

		switch (month) {
		case "Januari":
			startday = 2;
			days = 31;
			break;
		case "Februari":
			startday = 5;
			days = 28;
			break;
		case "Maart":
			startday = 5;
			days = 31;
			break;
		case "April":
			startday = 1;
			days = 30;
			break;
		case "Mei":
			startday = 3;
			days = 31;
			break;
		case "Juni":
			startday = 6;
			days = 30;
			break;
		case "Juli":
			startday = 1;
			days = 31;
			break;
		case "Augustus":
			startday = 4;
			days = 31;
			break;
		case "September":
			startday = 7;
			days = 30;
			break;
		case "Oktober":
			startday = 2;
			days = 31;
			break;
		case "November":
			startday = 5;
			days = 30;
			break;
		case "December":
			startday = 7;
			days = 31;
			break;
		default:
			startday = 1;
			days = 1;
		}

		System.out.println(month);
		System.out.println(2019);
		System.out.println("Ma Di Wo Do Vr Za Zo");

		// Initial start of beginning
		int tabs = startday * 3 - 3;
		for (int i = 0; i < tabs; i++) {
			System.out.print(" ");
		}

		int counter = 1;
		while (counter <= days) {
			if (startday == 8) {
				System.out.println();
				CounterLessThan10(counter); // Function to check whether 2 or 1 spaces need to be used
				startday = 1;
			} else {
				CounterLessThan10(counter); // Function to check whether 2 or 1 spaces need to be used
			}
			startday++;
			counter++;
		}

	}

	public void CounterLessThan10(int counter) {
		System.out.print(counter);
		if (counter < 10) {
			System.out.print("  ");
		} else {
			System.out.print(" ");
		}
	}
}
