public class Rectangular {
	public static void main(String[] args) {
		int counter = 5;
		
		Draw(counter, "-");
		for(int i = 0; i < counter; i++) {
			Draw(counter, " ");
		}
		
		Draw(counter, "-");
		
		
		
	}
	
	public static void Draw(int counter, String symbol) {
		System.out.print('+');
		for(int i = 0; i < counter; i++ ) {
			if(symbol == " ") {
				System.out.print(' ');
			}
			else if(symbol == "-") {
				System.out.print('-');
			}
		}
		System.out.println('+');
		
	}
}
