import java.util.ArrayList;

public class Level {

	private Party pirates;
	private Item item;
	
	public Level(Party pirates, Item item) {
		this.pirates = pirates;
		this.item = item;
	}
	
	public Party getPirates(){
		return pirates;
	}
	
	public Item getItem() {
		return item;
	}
}
