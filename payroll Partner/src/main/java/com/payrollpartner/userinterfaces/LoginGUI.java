package main.java.com.payrollpartner.userinterfaces;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
/*
 * Author: Ryan Bourque * Date: May 5 2022
 * this file contains the panel all login elements are on and tow listeners for the two buttons.
 * */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

// this is the initial gui for logging in
public class LoginGUI {// Using separate classes bc putting them all into one became unmanageable.

	static JTextField userNameTextField = new JTextField("Enter youe Username");//these are static so the action listeners can see them
	static JPasswordField passwordtextfield = new JPasswordField("Enter ");
	static JLabel bannerLabel = new JLabel(main.java.com.payrollpartner.Main.compBanner);

	static JPanel buildLogin() {

		JPanel loginPanel = new JPanel();
		
		//loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.PAGE_AXIS));
		
		
		GridBagConstraints gbc = new GridBagConstraints(); 
		GridBagLayout layout = new GridBagLayout();
		loginPanel.setLayout(layout);
		
		
	    gbc.fill = GridBagConstraints.HORIZONTAL;  
	    gbc.gridx = 0;  
	    gbc.gridy = 0;  
	    gbc.ipady = 50;
		loginPanel.add(new JLabel("Welcome to Payroll Partner, a emplyee database and payroll manager."),gbc);
		
	    gbc.gridx = 0;  
	    gbc.gridy = 5;  
		
		loginPanel.add(bannerLabel,gbc);
		
		gbc.ipady = 0;
		
		
		JPanel credentialsPanel = new JPanel();
		credentialsPanel.setLayout(layout);
		
		Dimension d = new Dimension(350,25);
		
		
		userNameTextField.addFocusListener(new textFieldFocusListener());
		
		
	    gbc.gridx = 0;  
	    gbc.gridy = 0; 
	    gbc.fill = GridBagConstraints.HORIZONTAL; 
		credentialsPanel.add(new JLabel("Username: "),gbc);
		gbc.gridx = 1;  
	    gbc.gridy = 0; 
	    gbc.fill = GridBagConstraints.HORIZONTAL; 
		credentialsPanel.add(userNameTextField,gbc);
		gbc.gridx = 0;  
	    gbc.gridy = 1; 
		credentialsPanel.add(new JLabel("Password: "),gbc);
		gbc.gridx = 1;  
	    gbc.gridy = 1; 
		credentialsPanel.add(passwordtextfield,gbc);

		//credentialsPanel.setMaximumSize(new Dimension(550, 80));
		
		
		JPanel butonsPanel = new JPanel();
		//butonsPanel.setLayout(new GridLayout(1, 2));
		
		JButton clearbutton = new JButton("Clear");
		clearbutton.addActionListener(new ClearListener());

		JButton loginbutton = new JButton("Login");
		loginbutton.addActionListener(new LoginListener());
		
		butonsPanel.add(clearbutton);
		butonsPanel.add(loginbutton);
		
		
		
		butonsPanel.setMaximumSize(new Dimension(550, 80));
		
	    gbc.gridx = 0;  
	    gbc.gridy = 10; 
	    //gbc.ipadx = 200;
	    gbc.ipady = 30;
	    //Dimentions d2 = new Dimentions(100,100);
	    credentialsPanel.setMinimumSize(d);
		loginPanel.add(credentialsPanel,gbc);
		
		
		
		gbc.ipady = 20;
		gbc.ipadx = 200;
	    gbc.gridx = 0;  
	    gbc.gridy = 15;
		loginPanel.add(butonsPanel,gbc);
		
		
		return loginPanel;
	}

	static class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			int empindex = -1;

			if (main.java.com.payrollpartner.Main.employeeDatabase.getIndexOfEmployeebyUsername(userNameTextField.getText()) > -1) {
				//System.out.print(main.Main.employeeDatabase.getIndexOfEmployeebyUsername(userNameTextField.getText()));
				empindex = main.java.com.payrollpartner.Main.employeeDatabase
						.getIndexOfEmployeebyUsername(userNameTextField.getText());

				if (main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIndex(empindex)
						.checkPasswordHash(passwordtextfield.getPassword()) == 1) {

					main.java.com.payrollpartner.Main.loggedinemp = empindex;

					userNameTextField.setText("Enter your Username");
					passwordtextfield.setText("Enter your Password");

					GuiManager.mainWindow.getContentPane().removeAll();// ((JButton) event.getSource()).getParent());

					GuiManager.mainWindow.add(MainMenu.buildMainMenu(new JPanel()));
					GuiManager.mainWindow.pack();
				} else {
					
					bannerLabel.setText("Usrname not found or password missmach!");
				}

			} else {
				bannerLabel.setText("Usrname not found or password missmach.");
				// System.out.println("Usrname not found or password missmach");
			}
			///////////////////////////////////////////////

			;

		}
	}

	static class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent event) { /** type the given code for this */
			userNameTextField.setText("");
			passwordtextfield.setText("");
		}
		
	}
	
	static class textFieldFocusListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent arg0) {
			
			userNameTextField.setText("");
			passwordtextfield.setText("");
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			

		}
		
		
		
	}
	
	
	
	
	
}
