package barcodev2;

public class codetype {
	

	String Name;				//the name that shows up in the combobox at the top
	String Rulestext;			//rules text justbelow combobox
	

	
	
	/////////////////////////////old we now just use the name for the pnglocation//// make sure the name and folder are the same
	String pngloc;	
		//folder location of .png files for the bar code numbers  
	//
	//for example UPC-A looks like this //UPCA   if you use special characters you must use excape characters in this string
	
	
	
	int Length;					// length of a code of this type
	boolean Isalphaallowed;		//are alpabetical characters allowed in his code
	
	
	
	String Pattern;				// here are the rules for patterns 
								//will make func that will look if it is a file name or a directroy and display in order
								//comas are diliminators   
								//if the car is a filename displays that file
								//if directory matches char added at that point with .png with that name ie( "1" = 1.png  )

	
								//I use directories to sperate gropes of characters. 
								//ex upc-a uses diferent characters on the left and right so i made a left directory and a right directory inside the upc-a folder

	
								//for example upc-a's pattern looks like this. 
								//quiet,se,/Left,/Left,/Left,/Left,/Left,/Left,mid,/Right,/Right,/Right,/Right,/Right,/Right,se,quiet
								

	public codetype(String name, String rules,  int len, boolean iaa, String png ,String pattern ) {
		Name = name;
		Rulestext = rules;
		pngloc = png;			//foldername may not cantain special charaters
		Length = len;
		Isalphaallowed = iaa;
		Pattern = pattern;
		
		
	}
	
	

	
	
	
	public String getName()
	{
		return Name;
	}
	
	public String getRules()
	{
		return Rulestext;
	}
	public String getPng()
	{
	return pngloc;
	}
	public int getLength()
	{
		return Length;
	}
	public boolean getIaa()
	{
		return Isalphaallowed;
	}
	public String getPatt()
	{
		return Pattern;
	}	
	
	
	
	
	
	
	
	

	
	
	
	
}
