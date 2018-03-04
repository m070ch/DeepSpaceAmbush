import java.util.Random;

public class Hero {
	
	//name
	private String name;
	
	//affiliation stat
	private Party.affiliation team;
	
	//hero's class
	//won't be instantiated until children classes
	private Party.heroType type;
	
	//power stats
	private int health, strength, stamina, luck;
	
	//items
	private ActionItem actionItem;
	private DefenseItem defenseItem;
	
	public Hero(String name) {
		this.name = name;
	}
	
	public Hero(String name, Party.affiliation team, Party.heroType type, int health, int strength, int stamina, int luck) {
		this.name = name;
		this.type = type;
		this.team = team;
		this.health = health;
		this.strength = strength;
		this.stamina = stamina;
		this.luck = luck;
	}
	
	public Hero(String name, Party.affiliation team, Party.heroType type, int[] stats) {
		this.name = name;
		this.type = type;
		this.team = team;
		this.health = stats[0];
		this.strength = stats[1];
		this.stamina = stats[2];
		this.luck = stats[3];
	}
	
	//Return the Hero's name
	public String getName() {
		return name;
	}
	
	//Return hero's type
	//not sure if higher levels of program will be able to access this enumerated type
	public Party.heroType getType(){
		return type;
	}
	
	public int getHealth() {
		return health;
	}
	
	public String getTypeAsString() {
		if(type == Party.heroType.Brute) return "Brute";
		else if (type == Party.heroType.Medic) return "Medic";
		else if (type == Party.heroType.Sniper) return "Sniper";
		else if (type == Party.heroType.Engineer) return "Engineer";
		else return "Hero";
	}
	
	//Return hero's type
	//not sure if higher levels of program will be able to access this enumerated type
	public Party.affiliation getTeam(){
		return team;
	}
	
	public String getTeamAsString() {
		if(team == Party.affiliation.Crew) return "Crew";
		else if (team == Party.affiliation.Pirate) return "Pirate";
		else return "Unknown";
	}
	
	//Return the Hero's status (health, strength, stamina, luck)
	public int[] getStatus() {
		return new int[]{health, strength, stamina, luck};
	}
	
	public void setItem(Item item) {
		if (item instanceof ActionItem) setActionItem((ActionItem) item);
		else if (item instanceof DefenseItem) setDefenseItem((DefenseItem) item);
	}
	
	public ActionItem getActionItem() {
		return actionItem;
	}
	
	public DefenseItem getDefenseItem() {
		return defenseItem;
	}
	
	//
	public void setActionItem(ActionItem actionItem) {
		this.actionItem = actionItem;
	}
	
	public void setDefenseItem(DefenseItem defenseItem) {
		this.defenseItem = defenseItem;
	}
	
	public int attack(){
		int crit = 1; //crit represent critical hit
		stamina = stamina-(strength/2); //degrade stamina on hit
		if(actionItem != null) {
			if (new Random().nextInt(10) <= (luck+actionItem.getLuck())-1 & type != Party.heroType.Sniper) crit = 2; //luck of 1 has 1/10 to be true
			return ((strength*(stamina/2))+actionItem.getDamage())*crit; //attack strength is function of stamina, 
																	//strength, item, and critical chance
		}
		else {
			if (new Random().nextInt(10) <= luck-1) crit = 2; //luck of 1 has 1/10 to be true
			return ((strength*(stamina/2))*crit);
		}
	}
	
	public int defend(int dmg){
		int arc = health;
		int crit = 1; 
		if(defenseItem != null & actionItem != null) {
			if (new Random().nextInt(10) <= (luck+actionItem.getLuck())-1 & type != Party.heroType.Engineer) crit = 2; //luck of 1 has 1/10 to be true
			health = health - ((dmg-defenseItem.getArmor())/crit);
		}
		else if (actionItem != null) {
			if (new Random().nextInt(10) <= luck-1 & type != Party.heroType.Engineer) crit = 2; //luck of 1 has 1/10 to be true
			health = health - dmg/crit;
		}
		else if (defenseItem != null) {
			if (new Random().nextInt(10) <= luck-1 & type != Party.heroType.Engineer) crit = 2; //luck of 1 has 1/10 to be true
			health = health - ((dmg-defenseItem.getArmor())/crit);
		}
		else {
			if (new Random().nextInt(10) <= luck-1 & type != Party.heroType.Engineer) crit = 2; 
			health = health - dmg/crit;
		}
		
		return arc - health;
	}
	
	public int heal(){
		int crit = 1; //crit represent critical hit
		int critLuck = 0;
		if(actionItem != null) critLuck = actionItem.getLuck();
		stamina = stamina-(strength/2); //degrade stamina on hit
		if(defenseItem != null) {
			if (new Random().nextInt(10) <= (luck+critLuck)-1 & type != Party.heroType.Sniper) crit = 2; //luck of 1 has 1/10 to be true
			return (((strength*(stamina/2))+defenseItem.getHealth())*crit); //attack strength is function of stamina, 
																	//strength, item, and critical chance
		}
		else {
			if (new Random().nextInt(10) <= (luck=critLuck)-1) crit = 2; //luck of 1 has 1/10 to be true
			return ((strength*(stamina/2))*crit);
		}
	}
	
	public void receiveHeal(int h) {
		health += h;
	}
	
	public void restoreStamina() {
		if(actionItem != null) {
			stamina = stamina + (health/2)+actionItem.getStamina();
		}
		else stamina = stamina + (health/2);
	}
	
	public void restoreHealth() {
		if(defenseItem != null) {
			health = health+defenseItem.getHealth();
		}
	}
	
	public void restoreAll(int[] stats) {
		this.health = stats[0];
		this.strength = stats[1];
		this.stamina = stats[2];
		this.luck = stats[3];
	}
		
}
