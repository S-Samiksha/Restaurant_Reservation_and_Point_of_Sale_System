package src;
import java.util.*;
import java.sql.Timestamp;


/**
 * Represents a reservation made for this restaurant. 
 * A reservation must have a available staff and table.
 */

public class Reservation {

	/**
	 * The closing hour of this restaurant.
	 */
	public static final int MAX_Time = 2200; 
	/**
	 * Opening hour of this restaurant.
	 */
	public static final int MIN_Time = 1000; 
	/**
	 * Contact number of the customer making this reservation.
	 */
	public static final int MAX_ContactNum = 99999999; 
	/**
	 * Maximum number of customer for this reservation.
	 */
	public static final int MAX_NumPeople = 10; 
	/**
	 * Minimum number of customer for this reservation.
	 */
	public static final int MIN_NumPeople = 2;
	/**
	 * Total number of table in this restaurant.
	 */
	public static final int MAX_Table = 10;
	
	/**
	 * Name of the customer making this reservation.
	 */
	private String customerName; 
	/**
	 * This reservation timing.
	 */
	private Timestamp timestamp;
	/**
	 * Customer contact number for this reservation.
	 * Able to contact the customer when necessary.
	 */
	private int contactNumber;
	/**
	 * Number of customer for this reservation.
	 */
	private int numPeople;
	/**
	 * Table number assignment for this reservation.
	 */
	private int table; 
	/**
	 * ID of the staff taking this reservation.
	 */
	private String staffID;
	/**
	 * Specific ID for this reservation.
	 */
	private int reservationID = -1;
	

	
	
	/**
	 * Creates an instance in the class mainapp.
	 */
	public Reservation(){};

	/**
	 * Creates a new reservation.
	 * @param staffID This Reservation's staff ID.
	 * @param customerName This Reservation's customer name.
	 * @param timestamp This Reservation's start time.
	 * @param contactNumber This Reservation's customer contact number.
	 * @param numPeople This Reservation's number of people.
	 * @param table This Reservation's assigned table.
	 * @param reservationID This Reservation's ID.
	 */
	public Reservation( String staffID, String customerName, Timestamp timestamp , int contactNumber, int numPeople, int table, int reservationID){
		this.customerName = customerName;
		this.timestamp = timestamp;
		this.contactNumber = contactNumber;
		this.numPeople = numPeople;
		this.staffID = staffID;
		this.table = table;
		this.reservationID = reservationID;
	}

