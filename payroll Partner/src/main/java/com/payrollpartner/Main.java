package main.java.com.payrollpartner;

//contains main
public class Main {
	
	public static main.java.com.payrollpartner.databases.EmployeeDatabase employeeDatabase = new main.java.com.payrollpartner.databases.EmployeeDatabase();
	public static int loggedinemp = -1;
	public static int infoOn = 1; // 0 for no pannel, 1 for info pannl
	public static String compBanner = "Use your X company credentials to login.";
	
	public static void main(String[] args) {	
			new main.java.com.payrollpartner.userinterfaces.GuiManager();
	}

}