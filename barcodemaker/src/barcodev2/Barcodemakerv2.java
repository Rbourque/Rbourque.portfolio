package barcodev2;

import java.util.ArrayList;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;

/*
 * 
 * 	This bar code maker was written by Ryan Bourque in February of 2020.
 *	Any questions may be e-mailed to rbourque64@gmail.com.						 
 *  This program was made in eclipse
 */

public class Barcodemakerv2 implements ActionListener, PropertyChangeListener {

	private JFrame frame;

	static gencodes codelist = new gencodes();
	String dir = System.getProperty("user.dir");
	boolean validlen = false;
	boolean validalpha = false;
	String code;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		full();
	}
		
	
	public static void full(){	

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Barcodemakerv2 window = new Barcodemakerv2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Barcodemakerv2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	


	
	public void initialize() {

		// ******************************ui objects*********************

		frame = new JFrame();
		frame.setBounds(100, 100, 754, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ArrayList<String> suportedcodes2 = new ArrayList<String>();// arraylist to fill with the manes of the codes in
																	// gencodes

		for (int i = 0; i != codelist.codelist.length; i++) {

			suportedcodes2.add(codelist.getcode(i).getName());

		}

		String[] suportedcodes = (String[]) suportedcodes2.toArray((new String[suportedcodes2.size()]));

		//JComboBox<String> comboBox = new JComboBox<String>(); //the designer i am
		// using does not like my combo box so i am using a genaric one when i need to
		// edit the gui.
		JComboBox<String> comboBox = new JComboBox<String>(suportedcodes);
		comboBox.setBounds(20, 25, 200, 24);
		frame.getContentPane().add(comboBox);
		comboBox.setSelectedIndex(0);

		

			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(650, 126, 47, 186);
			frame.getContentPane().add(panel_1);

			JLabel lblHeight = new JLabel("Height");
			panel_1.add(lblHeight);
			
			
			ButtonGroup HeightButtons = new ButtonGroup( );
			
			JRadioButton rdbtnA = new JRadioButton("A");
			JRadioButton rdbtnB = new JRadioButton("B");
			JRadioButton rdbtnC = new JRadioButton("C");
			JRadioButton rdbtnD = new JRadioButton("D");
			JRadioButton rdbtnE = new JRadioButton("E");
			
			HeightButtons.add(rdbtnA);
			HeightButtons.add(rdbtnB);
			HeightButtons.add(rdbtnC);
			HeightButtons.add(rdbtnD);
			HeightButtons.add(rdbtnE);
			
			panel_1.add(rdbtnA);
			panel_1.add(rdbtnB);
			panel_1.add(rdbtnC);
			panel_1.add(rdbtnD);
			panel_1.add(rdbtnE);
			
			rdbtnA.setSelected(true);
			

	
		Button save_button = new Button("Save");
		save_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				if(rdbtnA.isSelected() == true)
				{
					System.out.print("A");
				}else if(rdbtnB.isSelected() == true)
				{
					System.out.print("B");
				}else if(rdbtnC.isSelected() == true)
				{
					System.out.print("C");
				}else if(rdbtnD.isSelected() == true)
				{
					System.out.print("D");
				}else if(rdbtnE.isSelected() == true)
				{
					System.out.print("E");
				}
			
			}
			});
			
			
		save_button.setBounds(647, 362, 98, 39);
		frame.getContentPane().add(save_button);

		Button print_button = new Button("Print");
		print_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnA.isSelected() == true)
				{
					System.out.print("A");
				}else if(rdbtnB.isSelected() == true)
				{
					System.out.print("B");
				}else if(rdbtnC.isSelected() == true)
				{
					System.out.print("C");
				}else if(rdbtnD.isSelected() == true)
				{
					System.out.print("D");
				}else if(rdbtnE.isSelected() == true)
				{
					System.out.print("E");
				}
			
			}
		});
		print_button.setBounds(647, 313, 97, 42);
		frame.getContentPane().add(print_button);

		JLabel rulesLable = new JLabel(codelist.getcode(comboBox.getSelectedIndex()).getRules());
		rulesLable.setBounds(20, 40, 460, 101);
		frame.getContentPane().add(rulesLable);

		JFormattedTextField codeTextBox = new JFormattedTextField();
		String rate = "";
		codeTextBox.setValue((rate));
		codeTextBox.setBounds(84, 367, 145, 39);
		frame.getContentPane().add(codeTextBox);

		JLabel lblcode = new JLabel("Code:");
		lblcode.setBounds(12, 379, 70, 15);
		frame.getContentPane().add(lblcode);

		ImageIcon icon = new ImageIcon("/home/dpr/eclipse-workspace/barcodev2/src/barcodev2/Barcodes/Empty.png");


		JLabel slot1 = new JLabel(icon);
		slot1.setBounds(30, 150, 50, 150);
		frame.getContentPane().add(slot1);

		JLabel slot2 = new JLabel(icon);
		slot2.setBounds(60, 150, 50, 150);
		frame.getContentPane().add(slot2);

		JLabel slot3 = new JLabel(icon);
		slot3.setBounds(90, 150, 50, 150);
		frame.getContentPane().add(slot3);

		JLabel slot4 = new JLabel(icon);
		slot4.setBounds(120, 150, 50, 150);
		frame.getContentPane().add(slot4);

		JLabel slot5 = new JLabel(icon);
		slot5.setBounds(150, 150, 50, 150);
		frame.getContentPane().add(slot5);

		JLabel slot6 = new JLabel(icon);
		slot6.setBounds(180, 150, 50, 150);
		frame.getContentPane().add(slot6);

		JLabel slot7 = new JLabel(icon);
		slot7.setBounds(210, 150, 50, 150);
		frame.getContentPane().add(slot7);

		JLabel slot8 = new JLabel(icon);
		slot8.setBounds(240, 150, 50, 150);
		frame.getContentPane().add(slot8);

		JLabel slot9 = new JLabel(icon);
		slot9.setBounds(270, 150, 50, 150);
		frame.getContentPane().add(slot9);

		JLabel slot10 = new JLabel(icon);
		slot10.setBounds(300, 150, 50, 150);
		frame.getContentPane().add(slot10);

		JLabel slot11 = new JLabel(icon);
		slot11.setBounds(330, 150, 50, 150);
		frame.getContentPane().add(slot11);

		JLabel slot12 = new JLabel(icon);
		slot12.setBounds(360, 150, 50, 150);
		frame.getContentPane().add(slot12);

		JLabel slot13 = new JLabel(icon);
		slot13.setBounds(390, 150, 50, 150);
		frame.getContentPane().add(slot13);

		JLabel slot14 = new JLabel(icon);
		slot14.setBounds(420, 150, 50, 150);
		frame.getContentPane().add(slot14);

		JLabel slot15 = new JLabel(icon);
		slot15.setBounds(450, 150, 50, 150);
		frame.getContentPane().add(slot15);

		JLabel slot16 = new JLabel(icon);
		slot16.setBounds(480, 150, 50, 150);
		frame.getContentPane().add(slot16);

		JLabel slot17 = new JLabel(icon);
		slot17.setBounds(510, 150, 50, 150);
		frame.getContentPane().add(slot17);

		JLabel tooLongLable = new JLabel("Too Long.");
		tooLongLable.setBounds(566, 58, 70, 15);
		frame.getContentPane().add(tooLongLable);
		tooLongLable.setVisible(false);

		save_button.setEnabled(false);
		print_button.setEnabled(false);

		JLabel tooShortLable = new JLabel("Too Short");
		tooShortLable.setBounds(576, 85, 70, 15);
		frame.getContentPane().add(tooShortLable);



		Button clear_button = new Button("clear");
		clear_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				code = "";
				codeTextBox.setText("");

				slot1.setIcon(icon);

				slot2.setIcon(icon);

				slot3.setIcon(icon);

				slot4.setIcon(icon);

				slot5.setIcon(icon);

				slot6.setIcon(icon);

				slot7.setIcon(icon);

				slot8.setIcon(icon);

				slot9.setIcon(icon);

				slot10.setIcon(icon);

				slot11.setIcon(icon);

				slot12.setIcon(icon);

				slot13.setIcon(icon);

				slot14.setIcon(icon);

				slot15.setIcon(icon);

				slot16.setIcon(icon);

				slot17.setIcon(icon);
			}
		});
		clear_button.setBounds(346, 367, 98, 39);
		frame.getContentPane().add(clear_button);

		///////////////////////////////////// defauld states

		tooShortLable.setBounds(576, 85, 70, 15);
		frame.getContentPane().add(tooShortLable);

		tooLongLable.setVisible(false);
		tooShortLable.setVisible(false);
		save_button.setEnabled(false);
		print_button.setEnabled(false);
		
		JLabel checkdidgit = new JLabel("0");
		checkdidgit.setBounds(270, 379, 70, 15);
		frame.getContentPane().add(checkdidgit);

