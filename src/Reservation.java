package src;
import java.util.*;
import java.sql.Timestamp;
import java.io.*;
/**
 * Reservation has a table relationship (reservation cannot live without table in other words its a composition update it in the class diagram)
 * this one missing STAFF 
 * cannot survive without staff so composition relationship 
 * 
 */


public class Reservation {

	public static final int MAX_Time = 2200; 
	public static final int MIN_Time = 1000; //is this the opening time?? 

	public static final int MAX_ContactNum = 99999999; 
	public static final int MAX_NumPeople = 10; 
	public static final int MAX_Table = 10;
	//there is a minimum number of 2 people --> account for this 
	

	//Also, when I think about it the following things needs to be added
	/*
	1. reservation of table --> in other words find a table to reserve
	2. two hour before the reservation time the table has to go reserved aka unavailable
	3. addition of two hours to reservation time, the table has to become available again 
	4. it has to be based on system time as in mainapp.java

	line of logic 
	1. when a person enters a data and time you need to convert into date date type and store it as ONE variable known as DateTime
	2. then if DateTime of System == DateTime of Reservation - 2 --> table becomes unavailable (in other words find a table that is available, but also account for what happens if there is no table at all)
	3. if not table is booked the whole day which does make sense 
	4. if DateTime of System == DateTime of Reservation + 15 min --> if the person has not checked in --> table become available
	5. if person is still at table after 2 hours, let it be --> this part book till end


	cap to 3 tables a day 
	*/

	private String customerName; //change to lower camel case
	private Timestamp timestamp;
	private int contactNumber;
	private int numPeople;
	private int table; //I added this 
	private String staffID;
	private int reservationID;
	
	public Reservation( String staffID, String customerName, Timestamp timestamp , int contactNumber, int numPeople, int table, int reservationID){
		this.customerName = customerName;
		this.timestamp = timestamp;
		this.contactNumber = contactNumber;
		this.numPeople = numPeople;
		this.staffID = staffID;
		this.table = table;
		this.reservationID = reservationID;
	}

	//its int not Int --> idk if this was churned out by visual paradigm but we need to fix it if thats the case 

	public String getCustomerName() {
		return this.customerName;
	}

	/**
	 * 
	 * @param CustomerName
	 */
	public void setCustomerName(String CustomerName) {
		this.customerName = CustomerName;
			
	}
	



	public int getReservationID() {
		return this.reservationID;
	}

	public void setReservationID(String ReservationID) {
		this.reservationID = reservationID;
			
	}

	
	
	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	/**
	 * 
	 * @param CustomerName
	 */

	public void setTimestamp(Timestamp Timestamp) {
		this.timestamp = Timestamp;
	}

	

	public int getContactNumber() {
		return this.contactNumber ;
	}

	/**
	 * 
	 * @param ContactNumber
	 */
	public void setContactNumber(int ContactNumber) {
		// what if the number is EQUAL 9999 99999 (need to consider so I added the =)
		if ( ContactNumber >= MAX_ContactNum) {
			System.out.println("Please enter a valid contact number. ");
		}else {
			this.contactNumber = ContactNumber ;
		}
	}

	public int getNumPeople() {
		return this.numPeople ;
	}

	public void setNumPeople(int NumPeople) {

		if ( NumPeople > MAX_NumPeople) {
			System.out.println("Sorry, the max numble of people per table is " + MAX_NumPeople);
		}else {
			this.numPeople = NumPeople;
		}
	}

	public static int FindTable(List<Table> TableList, int customerPax) {
		int i = 0;
        for(i=0; i<TableList.size();i++){
			if(TableList.get(i).isAvailable() == true && TableList.get(i).gettableCapacity() >= customerPax){
				TableList.get(i).setisAvailable(false); //change list
				this.table = TableList.get(i).gettableNum(); //get table number
				return TableList.get(i).gettableNum(); //return table number
			}
		}
		return 0;
	}

	public List ReservationMaker(String staffID, String customerName, Timestamp timestamp , int contactNumber, int numPeople, int table, int reservationID){
		Reservation.get(tableNum).setStaffID(staffID);
		this.reservation();
	}

	public int getTableNumber(){
		return this.table;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	
	public String getStaffID(){
		return this.staffID;
	}
	
	public void setTable(int table) {
		this.table = table;
	}
	
	public int getTable(){
		return this.table;
	}
	 	
}
