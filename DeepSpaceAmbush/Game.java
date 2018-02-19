/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame window;
    Container con;
    JPanel titleNamePanel, nextButtonPanel, mainTextPanel, selectPlayerPanel, imagePanel;
    JLabel titleNameLabel, playerNameLabel, imageLabel;
    Font titleFont = new Font("Time New Roman", Font.PLAIN, 28);
    JButton nextButton;
    JTextArea storyTextArea;
    JTextField playerName;
    ImageIcon image;
    
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    
    StoryScreenHandler scHandler = new StoryScreenHandler();
    
    SelectTeamScreenHandler selectTeamHandler = new SelectTeamScreenHandler();
    
    public static void main(String[] args){
        Game game = new Game();
        game.setVisible(true);
    }
    
    public Game(){
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.white);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane(); 
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 180);
        //titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("Deep Space Ambush");
        titleNameLabel.setForeground(Color.red);
        titleNameLabel.setText("Deep Space Ambush");
        
        titleNameLabel.setFont(titleFont);
        
        nextButtonPanel = new JPanel();
        nextButtonPanel.setBounds(600, 500, 200, 100);
        nextButtonPanel.setBackground(Color.white);
        
        //Creates the NEXT button
        nextButton = new JButton("NEXT");
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.white);
        
        nextButton.addActionListener(tsHandler);
        
        titleNamePanel.add(titleNameLabel);
        nextButtonPanel.add(nextButton);
        
        con.add(titleNamePanel);
        con.add(nextButtonPanel);
    }
    
    //Screen where the user enters their name
    public void createEnterNameScreen(){
        
        titleNamePanel.setVisible(false);
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(150, 100, 400, 200);
        //titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("Deep Space Ambush");
        titleNameLabel.setForeground(Color.red);
        titleNameLabel.setText("Deep Space Ambush");
        
        titleNameLabel.setFont(titleFont);
        
        playerNameLabel = new JLabel("Please enter your name");
        playerNameLabel.setText("Please enter your name");
        
        JTextField playerName;
        //playerNameField.setBounds(100, 100, 600, 250);
        playerName = new JTextField(15);
        
        titleNamePanel.add(titleNameLabel);
        titleNamePanel.add(playerNameLabel);
        titleNamePanel.add(playerName);
        
        con.add(titleNamePanel);
        nextButton.addActionListener(scHandler);
        
    }
  
    //Screen where the story is being told
    public void createStoryScreen() {
        titleNamePanel.setVisible(false);
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
       // mainTextPanel.setBackground(Color.GRAY);
        con.add(mainTextPanel);
        
        storyTextArea = new JTextArea("Story");
        storyTextArea.setBounds(100, 200, 500, 250);
        //storyTextArea.setBackground(Color.GRAY);
        //storyTextArea.setForeground(Color.white);
        storyTextArea.setLineWrap(true);
        storyTextArea.setText("Story: \n  Welcome to  to the ...............");
        mainTextPanel.add(storyTextArea);
        //mainTextPanel.add(new JLabel(new ImageIcon("Card.png")));
        playerName.setVisible(false);


        imagePanel = new JPanel();
        imagePanel.setBounds(200, 200, 600, 250);
        imagePanel.setBackground(Color.blue);
        
        imageLabel = new JLabel();
        image = new ImageIcon("Card.png");
        imageLabel.setIcon(image);
        imagePanel.add(imageLabel);
        
        con.add(imagePanel);
        
        /**
         * Here I thought it would add another action listener to activate selectPlayerScreen method after the next button has been clicked
        **/
        nextButton.addActionListener(selectTeamHandler);

    }
    
    public void selectPlayerScreen(){
        titleNamePanel.setVisible(false);
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
       // mainTextPanel.setBackground(Color.GRAY);
        con.add(mainTextPanel);
        
        storyTextArea = new JTextArea("Select Player Team");
        storyTextArea.setBounds(100, 100, 600, 250);
        //storyTextArea.setBackground(Color.GRAY);
        //storyTextArea.setForeground(Color.white);
        storyTextArea.setLineWrap(true);
        storyTextArea.setText("Select Player Team");
        mainTextPanel.add(storyTextArea);
        mainTextPanel.add(new JLabel(new ImageIcon("Card.png")));
        playerName.setVisible(false);
    }

    public class TitleScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            createEnterNameScreen();
        }
    }
    
    public class StoryScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            createStoryScreen();
        }
    }
    
    public class SelectTeamScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            selectPlayerScreen();
        }
    }
}

