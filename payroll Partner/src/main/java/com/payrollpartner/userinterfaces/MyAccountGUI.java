package main.java.com.payrollpartner.userinterfaces;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


// a gui for managing ones own account
public class MyAccountGUI {

	
	static JPanel buildMyAccountPanel() {
		JPanel myAccountPanel = new JPanel();
		
		
		GuiManager.addbackbutton(myAccountPanel);
		
		return myAccountPanel;
	}
	
	
	
	
	private JPanel buildChangePassword(JPanel ChangePasswordPanel) {
		
		ChangePasswordPanel.setLayout(new GridLayout(5, 2));
		

		
		
		JTextField userNameTextField = new JTextField();
		
		
		JTextField passwordtextfield = new JTextField();
		
		
		JTextField bantextfield = new JTextField();
		
		ChangePasswordPanel.add(new JLabel("newpassunder8characters"));
		ChangePasswordPanel.add(new JLabel("passwordDontMatch"));
		ChangePasswordPanel.add(new JLabel("Enter new password"));
		ChangePasswordPanel.add(userNameTextField);
		ChangePasswordPanel.add(new JLabel("confirm new password"));
		ChangePasswordPanel.add(passwordtextfield);
		ChangePasswordPanel.add(new JLabel("Enter old password"));
		ChangePasswordPanel.add(bantextfield);
		
		GuiManager.addbackbutton(ChangePasswordPanel);
		
		JButton button =new JButton("Submit");
		//button.addActionListener(new changePasswordListener());
		ChangePasswordPanel.add(button);
		
		
		
		return ChangePasswordPanel;
	}
	
	
}
