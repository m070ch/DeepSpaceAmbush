
public abstract class Item {

	//the items name
	private String name;
	
	
	public Item(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStats() {
		return name+"\n";
	}
	
}
