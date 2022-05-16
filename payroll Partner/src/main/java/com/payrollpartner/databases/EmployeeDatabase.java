package main.java.com.payrollpartner.databases;

import java.util.ArrayList;
import main.java.com.payrollpartner.employees.*;

public class EmployeeDatabase {

	private ArrayList<Employee> Empdatabase = new ArrayList<Employee>(); // entries to start out
	private double Taxwitholdingspercent = 0.16; // with

	public EmployeeDatabase() {

		this.Taxwitholdingspercent = 0.16;

		
		
		//this code will be replaced with getting the data from a sql database.
		
		////// adds employees so there are some when you start it////////

		Admin emp1 = new Admin("a", "Jackson", "Man", "Jackson Man", null, "Floor Manager", "Operations", "Jackson Man",
				12, true, 18.56, 0, 0, 986, 4476.53, 23, 1000);
		emp1.setPasswordHash("a");
		emp1.setUserName("aa1");

		addEmployee(emp1);

		Manager emp2 = new Manager("JMan", "Jackson", "Man", "Jackson Man", null, "Floor Manager", "Operations",
				"Jackson Man", 12, true, 18.56, 0, 0, 986.23, 4476.53, 23, 1000);

		addEmployee(emp2);

		for (int i = 3; i < 33; ++i) {
			Associate dummyEmp = new Associate("NBlake" + Integer.toString(i), "Fake", "Associate"+ Integer.toString(i), "Fake Associate"+ Integer.toString(i) , null, "floor atendent",
					"Customer Service", "Jackson Man", i, false, 12.56, 14.50, 0, 0, 1476.53, 0, 1000);
			dummyEmp.setReportsTo(emp2);
			addEmployee(dummyEmp);
		}

		for (int i = 33; i < 63; ++i) {
			Manager dummyEmp = new Manager("FSlake" + Integer.toString(i), "fake", "Manager"+ Integer.toString(i), "fake Manager"+ Integer.toString(i) , null, "Manager", "Operations",
					"Jackson Man", i, true, 18.56, 0, 0, 986.23, 4476.53, 23, 1000);
			dummyEmp.setReportsTo(emp2);
			addEmployee(dummyEmp);
		}

		///////////////// ^^^^^will not exist in a later//
		///////////////// version//////////////////////////// */
	}

	public ArrayList<Employee> searchDatabase(String searchqueary) {

		ArrayList<Employee> searchResults = new ArrayList<Employee>();

		for (int c = 0; c < Empdatabase.size(); c++) {

			if (Empdatabase.get(c).getFullName().toLowerCase().contains(searchqueary.toLowerCase())) {
				searchResults.add(Empdatabase.get(c));
				// System.out.println(Empdatabase.get(c).getFullName() + " contains " +
				// searchqueary);
			}

		}

		return searchResults;
	}

	public double[] generateStats() {// will be moved to sql when that is implimented

		int noOfSalariedEmployees = 0;
		int noOfNotSalariedEmployees = 0;
		double hoursthiswek = 0;
		double totalWagePayroll = 0;// the total to be paid for includong wage X hours
		double totalSalPayroll = 0;
		double totalOvertimePay = 0;
		double totalYearToDatePay = 0;
		double benefitsContributions = 0;// these are reimbersments
		double totalNetPay = 0;

		for (int c = 0; c < Empdatabase.size(); c++) {

			if (Empdatabase.get(c).getSalaried()) {
				noOfSalariedEmployees += 1;

				totalSalPayroll += Empdatabase.get(c).getsalariePayPerPeriod();

			} else {
				noOfNotSalariedEmployees += 1;

				totalWagePayroll += Empdatabase.get(c).getNetPay();

			}

			hoursthiswek += Empdatabase.get(c).getHoursthiswek();
			totalOvertimePay += Empdatabase.get(c).getGrossOvertimePay();
			totalYearToDatePay += Empdatabase.get(c).getYearToDatePay();
			benefitsContributions += Empdatabase.get(c).getBenefitsContributions();

			totalNetPay += Empdatabase.get(c).getNetPay();
		}

		double[] stats = { noOfSalariedEmployees, noOfNotSalariedEmployees, hoursthiswek, totalWagePayroll,
				totalSalPayroll, totalOvertimePay, totalYearToDatePay, benefitsContributions, totalNetPay };

		return stats;
	}

	public int generateEmplyeeID() {
		boolean unique = true;
		int min = 100;
		int max = 1000;
		int ID = (int) (Math.random() * (max - min + 1) + min);

		for (int c = 0; c < Empdatabase.size() && unique == true; c++) {

			if (ID == Empdatabase.get(c).getIdNumber()) {

				unique = false;
			}

		}

		if (unique == true) {
			return ID;

		} else {

			return generateEmplyeeID();
		}

	}

	public int addEmployee(Employee employeeToAdd) {

		Empdatabase.add(employeeToAdd);

		return 1;
	}

	public int getSize() {
		return Empdatabase.size();
	}

	public int removeEmplyeeByID(int iDofEmployeetofind) {
		Employee removeditem;

		int index = getIndexOfEmployeebyIDNumber(iDofEmployeetofind);

		removeditem = getEmployeeByIndex(getIndexOfEmployeebyIDNumber(iDofEmployeetofind));

		if (index != -1 && removeditem != null) {

			for (int c = index; c < Empdatabase.size() - 1; ++c) {

				Empdatabase.set(c, Empdatabase.get(c + 1));

			}

			Empdatabase.remove(Empdatabase.size() - 1);

		} else {
			return -1;
		}
		return 1;

	}

	public int getIndexOfEmployeebyIDNumber(int iDNumberToFind) {

		int index = -1;

		for (int c = 0; c < Empdatabase.size(); c++) {

			if (Integer.compare(Empdatabase.get(c).getIdNumber(), iDNumberToFind) == 0) {

				index = c;
			}

		}
		return index;
	}

	public int getIndexOfEmployeebyUsername(String inputuserName) {

		int index = -1;

		for (int c = 0; c < Empdatabase.size(); c++) {

			if (Empdatabase.get(c).getUserName().equals(inputuserName)) {

				index = c;
			}

		}
		return index;
	}

	public Employee getEmployeeByIndex(int index) {/// gives the employee or null if dose not exist

		if (index < 0) {

			return null;

		}
		if (index > -1) {

			return Empdatabase.get(index);

		}

		return null;

	}

	public Employee getEmployeeByIDNo(int empID) {

		for (int i = 0; i < Empdatabase.size(); i++) {
			if (Empdatabase.get(i).getIdNumber() == empID) {
				return Empdatabase.get(i);
			}
		}

		return null;
	}

	public double getTaxwitholdingspercent() {
		return Taxwitholdingspercent;
	}

	public void getTaxwitholdingspercent(double taxwitholdings) {
		this.Taxwitholdingspercent = taxwitholdings;
	}
}