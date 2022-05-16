package main.java.com.payrollpartner.userinterfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EmployeeEdditer {

	static int empIDForDelete = -1;
	static int empIDForEddit = -1;

	// static objexts so they can be seen by listeners
	static JTextField firstNameTextField = new JTextField();
	static JTextField lastNameTextField = new JTextField();
	static JTextField sallarytextfield = new JTextField();
	static JTextField passwordtextfield = new JTextField();
	static JTextField UserNametextfield = new JTextField();
	static JTextField titleTextField = new JTextField();
	static JTextField departmentTextField = new JTextField();
	static JTextField reportsToTextField = new JTextField();
	
	static JRadioButton genUserNameButton = new JRadioButton();

	static JRadioButton manprivilegesradiobutton = new JRadioButton();

	static JPanel buildEmployeeEdditerPanel(int empID) {// if-1then we are just making a blankslate to add if > -1 we
														// are edditing an employee and must fill

		
		JPanel empEdditer = new JPanel();

		empIDForEddit = empID; // setting the static var so we can use it in the listeners

		genUserNameButton.setSelected(false);
		UserNametextfield.setEditable(true);

		
		empEdditer.setLayout(new GridLayout(12, 2));

		if (empID > -1) {
			firstNameTextField.setText(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empID).getFirstName());
			lastNameTextField.setText(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empID).getLastName());
			sallarytextfield.setText(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empID).getSalaryInfo());
			UserNametextfield.setText(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empID).getUserName());
			titleTextField.setText(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empID).getTitle());
			departmentTextField.setText(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empID).getDepartment());
			reportsToTextField.setText(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empID).getReportsTo());
			
			if (main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIndex(main.java.com.payrollpartner.Main.loggedinemp) instanceof main.java.com.payrollpartner.employees.Admin) {
				passwordtextfield.setText("");
				passwordtextfield.setEnabled(true);
			} else {
				passwordtextfield.setText("");
				passwordtextfield.setEnabled(false);

			}

		}

		if (empID == -1) {
			firstNameTextField.setText("");
			lastNameTextField.setText("");
			sallarytextfield.setText("");
			UserNametextfield.setText("");

		}

		empEdditer.add(new JLabel("First Name:"));
		empEdditer.add(firstNameTextField);

		empEdditer.add(new JLabel("Last Name:"));
		empEdditer.add(lastNameTextField);

		empEdditer.add(new JLabel("Salary:"));
		empEdditer.add(sallarytextfield);

		empEdditer.add(new JLabel("re-gernerate username with new name?"));
		empEdditer.add(genUserNameButton);
		genUserNameButton.addActionListener(new usernameradiobutnListener());

		empEdditer.add(new JLabel("Username:"));
		empEdditer.add(UserNametextfield);

		empEdditer.add(new JLabel("Password:"));
		empEdditer.add(passwordtextfield);
		// empEdditer.add(passwordtextfield); privileges

		empEdditer.add(new JLabel("Manager privileges?"));

		empEdditer.add(manprivilegesradiobutton);

		empEdditer.add(new JLabel("Title:"));
		empEdditer.add(titleTextField);

		empEdditer.add(new JLabel("Department:"));
		empEdditer.add(departmentTextField);
		
		empEdditer.add(new JLabel("Reports to:"));
		empEdditer.add(reportsToTextField);
		
		

		JButton subbutton = new JButton("Submit");
		subbutton.addActionListener(new EdditListener());

		GuiManager.addCancelButton(empEdditer);
		empEdditer.add(subbutton);

		return empEdditer;

	}

	static JPanel buildEmployeeRemovePanel(int empID) {
		JPanel EmployeeRemovePanel = new JPanel();
		
		if(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empID) == null){
			
			EmployeeRemovePanel.add(new JLabel("Error entry not found in database. please refresh database."));
			GuiManager.addCancelButton(EmployeeRemovePanel);
			return EmployeeRemovePanel;
		}
		
		
		JLabel removeText = new JLabel();
		JButton Deletebutton = new JButton("Delete");

		if (main.java.com.payrollpartner.Main.loggedinemp == main.java.com.payrollpartner.Main.employeeDatabase.getIndexOfEmployeebyIDNumber(empID)) {
			removeText.setText("You can not remove yourself!");

			Deletebutton.setEnabled(false);
		} else {

			removeText.setText(
					"Are you sure you want to remove " + main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empID) + "?");
			empIDForDelete = empID;

			Deletebutton.addActionListener(new DeleteListener());

		}

		EmployeeRemovePanel.add(removeText);

		GuiManager.addCancelButton(EmployeeRemovePanel);

		EmployeeRemovePanel.add(Deletebutton);

		return EmployeeRemovePanel;
	}

	private static class DeleteListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			main.java.com.payrollpartner.Main.employeeDatabase.removeEmplyeeByID(empIDForDelete);

			/// refreash the database window
			main.java.com.payrollpartner.userinterfaces.GuiManager.secondaryWindow.getContentPane().removeAll();
			main.java.com.payrollpartner.userinterfaces.GuiManager.secondaryWindow.setVisible(false);
			main.java.com.payrollpartner.userinterfaces.GuiManager.mainWindow.getContentPane().removeAll();
			main.java.com.payrollpartner.userinterfaces.GuiManager.mainWindow.add(DatabaseManagementGui.buildDatabaseManagmentPanel(0));

			main.java.com.payrollpartner.userinterfaces.GuiManager.mainWindow.pack();

		}
	}

	private static class EdditListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			// right now we are dealing with a java object but it will be a sql database one
			// day.
			// for that reason we will need to set this up so when we change over we can
			// construc queries.
			// so this may look a bit odd.

			// String query;

			if (empIDForEddit == -1) {// add new employee

				if (manprivilegesradiobutton.isSelected()) {

					main.java.com.payrollpartner.Main.employeeDatabase.addEmployee(new main.java.com.payrollpartner.employees.Manager(
							main.java.com.payrollpartner.Main.employeeDatabase.generateEmplyeeID(), firstNameTextField.getText(),
							lastNameTextField.getText(), passwordtextfield.getText(), titleTextField.getText(), departmentTextField.getText(),true, 123123  ));

				} else {
					main.java.com.payrollpartner.Main.employeeDatabase.addEmployee(new main.java.com.payrollpartner.employees.Associate(
							main.java.com.payrollpartner.Main.employeeDatabase.generateEmplyeeID(), firstNameTextField.getText(),
							lastNameTextField.getText(),  passwordtextfield.getText(),
							titleTextField.getText(), departmentTextField.getText() , false , 14  ));
				}

			} else {/// eddit employee

				if (firstNameTextField.getText()
						.equals(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empIDForEddit).getFirstName())
						&& lastNameTextField.getText()
								.equals(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empIDForEddit).getLastName())) {

					// the input and original name are the same

				} else {

					// System.out.println("not same ");
					main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empIDForEddit).setName(firstNameTextField.getText(),
							lastNameTextField.getText());

					// System.out.println(main.Main.employeeDatabase.getEmployeeByIDNo(empIDForEddit).toString());

					if (genUserNameButton.isSelected()) {// new username

						main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empIDForEddit).setUserName();

					}

				}

				if (!(passwordtextfield.getText().length() == 0) ) {
					main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empIDForEddit).setPasswordHash(passwordtextfield.getText());

				}	
				
				
				if (!titleTextField.getText()
						.equals(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empIDForEddit).getTitle())) {
					main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empIDForEddit).setTitle(titleTextField.getText());

				}

				if (!departmentTextField.getText()
						.equals(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empIDForEddit).getDepartment())) {

					main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empIDForEddit)
							.setDepartment(departmentTextField.getText());
				}
				
				if (!reportsToTextField.getText()
						.equals(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empIDForEddit).getReportsTo())) {

					main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIDNo(empIDForEddit)
							.setReportsTo(reportsToTextField.getText());
				}
				
				
				//TODO add if manprivilegesradiobutton but was checked is unchecked then we need to remove and then recreate as associate;

				//userinterfaces.GuiManager.secondaryWindow.getContentPane().removeAll();
				//userinterfaces.GuiManager.secondaryWindow.setVisible(false);
				//userinterfaces.GuiManager.mainWindow.getContentPane().removeAll();
				//userinterfaces.GuiManager.mainWindow.add(DatabaseManagementGui.buildDatabaseManagmentPanel());

				//userinterfaces.GuiManager.mainWindow.pack();


			}

			/// refreash the database window
			GuiManager.secondaryWindow.getContentPane().removeAll();
			GuiManager.secondaryWindow.setVisible(false);
			GuiManager.mainWindow.getContentPane().removeAll();
			GuiManager.mainWindow.add(DatabaseManagementGui.buildDatabaseManagmentPanel(0));

			GuiManager.mainWindow.pack();

		}
	}

	private static class usernameradiobutnListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			UserNametextfield.setEditable(!genUserNameButton.isSelected());

		}
	}
}