	/**
	 * Checks if the staff ID is valid for this reservation.
	 * @param StaffID This reservation's staff ID.
	 * @return Validity of this staff for this reservation.
	 */
	public boolean validateStaffID(String StaffID){
		for (int i = 0 ; i<mainapp.StaffList.size(); i++){
			if (StaffID.equals(mainapp.StaffList.get(i).getEmployeeID())){
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the start time is valid for this reservation.
	 * Ensures this reservation is made within booking hours.
	 * @param currentTime Real time when making this reservation.
	 * @param startTime This reservation's start time.
	 * @param openingTime Opening hour for this restaurant.
	 * @param closingTime Closing hour for this restaurant.
	 * @return Validity of this reservation start time.
	 */
	public boolean validateStartTime(Timestamp currentTime,Timestamp startTime, Timestamp openingTime, Timestamp closingTime){
		if (currentTime.before(startTime)){
			if(startTime.before(closingTime)){
				if((startTime).after(openingTime)){
					System.out.println("Entered date and time are valid!");
					return true;
				}
				else{
					System.out.println("Entered date and time are before booking hours!");
					return false;
				}
			}
			else{
				System.out.println("Entered date and time are after booking hours!");
				return false;
			}
		}
		else{
			System.out.println("Entered date and time have already passed!");
			return false;
		}
	}


	/**
	 * Checks if the number of customer is valid for this reservation.
	 * @param customerPax This reservation's number of customer.
	 * @return Validity of the number of customer for this reservation.
	 */
	public boolean validatecustomerPax(int customerPax){
		if(customerPax >= 2 && customerPax <= 10){
			return true;
		}
		return false;
	}

	/**
	 * Checks if the contact number of the customer is valid for this reservation.
	 * @param contactNumber This reservation's customer contact number.
	 * @return Validity of the customer contact number for this reservation.
	 */
	public boolean validateContactNumber(int contactNumber){
		if (contactNumber >= 1000_0000 && contactNumber <= 99999999){
			return true;
		}
		return false;
	}

	/**
	 * Gets the customer's name for this reservation.
	 * @return This Reservation's customer's name.
	 */
	public String getCustomerName() {
		return this.customerName;
	}

	/**
	 * Prints the information for this reservation.
	 */
	public void printReservation() {
		if(this.getReservationID() == -1) {
			System.out.printf("No reservation yet!\n");
		}
		else{
			System.out.printf("Reservation ID:%d\nName:%s\nTime Of Reservation :%s\nContact Number:%d\nNumber of People:%d\nTable:%d\nStaffID:%s\n",this.getReservationID(),this.getCustomerName(),this.getTimestamp(),this.getContactNumber(), this.getNumPeople(),this.getTable(),this.getStaffID());
		}
	}

	/**
	 * Changes the name of the customer for this reservation.
	 * @param CustomerName This Reservation's customer name.
	 */
	public void setCustomerName(String CustomerName) {
		this.customerName = CustomerName;
			
	}

	/**
	 * Gets this reservation's ID
	 * @return This Reservation's ID
	 */
	public int getReservationID() {
		return this.reservationID;
	}

	/**
	 * Changes the ID of this reservation.
	 * @param ReservationID This Reservation's ID.
	 */
	public void setReservationID(int ReservationID) {
		this.reservationID = ReservationID;
			
	}
	
	/**
	 * Gets the Reservation's start time.
	 * @return This reservation start time.
	 */
	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	/**
	 * Changes the start time of this reservation.
	 * @param Timestamp This Reservation's start time.
	 */
	public void setTimestamp(Timestamp Timestamp) {
		this.timestamp = Timestamp;
	}

	/**
	 * Gets the contact number of the customer for this reservation.
	 * @return This customer contact number.
	 */
	public int getContactNumber() {
		return this.contactNumber ;
	}

	/**
	 * Changes the contact number of the customer of this reservation.
	 * @param ContactNumber This Reservation's customer contact number.
	 */
	public void setContactNumber(int ContactNumber) {
		this.contactNumber = ContactNumber ;
	}

	/**
	 * Gets the number of customer for this reservation.
	 * @return This Reservation's number of customer.
	 */
	public int getNumPeople() {
		return this.numPeople ;
	}

	/**
	 * Changes the number of customer for this reservation.
	 * @param NumPeople This Reservation's number of customer.
	 */
	public void setNumPeople(int NumPeople) {
		this.numPeople = NumPeople;
	}

	/**
	 * Find the available table for reservation.
	 * @param customerPax This Reservation's number of customer.
	 * @return The available table for this reservation.
	 */
	public int FindTable(int customerPax) {
		int i = 0;
		List<Table> tableList = mainapp.TableList;
        for(i=0; i<tableList.size();i++){
			if(tableList.get(i).isAvailable() == true && tableList.get(i).gettableCapacity() >= customerPax){
				tableList.get(i).setisAvailable(false); //change list
				this.table = tableList.get(i).gettableNum(); //get table number
				return tableList.get(i).gettableNum(); //return table number
			}
		}
		return -1;
	}


	/**
	 * Gets the table number for this reservation.
	 * @return This reservation's table number.
	 */
	public int getTableNumber(){
		return this.table;
	}

	/**
	 * Changes the staff ID for this reservation.
	 * @param StaffID This Reservation's staff ID.
	 */
	public void setStaff(String StaffID){
		List<Staff> staffList = mainapp.StaffList;
		for (int i = 0; i< staffList.size();i++){
			if(StaffID.equals(staffList.get(i).getEmployeeID())){
				staffList.get(i).setisAvailable(false);
				this.staffID = StaffID;
				return;
			}
		}
		System.out.println("No Staff with that ID");
	}
	
	/**
	 * Gets the staff ID for this reservation.
	 * @return The Reservation's staff ID.
	 */
	public String getStaffID(){
		return this.staffID;
	}
	
	/**
	 * Changes the table number for this reservation.
	 * @param table This Reservation's table number.
	 */
	public void setTable(int table) {
		this.table = table;
	}
	
	/**
	 * Gets the table number of this reservation.
	 * @return This Reservation's table number.
	 */
	public int getTable(){
		return this.table;
	}
	 	
}
