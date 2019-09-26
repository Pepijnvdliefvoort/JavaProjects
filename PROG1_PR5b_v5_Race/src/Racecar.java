
public class Racecar {
	private String brand;
	private String driver;
	private int maxSpeed;
	private int startPosition;
	private int currentDistance;
	
	public Racecar(String brand, String driver, int maxspeed) {
		this.setBrand(brand);
		this.setDriver(driver);
		this.setMaxSpeed(maxspeed);
	}
	
	
	
	
	//Get & setters
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public int getStartPosition() {
		return startPosition;
	}
	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}
	public int getCurrentDistance() {
		return currentDistance;
	}
	public void setCurrentDistance(int currentDistance) {
		this.currentDistance = currentDistance;
	}
	@Override
	public String toString() {
		return getDriver()+ ", driving a  " + getBrand() + " \nwith a distance of " + getCurrentDistance();
	}
	
}
