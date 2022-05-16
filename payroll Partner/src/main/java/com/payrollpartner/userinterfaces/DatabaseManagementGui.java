package main.java.com.payrollpartner.userinterfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

//this is going to be its own menu for database managment

public class DatabaseManagementGui {

	static ArrayList<main.java.com.payrollpartner.employees.Employee> Searcheddatadatabase;
	static JTextField searchTextField = new JTextField("Search");
	int emptofind = -1;
	static JPanel dBManager = new JPanel();

	int startlist = 0;

	static JPanel buildDatabaseManagmentPanel(int searched) {

		// jScrollPane1.setViewportView(new JLabel("Connecting to the database. Please
		// wait...")
		dBManager = new JPanel();
		dBManager.setLayout(new BorderLayout());

		JPanel headerPanel = new JPanel();
		dBManager.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.LINE_AXIS));
		headerPanel.add(new JLabel("Employee Database"));

		Dimension d = new Dimension(200, 25);

		
		searchTextField = new JTextField("Search");
		searchTextField.addFocusListener(new searchTextFieldFocusListener());
		searchTextField.addKeyListener(new searchTextFieldKeyListener());
		searchTextField.setPreferredSize(d);
		headerPanel.add(searchTextField);
		//headerPanel.add(Box.createHorizontalGlue());

		// end of header panel

		JPanel footerPanel = new JPanel();
		GuiManager.addbackbutton(footerPanel);
		JButton addbutton = new JButton("+ Add");
		addbutton.addActionListener(new DatabaseMenuPanelListener());
		footerPanel.add(addbutton);

	
		dBManager.add(footerPanel, BorderLayout.SOUTH);
		dBManager.add(buildtable(searched), BorderLayout.CENTER);
		dBManager.repaint();
		dBManager.revalidate();
		

		
		return dBManager;

	}

	static JScrollPane buildtable(int searched) {

		JScrollPane vertical = new JScrollPane();// the table is made here
		JTextArea textArea = new JTextArea(5, 30);
		textArea.setEditable(false);

		JScrollPane listScroller = new JScrollPane(textArea);
		listScroller.setPreferredSize(new Dimension(1920, 1080));

		DefaultTableModel tableModel = new DefaultTableModel();

		JTable table = new JTable(tableModel);
		table.addMouseListener(new JTableButtonMouseListener(table));

		table.setBackground(Color.white);

		tableModel.addColumn("ID");
		tableModel.addColumn("Name");
		tableModel.addColumn("Title");
		tableModel.addColumn("Department");
		tableModel.addColumn("Reports to");
		tableModel.addColumn("Sallary");
		tableModel.addColumn("Edit");
		tableModel.addColumn("Remove");

		TableCellRenderer buttonRenderer = new JTableButtonRenderer();

		table.getColumn("Edit").setCellRenderer(buttonRenderer);
		table.getColumn("Remove").setCellRenderer(buttonRenderer);

		table.getColumn("ID").setMaxWidth(50);
		table.getColumn("Edit").setMaxWidth(50);
		table.getColumn("Remove").setMaxWidth(50);

		// table.getColumn("Edit").setMaxWidth(17);
		// table.getColumn("Remove").setMaxWidth(17);

		listScroller.setViewportView(table);

		if (Searcheddatadatabase == null || searched == 0) {
			
			Searcheddatadatabase = new ArrayList<main.java.com.payrollpartner.employees.Employee>();

			for (int c = 0; c < main.java.com.payrollpartner.Main.employeeDatabase.getSize(); c++) {

				Searcheddatadatabase.add(main.java.com.payrollpartner.Main.employeeDatabase.getEmployeeByIndex(c));
				
			}
			
		}

		for (int c = 0; c < Searcheddatadatabase.size(); c++) {

			JButton editbtn = new JButton("E");
			editbtn.addActionListener(new DatabaseMenuPanelListener());
			editbtn.addMouseListener(new JTableButtonMouseListener(table));
			editbtn.setName(Integer.toString(Searcheddatadatabase.get(c).getIdNumber()));

			JButton removebtn = new JButton("-");
			removebtn.addActionListener(new DatabaseMenuPanelListener());
			removebtn.addMouseListener(new JTableButtonMouseListener(table));
			removebtn.setName(Integer.toString(Searcheddatadatabase.get(c).getIdNumber()));

			tableModel.insertRow(0,
					new Object[] { Searcheddatadatabase.get(c).getIdNumber(), Searcheddatadatabase.get(c).getFullName(),
							Searcheddatadatabase.get(c).getTitle(), Searcheddatadatabase.get(c).getDepartment(),
							Searcheddatadatabase.get(c).getReportsTo(), Searcheddatadatabase.get(c).getSalaryInfo(),
							editbtn, removebtn });

			
		}

		listScroller.add(vertical);

		return listScroller;
	}

	/*
	 * class ButtonRenderer extends JButton implements TableCellRenderer { public
	 * ButtonRenderer() { setOpaque(true); }}
	 */
	private static class DatabaseMenuPanelListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			switch (((JButton) event.getSource()).getText()) {

			case "Add employee":

				break;
			case "-": // the remove button in the table
				// ( (JButton) event.getSource() ).getName();//this will be the row
				GuiManager.secondaryWindow.getContentPane().removeAll();
				GuiManager.secondaryWindow.add(main.java.com.payrollpartner.userinterfaces.EmployeeEdditer
						.buildEmployeeRemovePanel(Integer.parseInt(((JButton) event.getSource()).getName())));
				// System.out.print(( (JButton) event.getSource() ).getName() );
				GuiManager.secondaryWindow.pack();
				GuiManager.secondaryWindow.setVisible(true);

				break;
			case "E": // the eddit button in the table
				// ( (JButton) event.getSource() ).getName();

				GuiManager.secondaryWindow.getContentPane().removeAll();
				GuiManager.secondaryWindow.add(main.java.com.payrollpartner.userinterfaces.EmployeeEdditer
						.buildEmployeeEdditerPanel(Integer.parseInt(((JButton) event.getSource()).getName())));
				GuiManager.secondaryWindow.pack();
				GuiManager.secondaryWindow.setVisible(true);

				break;
			case "+ Add":
				GuiManager.secondaryWindow.getContentPane().removeAll();
				GuiManager.secondaryWindow.add(main.java.com.payrollpartner.userinterfaces.EmployeeEdditer.buildEmployeeEdditerPanel(-1));
				GuiManager.secondaryWindow.pack();
				GuiManager.secondaryWindow.setVisible(true);
				break;

			}

		}
	}

	//////////////////////// found at:
	//////////////////////// https://stackoverflow.com/questions/13833688/adding-jbutton-to-jtable

	// this is code for managing buttons in a jtable
	public static class JTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private static final String[] COLUMN_NAMES = new String[] { "Id", "Stuff", "Button1", "Button2" };
		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] { Integer.class, String.class, JButton.class,
				JButton.class };

		@Override
		public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override
		public int getRowCount() {
			return 4;
		}

		@Override
		public String getColumnName(int columnIndex) {
			return COLUMN_NAMES[columnIndex];
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return COLUMN_TYPES[columnIndex];
		}

		@Override
		public Object getValueAt(final int rowIndex, final int columnIndex) {
			/* Adding components */
			switch (columnIndex) {
			case 0:
				return rowIndex;
			case 1:
				return "Text for " + rowIndex;
			case 2: // fall through
				/* Adding button and creating click listener */
			case 3:
				final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button),
								"Button clicked for row " + rowIndex);
					}
				});
				return button;
			default:
				return "Error";
			}
		}
	}

	private static class JTableButtonMouseListener extends MouseAdapter {
		private final JTable table;

		public JTableButtonMouseListener(JTable table) {
			this.table = table;
		}

		public void mouseClicked(MouseEvent e) {
			int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
			int row = e.getY() / table.getRowHeight(); // get the row of the button

			/* Checking the row or column is valid or not */
			if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
				Object value = table.getValueAt(row, column);
				if (value instanceof JButton) {
					/* perform a click event */
					((JButton) value).doClick();
				}
			}
		}
	}

	private static class JTableButtonRenderer implements TableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JButton button = (JButton) value;
			return button;
		}
	}

	static class searchTextFieldFocusListener implements FocusListener {

		////// ^^^^^^^^/////////////found at:
		////// https://stackoverflow.com/questions/13833688/adding-jbutton-to-jtable

		// this is code for managing buttons in a jtable

		@Override
		public void focusGained(FocusEvent arg0) {

			if (searchTextField.getText().equals("Search")) {
				searchTextField.setText("");
			}
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			if (searchTextField.getText().length() == 0) {
				searchTextField.setText("Search");
			}

		}

	}

	static class searchTextFieldKeyListener implements KeyListener {

		public void keyPressed(java.awt.event.KeyEvent evt) {
			// we use key released for search

		}

		@Override
		public void keyReleased(KeyEvent arg0) {

			// make array list
			Searcheddatadatabase = main.java.com.payrollpartner.Main.employeeDatabase.searchDatabase(searchTextField.getText());

			// Get the components in the panel
			Component[] componentList = dBManager.getComponents();

			// Loop through the components
			for (Component c : componentList) {

				// Find the components you want to remove
				if (c instanceof JScrollPane) {

					// Remove it
					dBManager.remove(c);
//System.out.println("removed it");
				}
			}

			dBManager.add(buildtable(1), BorderLayout.CENTER);

			// rebuild empDatabase manager with new array list
			dBManager.repaint();
			dBManager.revalidate();
			

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// we use key released for search

		}
	}

}
