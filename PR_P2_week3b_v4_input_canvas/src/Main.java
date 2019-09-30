import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;

public class Main {
	final static int WIDTH = 400;
	final static int HEIGHT = 400;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Drawing canvas = new Drawing();
		canvas.setSize(WIDTH, HEIGHT);
		canvas.setBackground(randomColor());

		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

		
		//Get key input
		canvas.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					canvas.initShapes();
					canvas.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
					canvas.moveShapes();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
	}

	/**
	 * @return return dark random color
	 */
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
