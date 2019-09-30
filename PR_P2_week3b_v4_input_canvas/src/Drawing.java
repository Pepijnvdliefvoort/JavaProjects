import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Drawing extends Canvas {
	private static final long serialVersionUID = 1L;
	final public static int STEPS = 10;
	public ArrayList<ShapePreferences> circles = new ArrayList<ShapePreferences>();
	public ArrayList<ShapePreferences> rectangles = new ArrayList<ShapePreferences>();

	// Constructor
	public Drawing() {
		initShapes();
	}

	public void paint(Graphics g) {
		// Circles
		for (ShapePreferences circ : circles) {
			g.setColor(circ.getColor());
			g.fillOval(circ.getX(), circ.getY(), circ.getWidth(), circ.getHeight());
		}

		// Rectangles
		for (ShapePreferences rect : rectangles) {
			g.setColor(rect.getColor());
			g.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
		}

		// String
		Random rand = new Random();
		int r = rand.nextInt((99999 - 10000) + 1) + 10000;
		g.setColor(getRandomColor());
		g.drawString(Integer.toString(r), 10, 20);
	}

	/**
	 *  Move shapes in a random direction
	 */
	public void moveShapes() {
		//Circles
		for (ShapePreferences item : circles) {
			int x = item.getX();
			int y = item.getY();
			
			//Move shapes
			if(item.getDirection() == ShapeDirection.NORTH) {
				item.setY(y - STEPS);
			}
			if(item.getDirection() == ShapeDirection.EAST) {
				item.setX(x + STEPS);
			}
			if(item.getDirection() == ShapeDirection.SOUTH) {
				item.setY(y + STEPS);
			}
			if(item.getDirection() == ShapeDirection.WEST) {
				item.setX(x - STEPS);
			}
			
		}
		
		//Rectangles
		for (ShapePreferences item : rectangles) {
			int x = item.getX();
			int y = item.getY();
			
			//Move shapes
			if(item.getDirection() == ShapeDirection.NORTH) {
				item.setY(y - STEPS);
			}
			if(item.getDirection() == ShapeDirection.EAST) {
				item.setX(x + STEPS);
			}
			if(item.getDirection() == ShapeDirection.SOUTH) {
				item.setY(y + STEPS);
			}
			if(item.getDirection() == ShapeDirection.WEST) {
				item.setX(x - STEPS);
			}
			
		}
		
		//Update canvas
		repaint();
	}

	/**
	 *  Initialize 5 new shapes (5 circles, 5 rectangles)
	 */
	public void initShapes() {
		// Clear array if not empty
		if (!circles.isEmpty()) {
			circles.clear();
		}
		if (!rectangles.isEmpty()) {
			rectangles.clear();
		}

		ShapePreferences cs, rs;

		for (int i = 0; i < 5; i++) {
			cs = randomShape(ShapeType.CIRCLE);
			rs = randomShape(ShapeType.RECTANGLE);

			// Add shapes to array
			circles.add(cs);
			rectangles.add(rs);
		}

	}

	/**
	 * @param type CIRCLE, RECTANGLE or TEXT shape type
	 * @return if type is a circle, return a diameter instead of width + height else
	 *         if type is a rectangle, return width + height else return text shape
	 */
	public ShapePreferences randomShape(ShapeType type) {
		// Initialization
		Random rand = new Random();
		ThreadLocalRandom tlr = ThreadLocalRandom.current();

		// Random x, y, width, height
		int diameter = tlr.nextInt(40, 70);
		int width = tlr.nextInt(20, 100);
		int height = tlr.nextInt(20, 100);

		int x, y;
		if (getWidth() == 0) {
			x = tlr.nextInt(400 - diameter);
			y = tlr.nextInt(400 - diameter);
		} else {
			x = tlr.nextInt(getWidth() - diameter);
			y = tlr.nextInt(getHeight() - diameter);
		}

		// Random color
		Color rc = getRandomColor();

		// Random direction
		ArrayList<ShapeDirection> dir = new ArrayList<ShapeDirection>();
		dir.add(ShapeDirection.NORTH);
		dir.add(ShapeDirection.EAST);
		dir.add(ShapeDirection.SOUTH);
		dir.add(ShapeDirection.WEST);
		ShapeDirection direction = dir.get(rand.nextInt(dir.size()));

		// Return shape
		if (type.equals(ShapeType.CIRCLE)) {
			return new ShapePreferences(x, y, diameter, rc, direction);
		} else if (type.equals(ShapeType.RECTANGLE)) {
			return new ShapePreferences(x, y, width, height, rc, direction);
		} else if (type.equals(ShapeType.TEXT)) {
			return new ShapePreferences(rc);
		}

		return null;
	}

	/**
	 * @return return bright random color
	 */
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
