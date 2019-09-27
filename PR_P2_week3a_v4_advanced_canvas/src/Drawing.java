import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Drawing extends Canvas {
	private static final long serialVersionUID = 1L;
	public ArrayList<ShapePreferences> shapes = new ArrayList<ShapePreferences>();

	public void paint(Graphics g) {
		ShapePreferences cp, rp;

		for (int i = 0; i < 5; i++) {
			cp = randomShape(ShapeType.CIRCLE);
			rp = randomShape(ShapeType.RECTANGLE);

			// Circles
			g.setColor(cp.getColor());
			g.fillOval(cp.getX(), cp.getY(), cp.getWidth(), cp.getHeight());
			// Rectangle
			g.setColor(rp.getColor());
			g.fillRect(rp.getX(), cp.getY(), rp.getWidth(), rp.getHeight());

		}
		// String
		Random rand = new Random();
		int r = rand.nextInt((99999 - 10000) + 1) + 10000;
		
		g.setColor(getRandomColor());
		g.drawString(Integer.toString(r), 10, 20);
	}

	public ShapePreferences randomShape(ShapeType type) {
		Random rand = new Random();
		ThreadLocalRandom tlr = ThreadLocalRandom.current();

		// Random x, y, width, height
		int diameter = tlr.nextInt(40, 70 + 1);
		int width = tlr.nextInt(20, 100 + 1);
		int height = tlr.nextInt(20, 100 + 1);
		int x = rand.nextInt(getWidth() - diameter);
		int y = rand.nextInt(getHeight() - diameter);

		Color rc = getRandomColor();
		
		if (type.equals(ShapeType.CIRCLE)) {
			return new ShapePreferences(x, y, diameter, rc);
		} else if (type.equals(ShapeType.RECTANGLE)) {
			return new ShapePreferences(x, y, width, height, rc);
		} else if (type.equals(ShapeType.TEXT)) {
			return new ShapePreferences(rc);
		}

		return null;
	}

	public Color getRandomColor() {
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color rc = new Color(r, g, b);
		rc = rc.brighter();

		return rc;
	}
}
