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
public class Table {
	private boolean isAvailable = false; // initialize to 0
	private int tableCapacity;
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
	
	public Table(int tableNum , int tableCapacity, boolean isAvailable) {
		this.tableNum = tableNum;
		this.tableCapacity = tableCapacity;
		this.isAvailable = isAvailable;
	}

	public void setisAvailable(boolean available) {
		this.isAvailable = available;
	}

	public boolean isAvailable(){
		return this.isAvailable;
	}

	public int gettableCapacity(){
		return this.tableCapacity;
	}

	public int gettableNum(){
		return this.tableNum;
	}





	
}
