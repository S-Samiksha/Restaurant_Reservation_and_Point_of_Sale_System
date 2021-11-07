package src;
/**
 * mainapp
 * mainapp relies on the order class without it, it cannot live --> composition 
 * mainapp also relies on menuitems and setpackage because you want to show it to customers right!
 */
import java.util.*;
import java.sql.Timestamp;
import java.io.Console;

public class mainapp {
    //THIS IS A LIST 
    //WE implement list interface using the arraylist 
    //it is a LIST but has functions of arraylist 

    protected static List<MenuItems> MenuList = new ArrayList<>(30);
    protected static List<SetPackage> SPList = new ArrayList<>(30); 
    protected static List<Staff> StaffList = new ArrayList<>(30);
    protected static List<Table> TableList = new ArrayList<>(30);
    protected static List<Order> TotalOrders = new ArrayList<>(10000);
    protected static List<Reservation> ReservationList = new ArrayList<>(30);
    public static int tableNum = -1;
    
	/*public static String staffID;
	public static Timestamp DateTime;
	public static String customerName;
	public static int contactNum;


    	public static int peopleNum;*/
    public static final int MAX_Time = 2200; 
	public static final int MIN_Time = 1000;
    public static int ReservationID = 0;
    public static int OrderID=0;
    
    public static void main(String[] args){
        System.out.println("Restaurant Opening.....");
        FileToObject.staff();
        FileToObject.table();
        FileToObject.MenuItems();
        FileToObject.setPackage();
        FileToObject.Order();
        FileToObject.reservation(); //Error! cannot make static reference to the non static method  
        
        List<Reservation> ReservationList = new ArrayList<>(10000);
        Scanner sc = new Scanner(System.in);
        Date date = new Date();
        System.out.println("-----------" + new Timestamp(date.getTime()) + "---------------------------"); //this is system time 
        int c = 0;
        System.out.println("~~~~~~~~~~~~Welcome to Sally's Burger Town Restaurant!~~~~~~~~~~~~");

        while (c >= 0){
            System.out.println("----------------------------STAFF ACCESS---------------------------");
            System.out.println("| (1) Create An Order                                             |");
            System.out.println("| (2) Place/Remove An item                                        |");
            System.out.println("| (3) View an Order                                               |");
            System.out.println("| (4) Reservation (Make, Remove, Check)                           |");
            System.out.println("| (5) Print Order Invoice                                         |");
            System.out.println("| (6) Manager Access Only (Menu Item, Promotion, Sales Revenue)   |");
            System.out.println("| (7) Close Shop                                                  |");
            System.out.println("-------------------------------------------------------------------");
            c = sc.nextInt();
        switch(c){
            case 1: //SHREYA
                System.out.println("Enter number of people to be seated in the table\n"); 
                int customerpax = sc.nextInt();
                Order case1order = new Order();
                case1order.setStaff();
                String staffFound = case1order.getStaff();

                if (staffFound == ""){
                    System.out.println("No Staff available at the moment!\n");
                }
                else{
                    System.out.printf("Staff %d will be helping you!\n",case1order.getStaff());
                }

                int tableFound = case1order.FindTable(customerpax);
                if (tableFound == 0){
                    System.out.println("No table available at the moment!\n");
                }
                else{
                    System.out.printf("You are allocated to %d\n",case1order.getTable());
                }

                case1order.setOrderID(OrderID);
                System.out.printf("OrderID:%d",case1order.getOrderID());
                case1order.setTimestamp();
                TotalOrders.add(OrderID, case1order);
                OrderID++; // DO NOT EDIT THIS VARIABLE 
                break;

            case 2: //ARUSHI
                int case2orderID;
                System.out.println("Enter your order ID:");
                case2orderID = sc.nextInt();
                Order case2order = TotalOrders.get(case2orderID);
                case2order.printMenu(); //should we add a while loop for cutomer to order mulitple items in one order?
                System.out.println("Enter the menu item number you want to order from the menu: ");
                String menuitem = sc.next(); 
                case2order.addOrder(menuitem , case2order.customerOrder); 
                System.out.println("This is your updated order");
			    case2order.printOrder(case2order.customerOrder);
                break;
            case 3: //MELISE DO THIS
                int case3orderID;
                System.out.println("Enter your order ID:");
                case3orderID = sc.nextInt();
                if(case3orderID ==0){
                    System.out.println("Order does not exist!");
                }
                Order case3order = TotalOrders.get(case3orderID);
                System.out.println("View your order:");
                case3order.printOrder(case3order.customerOrder);
                break;
            case 4: //XINGKUN
                int count = 0;
                System.out.println("Enter Staff ID: ");
                int staffIDint = Integer.parseInt(sc.nextLine());
                String staffID = String.valueOf(staffIDint); //staffID cannot be resolved to a variable

                System.out.println("Enter Name of Customer: ");
                int customerNameint = Integer.parseInt(sc.nextLine());
                String customerName = String.valueOf(customerNameint); //customerName cannot be resolved to a variable

                System.out.println("Enter month (e.g. 01, 02 ...12): ");
                String month = sc.nextLine();
                System.out.println("Enter day (e.g 00, 01, 02..., 21)");
                String day = sc.nextLine();
                String datestr = month + day;
                int dateint = Integer.parseInt(datestr);
                System.out.println("Enter time (e.g 1000, 1030, 1100..., 2200)" + "Valid time is: "+ MIN_Time +"-"+MAX_Time);
                String startTime = sc.nextLine();

                try{
                    int endTimeint = Integer.parseInt(startTime) + 0200;
                    String endTime = "2021-"+month+"-"+day+endTimeint;
                }catch(Exception e){
                    System.out.println("Please enter a valid time. "+ MIN_Time +"-"+MAX_Time);
                    
                }




                System.out.println("Enter in number of people to be there: ");
                int peopleNum = sc.nextInt(); //peopleNum cannot be resolved to a variable

                // allocate a table as well 
                // at that time the table becomes reserved
                System.out.println("Enter Date and Time to come to restaurant: (yyyy-MM-dd-HH-mm)");
                int DateTimeint = Integer.parseInt(sc.nextLine());
                String DateTimestr = String.valueOf(DateTimeint);
                Timestamp DateTime = Timestamp.valueOf(DateTimestr); //DateTime cannot be resolved to a variable


                //if there is no table available at that date and time, tell the customer 
                //in the reservation object, enter data and time by date and time DATA TYPE!
                System.out.println("Enter Contact Number: ");
                int contactNum = sc.nextInt(); //contactNum cannot be resolved to a variable


                int tableNum = Reservation.FindTable(TableList, peopleNum);
                //this is one ReservationList.add <-- thats how you add into list in java
                

                    
                if (tableNum != -1) {
	                //reservation.setTable(tableNum);
                    ReservationList.add(new Reservation(staffID, customerName, DateTime, contactNum, peopleNum, tableNum, ReservationID));
	            // ReservationFTO....
                } else {
	                System.out.println("There is no table available. ");
                }
                ReservationID++;
                break;

            case 5: //MELISE
                int case5orderID;
                System.out.println("Enter your order ID:");
                case5orderID = sc.nextInt();
                if(case5orderID ==0){
                    System.out.println("Order does not exist!");
                }
                Order case5order = TotalOrders.get(case5orderID);
                System.out.println("View your order:");
                
                case5order.printInvoice(case5order.customerOrder); //error! cannot make static reference to non static method
                break;
            
            case 6:
                int tryAgain = 1, choice=0, case6count=0;
                String temp;
                Scanner sc2 = new Scanner(System.in);
                Console cs = System.console();


                while (case6count < 3 && tryAgain == 1){
                    System.out.println("Enter EmployeeID: ");
                    temp = sc2.nextLine();
                    //add in ismanager later

                        System.out.println("Enter Security key: ");

                        char[] securityKey = cs.readPassword();
                        
                            if(securityKey.toString().equals("OOP")){
                                SecurityAccess newSession = new SecurityAccess();
                                do{
                                    newSession.showOptions();
                                    choice = Integer.parseInt(sc2.nextLine());
                                    switch(choice){
                                        case 1:
                                            newSession.createMenu();
                                            break;
                                        case 2:
                                            newSession.updateMenu();
                                            break;
                                        case 3:
                                            newSession.createSet();
                                            break;
                                        case 4:
                                            newSession.updateSet();
                                            break;
                                        case 5:
                                            newSession.removeItem();
                                            break;
                                        case 6:
                                            newSession.totalSales();
                                            break;
                                        case 7:
                                            break;
                                        default:
                                            System.out.println("Wrong Choice!");
                                            choice = 0;
                                    }
                                }while(choice !=7);
                                break;
                            }else{
                                securityKey = null;
                                System.out.println("You are not allowed access! To Try again press 1:");
                                temp = sc2.nextLine(); 
                                tryAgain = Integer.parseInt(temp); 

                                case6count++;
                            }
                        }
                        if (tryAgain == 1 && case6count == 3){
                            System.out.println("You tried too many times. You are a potential threat. Calling manager now....");

                        }
                            System.out.println("You tried too many times. You are a potential threat. Calling manager now....");

                        }
                    
                break;
            case 7:
            
                FileToObject.MenuItemStore();
                FileToObject.SPitemsStore();
                FileToObject.OrderStore();
                c=-1;
                break;

            default:
                System.out.println("Wrong input! Try Again");
                c = 0;
                break;
        }
        }
        sc.close();
        

    }
