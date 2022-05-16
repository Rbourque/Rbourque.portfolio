package main.java.com.payrollpartner.userinterfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CompanyPolicyGUI {
	
	static JTextField bannerTextField = new JTextField();

	
	static JPanel buildCompanyPolicyPanel() {
	
		JPanel CompanyPolicyPanel = new JPanel();

		CompanyPolicyPanel.add(bannerTextField);
	
		
		GuiManager.addbackbutton(CompanyPolicyPanel);
		return CompanyPolicyPanel; 
	
	
	}
	/*private JPanel buildchban() {
		
		
		JPanel changeBannerPanel = new JPanel();
		changeBannerPanel.setLayout(new GridLayout(3, 1));

		JLabel ban = new JLabel("your curent banner is: " + main.Main.compBanner);
		changeBannerPanel.add(ban);

		
		changeBannerPanel.add(bantextfield);

		JButton subbutton = new JButton("Submit");
		PushListener pushlist = new PushListener();
		subbutton.addActionListener(pushlist);
		changeBannerPanel.add(subbutton);

		guiManager.addbackbutton(changeBannerPanel);
		return changeBannerPanel;
	}*/
	
	
	private class PushListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {



		}

	}
	
}
