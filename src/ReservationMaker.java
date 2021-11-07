/*package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class ReservationMaker {
	
	
	public static void makeReservation(Reservation reservation){
		
		System.out.println("Loading reservation Data......"); 
    	try {
    		String filePath = new File("").getAbsolutePath();
        	FileReader fr = new FileReader(filePath+"/src/data/reservation.txt"); 
			BufferedReader br = new BufferedReader(fr); 
			String line;
			String[] reservationObject; 
			line = br.readLine();
			int numOfLine = 0;
			
        	while(line!= null) { 
            	reservationObject = line.split("[|]"); 
            	Timestamp DateTimeT = Timestamp.valueOf(reservationObject[2]);
				mainapp.ReservationList.add(new Reservation(reservationObject[0], reservationObject[1], DateTimeT,Integer.parseInt(reservationObject[3]),Integer.parseInt(reservationObject[4]),Integer.parseInt(reservationObject[5])));

				line = br.readLine();
				numOfLine++;
        	}
        	
			br.close();
			
			
			Reservation reservation2 = mainapp.ReservationList.get(mainapp.tableNum);
			reservation2.setStaffID(mainapp.staffID);
			reservation2.setCustomerName(mainapp.customerName);
			reservation2.setTimestamp(mainapp.DateTime);
			reservation2.setContactNumber(mainapp.contactNum);
			reservation2.setNumPeople(mainapp.peopleNum);
			
			
			
			FileWriter fw = new FileWriter(filePath+"/src/data/reservation.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int j=0; j<numOfLine ; j++) {
				Reservation reservation1 = mainapp.ReservationList.get(j);
				String DateTimeStr = reservation1.getTimestamp().toString();
				String strReservation = String.valueOf(reservation1.getTableNumber()) + "|" +DateTimeStr +  "|" + String.valueOf(reservation1.getNumPeople()) + "|" + reservation1.getCustomerName() + String.valueOf(reservation1.getContactNumber()) + "|" + String.valueOf(reservation1.getStaffID()) + "|";
				bw.write(strReservation);
				bw.newLine();
			}
			System.out.println("Write reservation Data successful....");
			bw.close();
		}
			

		 catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}*/
