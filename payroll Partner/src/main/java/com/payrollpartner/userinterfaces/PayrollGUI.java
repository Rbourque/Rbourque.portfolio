package main.java.com.payrollpartner.userinterfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;




//this window is for displaying statistics about the employee database.
public class PayrollGUI {

	
	
	
	static JPanel buildPayrollPanel() {
		JPanel PayrollPanel = new JPanel(new BorderLayout());
		
		double[] stats = main.java.com.payrollpartner.Main.employeeDatabase.generateStats();
		
		//we need to show all this but for the company
		
		//w-4
		//tax withholdng
		//name address social 
		
		//salaries and wages
		//salaries = fixed ammount per pay period
		//wage = per houre worked
		//gross pay(subtotal before deductions)
		//time worked(for salaries used to calculate over time, used to calculate gross pay for waged employees)
		//overtime pay(some houers get 1.5*wages)
		//benifits contributions(some benifits the employee pays for but are reimbursed)
		//reimbersments
		//additional income(tips commissions or bonuses)
		//net pay(total)
		
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.LINE_AXIS));
		headerPanel.add(new JLabel("Payroll Stats"));
		
		
		
		headerPanel.add(Box.createHorizontalGlue());
		
		//end of header panel
		
		JPanel footerPanel = new JPanel();
		GuiManager.addbackbutton(footerPanel);
		
		//end of footer panel 
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		
	      JPanel totalsPanel, departmentPanel,salariesPanel, wagePanel;
	      totalsPanel = new JPanel(new GridLayout(9,1));
	      
	      
	      String[] statlables = {"Salaried employees:","wage employees","Total man-hours logged this week:","Total Wage payroll:" , "Total salarie payroll:" , "Total over time pay:","Total year to date pay:","Benefits and contribution reimbersments:", "Total payroll for this week:"};
	      
	      for(int c =0;c < stats.length;c++) {
	    	  totalsPanel.add(  new JLabel(   statlables[c]));
	    	  if(c > 1) {
	    		  totalsPanel.add(  new JLabel(   "$" +  stats[c]));  
	    		  
	    	  }else {
	    		  
	    		  totalsPanel.add(  new JLabel(   "" +  stats[c]));  
	    	  }
	    	  
	    	  
	    	  
	      }
	      
	      departmentPanel = new JPanel();
	      //TODO
	      salariesPanel = new JPanel();
	      //TODO
	      wagePanel = new JPanel();
	      //TODO
	      
	      tabbedPane.addTab("Totals ", totalsPanel);
	      tabbedPane.addTab("By Department ", departmentPanel);
	      tabbedPane.addTab("Salaries ", salariesPanel);
	      tabbedPane.addTab("Wages ", wagePanel);
		
		
		//end of tab pannel

		
		PayrollPanel.add(headerPanel,BorderLayout.NORTH);
		PayrollPanel.add(tabbedPane,BorderLayout.CENTER);
		PayrollPanel.add(footerPanel,BorderLayout.SOUTH);
		
		
		return PayrollPanel;
	}
	
	
}
