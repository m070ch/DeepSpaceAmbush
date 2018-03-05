import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.PrimitiveIterator;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class GameplayGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//declarations
	private JPanel topPanel;
	private JLabel topLabel;
	
	private JPanel piratePanel;
	private JPanel crewPanel;
	private JPanel centerPanel;
	
	private JTextArea pirate1text;
	private JTextArea pirate2text;
	private JTextArea pirate3text;
	
	private JTextArea crew1text;
	private JTextArea crew2text;
	private JTextArea crew3text;
	
	private ButtonGroup pirateRadios;
	private JRadioButton pirate1radio;
	private JRadioButton pirate2radio;
	private JRadioButton pirate3radio;
	
	private ButtonGroup crewRadios;
	private JRadioButton crew1radio;
	private JRadioButton crew2radio;
	private JRadioButton crew3radio;
	
	private JPanel sidePanel;
	private JTextArea messageBox;
	private JScrollPane messageScroll;
	private JButton doTurn;
	
	//TODO: declarations for objects to be added
	private ItemDialog itemDialog;
	private ArrayList<Level> levels;
	private int levelNumber;
	//TODO: [Oumar] finish method public void levelBuilder() that builds levels
	//				located directly above main()
	//TODO: [Oumar] declarations for objects to be created- use ItemDialog class as guide
	//private PartyBuilder partyBuilder;
	//private OpeningDialog openingDialog;
	//private LoseDialog loseDialog;
	//private WinDialog winDialog; 
	/////////////////////////////////////////////////////////////
	private Party pirates;
	private static Party crew;
	
	public GameplayGUI(String[] args) {
		setTitle("Deep Space Ambush");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		setLayout(new BorderLayout());
		setBounds(5, 5, 900, 650);
		setMinimumSize(new Dimension(800, 450));

		
		topPanel = new JPanel();
		topPanel.setBackground(new Color(168, 79, 79));
		topLabel = new JLabel("Level 1");
		topLabel.setFont(new Font(topLabel.getFont().toString(), Font.BOLD, 14));
		topPanel.add(topLabel);
		
		add(topPanel, BorderLayout.NORTH);
		
		add(centerPanel(), BorderLayout.CENTER);
		
		add(sidePanel(), BorderLayout.EAST);
	
		levelBuilder();
		levelNumber = 0;
		buildCrew(args);
		loadLevel();
		refreshStatus();
	}
	
	public JPanel sidePanel() {
		sidePanel = new JPanel();
		sidePanel.setLayout(new BorderLayout());
		
		
		messageBox = new JTextArea(30, 20);
		messageBox.setLineWrap(true);
		
		TitledBorder titleBorder = new TitledBorder("Messages");
		titleBorder.setTitleColor(new Color(0,0,0));
		titleBorder.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		
		messageBox.setBorder(titleBorder);
		messageBox.setBackground(new Color(147, 147, 147));
		
		doTurn = new JButton("Execute Turn");
		doTurn.addActionListener(new ButtonListener());
		doTurn.setBackground(new Color(168, 79, 79));
		doTurn.setPreferredSize(new Dimension(20,60));
		
		doTurn.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        doTurn.setBackground(new Color(79, 168, 79));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        doTurn.setBackground(new Color(168, 79, 79));
		    }
		});
		doTurn.setActionCommand("Execute Turn");
		
		sidePanel.add(messageBox, BorderLayout.CENTER);
		sidePanel.add(doTurn, BorderLayout.SOUTH);
		sidePanel.setMinimumSize(new Dimension( 650, 60));
		
		return(sidePanel);
	}
	
	public JPanel centerPanel() {
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2,1));
		TitledBorder titleBorder = new TitledBorder("Battle");
		titleBorder.setTitleColor(new Color(255, 255, 255));
		titleBorder.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
		centerPanel.setBorder(titleBorder);
		centerPanel.add(piratePanel());
		centerPanel.add(crewPanel());
		centerPanel.setBackground(new Color(68, 71, 76));
		return centerPanel;
	}
	
	public JPanel piratePanel() {
		piratePanel = new JPanel();
		piratePanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		piratePanel.setBackground(new Color(68, 71, 76));
		
		TitledBorder titleBorder = new TitledBorder("Pirate 1");
		titleBorder.setTitleColor(new Color(0,0,0));
		titleBorder.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		TitledBorder titleBorder2 = new TitledBorder("Pirate 2");
		titleBorder2.setTitleColor(new Color(0,0,0));
		titleBorder2.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		TitledBorder titleBorder3 = new TitledBorder("Pirate 3");
		titleBorder3.setTitleColor(new Color(0,0,0));
		titleBorder3.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		
		pirate1text = new JTextArea(7, 15);
		pirate1text.setBorder(titleBorder);
		pirate1text.setBackground(new Color(147, 147, 147));
		c.gridx = 0;
		c.gridy = 0;
		piratePanel.add(pirate1text, c);
		
		pirate2text = new JTextArea(7, 15);
		pirate2text.setBorder(titleBorder2);
		pirate2text.setBackground(new Color(147, 147, 147));
		c.gridx = 1;
		piratePanel.add(pirate2text, c);
		
		pirate3text = new JTextArea(7, 15);
		pirate3text.setBorder(titleBorder3);
		pirate3text.setBackground(new Color(147, 147, 147));
		c.gridx = 2;
		piratePanel.add(pirate3text, c);
		
		pirateRadios = new ButtonGroup();
		
		pirate1radio = new JRadioButton("Pirate 1");
		pirate1radio.setActionCommand("1");
		pirate1radio.setBackground(new Color(68, 71, 76));
		pirate1radio.setForeground(new Color(255,255,255));
		c.gridx = 0;
		c.gridy = 1;
		piratePanel.add(pirate1radio, c);
		
		pirate2radio = new JRadioButton("Pirate 2");
		pirate2radio.setActionCommand("2");
		pirate2radio.setBackground(new Color(68, 71, 76));
		pirate2radio.setForeground(new Color(255,255,255));
		c.gridx = 1;
		piratePanel.add(pirate2radio, c);
		
		pirate3radio = new JRadioButton("Pirate 3");
		pirate3radio.setActionCommand("3");
		pirate3radio.setBackground(new Color(68, 71, 76));
		pirate3radio.setForeground(new Color(255,255,255));
		c.gridx = 2;
		piratePanel.add(pirate3radio, c);
		
		pirateRadios.add(pirate1radio);
		pirateRadios.add(pirate2radio);
		pirateRadios.add(pirate3radio);
		
		return(piratePanel);
	}
	
	public JPanel crewPanel() {
		crewPanel = new JPanel();
		crewPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		crewPanel.setBackground(new Color(68, 71, 76));
		
		TitledBorder titleBorder = new TitledBorder("Crew 1");
		titleBorder.setTitleColor(new Color(0,0,0));
		titleBorder.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		TitledBorder titleBorder2 = new TitledBorder("Crew 2");
		titleBorder2.setTitleColor(new Color(0,0,0));
		titleBorder2.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		TitledBorder titleBorder3 = new TitledBorder("Crew 3");
		titleBorder3.setTitleColor(new Color(0,0,0));
		titleBorder3.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		
		crewRadios = new ButtonGroup();
		
		crew1radio = new JRadioButton("Crew 1");
		crew1radio.setActionCommand("1");
		crew1radio.setBackground(new Color(68, 71, 76));
		crew1radio.setForeground(new Color(255,255,255));
		c.gridx = 0;
		c.gridy = 0;
		crewPanel.add(crew1radio, c);
		
		crew2radio = new JRadioButton("Crew 2");
		crew2radio.setActionCommand("2");
		crew2radio.setBackground(new Color(68, 71, 76));
		crew2radio.setForeground(new Color(255,255,255));
		c.gridx = 1;
		crewPanel.add(crew2radio, c);
		
		crew3radio = new JRadioButton("Crew 3");
		crew3radio.setActionCommand("3");
		crew3radio.setBackground(new Color(68, 71, 76));
		crew3radio.setForeground(new Color(255,255,255));
		c.gridx = 2;
		crewPanel.add(crew3radio, c);
		
		crewRadios.add(crew1radio);
		crewRadios.add(crew2radio);
		crewRadios.add(crew3radio);
		

		crew1text = new JTextArea(7, 15);
		crew1text.setBorder(titleBorder);
		crew1text.setBackground(new Color(147, 147, 147));
		c.gridx = 0;
		c.gridy = 1;
		crewPanel.add(crew1text, c);
		
		crew2text = new JTextArea(7, 15);
		crew2text.setBorder(titleBorder2);
		crew2text.setBackground(new Color(147, 147, 147));
		c.gridx = 1;
		crewPanel.add(crew2text, c);
		
		crew3text = new JTextArea(7, 15);
		crew3text.setBorder(titleBorder3);
		crew3text.setBackground(new Color(147, 147, 147));
		c.gridx = 2;
		crewPanel.add(crew3text, c);
		

		
		return(crewPanel);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String actionCommand=e.getActionCommand();
			if (actionCommand.equals("Execute Turn")){
				exTurn(crewRadios.getSelection().getActionCommand(), pirateRadios.getSelection().getActionCommand());
			}
		}
	}
	
	public void exTurn(String crewIndex, String pirateIndex) {
		messageBox.setText("");
		Hero crewMember = crew.getMember(Integer.parseInt(crewIndex)-1);
		Hero pirateMember = pirates.getMember(Integer.parseInt(pirateIndex)-1);
		
		int attack = crewMember.attack();
		messageBox.append(crewMember.getName()+" attacked "+pirateMember.getName()
				+" with "+Integer.toString(attack)+" strength\n");
		int defend = pirateMember.defend(attack);
		messageBox.append(pirateMember.getName()+" took "+Integer.toString(defend)+" damage\n");
		if(pirateMember.getHealth() > 0) {
			attack = pirateMember.attack();
			messageBox.append(pirateMember.getName()+" retaliated with "+Integer.toString(attack)+" strength\n");
			defend = crewMember.defend(attack);
			messageBox.append(crewMember.getName()+" took "+Integer.toString(defend)+" damage\n");
			if(crewMember.getHealth() <= 0) {
				messageBox.append(crewMember.getName()+" is dead\n");
			}
		} else messageBox.append(pirateMember.getName()+" is dead\n");
		
		
		String cont = refreshStatus();
		
		if (cont.equals("pirate victory")) {
			messageBox.setText("You've lost! Better luck next time!");
		}
		else if (cont.equals("crew victory")) {
			Item itemTemp = levels.get(levelNumber).getItem();
			itemDialog = new ItemDialog();
			String type = itemDialog.show(crew.teamTypesAsString(), itemTemp.getStats());
			crew.getMember(type).setItem(itemTemp);
			loadLevel();
		}
	}
	
	public void buildCrew(String[] args) {
		crew = new Party();
		crew.createParty("Crew", args);
		((TitledBorder) crew1text.getBorder()).setTitle(crew.getMember(0).getName());
		((TitledBorder) crew2text.getBorder()).setTitle(crew.getMember(1).getName());
		((TitledBorder) crew3text.getBorder()).setTitle(crew.getMember(2).getName());
	}
	
	public void loadLevel() {
		levelNumber++;
		pirates = new Party();
		pirates = levels.get(levelNumber).getPirates();
		System.out.println("new Pirates: level "+Integer.toString(levelNumber));
		System.out.println(pirates.getMember(0).getName()+" "+pirates.getMember(1).getName()+" "+pirates.getMember(2).getName());
		crew.restoreTeam();
		refreshStatus();
		topLabel = new JLabel("Level "+Integer.toString(levelNumber+1));
		
		
		((TitledBorder) pirate1text.getBorder()).setTitle(pirates.getMember(0).getName());
		((TitledBorder) pirate2text.getBorder()).setTitle(pirates.getMember(1).getName());
		((TitledBorder) pirate3text.getBorder()).setTitle(pirates.getMember(2).getName());
	}
	
	public String refreshStatus() {
		int deadCount = 0;
		ArrayList<String> crewStatus = crew.getAllStatusAsString();
		crew1text.setText(crewStatus.get(0));
		crew2text.setText(crewStatus.get(1));
		crew3text.setText(crewStatus.get(2));
		
		ArrayList<String> piratesStatus = pirates.getAllStatusAsString();
		pirate1text.setText(piratesStatus.get(0));
		pirate2text.setText(piratesStatus.get(1));
		pirate3text.setText(piratesStatus.get(2));
		
		for(int i = 0; i < 3; i++) {
			if (crewStatus.get(i).equals("dead")) deadCount++;
		}
		if (deadCount == 3) return "pirate victory";
		
		deadCount = 0;
		
		for(int i = 0; i < 3; i++) {
			if (piratesStatus.get(i).equals("dead")) deadCount++;
		}
		if (deadCount == 3) return "crew victory";
		
		return "continue";
		
	}
	
	   //random number generator method to create the random pirate class
	 
	private PrimitiveIterator.OfInt randomIterator;
     /**
      * Initialize a new random number generator that generates
      * random numbers in the range [min, max]
      * @param min - the min value (inclusive)
      * @param max - the max value (inclusive)
      * @return
      */
     public void IntRandomNumberGenerator(int min, int max) {
         randomIterator = new Random().ints(min, max + 1).iterator();
     }
     /**
      * Returns a random number in the range (min, max)
      * @return a random number in the range (min, max)
      */
     public int nextInt() {
         return randomIterator.nextInt();
     }	 
	 
	public void levelBuilder() {
	  levels = new ArrayList<Level>();
	  //repeat this 10 times adding in w/e values you want
	  Party pirateParty;

	  ArrayList<Item> items = new ArrayList<Item>();
	  items.add(new ActionItem("Axe", 10, 4, 6));
	  items.add(new DefenseItem("Shield", 10,5));
	  items.add(new ActionItem("Sniper Canon", 10, 0, 10));
	  items.add( new DefenseItem("Running", 2,2));
	  items.add(new DefenseItem("Medium Gauntlet", 2,2));
	  items.add(new ActionItem("Canon", 10, 5, 1));
	  items.add(new ActionItem("ShotGun", 10, 0, 10));
	  items.add( new ActionItem("Rifle", 8, 5, 2));
	  items.add( new ActionItem("Knive", 4, 10, 2));
	  items.add(new ActionItem("Pistol", 7, 0, 5));
	  
	  for(int j = 0; j < items.size(); j++) {
		  pirateParty = new Party();
		  //Initializing the Array of Strings
		  ArrayList<String> typesOfPirates = new ArrayList<String>();
		  
		  //initialize the integer randomChoice for the choice of type 
		  int randomChoice;
		  for (int i = 0; i < 3; i++) {
		  
		  //Initialize the random numbers
			  IntRandomNumberGenerator(1, 4);
			  randomChoice = nextInt();
			  switch (randomChoice) {
				  case 1:
				   typesOfPirates.add("Brute");
				   System.out.printf("Brute added to Pirates\n");
				   break;
				  case 2:
				   typesOfPirates.add("Medic");
				   //System.out.printf("Medic added to Pirates\n");
				   break; 
				  case 3:
				   typesOfPirates.add("Engineer");
				   //System.out.printf("Engineer added to Pirates\n");
				   break;
				  case 4:
				   typesOfPirates.add("Sniper");
				   //System.out.printf("Sniper added to Pirates\n");
				   break;
				  default:
				   //System.out.printf("Invalid number selected\n");
			  }	  
		  }
		  
		  //switching it to String to be passed to the party builder
		  String[] returnedPirates = new String[typesOfPirates.size()];
		    returnedPirates = (String[]) typesOfPirates.toArray(returnedPirates);
		   
		 
		  //Build the Pirateparty
		   pirateParty.createPirateParty(returnedPirates, levelNumber);
		  
		  
		  levels.add(new Level(pirateParty,
		     items.get(j) //strength, defense, stamina, luck (set some to 0)
		    )
		  );
	 }
	}
	  
	 
	
	public static void main(String[] args){
		GameplayGUI window = new GameplayGUI(args);
		window.setVisible(true);
		//buildCrew(args);
		
	}// end main method
}
