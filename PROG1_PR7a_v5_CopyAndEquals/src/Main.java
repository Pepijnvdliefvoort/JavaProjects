
public class Main {
	public static void main(String[] args) {
		IntClass ic1 = new IntClass();
		ic1.setValue(4);
		IntClass ic2 = ic1;
		ic2.setValue(3);

		if (ic1 == ic2) {
			System.out.println("ic1 and ic2 are the same.");
		} else {
			System.out.println("ic1 and ic2 are NOT the same.");
		}

		if (ic1.equals(ic2)) {
			System.out.println("ic1 and ic2 are equal.");
		} else {
			System.out.println("ic1 and ic2 are NOT equal.");
		}

		IntClass ic3 = new IntClass();
		ic3.setValue(4);
		IntClass ic4 = new IntClass();
		ic4.setValue(4);

		if (ic3 == ic4) {
			System.out.println("ic3 and ic4 are the same.");
		} else {
			System.out.println("ic3 and ic4 are NOT the same.");
		}

		if (ic3.equals(ic4)) {
			System.out.println("ic3 and ic4 are equal.");
		} else {
			System.out.println("ic3 and ic4 are NOT equal.");
		}

	}

}
