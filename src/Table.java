package src;
/**
 * Table 
 * 
 * this one also needs flat file  --> create a constructor 
 * 
 */
public class Table {
	private boolean isAvailable = false; // initialize to 0
	private short tableCapacity;
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
	
	public void setisAvailable(boolean available) {
		this.isAvailable = available;
	}

	public boolean isAvailble(){
		return this.isAvailable;
	}

	public int getTableCapacity(){
		return this.tableCapacity;
	}
}
