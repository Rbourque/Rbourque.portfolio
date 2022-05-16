package barcodev2;

import barcodev2.codetype;

public class gencodes {

	

	public barcodev2.codetype upca = new barcodev2.codetype("UPC-A", "UPC-A is a 12 numerical digit code.", 12, false,"UPC-A","quiet.png,se.png,/Left/,/Left/,/Left/,/Left/,/Left/,/Left/,mid.png,/Right/,/Right/,/Right/,/Right/,/Right/,/Right/,se.png,quiet.png");
	public barcodev2.codetype upce = new barcodev2.codetype("UPC-E", "UPC-E is a 6 numerical digit code." , 6 , false, "UPC-E","a");
	
	
	
	
	public codetype[] codelist = {upca,upce};
	
	
	
	public codetype getcode(int c)
	{
		
		
		return codelist.clone()[c];
		
		
	}
	
	public int getlength(){
		
		
		return codelist.length;
	}
	
	
}
