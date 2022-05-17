package main.java.com.payrollpartner.userinterfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import main.java.com.payrollpartner.*;

// a gui for managing ones own account
public class MyAccountGUI {

	
	static JPanel buildMyAccountPanel() {
		JPanel myAccountPanel = new JPanel();
		
		
		/* view stats 

		private String userName = "";
		private String firstName;
		private String lastName;
		private String fullName;
		private char[] passwordHash;

		private String title;
		private String department;
		private String reportsTo;
		private int idNumber;

		private boolean salaried;
		private double hoursThisWeek;
		private double wage;
		private double grossOvertimePay;
		private double salariePayPerPeriod;
		private double yearToDatePay;
		private double benefitsContributions;// these are reimbersments
		private double netPay;
		
		*/
		
		
		String[] empdata = {
				"Name: ",
				Main.employeeDatabase.getEmployeeByIndex(Main.loggedinemp).getFullName(),
				"Username: ",
				Main.employeeDatabase.getEmployeeByIndex(Main.loggedinemp).getUserName(),
				
				
				"Wage: ",""+	
				Main.employeeDatabase.getEmployeeByIndex(Main.loggedinemp).getWage(),
				
				
				
				"Hours logged this week: ",""+	
				Main.employeeDatabase.getEmployeeByIndex(Main.loggedinemp).getHoursthiswek(),
				
				"Year to Date: ",""+	
						Main.employeeDatabase.getEmployeeByIndex(Main.loggedinemp).getYearToDatePay(),
		
		};
		
		if(Main.employeeDatabase.getEmployeeByIndex(Main.loggedinemp).getSalaried()) {
		empdata[4]  = "Salarie";
		empdata[5] = ""+Main.employeeDatabase.getEmployeeByIndex(Main.loggedinemp).getsalariePayPerPeriod();
		}
		
		
		
		
		
		
		myAccountPanel.setLayout(new GridLayout((empdata.length/2) + 1,2));
		
		
		for(int i =0;i< empdata.length; i++) {
			myAccountPanel.add(new JLabel(empdata[i]));
		}
		
		
		JButton changepassbutton = new JButton("change password");
		changepassbutton.addActionListener(new changePasswordPanelListener());
		
		
		GuiManager.addbackbutton(myAccountPanel);
		myAccountPanel.add(changepassbutton);
		
		return myAccountPanel;
	}
	
	
	private static class changePasswordPanelListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			
		}
		}
	
	
	
	
}
