package src;
/**
 * mainapp
 * mainapp relies on the order class without it, it cannot live --> composition 
 * mainapp also relies on menuitems and setpackage because you want to show it to customers right!
 */
import java.util.*;
//import java.text.SimpleDateFormat;
import java.sql.Timestamp;
public class mainapp {
    //LOOK HERE AND MAKE SURE YOU USE THE CORRECT VARIABLE NAME

    protected static List<MenuItems> MenuList = new ArrayList<>(30);
    protected static List<SetPackage> SPList = new ArrayList<>(30);
    protected static List<Staff> StaffList = new ArrayList<>(30);
    protected static List<Table> TableList = new ArrayList<>(30);

    //everytime you declare the order increment the order number and add it into the list; 
    
    public static void main(String[] args) {
        FileToObject.main(args);
        List<Order> TotalOrders = new ArrayList<>(10000);
        List<Reservation> TotalReservation = new ArrayList<>(10000);
        Scanner sc = new Scanner(System.in);
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date();
        System.out.println("-----------" + new Timestamp(date.getTime()) + "---------------------------");
        int c = 0;
        

        while (c >= 0){
            System.out.println("------------------------------------------------------------------");
            System.out.println("| (1) Create An Order                                             |");
            System.out.println("| (2) Place An Alacarte Order                                     |");
            System.out.println("| (3) Place A Set Package                                         |");
            System.out.println("| (4) View an Order                                               |");
            System.out.println("| (5) Reservation (Make, Remove, Check)                           |");
            System.out.println("| (6) Print Order Invoice                                         |");
            System.out.println("| (7) Manager Access Only (Menu Item, Promotion, Sales Revenue)   |");
            System.out.println("| (8) Close Shop                                                  |");
            System.out.println("-------------------------------------------------------------------");
            c = sc.nextInt();
        switch(c){
            case 1:
                System.out.println("Enter Staff ID: ");
                System.out.println("Enter number of people to be seated in the table"); 
                TotalOrders.add(new Order()); //create the orders 
                //print menu

                System.out.println("Print order");
                //Object attributes of the order to be filled here --> table, staff
                //Date and time to be updated this is NEEDED for case 6 please do not miss it out 
                //initialize total price to 0 for every new order made 
                // You are only allowed to acces the order class 
                break;
            case 2:
                //remember that user cannot do 2 and 3 and 5 without order creation! --> account for exception handling 
                //allowed to access order and menuitems 
                //System.out.println("Printing Menuitems....");
                //create function to print all menuitems 
                //initialize menu items here or at the front or wherever --> parsing in flat file etc.
                System.out.println("Enter in Order Number: ");
                System.out.println("What is your Ala Carte Order...?");
                System.out.println("This is your final order");
                break;
            case 3:
                //allowed to access order and menuitems 
                //initialize setpackage items here or at the fron or wherever --> parsing in flat file etc.
                System.out.println("Enter in Order Number: ");
                System.out.println("What is your Set Package Order...?");
                System.out.println("This is your final order");
                break;
            case 4:
                System.out.println("What order would you like to see?");
                //print the order, note this is different from order invoice because order invoice is print the receipt 
                break;
            case 5:
                //create reservation object --> the entire reservation can one person do only! 
                
                System.out.println("Enter Staff ID: ");
                System.out.println("Enter Name of Customer: ");
                System.out.println("Enter in number of people to be there: ");
                // allocate a table as well 
                // at that time the table becomes reserved
                System.out.println("Enter Date and Time to come to restaurant: ");
                //if there is no table available at that date and time, tell the customer 
                //in the reservation object, enter data and time by date and time DATA TYPE!
                System.out.println("Enter Contact Number: ");
                TotalReservation.add(new Reservation());
                break;
            case 6:
                //get order number 
                //clear table
                //ask if member 
                //since the list is sorted parse the list until the item is not the same thats the quantity 
                //get raw price from order class
                //get 7% GST 
                //get 5% Service tax 
                System.out.println("Are you a member?");
                boolean isMember = sc.nextBoolean();
                if (isMember){
                    System.out.println("You are a Member! You will get a 10% Discount");
                    //minus 10% member discount 
                }
                
                System.out.println("Here is your final invoice");
                System.out.println("-----------" + new Timestamp(date.getTime()) + "------------");
                System.out.println("-------------------------------------------------------------");
                System.out.println("|-------------------- Sally's Burger Town ------------------|");
                System.out.println("|  Staff ID:                                                |");
                System.out.println("|  Items                   | Qty | Unit Price | Total Price |");
                System.out.println("|  Items                   | Qty | Unit Price | Total Price |");
                System.out.println("|  Items                   | Qty | Unit Price | Total Price |");
                System.out.println("|  Total Price :                                            |");
                System.out.println("|  Total GST   :                                            |");
                System.out.println("|  Total Service Tax :                                      |");
                System.out.println("|  Total Member's Discount :                                |");
                System.out.println("|  Total Payable Amount:                                    |");
                System.out.println("|---------------- Thank you for Visiting! ------------------|");
                System.out.println("|----------------- Please do come again! ------------------ |");
                System.out.println("-------------------------------------------------------------");
                    
                //are they a member 
                //call price function in ORDER CLASS
                
                break;
            case 7:
                int count = 0;
                int tryAgain = 1; 
                String securityKey, temp;
                Scanner sc2 = new Scanner(System.in);

                while (count < 3 && tryAgain == 1){
                    System.out.println("Enter Security key: ");
                    securityKey = sc2.nextLine();
                    if(securityKey.equals("OOP")){
                        SecurityAccess newSession = new SecurityAccess();


                    }else{
                        securityKey = "";
                        System.out.println("You are not allowed access! To Try again press 1:");
                        temp = sc2.nextLine();
                        tryAgain = Integer.parseInt(temp);
                        count++;
                    }
                }

                if (tryAgain == 1 && count == 3){
                    System.out.println("You tried too many times. You are a potential threat. Calling manager now....");

                }
                break;
            case 8:

                break;
            default:
                System.out.println("Wrong input! Try Again");
                c = 0;
                break;
        }
        }
        sc.close();
        

    }
}