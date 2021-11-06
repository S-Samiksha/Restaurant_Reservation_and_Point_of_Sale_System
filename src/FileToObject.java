package src;


import java.io.*;
//import java.util.Scanner;

//for conversion of flat file into objects 
public class FileToObject {



    public static void main(String args[]){
		//Staff Data might as well print
		//Start Copy here
		System.out.println("Loading Staff Data......"); //Change this to whatever data you are loading 
        try {
            FileReader Staff = new FileReader("data/staff.txt"); //change this to the path file to read the file 
			BufferedReader file = new BufferedReader(Staff); //this is like a scanner but only for text files 
			String line; //create a string called line which will read each line, for staff one line can be "E1|Samiksha|Female|87658987|Waiter"
			String[] staffObject; //then we need to split "E1|Samiksha|Female|87658987|Waiter" based on the |
			line = file.readLine(); //.readline is an inbuilt function enabling you to read the line "E1|Samiksha|Female|87658987|Waiter"
            while(line!= null) { //stop when the line is null meaning no more data left
                staffObject = line.split("[|]"); //remember that it is [|] not |. Why? because we are accounting for an array of string not just a string 
				/*
				"E1|Samiksha|Female|87658987|Waiter" --> this is a string
				["E1", "Samiksha", "Female" , "87658987", "Waiter"] --> this is an array of string split by |
 				*/
				mainapp.StaffList.add(new Staff(staffObject[0], staffObject[1], staffObject[2], Integer.parseInt(staffObject[3]), staffObject[4]));
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

		//end copy here 

		//menu


		//set pack

		//reservation 


		//order

        
    }



    
}

