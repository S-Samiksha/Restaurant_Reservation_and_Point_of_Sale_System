package src;

/**
 * Represents a table in the restaurant. 
 * A restaurant can have many tables.
 * A table can only have 1 order or 1 reservation and 1 staff.
 */

public class Table {
	
	/**
	 * Availability of the table.
	 */
	private boolean isAvailable = false; 
	/**
	 * Maximum capacity of the table.
	 */
	private int tableCapacity;
	/**
	 * Specific number/ID given to the table.
	 */
	private int tableNum;
	
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
	 * Table cannot be assignment if the number of customer exceeds the maximum table capacity.
	 * Table capacity can only be changed through security access by authorized personnel as it is fixed to prevent staff from changing. 
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
