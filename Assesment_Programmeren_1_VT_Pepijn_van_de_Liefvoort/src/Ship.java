
public class Ship {
	//Constructor
	public Ship(String nameShip, int length) {
		this.setTypeShip(nameShip);
		this.setLength(length);
	}
	
	//Initialisation
	private String typeShip;
	private int length;
	private int hit;	
	
	//Get & setters
	public String getTypeShip() {
		return typeShip;
	}
	public void setTypeShip(String typeShip) {
		this.typeShip = typeShip;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
}
