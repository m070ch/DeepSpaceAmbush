import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
	private JButton doTurn;
	
	//TODO: declarations for objects to be added
	private ItemDialog itemDialog;
	private ArrayList<Level> levels;
	//TODO: [Oumar] finish method public void levelBuilder() that builds levels
	//				located directly above main()
	//TODO: [Oumar] declarations for objects to be created- use ItemDialog class as guide
	//private PartyBuilder partyBuilder;
	//private OpeningDialog openingDialog;
	//private LoseDialog loseDialog;
	//private WinDialog winDialog; 
	
	private Party pirates;
	private Party crew;
	
	public GameplayGUI() {
		setTitle("Deep Space Ambush");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBounds(5, 5, 900, 650);
		
		add(centerPanel(), BorderLayout.CENTER);
		
		topPanel = new JPanel();
		topLabel = new JLabel("Level 1");
		topPanel.add(topLabel);
		add(topPanel, BorderLayout.NORTH);
		
		add(sidePanel(), BorderLayout.EAST);
	
	}
	
	public JPanel sidePanel() {
		sidePanel = new JPanel();
		sidePanel.setLayout(new BorderLayout());
		
		messageBox = new JTextArea(30, 15);
		messageBox.setBorder(new TitledBorder("Messages"));
		doTurn = new JButton("Execute Turn");
		doTurn.addActionListener(new ButtonListener());
		
		sidePanel.add(messageBox, BorderLayout.CENTER);
		sidePanel.add(doTurn, BorderLayout.SOUTH);
		
		return(sidePanel);
	}
	
	public JPanel centerPanel() {
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2,1));
		centerPanel.setBorder(new TitledBorder("Battle"));
		centerPanel.add(piratePanel());
		centerPanel.add(crewPanel());
		return centerPanel;
	}
	
	public JPanel piratePanel() {
		piratePanel = new JPanel();
		piratePanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		pirate1text = new JTextArea(7, 15);
		pirate1text.setBorder(new TitledBorder("Pirate 1"));
		c.gridx = 0;
		c.gridy = 0;
		piratePanel.add(pirate1text, c);
		
		pirate2text = new JTextArea(7, 15);
		pirate2text.setBorder(new TitledBorder("Pirate 2"));
		c.gridx = 1;
		piratePanel.add(pirate2text, c);
		
		pirate3text = new JTextArea(7, 15);
		pirate3text.setBorder(new TitledBorder("Pirate 3"));
		c.gridx = 2;
		piratePanel.add(pirate3text, c);
		
		pirateRadios = new ButtonGroup();
		
		pirate1radio = new JRadioButton("Pirate 1");
		pirate1radio.setActionCommand("1");
		c.gridx = 0;
		c.gridy = 1;
		piratePanel.add(pirate1radio, c);
		
		pirate2radio = new JRadioButton("Pirate 2");
		pirate2radio.setActionCommand("2");
		c.gridx = 1;
		piratePanel.add(pirate2radio, c);
		
		pirate3radio = new JRadioButton("Pirate 3");
		pirate3radio.setActionCommand("3");
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
		
		crew1text = new JTextArea(7, 15);
		crew1text.setBorder(new TitledBorder("Crew 1"));
		c.gridx = 0;
		c.gridy = 0;
		crewPanel.add(crew1text, c);
		
		crew2text = new JTextArea(7, 15);
		crew2text.setBorder(new TitledBorder("Crew 2"));
		c.gridx = 1;
		crewPanel.add(crew2text, c);
		
		crew3text = new JTextArea(7, 15);
		crew3text.setBorder(new TitledBorder("Crew 3"));
		c.gridx = 2;
		crewPanel.add(crew3text, c);
		
		crewRadios = new ButtonGroup();
		
		crew1radio = new JRadioButton("Crew 1");
		crew1radio.setActionCommand("1");
		c.gridx = 0;
		c.gridy = 1;
		crewPanel.add(crew1radio, c);
		
		crew2radio = new JRadioButton("Crew 2");
		crew2radio.setActionCommand("2");
		c.gridx = 1;
		crewPanel.add(crew2radio, c);
		
		crew3radio = new JRadioButton("Crew 3");
		crew3radio.setActionCommand("3");
		c.gridx = 2;
		crewPanel.add(crew3radio, c);
		
		crewRadios.add(crew1radio);
		crewRadios.add(crew2radio);
		crewRadios.add(crew3radio);
		
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
		Hero crewMember = crew.getMember(Integer.parseInt(crewIndex));
		Hero pirateMember = pirates.getMember(Integer.parseInt(pirateIndex));
		
		int attack = crewMember.attack();
		messageBox.append("Crew "+crewMember.getName()+" attacked the pirate "+pirateMember.getName()
				+" with "+Integer.toString(attack)+" strength\n");
		int defend = pirateMember.defend(attack);
		messageBox.append("Pirate Member "+pirateMember.getName()+" took "+Integer.toString(defend)+" damage\n");
		if(pirateMember.getHealth() > 0) {
			attack = pirateMember.attack();
			messageBox.append("Pirate "+pirateMember.getName()+" retaliated with "+Integer.toString(attack)+" strength\n");
			defend = crewMember.defend(attack);
			messageBox.append("Crew "+crewMember.getName()+" took "+Integer.toString(defend)+" damage\n");
			if(crewMember.getHealth() == 0) {
				messageBox.append("Crew "+crewMember.getName()+" is dead\n");
			}
		} else messageBox.append("Pirate "+pirateMember.getName()+" is dead\n");
		
		String cont = refreshStatus();
		
		if (cont.equals("pirate victory")) {
			//TODO:pirate victory behavior
		}
		else if (cont.equals("crew victory")) {
			//TODO:crew victory behavior
			//TODO: itemDialog.show(crew.getAllStatusAsString(), itemstats).setItem(*item dropped*);
		}
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
	
	public void levelBuilder() {
		levels = new ArrayList<Level>();
		//repeat this 10 times adding in w/e values you want
		Party pirateParty = new Party();
		pirateParty.createPirateParty(
				pirateParty.customPirateBuilder("type as a string", new int[]{0, 0, 0, 0}), //strength, defense, stamina, luck
				pirateParty.customPirateBuilder("type as a string", new int[]{0, 0, 0, 0}),
				pirateParty.customPirateBuilder("type as a string", new int[]{0, 0, 0, 0})
		);
		levels.add(new Level(pirateParty, 
					new ActionItem("name of item", 0, 0, 0, 0) //strength, defense, stamina, luck (set some to 0)
				)
		);
		
	}
	
	
	public static void main(String[] args){
		GameplayGUI window = new GameplayGUI();
		window.setVisible(true);
	}// end main method
}
