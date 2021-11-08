package src;
/**
 * mainapp
 * mainapp relies on the order class without it, it cannot live --> composition 
 * mainapp also relies on menuitems and setpackage because you want to show it to customers right!
 */
import java.util.*;
import java.sql.Timestamp;
import java.io.Console;
import java.io.IOException;

public class mainapp {


    protected static List<MenuItems> MenuList = new ArrayList<>(30);
    protected static List<SetPackage> SPList = new ArrayList<>(30); 
    protected static List<Staff> StaffList = new ArrayList<>(30);
    protected static List<Table> TableList = new ArrayList<>(30);
    protected static List<Order> TotalOrders = new ArrayList<>(10000);
    protected static List<Reservation> ReservationList = new ArrayList<>(30);
    public static int tableNum = -1;
    

    public static final int MAX_Time = 2200; 
	public static final int MIN_Time = 1000;
    public static int ReservationID = 0;
    public static int OrderID = 11;//change later!!!!
    
    public static void main(String[] args) throws IOException{
        System.out.println("Restaurant Opening.....");
        FileToObject.staff();
        FileToObject.table();
        FileToObject.MenuItems();
        FileToObject.setPackage();
        FileToObject.Order();
        //FileToObject.reservation();
        
        List<Reservation> ReservationList = new ArrayList<>(10000);
        Scanner sc = new Scanner(System.in);
        Date date = new Date();
        System.out.println("-----------" + new Timestamp(date.getTime()) + "---------------------------"); 
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
                if (staffFound == ""){ // edit this
                    System.out.println("No Staff available at the moment!\n");
                }
                else{
                    System.out.printf("Staff %s will be helping you!\n",case1order.getStaff());
                }

                int tableFound = case1order.FindTable(customerpax);
                if (tableFound == 0){
                    System.out.println("No table available at the moment!\n");
                }
                else{
                    System.out.printf("You are allocated to %d\n",case1order.getTable());
                }

                case1order.setOrderID(OrderID);
                System.out.printf("OrderID:%d\n",case1order.getOrderID());
                case1order.setTimestamp();
                TotalOrders.add(OrderID, case1order);
                OrderID++; // DO NOT EDIT THIS VARIABLE 
                System.out.printf("%d\n", TotalOrders.size());
                break;

            case 2: //ARUSHI 
                int case2orderID=0;
                int choicecase = 0;
                System.out.println("Enter your order ID:");
                case2orderID = sc.nextInt(); 
                Order case2order = TotalOrders.get(case2orderID);
                do{
                    System.out.println("Enter choice:");
                    System.out.println("(1): Add item to Order");
                    System.out.println("(2): Remove Item From Order ");
                    System.out.println("(3): Exit ");

                    choicecase = sc.nextInt();
                    switch(choicecase){
                        case 1:
                            case2order.printMenu(); 
                            System.out.println("Enter the menu item number you want to order from the menu: ");
                            String menuitem = sc.next(); 
                            case2order.addOrder(menuitem); 
                            System.out.println("This is your updated order");
			                case2order.printOrder();
                            break;
                        case 2:
                            case2order.removeFromOrder();
                            System.out.println("This is your updated order");
			                case2order.printOrder();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Wrong choice!");
                            choicecase = 0;
                    }
                }while(choicecase != 3);
                
                break;
    
            case 3: //MELISE DO THIS
                int case3orderID;
                System.out.println(TotalOrders.get(0));
                System.out.println("Enter your order ID:");
                case3orderID = sc.nextInt();
                try{
                    TotalOrders.get(case3orderID);
                }
                catch(Exception e){
                    System.out.println("Invalid OrderID");
                    break;
                }
                Order case3order = TotalOrders.get(case3orderID);
                System.out.println("View your order:");
                case3order.printOrder();
                
                break;


            case 4: //XINGKUN
               /* //int count = 0;
                int table=0;
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
                int peopleNum = sc.nextInt();
                System.out.println("Enter Date and Time to come to restaurant: (yyyy-MM-dd HH:mm:ss)");
                int DateTimeint = Integer.parseInt(sc.nextLine());
                String DateTimestr = String.valueOf(DateTimeint);
                Timestamp DateTime = Timestamp.valueOf(DateTimestr); 
                System.out.println("Enter Contact Number: ");
                int contactNum = sc.nextInt();
                int tableNum = ReservationList.get(ReservationID).FindTable(peopleNum);
                
                if (tableNum != -1 ) {
                    for (int i=0; i <= ReservationID; i++){
                        Timestamp check = ReservationList.get(i).getTimestamp(); //Error here!!! i cannot be resolved to a variable 
                        if (check.after(DateTime) && check.before(DateTime)){
                            System.out.println("There is no table available. Please change pax/time");
                        }
                    }
                    ReservationList.add(new Reservation(staffID, customerName, DateTime, contactNum, peopleNum, tableNum, ReservationID));
                        
                } else {
	                System.out.println("There is no table available. Please change pax/time");
                }
                ReservationID++;*/
                break;

            case 5: //MELISE
                int case5orderID;
                System.out.println("Enter your order ID:");
                case5orderID = sc.nextInt();
                Order case5order = TotalOrders.get(case5orderID);
                System.out.println("View your order:");
                
                case5order.printInvoice(); 
                break;
            
            case 6:
                int tryAgain = 1, choice=0, count=0;
                String temp;
                Scanner sc2 = new Scanner(System.in);
                Console cs = System.console();
                while (count < 3 && tryAgain == 1){
                    System.out.println("Enter EmployeeID: ");
                    temp = sc2.nextLine();
                    //add in ismanager later

                        System.out.println("Enter Security key: ");

                        String securityKey = sc2.nextLine();
                        
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

                                count++;
                            }
                        }
                        if (tryAgain == 1 && count == 3){
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
                for (int i=0; i<TotalOrders.size();i++){
                    System.out.println(TotalOrders.get(i).getOrdersList());
                }
                System.out.println("Wrong Input Try Again!");
                c=0;
                break;
        }
        
      

    }
    }
 
        
    }
