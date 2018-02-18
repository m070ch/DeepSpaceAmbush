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
		members.add(buildHero(types[1], affStr));
		members.add(buildHero(types[2], affStr));
		members.add(buildHero(types[3], affStr));
	}
	
	//takes a string of a hero type (i.e. "engineer") and
	//returns a string with all of that type's starting stats
	//for the party builder screen in GUI
	public String statsPrototype(String type) {
		heroType enumType = stringToType(type);
		if(enumType == null) return "";
		
		int[] stats = getStatsOfType(enumType);
		
		String str = "";
		str += "Health: "+Integer.toString(stats[1])+"\n";
		str += "Strength: "+Integer.toString(stats[2])+"\n";
		str += "Stamina: "+Integer.toString(stats[3])+"\n";
		str += "Luck: "+Integer.toString(stats[4])+"\n";
		
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
	
	//converts a string into a heroType enumerated type
	public heroType stringToType(String type) {
		if(type == "Brute") {
			return heroType.Brute;
		}
		else if(type == "Medic") {
			return heroType.Medic;
		}
		else if(type == "Sniper") {
			return heroType.Sniper;
		}
		else if(type == "Engineer") {
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
	
	//returns an int vector of starting stats for any type
	//
	//vector order - health, strength, stamina, luck
	//need to add in starting stats for types
	public int[] getStatsOfType(heroType type) {
		if(type == heroType.Brute) {
			return new int[]{1,1,1,1};
		}
		else if(type == heroType.Medic) {
			return new int[]{1,1,1,1};
		}
		else if(type == heroType.Sniper) {
			return new int[]{1,1,1,1};
		}
		else if(type == heroType.Engineer) {
			return new int[]{1,1,1,1};
		}
		else return null;
	}
	
}
