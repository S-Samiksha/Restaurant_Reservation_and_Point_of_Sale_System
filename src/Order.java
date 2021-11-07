package src;
import java.util.*; 
import java.sql.Timestamp;

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
	private Timestamp timestamp;
	private int orderID;
	private String staffID; 
	private int tableNumber;
	private float totalPrice;
	public ArrayList<MenuItems> customerOrder;

	public Order(){
		this.staffID = new String("");
		this.orderID = 0;
		this.tableNumber = 0;
		this.totalPrice = (float)0;
		this.customerOrder = new ArrayList<MenuItems>(); 
	}
	//create the constructor!
	public Order(int orderID,String staffID, int tableNumber, Timestamp timestamp,float totalPrice, ArrayList<MenuItems> customerOrder){
		this.staffID = staffID;
		this.orderID = orderID;
		this.tableNumber = tableNumber;
		this.totalPrice = totalPrice;
		this.customerOrder = customerOrder;
		this.timestamp = timestamp;
	}


	//edit this part according to the  data structure of the menuitems 
	public void printOrder() {
		System.out.println("Your Order:");
		int i = 0;
		if(this.customerOrder.size() == 0) {
			System.out.printf("No orders yet!\n");
		}
		while (i < this.customerOrder.size()){
			System.out.printf("Order %d: ID:%s Name:%s Type:%s Description:%s Price:%f\n",i+1, customerOrder.get(i).getitemID(), customerOrder.get(i).getName(), customerOrder.get(i).getType(), customerOrder.get(i).getDescription(), customerOrder.get(i).getPrice());
			i++;
		}
	}


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
			System.out.printf("|%d %s %f| \n", count, this.customerOrder.get(i).getName(),this.customerOrder.get(i).getPrice());
			i++;
		}
	}

	public void printInvoice(){
		//shift everything over from mainapp
		//based on orderID, retrieve price and items fron order.txt
		//either we do this by a per order basis--> not very good because this means when we create other order this screws up
		//or we do this by order id, which means when we need to printinvoice then we retrive by order basis based on orderID
		//^^ method 2 is better i think... but need to think about how to do this--> need to get filetobject up first
		//then would be able to correctly retrieve from data which is orderID which is menuItem which is price etc
		//hencce this functions runs differently from other functions in order.java 
		
		double totalPrice = 0.0;
        double MemberDiscount= 0.0;
        double GSTamount = 0.0;
        double Taxamount = 0.0;
        double PayablePrice = 0.0;

		totalPrice = getPrice();
        System.out.println("Are you a member?");
        boolean isMember = sc.nextBoolean();
        if (isMember){
            System.out.println("You are a Member! You will get a 10% Discount");
            MemberDiscount = totalPrice*0.1;
            //minus 10% member discount 
        }
 
        GSTamount = totalPrice*0.07;
        Taxamount = totalPrice*0.10;
        PayablePrice = totalPrice - MemberDiscount + GSTamount + Taxamount;
		String staffid = this.getStaff();
		int tableNum = this.getTable();
		Date date = new Date();

        System.out.println("Here is your final invoice");
        System.out.println("-----------" + new Timestamp(System.currentTimeMillis()) + "------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("|-------------------- Sally's Burger Town ------------------|");
		System.out.println("|----------------------50 Nanyang Avenue--------------------|");
		System.out.println("|----------------------------639798-------------------------|");
		System.out.println("|-------------------------Tel: 98765432 --------------------|");
        System.out.println("|  Staff ID: "+ staffid +"Table No.:" + tableNum+"          |");
		viewInvoiceOrder();
        System.out.println("|  Total Price : SGD"+totalPrice+"                          |");
        System.out.println("|  Total GST   : SGD"+GSTamount+"                           |");
        System.out.println("|  Total Service Tax : SGD"+Taxamount+"                     |");
        System.out.println("|  Total Member's Discount : SGD "+MemberDiscount+"         |");
        System.out.println("|  Total Payable Amount: SGD "+PayablePrice+"               |");
        System.out.println("|---------------- Thank you for Visiting! ------------------|");
        System.out.println("|----------------- Please do come again! ------------------ |");
        System.out.println("-------------------------------------------------------------");
	}
	
	public void printMenu(){
		int i = 0;
		System.out.println("Menu:");
		System.out.println("Ala Carte Menu");
		List<MenuItems> menuitems = mainapp.MenuList; 
		while (i < menuitems.size()){ 
			System.out.printf("ID:%s Name:%s Type:%s Description:%s Price:%f\n",menuitems.get(i).getitemID(), menuitems.get(i).getName(), menuitems.get(i).getType(),menuitems.get(i).getDescription(),menuitems.get(i).getPrice());
			i++;
		}
		List<SetPackage> setpackages = mainapp.SPList; 
		System.out.println("\nSet Package Menu");
		i = 0;
		while (i < setpackages.size()){ 
			System.out.printf("ID:%s Name:%s Type:%s Description:%s Price:%f\n",setpackages.get(i).getitemID(), setpackages.get(i).getName(), setpackages.get(i).getType(),setpackages.get(i).getDescription(),setpackages.get(i).getPrice());
			i++;
		}
	}

	public void addOrder(String ItemID){
		int ID = Integer.parseInt(ItemID.substring(2).intern());
		System.out.println("Enter the quantity");
		int quantity = sc.nextInt();
		List<MenuItems> menuitems = mainapp.MenuList;
		List<SetPackage> setpackages = mainapp.SPList;
		if (ItemID.substring(0,2).intern() == "AC") {
			for (int i = 0 ; i < quantity; i++){
				this.customerOrder.add(menuitems.get(ID-1));
				//System.out.printf("%d\n",menuitems.get(i-1).getName());
			}
		}
		if (ItemID.substring(0,2).intern() == "SP") {
			for (int i = 0 ; i < quantity; i++){
				this.customerOrder.add(setpackages.get(ID-1));
			}
		}
		System.out.println("Item(s) added successfully");
	}

	public void removeFromOrder(){
		printOrder();
		if (this.customerOrder.size() == 0) {
			System.out.printf("Cannot remove from order.\n");
		}
		else {
			System.out.println("Select an item to remove from order and enter the number:");
			int orderNumber = sc.nextInt();
			this.customerOrder.remove(orderNumber - 1);
			System.out.println("Item removed successfully");
		}
	}
	
	public float getPrice(){
		float totalPrice = (float)0;
		for (int i = 0; i< this.customerOrder.size();i++) {
			totalPrice += this.customerOrder.get(i).getPrice();
		}
		this.totalPrice = totalPrice;
		return this.totalPrice;
	} 
	
	public int setOrderID(int i){
		this.orderID = i;
		return i;
	}
	public int getOrderID(){
		return this.orderID;
	}
	public void setTimestamp(){
		this.timestamp = new Timestamp(System.currentTimeMillis());
	}
	 
	public Timestamp getTimestamp(){
		return this.timestamp;
	}
	public void setStaff(){
		List<Staff> staffList = mainapp.StaffList;
		for (int i = 0; i< staffList.size();i++){ 
			if(staffList.get(i).getisAvailable()){
				staffList.get(i).setisAvailable(false);
				this.staffID = staffList.get(i).getEmployeeID() ;
				return;
			}
		}
		System.out.println("No Available Staff");
	}

	public String getStaff(){
		return this.staffID;
	}


	public int FindTable(int customerPax) {
		List<Table> TableList = mainapp.TableList; //Error! No protected inside a method of a class
		int i = 0;
        for(i=0; i<TableList.size();i++){
			if(TableList.get(i).isAvailable() == true && TableList.get(i).gettableCapacity() >= customerPax){
				TableList.get(i).setisAvailable(false);
				this.tableNumber = TableList.get(i).gettableNum();
				return TableList.get(i).gettableNum();
			}
		}
		return 0;
	}

	public int getTable(){
		return this.tableNumber;
	}

	public ArrayList<MenuItems> getOrdersList(){
		return this.customerOrder;
	}

	public Timestamp getDateTime(){
		return this.timestamp;
	}

	public float getTotalprice(){
		return this.getTotalprice();
	}
}



