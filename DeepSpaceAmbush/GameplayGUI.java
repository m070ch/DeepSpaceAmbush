import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class GameplayGUI extends JFrame{

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
		c.gridx = 0;
		c.gridy = 1;
		piratePanel.add(pirate1radio, c);
		
		pirate2radio = new JRadioButton("Pirate 2");
		c.gridx = 1;
		piratePanel.add(pirate2radio, c);
		
		pirate3radio = new JRadioButton("Pirate 3");
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
		c.gridx = 0;
		c.gridy = 1;
		crewPanel.add(crew1radio, c);
		
		crew2radio = new JRadioButton("Crew 2");
		c.gridx = 1;
		crewPanel.add(crew2radio, c);
		
		crew3radio = new JRadioButton("Crew 3");
		c.gridx = 2;
		crewPanel.add(crew3radio, c);
		
		crewRadios.add(crew1radio);
		crewRadios.add(crew2radio);
		crewRadios.add(crew3radio);
		
		return(crewPanel);
	}
	
	
	public static void main(String[] args){
		GameplayGUI window = new GameplayGUI();
		window.setVisible(true);
	}// end main method
}