
public class ActionItem extends Item {

	private int damage;
	private int stamina;
	private int luck;

	
	public ActionItem(String name, int damage, int stamina, int luck) {
		super(name);
		this.damage = damage;
		this.stamina = stamina;
		this.luck = luck;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getStamina() {
		return stamina;
	}
	
	public int getLuck() {
		return luck;
	}
	
	public String getStats() {
		String str = "";
		if (damage > 0 ) str += "Damage: +"+Integer.toString(damage)+"\n";
		if (stamina > 0 ) str += "Stamina: +"+Integer.toString(stamina)+"\n";
		if (luck > 0 ) str += "Luck: +"+Integer.toString(luck)+"\n";
		return str;
	}
	
}
