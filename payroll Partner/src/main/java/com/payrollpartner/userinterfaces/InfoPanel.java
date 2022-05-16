package main.java.com.payrollpartner.userinterfaces;
import java.awt.GridLayout;

import javax.swing.JLabel;
//this part of the userinterface tells the user about logins they can try and the description of the project
import javax.swing.JPanel;

public class InfoPanel {

	static JPanel buildInfoPanel() {
		
		JPanel infoPanel = new JPanel();
		
		
		String[] msg = {"This is my personal project to create a mock internal payroll application.","","you can use the" ,"Username: aa1 "," Password: a","","Features:","Employee database with add and eddit functions ","comming soon:", "search"};
		
		
		infoPanel.setLayout(new GridLayout(msg.length,1));
		
		
		
		for(int c = 0; c < msg.length;c++)
		{
			
			infoPanel.add(new JLabel(msg[c]));
			
		}
			
		return infoPanel;
	}
	
	
}
