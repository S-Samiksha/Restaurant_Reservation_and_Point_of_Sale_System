package src;
import java.util.*; 
import java.sql.Timestamp;

	/**
	 * Represents an order made for each table in the restaurant.
	 * An order must have a item in the menu, a staff and a table.
	 * An order may have a set package. 
	 */
public class Order {
	Scanner sc = new Scanner(System.in);
	/**
	 * Time when this order is been made.
	 */
	private Timestamp timestamp;
	/**
	 * Specific ID for this order.
	 */
	private int orderID;
	/**
	 * ID of the staff assigned to this order.
	 */
	private String staffID; 
	/**
	 * Table number of the table assigned to this order.
	 */
	private int tableNumber;
	/**
	 * Sum of total price for this order.
	 */
	private float totalPrice;
	/**
	 * List of item/set packages for this order.
	 */
	public ArrayList<MenuItems> customerOrder;

	/**
	 * Creates and initializes a new empty order.
	 */
	public Order(){
		this.staffID = new String("");
		this.orderID = 0;
		this.tableNumber = 0;
		this.totalPrice = (float)0;
		this.customerOrder = new ArrayList<MenuItems>(); 
	}
	
	/**
	 * Creates a new order by staff for the customer with details.
	 * @param orderID This Order's ID
	 * 					Should not be changed once set.
	 * @param staffID This Order's assigned staff.
	 * @param tableNumber This Order's assigned table number.
	 * 						Should not be changed once assigned.
	 * @param timestamp This Order's start time.
	 * 					Should not be changed once set.
	 * @param totalPrice This Order's total price.
	 * 					Constantly updates when item/set package is added or removed.
	 * @param customerOrder This Order's list of item/set package.
	 * 						Constantly updates when item/set package is added or removed.
	 */
	public Order(int orderID,String staffID, int tableNumber, Timestamp timestamp,float totalPrice, ArrayList<MenuItems> customerOrder){
		this.staffID = staffID;
		this.orderID = orderID;
		this.tableNumber = tableNumber;
		this.totalPrice = totalPrice;
		this.customerOrder = customerOrder;
		this.timestamp = timestamp;
	}



	/**
	 * Prints the item and set package in this order.
	 */
	public void printOrder() {
		System.out.println("Your Order:\n");
		int i = 0;
		if(this.customerOrder.size() == 0) {
			System.out.printf("No orders yet!\n");
		}
		while (i < this.customerOrder.size()){
			System.out.printf("Order %d: ID:%s Name:%s Type:%s Description:%s Price:$%.2f\n",i+1, customerOrder.get(i).getitemID(), customerOrder.get(i).getName(), customerOrder.get(i).getType(), customerOrder.get(i).getDescription(), customerOrder.get(i).getPrice());
			i++;
		}
	}

	/**
	 * Gets the invoice of this order.
	 */
	public void viewInvoiceOrder(){
		int i = 0;
		if(this.customerOrder.size() == 0){
			System.out.println("No orders yet! \n");
		}
		int count = 0;
		int j = 0;
		int k = 0;
		String temp;
		//to get quantity
		for (j=0;j<this.customerOrder.size();j++){
			temp = this.customerOrder.get(j).getitemID();
			for (k=j; k<this.customerOrder.size();k++){
				if(this.customerOrder.get(k).getitemID().equals(temp)){
				count++;
				}
			}
		}
		while (i<this.customerOrder.size()){
			String line = "  "+count+" "+this.customerOrder.get(i).getName()+" "+this.customerOrder.get(i).getPrice();
			System.out.printf("|  %d %s %f", count, this.customerOrder.get(i).getName(),this.customerOrder.get(i).getPrice());
			for ( int  l = 0; l<55-line.length();l++){
				System.out.printf(" ");
			}
			System.out.printf("|\n");
			i++;
		}
	}
	
