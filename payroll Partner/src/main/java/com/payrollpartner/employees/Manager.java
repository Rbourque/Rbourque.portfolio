package main.java.com.payrollpartner.employees;

//import java.util.ArrayList; 

public class Manager extends Employee
 {
	 
	//private ArrayList<String> reportsToMe;
	
	
////as if from db
		public Manager(String string, String string2, String string3, String string4, char [] string5, String string6,
				String string7, String string8, int i, boolean b, double d, double e, int j, double k, double f, int l,
				int m) {
			
			super( string,  string2,  string3,  string4,  string5,  string6,
					 string7,  string8,  i,  b,  d,  e,  j,  k,  f,  l,
					 m);
			
			
	
			
			
			// TODO Auto-generated constructor stub
		}
		
		//as if from adding
		public Manager(int m, String string, String string2, String string3, String string4, String string5,boolean bool, int i) {
			
			super(m , string , string2 , string3 ,	string4 , string5, bool  , i );
			
		}
		
		
		
		
//add array for who reports to them
	 //custom to string that includes reports to me 
}