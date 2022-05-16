package main.java.com.payrollpartner.userinterfaces;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainMenu {

	JPanel buttonPanel, clearPanel;
	JLabel bannerLabel;

	
	
	static JPanel buildMainMenu(JPanel mainMenuPanel) {

		String data = main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIndex(main.java.com.payrollpartner.Main.loggedinemp).toString();
		String[] empdata = data.split("\\r?\\n");
		
		mainMenuPanel.setLayout(new GridLayout(empdata.length +7, 1));
		
		mainMenuPanel.setBackground(Color.white);
		for (int b = 0; b < empdata.length; b++) {

			mainMenuPanel.setPreferredSize(main.java.com.payrollpartner.userinterfaces.GuiManager.smallbox);
			mainMenuPanel.add(new JLabel(empdata[b]));

		}
		

		
		String[] categories = new String[] {  "My account", "Payroll", "Employee database", "Company Policies" };
		//Admin: all buttons.
		//Manager: all but last.
		//Associate: only the first.
		
		
		switch (main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIndex(main.java.com.payrollpartner.Main.loggedinemp).getClass().toString()){
		
		case "class main.java.com.payrollpartner.employees.Admin":
			for (int c = 0; c < categories.length; c++)/// makes all the buttons
			{ // create the button for each key 
				JButton button = new JButton(categories[c]);
				// add an ActionListener to the button 
				 
				button.addActionListener(new mainMenuPanelListener());
				// add button to keyPanel 
				mainMenuPanel.add(button);
			}
			break;
		
		case "class employees.Manager":
			for (int c = 0; c < categories.length-1; c++)/// makes all the buttons
			{ /** create the button for each key */
				JButton button = new JButton(categories[c]);
				/** add an ActionListener to the button */
				 
				button.addActionListener(new mainMenuPanelListener());
				/** add button to keyPanel */
				mainMenuPanel.add(button);
			}
			break;
		
		case "class employees.Associate":

			JButton myinfobutton = new JButton(categories[0]);
			myinfobutton.addActionListener(new mainMenuPanelListener());
			mainMenuPanel.add(myinfobutton);
			
			break;
			
			
			
		default:
			System.out.println(	main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIndex(main.java.com.payrollpartner.Main.loggedinemp).getClass().toString());
			break;
		}
		
		JButton button = new JButton("Logout");
		button.addActionListener(new mainMenuPanelListener());
		mainMenuPanel.add(button);
		
		return mainMenuPanel;

	}
	
	private static class mainMenuPanelListener implements ActionListener {

		public void actionPerformed(ActionEvent event) { /** type the given code for this */

			
			switch (((JButton) event.getSource()).getText()) {

			case "My account":

				GuiManager.mainWindow.getContentPane().removeAll();// we removeall in every case instead of one time before the swich as we can not get the text if we remove before
				GuiManager.mainWindow.add(MyAccountGUI.buildMyAccountPanel());
				GuiManager.mainWindow.pack();

				break;

			case "Employee database":

				GuiManager.mainWindow.getContentPane().removeAll();
				GuiManager.mainWindow.add(DatabaseManagementGui.buildDatabaseManagmentPanel(0));

				GuiManager.mainWindow.pack();

				break;

			case "Company Policies":
				GuiManager.mainWindow.getContentPane().removeAll();
				GuiManager.mainWindow.add(CompanyPolicyGUI.buildCompanyPolicyPanel());
				GuiManager.mainWindow.pack();
				break;
				
			case "Payroll":
				
				GuiManager.mainWindow.getContentPane().removeAll();
				GuiManager.mainWindow.add(PayrollGUI.buildPayrollPanel());
				GuiManager.mainWindow.pack();
				break;


			case "Logout":
				main.java.com.payrollpartner.Main.loggedinemp = -1;
			
				GuiManager.mainWindow.getContentPane().removeAll();
				GuiManager.mainWindow.add(LoginGUI.buildLogin());
				GuiManager.mainWindow.pack();
				break;

			default:
				System.out.println(
						"Error: pleasewrite a bug report and send it via carrier pidgen to rhode island college.");
				break;
			}

		}

	}
}
