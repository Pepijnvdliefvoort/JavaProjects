public class HelloWorld {
	public static void main(String[] args) {
		for(int i = 1; i < 5; i++) {
			System.out.print("Hall");
			
			for(int j = 0; j < i; j++) {
				System.out.print("o");
			}
			System.out.println();
		}
	}
}	
