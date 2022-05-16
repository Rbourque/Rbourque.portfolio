package main.java.com.payrollpartner.userinterfaces;
//this deals with what menu to display and when to display it
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.net.URL;

import javax.swing.*;

public class GuiManager {

	static Dimension tenEightyP = new Dimension(1920,1080);
	static Dimension smallbox = new Dimension(500,400);
	
	static JFrame mainWindow = new JFrame("PayrollPartner");
	static JFrame secondaryWindow = new JFrame("PayrollPartner");

	static void addbackbutton(JPanel curentPanel) // generic buttons
	{
		JButton button =new JButton("Back");
				button.addActionListener(new BackListener());
		curentPanel.add(button);
	}

	static void addCancelButton(JPanel curentPanel) {
		JButton button =new JButton("Cancel");
		button.addActionListener(new CancelListener());
		curentPanel.add(button);
	}

	public GuiManager() {

		//working on adding custom icon
		// URL url = new URL("/com/xyz/resources/camera.png");
		// Toolkit kit = Toolkit.getDefaultToolkit();
		// Image img = kit.createImage(url);
		// mainWindow.setIconImage(img);
	
		
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.add(LoginGUI.buildLogin());

		mainWindow.pack();
		mainWindow.setSize(smallbox);
		mainWindow.setVisible(true);
		
		if(main.java.com.payrollpartner.Main.infoOn == 1) {
		JFrame infoframe = new JFrame("PayrollPartner");  // this is a window that would display info for the user like features and logins they can use
		infoframe.add(InfoPanel.buildInfoPanel());
		infoframe.setSize(700,700);
		infoframe.setVisible(true);
		infoframe.pack();
		}
	}

	// action listeners for generic buttons



	private static class BackListener implements ActionListener {

		public  void actionPerformed(ActionEvent event) {

			
			mainWindow.getContentPane().removeAll();
			mainWindow.add(main.java.com.payrollpartner.userinterfaces.MainMenu.buildMainMenu(new JPanel()));
			mainWindow.pack();

		}

	}

	private static class CancelListener implements ActionListener {

		public  void actionPerformed(ActionEvent event) {

			secondaryWindow.getContentPane().removeAll();
			secondaryWindow.setVisible(false);

		}

	}





}
