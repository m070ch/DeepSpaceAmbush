import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class ItemDialog{

	private ButtonGroup crewRadios;
	private JRadioButton crew1radio;
	private JRadioButton crew2radio;
	private JRadioButton crew3radio;
	
	private JTextArea itemStats;
	private JLabel instructions;
	
	
	private JPanel top;
	
	public ItemDialog() {
		
		itemStats = new JTextArea();
		instructions = new JLabel("Your enemies have dropped an item! Choose which hero you want to give it to:");
		
		crew1radio = new JRadioButton();
		crew2radio = new JRadioButton();
		crew3radio = new JRadioButton();
		
		crewRadios = new ButtonGroup();
		crewRadios.add(crew1radio);
		crewRadios.add(crew2radio);
		crewRadios.add(crew3radio);
		
		top = new JPanel();
		top.setLayout(new FlowLayout());
		top.add(instructions);
		top.add(itemStats);
		
	}
	
	public JRadioButton[] setCrew(ArrayList<String> crew) {
		crew1radio.setText(crew.get(0));
		crew1radio.setActionCommand(crew.get(0));
		crew2radio.setText(crew.get(1));
		crew2radio.setActionCommand(crew.get(1));
		crew3radio.setText(crew.get(2));
		crew3radio.setActionCommand(crew.get(2));
		
		return new JRadioButton[] {crew1radio, crew2radio, crew3radio};
	}
	
	public void setItem(String str) {
		itemStats.setText(str);
	}
	
	public String show(ArrayList<String> crew, String stats){
		
		setItem(stats);
		
        int optionType = JOptionPane.OK_CANCEL_OPTION;

        int selection = JOptionPane.showOptionDialog(null,
                top, "Item Assingment", optionType, JOptionPane.QUESTION_MESSAGE, null,
                setCrew(crew), null);

        if (selection == 0) return null;
        else {
            return crewRadios.getSelection().getActionCommand();       	
        }
    }
}