	/**
	 * Prints the invoice for this order for the customer.
	 * Prints at check out to show customer item ordered and the total price payable.
	 */
	public void printInvoice(){
		double totalPrice = 0.0;
        double MemberDiscount= 0.0;
        double GSTamount = 0.0;
        double Taxamount = 0.0;
        double PayablePrice = 0.0;

		totalPrice = getPrice();
        System.out.println("Are you a member? Enter 'true' if yes and 'false' is no");
        boolean isMember = Boolean.parseBoolean(sc.nextLine());
        if (isMember){
            System.out.println("You are a Member! You will get a 10% Discount.");
            MemberDiscount = totalPrice*0.1;
            //minus 10% member discount 
        }
 
        GSTamount = totalPrice*0.07;
        Taxamount = totalPrice*0.10;
        PayablePrice = totalPrice - MemberDiscount + GSTamount + Taxamount;
		String staffid = this.getStaff();
		int tableNum = this.getTable();

        System.out.println("Here is your final invoice:\n");
        System.out.println("+------------------" + new Timestamp(System.currentTimeMillis()) + "------------------+"); 
        System.out.println("|-----------------------------------------------------------|"); 
        System.out.println("|--------------------Sally's Burger Town--------------------|"); 
		System.out.println("|----------------------50 Nanyang Avenue--------------------|");
		System.out.println("|----------------------------639798-------------------------|");
		System.out.println("|-------------------------Tel: 98765432 --------------------|");
        System.out.println("|------------------Staff ID: "+ staffid +" Table No.:" + tableNum+"-----------------|");
		viewInvoiceOrder();
        System.out.printf("|  Total Price : SGD$%.2f                                  |\n",totalPrice);
        System.out.printf("|  Total GST : SGD$%.2f                                     |\n",GSTamount);
        System.out.printf("|  Total Service Tax : SGD$%.2f                             |\n",Taxamount);
        System.out.printf("|  Total Member's Discount : SGD$%.2f                       |\n",MemberDiscount);
        System.out.printf("|  Total Payable Amount: SGD $%.2f                         |\n",PayablePrice);
        System.out.println("|---------------- Thank you for Visiting! ------------------|");
        System.out.println("|----------------- Please do come again! ------------------ |");
        System.out.println("+-----------------------------------------------------------+\n");
	}
	 
	/**
	 * Prints the item, price and description in the menu for the customer for this order.
	 */
	public void printMenu(){
		int i = 0;
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Ala Carte Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
		List<MenuItems> menuitems = mainapp.MenuList; 
		class MenuItemsComparator implements Comparator<MenuItems> {
			@Override
			public int compare(MenuItems o1, MenuItems o2) {
				return o2.getType().compareTo(o1.getType());
			}
		}
		Collections.sort(menuitems, new MenuItemsComparator());
		String Type = menuitems.get(0).getType();
		System.out.printf("\n%s\n", Type);
		System.out.printf("----------------------------------------------------------------------------------------------------------\n");
		while (i < menuitems.size()){ 
			if(!Type.equals(menuitems.get(i).getType())){
				Type = menuitems.get(i).getType();
				System.out.printf("\n%s\n", Type);
				System.out.printf("----------------------------------------------------------------------------------------------------------\n");
			}
            System.out.println();
			System.out.printf("ID: %s Name: %s Type: %s       Price: %.2f\n",menuitems.get(i).getitemID(), menuitems.get(i).getName(), menuitems.get(i).getType(),menuitems.get(i).getPrice());
            System.out.printf("Description: %s ", menuitems.get(i).getDescription());
            System.out.println();
            System.out.println("                                                 -----                                                   ");
			i++;
		}
		List<SetPackage> setpackages = mainapp.SPList; 
		Collections.sort(setpackages, new MenuItemsComparator());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Set Package Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		i = 0;
		Type = setpackages.get(0).getType();
		System.out.printf("\n%s\n", Type);
		System.out.printf("----------------------------------------------------------------------------------------------------------\n");
		while (i < setpackages.size()){ 
			if(!Type.equals(setpackages.get(i).getType())){
				Type = setpackages.get(i).getType();
				System.out.printf("\n%s\n", Type);
				System.out.printf("----------------------------------------------------------------------------------------------------------\n");
			}
            System.out.println();
			System.out.printf("ID: %s Name: %s Type: %s Price: %.2f\n",setpackages.get(i).getitemID(), setpackages.get(i).getName(), setpackages.get(i).getType(),setpackages.get(i).getPrice());
            System.out.printf("Description: %s ", setpackages.get(i).getDescription());
            System.out.println();
            System.out.println("                                                 -----                                                   ");
            i++;
		}
        System.out.println("---------------------------------------------------------------------------------------------------------");
	}

	/**
	 * Adds an item with specific quantity for this order.
	 * @param ItemID This Order's newly added item ID.
	 * @param quantity This Order's quantity of the newly added item.
	 */
	public void addOrder(String ItemID, int quantity){
		int ID = Integer.parseInt(ItemID.substring(2).intern());
		List<MenuItems> menuitems = mainapp.MenuList;
		List<SetPackage> setpackages = mainapp.SPList;
		if (ItemID.substring(0,2).intern() == "AC") {
			for (int i = 0 ; i < quantity; i++){
				this.customerOrder.add(menuitems.get(ID-1));
			}
		}
		if (ItemID.substring(0,2).intern() == "SP") {
			for (int i = 0 ; i < quantity; i++){
				this.customerOrder.add(setpackages.get(ID-1));
			}
		}
		System.out.println("Item(s) added successfully");
	}

