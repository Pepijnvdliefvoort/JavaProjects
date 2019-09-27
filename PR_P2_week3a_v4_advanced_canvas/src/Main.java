import java.awt.Canvas;
import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class Main {
	final static int WIDTH = 400;
	final static int HEIGHT = 400;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Canvas canvas = new Drawing();
		canvas.setSize(WIDTH, HEIGHT);
		canvas.setBackground(randomColor());
		
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

		System.out.println();
	}
	
	public static Color randomColor() {
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r, g, b);
		randomColor = randomColor.darker();
		
		return randomColor;
	}
}
