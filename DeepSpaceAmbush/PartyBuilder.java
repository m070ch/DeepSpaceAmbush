import javax.swing.JFrame;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;


public class PartyBuilder extends JFrame{
	
	//constructor
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PartyBuilder() {
		initComponents();
	}

	
	
	//Variables needed to build the frame

	//Brute
	
	JScrollPane brutePanel1 = new JScrollPane();
	JTextArea bruteStatsBox = new JTextArea();
	JCheckBox bruteSelection = new JCheckBox();
	
	//Medic
	
	JScrollPane medicPanel1 = new JScrollPane();
	JTextArea medicStatsBox = new JTextArea();
	JCheckBox medicSelection = new JCheckBox();
	
	//Engineer
	
	JScrollPane engineerPanel1 = new JScrollPane();
	JTextArea engineerStatsBox = new JTextArea();
	JCheckBox engineerSelection = new JCheckBox();
	
	//Sniper
	
	JScrollPane sniperPanel1 = new JScrollPane();
	JTextArea sniperStatsBox = new JTextArea();
	JCheckBox sniperSelection = new JCheckBox();
	
	//Method to initiate the frame
	
	
	
	
	
	
    private void initComponents() {
    	
    	//Components of the frame
    	//JPanel panel = new JPanel();
    	
        
        
    		setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    		/*--------------Title Label----------------*/
    	
    		JLabel titleLabel = new JLabel();
    		titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    		titleLabel.setText("Please select your team");
    		
    	
    		/*-------------Brute Variables------------- */
    	
    	
    		
    		brutePanel1.setViewportView(bruteStatsBox);
    		bruteStatsBox.setEditable(false);
    		bruteStatsBox.setColumns(20);
    		bruteStatsBox.setRows(5);
    		bruteStatsBox.addAncestorListener(new javax.swing.event.AncestorListener() {
                public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                }
                public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                	bruteStatsBoxAncestorAdded(evt);
                }
                public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                }
            });
    		
    		//checkbox addition
    		
    		bruteSelection.setText("Brute");

    	
    		
    	
    		
    		/*-------------Medic Variables------------- */
    		
    		
    		medicPanel1.setViewportView(medicStatsBox);
    		medicStatsBox.setEditable(false);
    		medicStatsBox.setColumns(20);
    		medicStatsBox.setRows(5);
    		medicStatsBox.addAncestorListener(new javax.swing.event.AncestorListener() {
                public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                }
                public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                	medicStatsBoxAncestorAdded(evt);
                }
                public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                }
            });
    		
    		//checkbox addition
    		
    		medicSelection.setText("Medic");
    		
    		
    		/*-------------Sniper Variables------------- */
    		
    		
    		sniperPanel1.setViewportView(sniperStatsBox);
    		sniperStatsBox.setEditable(false);
    		sniperStatsBox.setColumns(20);
    		sniperStatsBox.setRows(5);
    		sniperStatsBox.addAncestorListener(new javax.swing.event.AncestorListener() {
                public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                }
                public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                	sniperStatsBoxAncestorAdded(evt);
                }
                public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                }
            });
    		
    		// checkbox addition
    		
    		sniperSelection.setText("Sniper");

    		
    		/*-------------Engineer Variables------------- */
    		
    		
    		engineerPanel1.setViewportView(engineerStatsBox);
    		engineerStatsBox.setEditable(false);
    		engineerStatsBox.setColumns(20);
    		engineerStatsBox.setRows(5);
    		engineerStatsBox.addAncestorListener(new javax.swing.event.AncestorListener() {
                public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                }
                public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                	engineerStatsBoxAncestorAdded(evt);
                }
                public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                }
            });
    		
    		engineerSelection.setText("Engineer");

    		
    		
    		/*--------------Continue Button----------------*/
    		
    					
    		
    		JButton continueButton = new JButton();
    		continueButton.setText("CONTINUE");
    		continueButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    continueButtonActionPerformed(evt);
                }
            });
    		
    		
    		//Layout of the panel frame
    		
    		 javax.swing.GroupLayout  layout = new  javax.swing.GroupLayout (getContentPane());
    		getContentPane().setLayout(layout);
    		layout.setHorizontalGroup(
    				layout.createParallelGroup(Alignment.LEADING)
    				.addGroup(layout.createSequentialGroup()
    						.addGroup(layout.createParallelGroup(Alignment.LEADING)
    								.addGroup(layout.createSequentialGroup()
    										.addGap(102, 102, 102)
    										.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE,339, GroupLayout.PREFERRED_SIZE))
    								.addGroup(layout.createSequentialGroup()
    										.addGap(20, 20, 20)
    										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
    												.addComponent(continueButton)
    												.addGroup(layout.createSequentialGroup()
    														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    																.addComponent(brutePanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    							                                    .addComponent(medicPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    							                                    .addComponent(bruteSelection)
    							                                    .addComponent(engineerSelection))
    														.addGap(27, 27, 27)
    						                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    						                                    .addComponent(sniperPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    						                                    .addComponent(engineerPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    						                                    .addComponent(medicSelection)
    						                                    .addComponent(sniperSelection))))))
    														.addContainerGap(18, Short.MAX_VALUE))
    						);
    		
    		layout.setVerticalGroup(
    	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    	            .addGroup(layout.createSequentialGroup()
    	                .addGap(21, 21, 21)
    	                .addComponent(titleLabel)
    	                .addGap(18, 18, 18)
    	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
    	                    .addComponent(brutePanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    	                    .addComponent(engineerPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
    	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    	                    .addComponent(bruteSelection)
    	                    .addComponent(medicSelection))
    	                .addGap(25, 25, 25)
    	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    	                    .addComponent(medicPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    	                    .addComponent(sniperPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
    	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    	                    .addComponent(engineerSelection)
    	                    .addComponent(sniperSelection))
    	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
    	                .addComponent(continueButton)
    	                .addContainerGap())
    	        );
    		//con.add(getContentPane());
    		pack();
    		
    }	
    		/*--------------Action Listeners Methods----------------*/
    
  //Brutestats box update
    	
    private void bruteStatsBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {                                         
        
    	// Displays the stats for the Brute class
        
        bruteStatsBox.setText(retrieveTextBrute());
    }   
    
    
  //Medicstats box update
	
    private void medicStatsBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {                                         
        
    	// Displays the stats for the Medic class
        
        medicStatsBox.setText(retrieveTextMedic());
    }   
    
//Sniperstats box update
	
    private void sniperStatsBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {                                         
        
    	// Displays the stats for the Medic class
        
        sniperStatsBox.setText(retrieveTextSniper());
    }   
    
    
//Engineerstats box update
	
    private void engineerStatsBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {                                         
        
    	// Displays the stats for the Medic class
        
        sniperStatsBox.setText(retrieveTextEngineer());
    }   
    
   /*--------------Methods for the checkbox selection------------------  */ 
    

    
    
    
    		//Continue button action
    		 private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
    		        // TODO add your handling code here:
    		        
    		        if (properSelection()){
    		         GameplayGUI.main(getSelection());
    		        this.setVisible(false);
    		        }
    		        //else{   
    		        //new TooManyChoicesError().setVisible(true);
    		        //this.setVisible(false);}
    		       
    		      
    		        
    		        }
    		     
    		  
    		
    		  /*------------Additonal Methods for needed for Character Selection-------------  */
    		        
		        private String[] getSelection(){
    		       
    		        
    		       ArrayList<String> checkList = new ArrayList<String>();
    		       
    		       if(bruteSelection.isSelected()){
    		           checkList.add(bruteSelection.getText());
    		       }
    		       
    		       if(medicSelection.isSelected()){
    		           checkList.add(medicSelection.getText());
    		       }
    		      
    		       if(engineerSelection.isSelected()){
    		           checkList.add(engineerSelection.getText());
    		       }

    		        if(sniperSelection.isSelected()){
    		           checkList.add(sniperSelection.getText());
    		       }
    		        
    		        if (checkList.size() != 3 ){
    		            return null;
    		        }
    		        
    		           return new String[]{checkList.get(0), checkList.get(1), checkList.get(2)};

    		    }

    		  private boolean properSelection(){
    		        boolean answer = false;
    		        
    		       List<JCheckBox> checkList = new ArrayList<JCheckBox>();
    		       
    		       if(bruteSelection.isSelected()){
    		           checkList.add(bruteSelection);
    		       }
    		       
    		       if(medicSelection.isSelected()){
    		           checkList.add(medicSelection);
    		       }
    		      
    		       if(engineerSelection.isSelected()){
    		           checkList.add(engineerSelection);
    		       }

    		        if(sniperSelection.isSelected()){
    		           checkList.add(sniperSelection);
    		       }
    		        
    		        if (checkList.size() == 3 ){
    		            answer = true;
    		        }
    		        
    		           return answer;

    		    }
    		    
    		     private String retrieveTextBrute(){
    		        String text = new String();
    		        text += "Attack: 10\nDefense: 10\nStamina: 5\nLuck: 2";
    		    	return(text);
    		    }
    		    
    		      private String retrieveTextMedic(){
    		        String text = new String();
    		        text += "Attack: 5\nDefense: 10\nStamina: 5\nLuck: 3";
    		    	return(text);
    		    }
    		      
    		       private String retrieveTextEngineer(){
    		        String text = new String();
    		        text += "Attack: 10\nDefense: 5\nStamina: 5\nLuck: 2";
    		    	return(text);
    		    }
    		       
    		        private String retrieveTextSniper(){
    		        String text = new String();
    		        text += "Attack: 10\nDefense: 5\nStamina: 10\nLuck: 5";
    		    	return(text);
    		    }
    		        
    		  
    		  
    		  
    		  
    		  
    		  
    		  //main method to test output
    		  public static void main(String args[]) {
    		        /* Set the Nimbus look and feel */
    		        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    		        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    		         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
    		         */
    		        try {
    		            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    		                if ("Nimbus".equals(info.getName())) {
    		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
    		                    break;
    		                }
    		            }
    		        } catch (ClassNotFoundException ex) {
    		            java.util.logging.Logger.getLogger(PartyBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    		        } catch (InstantiationException ex) {
    		            java.util.logging.Logger.getLogger(PartyBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    		        } catch (IllegalAccessException ex) {
    		            java.util.logging.Logger.getLogger(PartyBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    		            java.util.logging.Logger.getLogger(PartyBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    		        }
    		        //</editor-fold>

    		        /* Create and display the form */
    		        java.awt.EventQueue.invokeLater(new Runnable() {
    		            public void run() {
    		                new PartyBuilder().setVisible(true);
    		            }
    		        });
    		    }
    		  
    		  
    		
    }
	
	
	
	
