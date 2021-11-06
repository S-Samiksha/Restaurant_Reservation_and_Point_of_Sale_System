package src;
import java.util.*; 
//import java.text.SimpleDateFormat;
//import java.sql.Timestamp;

/**
 * Order
 * this one is reliant on menu items and setpackage 
 * in fact it can live without set package aggregation relationship
 * but cannot live without menuitems if not what kind of order is that? so it is a composition relationship update the class diagram 
 * in addition order CANNOT live without staff and table.
 * if you order, but dont have table. the customer will end up having to stand? --> composition relationship
 * You also need a staff --> this is also a must in other words also a composition relationship
 * 
 */
public class Order {
	Scanner sc = new Scanner(System.in);
	//use the timestamp and date class in java.utils and java.sql it commented out 
	//private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private String staffID; 
	private int tableNumber;
	private float totalPrice;
	//date time 
	ArrayList<String> ItemList = new ArrayList<String>(); //put in the itemID everytime an item is added, you automatically add to the total price --> privately 
	//private Date date; 
	//private int i=0;


	//create the constructor!
	public Order(){
		

	}

	public void addOrder(String ItemID){
		/*
		1. check the first two letters 
		2. add the price into total price automatically!!! 
		3. add sorted list! that will help to calculate total quantity without needing a quantity attribute
		*/
		//you can choose to bring the main app stuff here for easier coding collapsing the switch case 2 and 3 
		ItemList.add(ItemID);


	}

	public float getPrice(){
		return this.totalPrice;
	}

	//the other set staff get staff
	//set table if available etc. 

	public String getStaff() {

		return this.staffID;
	}



	public void FindTable() {
		//this has to be based on whether table is available you cannot just put the table number there 
	}

	public int getTable(){
		return this.tableNumber;
	}

	public void removeFromOrder(String MenuItems) { //pass in the item to be removed

		// remember this isnt just menu items, the person can order a mix or ala carte and promotional items 
		int i = 0;
		int size;
		size = ItemList.size(); //get size of array //its wrong by the way, the debugger says "length cannot be resolved is not a field java"
		for (i =0; i<size;i++) { //point at every item to find a match
			if(ItemList.get(i) == MenuItems) {
				//remove that item
			}else {
				System.out.println("Item cannot be removed.");
			}
		}
		System.out.println("Order removed.");
		

		
	}





}