	/**
	 * Removes an item from this order.
	 * @param orderNumber This Order's removed item ID..
	 */
	public void removeFromOrder(int orderNumber){
		if (this.customerOrder.size() == 0) {
			System.out.printf("Cannot remove from order.\n");
		}
		else {
			this.customerOrder.remove(orderNumber);
			System.out.println("Item removed successfully");
		}
	}
	
	/**
	 * Gets the total price for the order.
	 * @return The total price for this order.
	 * 			Does not include any discount.
	 */
	public float getPrice(){
		float totalPrice = (float)0;
		for (int i = 0; i< this.customerOrder.size();i++) {
			totalPrice += this.customerOrder.get(i).getPrice();
		}
		this.totalPrice = totalPrice;
		return this.totalPrice;
	} 
	

	/**
	 * Changes the order ID for this order.
	 * @param i This Order's ID.
	 * @return This Order's ID.
	 */
	public int setOrderID(int i){
		this.orderID = i;
		return i;
	}

	/**
	 * Gets the order ID for this order.
	 * @return This Order's order ID
	 */
	public int getOrderID(){
		return this.orderID;
	}

	/**
	 * Changes the time accordingly with the real time.
	 */
	public void setTimestamp(){
		this.timestamp = new Timestamp(System.currentTimeMillis());
	}
	 
	/**
	 * Gets the start time for this order.
	 * @return This Order's start time.
	 */
	public Timestamp getTimestamp(){
		return this.timestamp;
	}

	/**
	 * Assigns an available staff to serve this order.
	 */
	public void setStaff(){
		List<Staff> staffList = mainapp.StaffList;
		for (int i = 0; i< staffList.size();i++){ 
			if(staffList.get(i).getisAvailable()){
				this.staffID = staffList.get(i).getEmployeeID();
				return;
			}
		}
		System.out.println("No Available Staff");
	}

	/**
	 * Checks if the number of customer for this order is within the acceptable range.
	 * @param customerPax This Order's number of customer.
	 * @return True for within the acceptable range. False for not within the acceptable range.
	 */
	public boolean validatecustomerPax(int customerPax){
		if(customerPax >= 2 && customerPax <= 10){
			return true;
		}
		return false;
	}
	
	/**
	 * Changes the staff serving this order.
	 * @param StaffID This Order's staff ID.
	 */
	public void setStaff(String StaffID){
		this.staffID = StaffID;
	}

	/**
	 * Gets the ID of the staff serving this order.
	 * @return This Order's staff ID.
	 */
	public String getStaff(){
		return this.staffID;
	}


	/**
	 * Finds a available table for this order.
	 * This order can only be created if there is an empty table.
	 * @param customerPax This Order's number of customer.
	 * @return Table number if a table is found and 0 if no table is found.
	 */
	public int FindTable(int customerPax) {
		List<Table> TableList = mainapp.TableList; 
		int i = 0;
        for(i=0; i<TableList.size();i++){
			if(TableList.get(i).isAvailable() == true && TableList.get(i).gettableCapacity() >= customerPax){
				setTable(TableList.get(i).gettableNum());
				return TableList.get(i).gettableNum();
			}
		}
		return 0;
	}

	/**
	 * Changes the table number for this order.
	 * @param TableNum This Order's table number.
	 */
	public void setTable(int TableNum){
		this.tableNumber = TableNum;
	}

	/**
	 * Gets the table number for this order.
	 * @return This Order's assigned table number.
	 */
	public int getTable(){
		return this.tableNumber;
	}
	/**
	 * Gets the list of item in this order.
	 * @return This Order's list of item.
	 */
	public ArrayList<MenuItems> getOrdersList(){
		return this.customerOrder;
	}

	/**
	 * Gets the date and time for this order.
	 * @return This order's date and time.
	 */
	public Timestamp getDateTime(){
		return this.timestamp;
	}

	/**
	 * Gets the total price for this order.
	 * Subject to change when item is added or removed and when the price of item changed.
	 * @return This Order's total price.
	 */
	public float getTotalprice(){
		return this.totalPrice;
	}
}
