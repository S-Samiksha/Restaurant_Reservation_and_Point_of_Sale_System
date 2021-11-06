package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReservationFTO {
	
	
	public static void table(){
		
		System.out.println("Loading Reservation Data......"); 
    	try {
        	FileReader Table = new FileReader("data/table.txt"); 
			BufferedReader file = new BufferedReader(Table); 
			String line;
			String[] tableObject; 
			line = file.readLine();
        	while(line!= null) { 
            	tableObject = line.split("[|]"); 
				mainapp.TableList.add(new Table(Integer.parseInt(tableObject[0]), Integer.parseInt(tableObject[1]), Boolean.parseBoolean(tableObject[2])));
				/*Giving you more functions if the objects require 
				Integer.parseInt --> convert string to int like that of contact number
				Double.parseDouble --> convert string to double 
				Float.parseFloat --> convert float to double 
				string to date time --> https://www.javatpoint.com/java-string-to-date 
				*/
				line = file.readLine();
        	}

			file.close();
		

		
		} catch (IOException e) {
		e.printStackTrace();
		}


	
}
	
	

}
