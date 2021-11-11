package src;
/**
 * Table 
 * 
 * this one also needs flat file  --> create a constructor 

 ---
 table flat file will be better if it is sorted ->  more efficient 
 I alr sorted it but just make sure-> whoever is doing this 
 reason why:
 so for example we have a pax of 4 -> ideally we should give them a four seater table.
 But then imagine our first available table as we iterate through table.txt is 6. 
 Then its not so efficient.

 - shreya xoxo <3
 ---
 * 
 */

/**
 * Represents a table in the restaurant. 
 * A restaurant can have many tables.
 */

public class Table {
	
	/**
	 * Availability of the table.
	 */
	private boolean isAvailable = false; // initialize to 0
	/**
	 * Maximum capacity of the table.
	 */
	private int tableCapacity;
	/**
	 * Specific number/ID given to the table.
	 */
	private int tableNum;
	/*
	max capacity = 10 (in the manual)
	min capacity = 2 (in the manual)
	capacity = even (in the manual)
	setTableCapacity()
	setTableNumber()
	cannot be inside due to security reason. Imagine.... 
	An angry staff knows how we code.... 
	if we can set table number... 
	they can set everything to 0 and sabotage the restaruant so no
	hence, we can only have get methods to mainclass

	*/
	
	/**
	 * Creates a new table for the restaurant.
	 * @param tableNum This Table's number/ID.
	 * @param tableCapacity This Table's maximum capacity.
	 * @param isAvailable This Table's availability.
	 */
	public Table(int tableNum , int tableCapacity, boolean isAvailable) {
		this.tableNum = tableNum;
		this.tableCapacity = tableCapacity;
		this.isAvailable = isAvailable;
	}

	/**
	 * Changes the availability of the table.
	 * Used when customer arrives, leaves and when reservation is being made.
	 * @param available This Table's availability.
	 */
	public void setisAvailable(boolean available) {
		this.isAvailable = available;
	}

	/**
	 * Gets the availability of the table.
	 * Table can only be assignment when it is available.
	 * @return This Table's availability.
	 */
	public boolean isAvailable(){
		return this.isAvailable;
	}

	/**
	 * Gets the maximum capacity of the table.
	 * Table cannot be assignment if the number of customer exits the maximum table capacity.
	 * Table capacity can only be changed through security access by authorized personnel as it is fixed and to prevent staff from changing. 
	 * @return This Table's capacity.
	 */
	public int gettableCapacity(){
		return this.tableCapacity;
	}

	/**
	 * Gets the table number/ID.
	 * Table number can only be changed through security access by authorized personnel as it is fixed and to prevent staff from changing. 
	 * @return This Table's number/ID.
	 */
	public int gettableNum(){
		return this.tableNum;
	}





	
}
