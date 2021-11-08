package src;
/**
 * mainapp
 * mainapp relies on the order class without it, it cannot live --> composition 
 * mainapp also relies on menuitems and setpackage because you want to show it to customers right!
 */
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
    /// change according to number of lines in data.txt
    public static int ReservationID = 3;
    public static int OrderID = 11;
    
    public static void main(String[] args) throws IOException{
        System.out.println("Restaurant Opening.....");
        FileToObject.staff();
        FileToObject.table();
        FileToObject.MenuItems();
        FileToObject.setPackage();
        FileToObject.Order();
        FileToObject.reservation();
        
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
                boolean reservationFound = false;
                System.out.println("Have you reserved a table? Enter true or false.\n"); 
                Boolean reserved = sc.nextBoolean();
                if(reserved){
                    System.out.println("Please enter your Reservation ID:\n");
                    int reservationID = sc.nextInt();
                    for(int i=0; i<mainapp.ReservationList.size();i++){
                        if(mainapp.ReservationList.get(i).getReservationID() == reservationID){
                            System.out.println("Reservation found!\n");
                            Order reservationOrder = new Order();
                            reservationOrder.setOrderID(OrderID);
                            reservationOrder.setStaff(mainapp.ReservationList.get(i).getStaffID());
                            reservationOrder.setTimestamp();
                            reservationOrder.setTable(mainapp.ReservationList.get(i).getTable());
                            TotalOrders.add(OrderID, reservationOrder);
                            OrderID++; // DO NOT EDIT THIS VARIABLE 
                            mainapp.ReservationList.remove(i);
                            System.out.printf("OrderID:%d\n",reservationOrder.getOrderID());
                            reservationFound =true;
                        }
                    }

                }
                if(reservationFound){
                    break;
                }
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
            /// MAJOR EDITS 
                int choicecase4 = 0;
                do{
                    System.out.println("Enter choice:");
                    System.out.println("(1): Make a Reservation");
                    System.out.println("(2): Remove a Reservation");
                    System.out.println("(3): Check a Reservation");
                    System.out.println("(4): Exit");
                    choicecase4 = sc.nextInt();
                    switch(choicecase4){
                        case 1:
                            System.out.println("Enter Staff ID: ");
                            String staffID = sc.next();
                            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                            System.out.printf("The current time is %s\n", currentTime);
                            
                            System.out.println("Enter Name of Customer:");
                            String customerName = sc.next();
                            Timestamp startTime = new Timestamp(System.currentTimeMillis());
                            startTime.setTime(0);
                            boolean setDate = false;
                            sc.nextLine();
                            while(!setDate){
                                try{
                                    System.out.println("Enter a Reservation Date and Time:\nformat:yyyy-MM-dd HH:mm:ss\nBooking Hours: 10:00:00 - 20:00:00");
                                    String Date = sc.nextLine();
                                    startTime = Timestamp.valueOf(Date); 
                                    SimpleDateFormat getDate = new SimpleDateFormat("yyyy-MM-dd");
                                    String currentDate = getDate.format(startTime);
                                    Timestamp closingTime = Timestamp.valueOf(currentDate+" 20:01:00");
                                    Timestamp openingTime = Timestamp.valueOf(currentDate+" 9:59:00");

                                    if (currentTime.before(startTime)){
                                        if(startTime.before(closingTime)){
                                            if((startTime).after(openingTime)){
                                                System.out.println("Entered date and time are valid!");
                                                setDate = true;
                                            }
                                            else{
                                                System.out.println("Entered date and time are before booking hours!");
                                            }
                                        }
                                        else{
                                            System.out.println("Entered date and time are after booking hours!");
                                        }
                                    }
                                    else{
                                        System.out.println("Entered date and time have already passed!");
                                    }
                                }
                                catch(Exception e){
                                    System.out.println("Enter a valid date and time in yyyy-MM-dd HH:mm:ss format!");
                                }
                            }
                            System.out.print("Enter the number of people to be there:");
                            int peopleNum = sc.nextInt();

                            System.out.println("Enter Contact Number:");
                            int contactNum = sc.nextInt();
                            int tableNum = -1;

                            Reservation newReservation = new Reservation(staffID, customerName, startTime, contactNum, peopleNum, tableNum, ReservationID);
                            newReservation.FindTable(peopleNum);
                            if (newReservation.getTable() == -1){
                                System.out.printf("No Tables Available! Reservation cannot be made the moment!\n");
                                break;
                            }
                            else{
                                System.out.printf("Table %d has been blocked for you!\n", newReservation.getTable());
                            }
                            System.out.printf("Reservation Made!Your reservation ID is:%d\n", newReservation.getReservationID());
                            mainapp.ReservationList.add(newReservation);
                            break;
                        case 2:
                            boolean reservationFound1 = false;
                            System.out.println("Please enter your Reservation ID:\n");
                            int reservationID1 = sc.nextInt();
                            for(int i=0; i<mainapp.ReservationList.size();i++){
                                if(mainapp.ReservationList.get(i).getReservationID() == reservationID1){
                                    System.out.printf("Reservation with ID %d found!\n", reservationID1);
                                    mainapp.ReservationList.remove(i);
                                    System.out.printf("Reservation Removed.\n");
                                    reservationFound1 = true;
                                }
                            }
                            if(!reservationFound1){
                                System.out.printf("No reservation with ID %d found!\n",reservationID1);
                            }
                            break;
                        case 3:
                            System.out.println("Please enter your Reservation ID:\n");
                            boolean reservationFound2 = false;
                            int reservationID2 = sc.nextInt();
                            for(int i=0; i<mainapp.ReservationList.size();i++){
                                if(mainapp.ReservationList.get(i).getReservationID() == reservationID2){
                                    System.out.printf("Reservation Details are as follows:\n");
                                    mainapp.ReservationList.get(i).printReservation();
                                    reservationFound2 = true;
                                }
                            }
                            if(!reservationFound2){
                                System.out.printf("No reservation with ID %d found!\n",reservationID2);
                            }
                            break;
                        default:
                        System.out.println("Wrong choice!");
                        choicecase = 0;
                        break;
                    }
                }
                while(choicecase4 != 4);
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
