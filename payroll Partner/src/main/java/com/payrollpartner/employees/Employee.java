package main.java.com.payrollpartner.employees;

//in a three level architecture of accounts there is a Associate than only has control of their own info a manager who can edit associates and an Admin who can manage more setting and the database.

//w-4
//tax withholdng
//name address social 

import java.util.Arrays;

public abstract class Employee {

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

	// we need two different constroctors 1: getting from the database. 2: added via
	// the interface

	// from the database
	public Employee(String IuserName, String IfirstName, String IlastName, String IfullName, char[] IpasswordHash,
			 String Ititle, String Idepartment, String IreportsTo, int IidNumber, boolean Isalaried,
			double IhoursThisWeek, double Iwage, double IgrossOvertimePay, double IsalariePayPerPeriod,
			double IyearToDatePay, double IbenefitsContributions, double InetPay) {	
		
		this.userName = IuserName;
		this.lastName = IlastName;
		
		
		
		this.fullName = IfullName;
		this.passwordHash = IpasswordHash;

		this.title = Ititle;
		this.department = Idepartment;
		this.reportsTo = IreportsTo;
		this.idNumber = IidNumber;
		this.salaried = Isalaried;
		this.hoursThisWeek = IhoursThisWeek;
		this.wage = Iwage;
		this.grossOvertimePay = IgrossOvertimePay;
		 this.salariePayPerPeriod = IsalariePayPerPeriod;
		this.yearToDatePay = IyearToDatePay;
	this.benefitsContributions = IbenefitsContributions;// these are reimbersments
	
		this.netPay = InetPay;
	}

	// from the interface
	public Employee(int inputID, String inputFirstName, String inputLastName, String password, String inputTitle,
			String inputDepartment, boolean Isalaried , int Ipay) {

		
		this.idNumber = inputID;
		
		setName(inputFirstName, inputLastName);
		setUserName();
		
		setPasswordHash(password);
		this.setTitle(inputTitle);
		this.setDepartment(inputDepartment);
		this.salaried = Isalaried;

		if(this.salaried) {
			this.salariePayPerPeriod = Ipay;
			this.wage = 0;
		}else {
			this.wage = Ipay;
			this.salariePayPerPeriod = 0;
		}
		
		this.hoursThisWeek = 0;
		this.grossOvertimePay = 0;
		this.yearToDatePay = 0;
		this.benefitsContributions = 0;
		this.netPay = 0;



	}

	
	//public Employee() {
		//System.out.print("Error");
		//error
		
	//}
	
	public double caculateNetPay() {
		
		if (!this.salaried) {

			this.netPay = (hoursThisWeek * wage);// if salaried wage = 0 so this will do nothing
			if (hoursThisWeek > 40) {
				netPay += (hoursThisWeek - 40) * (wage / 2);
			}

		} else {

			this.netPay = salariePayPerPeriod;

		}
		
		//TODO net pay - taxes
		
		return this.netPay;
		
	}
	
	
	public void setName(String inputFirstName, String inputLastName) {

		this.firstName = Character.toUpperCase(inputFirstName.charAt(0)) + inputFirstName.substring(1);
		this.lastName = Character.toUpperCase(inputLastName.charAt(0)) + inputLastName.substring(1);

		this.fullName = this.firstName + " " + this.lastName;
	}

	public void setUserName() {
		this.userName = firstName.charAt(0) + lastName + idNumber;
	}

	public void setUserName(String username) {// 1 on succeed -1 on fail
		this.userName = username;
		
	}

	public String getSalaryInfo() {/// get more info on what is in a salary


		if (salaried == true) {

			return "Salarie Pay per week: " + this.salariePayPerPeriod;
		} else {
			return "Wage Pay per week: " + this.wage;

		}
		
	}



	public int checkPasswordHash(char[] inputPassword) {///fake password encryption

	

		for (int i = 0; i < inputPassword.length; ++i) {

			inputPassword[i] = (char) (inputPassword[i] + 2);
		}


		if (Arrays.equals(inputPassword, passwordHash)) {
			return 1;
		} else {
			return -1;
		}

	}

	public void setPasswordHash(String newPassword) {

		char[] passwordAsCharArray = newPassword.toCharArray();

		for (int i = 0; i < newPassword.length(); ++i) {

			passwordAsCharArray[i] = (char) (passwordAsCharArray[i] + 2);

		}

		this.passwordHash = Arrays.copyOf(passwordAsCharArray, passwordAsCharArray.length);

	}

	public String getFullName() {
		return this.fullName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String toString() {

		String empData = "ID no: " + getIdNumber() + "\n";
		empData += "Name: " + fullName + "\n";

		empData += "Title: " + getTitle() + "\n";

		empData += "Sallary: " + getSalaryInfo() + "\n";

		return empData;
	}

	public String getUserName() {
		return userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String Ititle) {
		this.title = Character.toUpperCase(Ititle.charAt(0)) + Ititle.substring(1);

	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(main.java.com.payrollpartner.employees.Manager reportsTo) {
		this.reportsTo = reportsTo.getFullName();
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}

	public int getIdNumber() {

		return idNumber;
	}

	public int setIdNumber(int idNumber) {

		if (idNumber > 0) {
			this.idNumber = idNumber;
			return 1;
		} else {
			return -1;
		}

	}

	public double getHoursthiswek() {
		return hoursThisWeek;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getGrossOvertimePay() {
		return grossOvertimePay;
	}

	public double getsalariePayPerPeriod() {
		return salariePayPerPeriod;
	}

	public void setsalariePayPerPeriod(double salarie) {
		this.salariePayPerPeriod = salarie;
	}

	public double getYearToDatePay() {
		return yearToDatePay;
	}

	public double getBenefitsContributions() {
		return benefitsContributions;
	}

	public void setBenefitsContributions(double benefitsContributions) {
		this.benefitsContributions = benefitsContributions;
	}

	public double getNetPay() {
		return netPay;
	}

	public boolean getSalaried() {
		return salaried;
	}

	public void setSalaried(boolean salaried) {
		this.salaried = salaried;
	}

}// end class