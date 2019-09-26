
public class Sine {
	public static final double sinus = Math.PI * 2;
	final static double steps = sinus / 20;
	
	public static void main(String[] args) throws InterruptedException {
		int xOffset = 50;
		
		for(int i = 0; i < 10; i++) {
			for(double angle = 0; angle < sinus; angle+= steps) {
				double result = 20 * Math.sin(angle);

				String resultString = "";

				for (int count = 0; count <= result + xOffset; count++) {
					resultString += " ";
				}

				resultString += "X";

				System.out.println(resultString);

				Thread.sleep(60);
			}
		}
	}
}
