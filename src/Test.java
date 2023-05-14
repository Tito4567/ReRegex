import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) throws FileNotFoundException, InterruptedException 
	{
		
		File fle = new File("ipaddresses.txt");
		Scanner scn = new Scanner(fle);
		String stg = "";

		do 
		{
			int counter = 0;
			boolean value = false;
			int innerif = 0;
			stg = scn.nextLine();
			
			 
			for (int i = 0; i < stg.length(); i++) 
			{
				String number = "";
				if ((stg.charAt(i) == '.') && ((i != 0) && (stg.length() - 1) != i)) 
				{
					
					for (int j = innerif; j < i; j++) 
					{					
						number += stg.charAt(j);
					}
						
					
					if (number.contains(".")) 
					{
						if(!isNumber(number.substring(number.indexOf('.') + 1))) {break;}// just added
						
						
						value = ((Integer.parseInt((number.substring(number.indexOf('.') + 1))) >= 0)
								&& Integer.parseInt((number.substring(number.indexOf('.') + 1))) <= 255);
						
						//System.out.println(value);
						if(value == true) {counter++;}else {counter--;}
					} else 
					
					{
						if(!isNumber(number.substring(number.indexOf('.') + 1))) {break;}// just added
						
						value = ((Integer.parseInt((number.substring(number.indexOf('.') + 1))) >= 0)
								&& Integer.parseInt((number.substring(number.indexOf('.') + 1))) <= 255);
						
//						System.out.println(value);
						if(value == true) {counter++;}else {counter--;}
					}

					innerif = i;
					
					// Below reads in the last character as long as it is not a '.' 
				} if ((((stg.length() - 1) == i) && (stg.charAt(stg.length() - 1) != '.')) && stg.charAt(0) != '.' ) 
				{
					
					int g = i;
					g++;
					for (int j = innerif; j < g; j++) 
					{
						number += stg.charAt(j);
					}
					
					if(!isNumber(number) && (!number.contains("."))) {break;}
					
					value = ((Integer.parseInt((number.substring(number.indexOf('.') + 1))) >= 0)
							&& Integer.parseInt((number.substring(number.indexOf('.') + 1))) <= 255);

//					System.out.println(value);
					if(value == true) {counter++;}else {counter--;}
				}

			}
			if(counter == 4) {System.out.println(true);}else {System.out.println(false);}

		} while (scn.hasNext());
	}	
	
	public static boolean isNumber(String str) 
	{ 
		  try 
		  {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e)
		  
		  {  
		    return false;  
		  }  
	}
}
