import java.awt.Color;

public class ShapePreferences {
	private int x, y, width, height;
	private Color color;
	private ShapeDirection direction;
	
	public ShapePreferences(int x, int y, int width, int height, Color color, ShapeDirection direction) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.direction = direction;
	}
	
	public ShapePreferences(int x, int y, int diameter, Color color, ShapeDirection direction) {
		this.x = x;
		this.y = y;
		this.width = diameter;
		this.height = diameter;
		this.color = color;
		this.direction = direction;
	}
	
	public ShapePreferences(Color color) {
		this.color = color;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	public ShapeDirection getDirection() {
		return direction;
	}

	public void setDirection(ShapeDirection direction) {
		this.direction = direction;
	}
}