//*****		
		JLabel lblTypeTheFirst = new JLabel("Type the first 11 didgits. The last one will be caculated for you.");
		lblTypeTheFirst.setBounds(20, 313, 460, 42);
		frame.getContentPane().add(lblTypeTheFirst);
		
		Button Open_button = new Button("Open");
		Open_button.setEnabled(true);
		Open_button.setBounds(538, 362, 98, 39);
		frame.getContentPane().add(Open_button);
		
//^^^^^^^^^^^^^^^^^^^^^^^^ui objects^^^^^^^^^^^^^^^^^^^^^^^^^^^^^		

//****************************Logic for when key is pressed in codetextbox****************

		
		
		
		KeyListener keyListener = new KeyListener() {

			public void keyPressed(KeyEvent keyEvent) {

			}

			public void keyReleased(KeyEvent keyEvent) {

				logic();
			}
			
			
			
			
			public ImageIcon getBarcodeIcon(String tokens, boolean isNumber) {
				
				
				String dir = System.getProperty("user.dir");
				dir += "/src/barcodev2/Barcodes/";
				
				String Erordir = dir + "Error.png";
				
				
				dir += codelist.getcode(comboBox.getSelectedIndex()).getPng();
				
				if(isNumber == false) {
					dir += "/";
				}
				
				dir += tokens;
				
				ImageIcon iconuse = new ImageIcon(dir);

				File f = new File(dir);

				if (f.exists() && !f.isDirectory()) {

					iconuse = new ImageIcon(dir);

				} else {

					iconuse = new ImageIcon(Erordir);
					

				}
				return iconuse;
				
			}
			
			
			
			
			public void setslot(int slotpos, ImageIcon iconuse) {

				
				switch (slotpos) {
				case 0:
					slot1.setIcon(iconuse);

					break;
				case 1:
					slot2.setIcon(iconuse);
					;
					break;
				case 2:
					slot3.setIcon(iconuse);
					break;
				case 3:
					slot4.setIcon(iconuse);
					;
					break;
				case 4:
					slot5.setIcon(iconuse);
					break;
				case 5:
					slot6.setIcon(iconuse);
					;
					break;
				case 6:
					slot7.setIcon(iconuse);
					break;
				case 7:
					slot8.setIcon(iconuse);
					;
					break;
				case 8:
					slot9.setIcon(iconuse);
					break;
				case 9:
					slot10.setIcon(iconuse);
					break;
				case 10:
					slot11.setIcon(iconuse);
					;
					break;
				case 11:
					slot12.setIcon(iconuse);
					break;
				case 12:
					slot13.setIcon(iconuse);

					break;
				case 13:
					slot14.setIcon(iconuse);
					break;
				case 14:
					slot15.setIcon(iconuse);
					;
					break;
				case 15:
					slot16.setIcon(iconuse);
					break;
				case 16:
					slot17.setIcon(iconuse);
					break;

				default:

					break;
				}
				
			}


			public void logic() {

				try {

					 
					if(codeTextBox.getText().length() == codelist.getcode(comboBox.getSelectedIndex()).getLength()) {
						
						codeTextBox.setText(code);
					}
					
					
					if (code.length() == codelist.getcode(comboBox.getSelectedIndex()).getLength()) {
						if(codeTextBox.getText().length() == codelist.getcode(comboBox.getSelectedIndex()).getLength()-1) {
							code = codeTextBox.getText();
						}
						codeTextBox.setText(code);
					} else {
						
						code = codeTextBox.getText();
					}

				} catch (java.lang.NullPointerException e) {

					code = codeTextBox.getText();
				}

				// System.out.println("code: " + code);

				// evaluate code and use png files to display

				String[] tokens = codelist.getcode(comboBox.getSelectedIndex()).getPatt().split(",");

				// ArrayList<String> pattern = new ArrayList<String>();
				int posincode = 0;
				int utilitpos = 0;
				int slotpos = posincode + utilitpos;

				for (int c = 0; c < tokens.length; c++) {

					if (tokens[c].contains(".")) {

						// display the file with that name in that order.
						// System.out.println("Working Directory = " + System.getProperty("user.dir"));

						// /barcodev2/src/barcodev2/Barcodes/UPC-A/mid.png

						slotpos = posincode + utilitpos;
						
						setslot(slotpos, getBarcodeIcon(tokens[c], false));

						utilitpos += 1;


					} else {

						// we have the name of a directory.
						// if code has a letter or number in that position use that letter or number as
						// the file name in that directory.

						String dir = System.getProperty("user.dir");
						dir += "/src/barcodev2/Barcodes/";
						dir += codelist.getcode(comboBox.getSelectedIndex()).getPng();
						dir += tokens[c];

						try {

							dir += code.charAt(posincode);
							dir += ".png";

							ImageIcon iconuse = new ImageIcon(dir);

							File barcodeicon = new File(dir);

							if (barcodeicon.exists() && !barcodeicon.isDirectory()) {

								iconuse = new ImageIcon(dir);

							} else {
								iconuse = new ImageIcon(
										"/home/dpr/eclipse-workspace/barcodev2/src/barcodev2/Barcodes/Error.png");

							}

							// System.out.println(code.charAt(posincode));

							slotpos = posincode + utilitpos;
							
							
							setslot(slotpos, iconuse);

	

						} catch (java.lang.StringIndexOutOfBoundsException e) {

							// if nothing is typed in for this location yet.
							break;
						}

						// System.out.println(dir);

						posincode += 1;

					}

				}

//we will now test for letters as some codes do not use them.				

				if (codelist.getcode(comboBox.getSelectedIndex()).getIaa() == false) {

					if (code.matches(".*\\D+.*")) {
						// System.out.println("contains something that is not a number");
						validalpha = false;
					} else {
						validalpha = true;
					}

				}

				if (code.length() == codelist.getcode(comboBox.getSelectedIndex()).getLength() - 1) {

					//////////////////////////////////////////////////////////////// calculate check
					//////////////////////////////////////////////////////////////// digit/////////////////////////////
					///////// sum of nums in even positions
					///////// sum of nums in odd positions x 3
					int oddpar = 0;
					int evenpar = 0;
					int wholepar = 0;
					boolean par = false; // false = odd true = even we start at pos 1(represented by position 0 in out
											// code) so its odd so we start false

					

					for (int c = 0; c < code.length(); c++) {

						int codeasint = Integer.parseInt(String.valueOf(code.charAt(c)));

						if (par == false) {
							oddpar += codeasint;
							// System.out.println("odd: " + oddpar);
						} else {
							evenpar += codeasint;
							// System.out.println("eve: " + evenpar);
						}

						par = !par; 

					}

					oddpar = oddpar * 3;

					wholepar = oddpar + evenpar;

					if (wholepar > 10) {

						wholepar = wholepar % 10;
					}

					int lastdig = 0;

					if (wholepar != 0) {

						lastdig = 10 - wholepar;

					}

					System.out.println("checkdigit: " + lastdig);
					
					System.out.println("code: " + code);
					
					checkdidgit.setText(String.valueOf(lastdig));
 			

					////////////////////////////////////////// endclac checkdigit
				}

				if (code.length() > codelist.getcode(comboBox.getSelectedIndex()).getLength()-1) {
					tooLongLable.setVisible(true);
				} else {
					tooLongLable.setVisible(false);
				}

				if (code.length() == codelist.getcode(comboBox.getSelectedIndex()).getLength()-1) {
					validlen = true;
				} else {
					validlen = false;
				} 

				if (validlen == true && validalpha == true) {

					rulesLable.setForeground(Color.black);
					save_button.setEnabled(true);
					print_button.setEnabled(true);

				} else {
					rulesLable.setForeground(Color.red);
					save_button.setEnabled(false);
					print_button.setEnabled(false);

				}

			}// logic

			public void keyTyped(KeyEvent keyEvent) {

			}

		};

		codeTextBox.addKeyListener(keyListener);

		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {


				rulesLable.setText(codelist.getcode(comboBox.getSelectedIndex()).getRules());



				codeTextBox.setText("");
				code = "";
			}
		});

		// ****************************Logic for when key is pressed in


	}
	



	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
