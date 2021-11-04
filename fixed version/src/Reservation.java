package src;
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
	//there is a minimum number of 2 people --> account for this 
	

	//Also, when I think about it the following things needs to be added
	/*
	1. reservation of table --> in other words find a table to reserve
	2. One hour before the reservation time the table has to go reserved aka unavailable
	3. addition of two hours to reservation time, the table has to become available again 
	4. it has to be based on system time as in mainapp.java

	line of logic 
	1. when a person enters a data and time you need to convert into date date type and store it as ONE variable known as DateTime
	2. then if DateTime of System == DateTime of Reservation - 1 --> table becomes unavailable (in other words find a table that is available, but also account for what happens if there is no table at all)
	3. if not table is booked the whole day which does make sense 
	4. if DateTime of System == DateTime of Reservation + 1 --> if the person has not checked in --> table become available
	5. if person is still at table after 2 hours, let it be 



	*/

	private String CustomerName;
	private String Date;
	private int Time;
	private int ContactNumber;
	private int NumPeople;
	private int table; //I added this 

	//its int not Int --> idk if this was churned out by visual paradigm but we need to fix it if thats the case 

	public String getCustomerName() {
		return this.CustomerName;
	}

	/**
	 * 
	 * @param CustomerName
	 */
	public void setCustomerName(String CustomerName) {
		//what if customer name is empty??
		this.CustomerName = CustomerName;
	}

	public String getDate() {

		return this.Date;
	}

	/**
	 * 
	 * @param Date
	 */
	public void setDate(String Date) {
		this.Date = Date;
	}

	public int getTime() {
		return this.Time;
	}


	public void setTime(int Time) {
		if (Time > MAX_Time && Time < MIN_Time) {
			System.out.println("Please enter a valid time. ");
		}else {
			this.Time = Time ;
		}
	}

	public int getContactNumber() {
		return this.ContactNumber ;
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
			this.ContactNumber = ContactNumber ;
		}
	}

	public int getNumPeople() {
		return this.NumPeople ;
	}

	public void setNumPeople(int NumPeople) {

		if ( NumPeople > MAX_NumPeople) {
			System.out.println("Sorry, the max numble of people per table is " + MAX_NumPeople);
		}else {
			this.NumPeople = NumPeople;
		}
	}

	public int getTableNumber(){
		return this.table;
	}

	//the reason why i labelled this find is to make things clearer that we are in fact finding a table 
	public void findTable(){
		/*
		Line of logic 
		1. Find a table available at that table -1 to +2 hours of booking time 
		2. If there are no available tables, suggest that they reduce number of people coming 
		*/

	}




	//there was a weird getattribute function definitely visual paradigm got issue 





}