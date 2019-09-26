
public class Bubble_sort {
	int[] arr = { 5, 1, 12, -5, 16 };
	Boolean sorted = false;

	public static void main(String[] args) {
		Bubble_sort bb = new Bubble_sort();
		bb.BubbleSort();

	}


	void BubbleSort() {
		int n = arr.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			System.out.print("Iteratie " + (i + 1) + ": ");
			for (int x = 0; x < arr.length; x++) {
				System.out.print(arr[x] + " ");
			}
			System.out.println();
			for (int j = 1; j < (n - i); j++) {

				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;

				}
			}
		}

	}
}
