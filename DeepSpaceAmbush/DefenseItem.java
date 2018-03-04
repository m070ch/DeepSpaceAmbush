
public class DefenseItem extends Item {

	private int armor;
	private int health;
	
	public DefenseItem(String name, int armor, int health) {
		super(name);
		this.armor = armor;
		this.health = health;
	}
	
	
	public int getArmor() {
		return armor;
	}
	
	public int getHealth() {
		return health;
	}
	
	public String getStats() {
		String str = super.getStats();
		if (armor > 0 ) str += "\tArmor: +"+Integer.toString(armor)+"\n";
		if (health > 0 ) str += "\tHealing: +"+Integer.toString(health)+"\n";
		return str;
	}
}
