
public class Cake {
	private String name;
	private boolean sugarFree;
	
	//Constructor
	public Cake(String name, boolean sugarFree) {
		this.setName(name);
		this.setSugarFree(sugarFree);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSugarFree() {
		return sugarFree;
	}
	public void setSugarFree(boolean sugarFree) {
		this.sugarFree = sugarFree;
	}
	
	
}
