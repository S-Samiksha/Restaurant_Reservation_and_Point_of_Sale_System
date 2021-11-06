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


	//create the constructor!
	public Order(){
		staffID = new String("");
		orderID = 0;
		tableNumber = 0;
		totalPrice = (float)0;
		customerOrder = new ArrayList<MenuItems>(); 
	}

	//edit this part according to the  data structure of the menuitems 
	public void printOrder(ArrayList<MenuItems> customerOrder) {
		System.out.println("Your Order:");
		int i = 0;
		if(customerOrder.size() == 0) {
			System.out.printf("No orders yet!\n");
		}
		while (i < customerOrder.size()){
			System.out.printf("Order %d: ID:%s Name:%s Type:%s Description:%s Price:%f\n",i+1, customerOrder.get(i).getitemID(), customerOrder.get(i).getName(), customerOrder.get(i).getType(), customerOrder.get(i).getDescription(), customerOrder.get(i).getPrice());
			i++;
		}
	}

	public void printInvoice(int orderID){
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

        System.out.println("Here is your final invoice");
        System.out.println("-----------" + new Timestamp(date.getTime()) + "------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("|-------------------- Sally's Burger Town ------------------|");
        System.out.println("|  Staff ID:                                                |");
        System.out.println("|  Items                   | Qty | Unit Price | Total Price |");
        System.out.println("|  Items                   | Qty | Unit Price | Total Price |");
        System.out.println("|  Items                   | Qty | Unit Price | Total Price |");
        System.out.println("|  Total Price : "+totalPrice+"                             |");
        System.out.println("|  Total GST   : "+GSTamount+"                              |");
        System.out.println("|  Total Service Tax : "+Taxamount+"                        |");
        System.out.println("|  Total Member's Discount : "+MemberDiscount+"             |");
        System.out.println("|  Total Payable Amount: "+PayablePrice+"                   |");
        System.out.println("|---------------- Thank you for Visiting! ------------------|");
        System.out.println("|----------------- Please do come again! ------------------ |");
        System.out.println("-------------------------------------------------------------");
	}
	
	public void printMenu(ArrayList<MenuItems> menuitems, MenuItems[] setpackages){
		timestamp = new Timestamp(System.currentTimeMillis());
		int i = 0;
		System.out.println("Menu:");
		System.out.println("Ala Carte Menu");
		while (i < menuitems.size()){
			System.out.printf("ID:%s Name:%s Type:%s Description:%s Price:%f\n",menuitems.get(i).getitemID(), menuitems.get(i).getName(), menuitems.get(i).getType(),menuitems.get(i).getDescription(),menuitems.get(i).getPrice());
			i++;
		}
		System.out.println("\nSet Package Menu");
		while (i < setpackages.length){
			System.out.printf("ID:%s Name:%s Type:%s Description:%s Price:%f\n",setpackages[i].getitemID(), setpackages[i].getName(), setpackages[i].getType(),setpackages[i].getDescription(),setpackages[i].getPrice());
			i++;
		}
	}

	public void addOrder(String ItemID,ArrayList<MenuItems> menuitems, MenuItems[] setpackages){
		System.out.println("Select an item to order and enter the ID:");
		String ID = sc.next();
		System.out.println("Enter the quantity");
		int quantity = sc.nextInt();
		if (ID.substring(0,1) == "AC") {
			for (int i = 0 ; i < quantity; i++){
				customerOrder.add(menuitems.get(i-1));
			}
		}
		if (ID.substring(0,1) == "SP") {
			for (int i = 0 ; i < quantity; i++){
				customerOrder.add(setpackages[i-1]);
			}
		}
		System.out.println("Item(s) added successfully");
	}

	public void removeFromOrder(ArrayList<MenuItems> customerOrder){
		printOrder(customerOrder);
		if (customerOrder.size() == 0) {
			System.out.printf("Cannot remove from order.\n");
		}
		else {
			System.out.println("Select an item to remove from order and enter the number:");
			int orderNumber = sc.nextInt();
			customerOrder.remove(orderNumber - 1);
			System.out.println("Item removed successfully");
		}
	}
	
	public float getPrice(ArrayList<MenuItems> customerOrder){
		float totalPrice = (float)0;
		for (int i = 0; i< customerOrder.size();i++) {
			totalPrice += customerOrder.get(i).getPrice();
		}
		this.totalPrice = totalPrice;
		return this.totalPrice;
	} 


	public String getStaff(ArrayList<Staff> StaffList){
		for (int i = 0; i< StaffList.size();i++){
			if(StaffList.get(i).getisAvailable()){
				return this.staffID;
			}
		}
		System.out.println("No Available Staff");
		return " ";
	}



	public int FindTable( ArrayList<Table> TableList, ArrayList<Reservation> ReservationList, int customerPax) {
		//this has to be based on whether table is available
		// //Approach: whenever there is a demand for a table (FindTable is called), we check the reservation list to see what tables need to be blocked at this point in time and consider the rest
		// Collections.sort(ReservationList, Reservation.bystartdate);
		// Collections.sort(ReservationList, Reservation.bystarttime);
		// Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		int i = 0;
		// ok i can only complete this part if reservation is done
        for(i=0; i<TableList.size();i++){
			if(TableList.get(i).isAvailable() == true && TableList.get(i).gettableCapacity() >= customerPax){
				TableList.get(i).setisAvailable(false);
				this.tableNumber = TableList.get(i).gettableNum();
				return TableList.get(i).gettableNum();
			}
		}

		return 1; //this error return type must have --> is it meant to be this 

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


	}

