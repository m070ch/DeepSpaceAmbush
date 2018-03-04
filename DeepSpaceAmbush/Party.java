import java.util.ArrayList;


public class Party {

	public enum affiliation{Crew, Pirate}
	private affiliation team;
	
	public enum heroType{Brute, Medic, Sniper, Engineer}
	
	private ArrayList<Hero> members;
	
	public Party() {
		
	}
	
	//Creates a party with an affiliation string (i.e. "crew")
	//and a vector of strings of hero types (should be a vector of length 3)
	//i.e. {"Engineer", "Medic", "Brute"}
	public void createParty(String affStr, String[] types) {
		members = new ArrayList<Hero>();
		members.add(buildHero(types[0], affStr));
		members.add(buildHero(types[1], affStr));
		members.add(buildHero(types[2], affStr));
	}
	
	public void createPirateParty(Hero pirate1, Hero pirate2, Hero pirate3) {
		members = new ArrayList<Hero>();
		members.add(pirate1);
		members.add(pirate2);
		members.add(pirate3);
	}
	
	public void restoreTeam() {
		for (int i = 0; i < members.size(); i++) {
			members.get(i).restoreAll(getStatsOfType(members.get(i).getType()));
		}
	}
	
	public ArrayList<String> teamTypesAsString() {
		ArrayList<String> strs = new ArrayList<String>();
		for (int i = 0; i < members.size(); i++) {
			strs.add(members.get(i).getTypeAsString());
		}
		return strs;
	}
	
	//takes a string of a hero type (i.e. "engineer") and
	//returns a string with all of that type's starting stats
	//for the party builder screen in GUI
	public String statsPrototype(String type) {
		heroType enumType = stringToType(type);
		if(enumType == null) return "";
		
		int[] stats = getStatsOfType(enumType);
		
		String str = "";
		str += "Health: "+Integer.toString(stats[0])+"\n";
		str += "Strength: "+Integer.toString(stats[1])+"\n";
		str += "Stamina: "+Integer.toString(stats[2])+"\n";
		str += "Luck: "+Integer.toString(stats[3])+"\n";
		
		return str;
	}
	
	//builds and returns a hero with a string "team" and string "type"
	//i.e. buildHero("crew", "engineer");
	public Hero buildHero(String type, String team){
		heroType enumType = stringToType(type);
		affiliation enumTeam = stringToTeam(team);
		
		if (enumType == null | enumTeam == null) return null;
		
		int[] stats = getStatsOfType(enumType);
		
		return new Hero(type+"-"+team, enumTeam, enumType, stats);
	}
	
	public Hero customPirateBuilder(String type, int[] stats) {
		heroType enumType = stringToType(type);
		return new Hero(type+"-Pirate", affiliation.Pirate, enumType, stats[0], stats[1], stats[2], stats[3]);
	}
	
	//converts a string into a heroType enumerated type
	public heroType stringToType(String type) {
		if(type.equals("Brute")) {
			return heroType.Brute;
		}
		else if(type.equals("Medic")) {
			return heroType.Medic;
		}
		else if(type.equals("Sniper")) {
			return heroType.Sniper;
		}
		else if(type.equals("Engineer")) {
			return heroType.Engineer;
		}
		else return null;
	}
	
	//converts a string into an affiliation enumerated type
	public affiliation stringToTeam(String team) {
		if (team == "Crew") return affiliation.Crew;
		else if (team == "Pirate") return affiliation.Pirate;
		else return null;
	}
	
	public String getTeam() {
		if(team == affiliation.Crew) return "Crew";
		else if (team == affiliation.Pirate) return "Pirate";
		else return null;
	}
	
	//returns an int vector of starting stats for any type
	//
	//vector order - health, strength, stamina, luck
	//need to add in starting stats for types
	public int[] getStatsOfType(heroType type) {
		if(type == heroType.Brute) {
			return new int[]{100,100,50,20};
		}
		else if(type == heroType.Medic) {
			return new int[]{50,100,50,30};
		}
		else if(type == heroType.Sniper) {
			return new int[]{100,50,100,50};
		}
		else if(type == heroType.Engineer) {
			return new int[]{50,100,100,20};
		}
		else return null;
	}
	
	//returns status of all heroes
	//as Arraylist of vectors
	public ArrayList<int[]> getAllStatus(){
		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < members.size(); i++) {
			list.add(members.get(i).getStatus());
		}
		return list;
	}
	
	//returns status of all heroes
	//as Arraylist of vectors
	public ArrayList<String> getAllStatusAsString(){
		String str = "";
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < members.size(); i++) {
			str = "";
			int[] status = members.get(i).getStatus();
			if (status[0] <= 0) {
				list.add("dead");
			}
			else {
				str += "Health: "+Integer.toString(status[0])+"\n";
				str += "Strength: "+Integer.toString(status[1])+"\n";
				str += "Stamina: "+Integer.toString(status[2])+"\n";
				str += "Luck: "+Integer.toString(status[3])+"\n";
				if (members.get(i).getActionItem() != null) {
					str += members.get(i).getActionItem().getStats();
				}
				if (members.get(i).getDefenseItem() != null) {
					str += members.get(i).getDefenseItem().getStats();
				}
				list.add(str);
			}
		}
		return list;
	}
	
	//returns ArrayList of members
	public ArrayList<Hero> getHeroes(){
		return members;
	}
	
	public ArrayList<String> getHeroesAsString() {
		ArrayList<String> str = new ArrayList<String>();
		
		for (int i = 0; i < members.size(); i++) {
			str.add(members.get(i).getName());
		}
		
		return(str);
	}
		
	//returns hero at index i in arrayList
	public Hero getMember(int i) {
		return members.get(i);
	}
	
	//returns hero based on type
	public Hero getMember(String str) {
		heroType type = stringToType(str);
		if (type == null) return null;
		
		for (int i = 0; i < members.size(); i++) {
			Hero h = members.get(i);
			if(h.getType() == type) return h;
		}
		
		return null;
	}
	
	//takes an int of hero's position in arrayList and returns their attack
	public int heroAttacks(int i) {
		return members.get(i).attack();
	}
	
	//takes an int of hero's position in arrayList and attack damage
	//call's hero's defense method
	public void heroDefends(int i, int dmg) {
		members.get(i).defend(dmg);
		members.get(i).restoreHealth();
	}
	
	//takes an int of hero's position in arrayList and healing
	//call's hero's receiveHeal method
	public void heroReceivesHeal(int i, int h) {
		members.get(i).receiveHeal(h);
	}
	
	//takes int of hero's position in arrayList and returns heal
	public int heroHeals(int i) {
		return members.get(i).heal();
	}
}
