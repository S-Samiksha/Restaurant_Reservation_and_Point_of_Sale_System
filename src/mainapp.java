package src;
/**
 * mainapp
 * mainapp relies on the order class without it, it cannot live --> composition 
 * mainapp also relies on menuitems and setpackage because you want to show it to customers right!
 */
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.io.IOException;

public class mainapp {


    protected static List<MenuItems> MenuList = new ArrayList<>(30);
    protected static List<SetPackage> SPList = new ArrayList<>(30); 
    protected static List<Staff> StaffList = new ArrayList<>(30);
    protected static List<Table> TableList = new ArrayList<>(30);
    protected static List<Order> TotalOrders = new ArrayList<>(10000);
    protected static List<Reservation> ReservationList = new ArrayList<>(10000);
    public static int tableNum = -1;
    

    public static final int MAX_Time = 2200; 
	public static final int MIN_Time = 1000;
    /// change according to number of lines in data.txt
    public static int ReservationID = 3;
    public static int OrderID = 11;
    public static boolean exceptionLoop = false;
    
    public static void main(String[] args) throws IOException{
        System.out.println("Restaurant Opening.....");
        FileToObject.staff();
        FileToObject.table();
        FileToObject.MenuItems();
        FileToObject.setPackage();
        FileToObject.Order();
        FileToObject.reservation();
        System.out.println(ReservationList.size());
        Scanner sc = new Scanner(System.in);
        Date date = new Date();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                for(int i = 0; i < mainapp.ReservationList.size();i++){
                   if (((currentTime.getTime()-mainapp.ReservationList.get(i).getTimestamp().getTime())/1000)/60 >= 720){
                       System.out.printf("NOTICE:Reservation with ID %d has been deleted due reservation period expiry\n", mainapp.ReservationList.get(i).getReservationID());
                       mainapp.ReservationList.remove(i);
                       int tableID = mainapp.ReservationList.get(i).getTable();
                       String StaffID = mainapp.ReservationList.get(i).getStaffID();
                       int j;
                       for (j=0; j<mainapp.TableList.size();j++){
                            if(tableID == mainapp.TableList.get(j).gettableNum()){
                                mainapp.TableList.get(i).setisAvailable(true);
                                return;
                            }
                        }
                        for (j = 0 ; j<mainapp.StaffList.size();j++){
                            if(StaffID.equals(mainapp.StaffList.get(j).getEmployeeID())){
                                mainapp.StaffList.get(i).setisAvailable(true);;
                                return;
                            }
                        }
                   }
               }
            }
            },0,5000);
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
            try{
                c = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                c = 9;
            } 
            
        switch(c){
            case 1: 
                boolean reservationFound = false;
                boolean reserved = false;
                while(!exceptionLoop){
                    System.out.println("Have you reserved a table? Enter true or false.");
                    String reservedString = sc.nextLine();
                    if(reservedString.equals("true") || reservedString.equals("false")){
                        reserved = Boolean.parseBoolean(reservedString);
                        exceptionLoop = true;
                    }
                    else{
                        System.out.println("Please enter either true or false!");  
                    }
                }
                exceptionLoop = false;
                if(reserved){
                    int reservationID = -1;
                    while(!exceptionLoop){
                        try{
                            System.out.println("Please enter your Reservation ID:");
                            String reservationIDString = sc.nextLine();
                            reservationID = Integer.parseInt(reservationIDString);
                            exceptionLoop = true;
                        }
                        catch(Exception e){
                            System.out.println("Please enter a valid integer value for Reservation ID!"); 
                        }
                    }
                    exceptionLoop = false;

                    for(int i=0; i<mainapp.ReservationList.size();i++){
                        if(mainapp.ReservationList.get(i).getReservationID() == reservationID){
                            System.out.println("Reservation found!");
                            Timestamp timeNow  = new Timestamp(System.currentTimeMillis());
                            reservationFound = true;
                            if (Math.abs(timeNow.getTime()-mainapp.ReservationList.get(i).getTimestamp().getTime())/1000/60 <= 30){
                                System.out.println("Your reservation is active!");
                                Order reservationOrder = new Order();
                                reservationOrder.setOrderID(OrderID);
                                reservationOrder.setStaff(mainapp.ReservationList.get(i).getStaffID());
                                reservationOrder.setTimestamp();
                                reservationOrder.setTable(mainapp.ReservationList.get(i).getTable());
                                TotalOrders.add(OrderID, reservationOrder);
                                OrderID++; // DO NOT EDIT THIS VARIABLE 
                                mainapp.ReservationList.remove(i);
                                System.out.printf("Staff %s will be helping you!\n",reservationOrder.getStaff());
                                System.out.printf("You are allocated to %d\n",reservationOrder.getTable());
                                System.out.printf("OrderID:%d\n",reservationOrder.getOrderID());
                            }
                            else{
                                System.out.println("Your reservation is not within the past or next 30 minutes! Please come back later!");
                            }
                        }
                    }
                }
                if(reservationFound){
                    break;
                }
                else{
                    System.out.println("The ID you entered does not belong to an existing reservation!");
                }

                Order case1order = new Order();
                int customerPax = 0;
                while(!exceptionLoop){
                    try{
                        System.out.println("Enter number of people to be seated in the table");
                        String customerPaxString = sc.nextLine();
                        customerPax = Integer.parseInt(customerPaxString);
                    }
                    catch(Exception e){
                        System.out.println("Pleaee enter an integer value for the number of people to be seated!"); 
                        continue;
                    }
                    if(case1order.validatecustomerPax(customerPax)){
                        exceptionLoop = true;
                    }
                    else{
                        System.out.println("Number of people for reservation ahould be between 2-10!");
                    }
                }
                exceptionLoop = false;
                
                case1order.setStaff();
                String staffFound = case1order.getStaff();
                if (staffFound == ""){ 
                    System.out.println("No Staff available at the moment!\n");
                }
                else{
                    System.out.printf("Staff %s will be helping you!\n",case1order.getStaff());
                }

                int tableFound = case1order.FindTable(customerPax);
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

            case 2: 
                int case2orderID=0;
                int choicecase2 = 0;
                while(!exceptionLoop){
                    try{
                        System.out.println("Enter your order ID:");
                        case2orderID = Integer.parseInt(sc.nextLine()); 
                        exceptionLoop = true;

                    }catch(Exception e){
                        System.out.println("Invalid Order ID");
                    }
                }
                exceptionLoop = false;
                Order case2order = TotalOrders.get(case2orderID);
                do{ 
                    System.out.println("Enter choice:");
                    System.out.println("(1): Add item to Order");
                    System.out.println("(2): Remove Item From Order ");
                    System.out.println("(3): Exit ");
                    try {
                        choicecase2 = Integer.parseInt(sc.nextLine());

                    }catch (Exception e){
                        System.out.print("Invalid choice! Try Again! Input an Integer");
                        choicecase2 = 0;
                    }
                    
                    switch(choicecase2){
                        case 1:
                            case2order.printMenu(); 
                            System.out.println("Enter the menu item number you want to order from the menu:");
                            String menuitem;
                            while(!exceptionLoop){
                                try{
                                    menuitem = sc.nextLine();
                                    System.out.println("Enter the quantity");
                                    int quantity = sc.nextInt();
                                    case2order.addOrder(menuitem,quantity); 
                                    System.out.println("This is your updated order");
                                    case2order.printOrder();
                                    exceptionLoop = true;
                                }catch(Exception e){
                                    System.out.println("Invalid menu item/quantity value"); 
                                }
                            }
                            exceptionLoop = false;
                            
                            break;
                        case 2:
                            case2order.printOrder();
                            while(!exceptionLoop){
                                try{
                                    System.out.println("Select an item to remove from order and enter the number:");
                                    int orderNumber = sc.nextInt();
                                    case2order.removeFromOrder(orderNumber-1);
                                    exceptionLoop = true;
                                    System.out.println("This is your updated order");
                                    case2order.printOrder();
                                }
                                catch(Exception e){
                                    System.out.println("Please enter an integer value");
                                }
                            }
                            exceptionLoop = false;
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Wrong choice!");
                            choicecase2 = 0;
                            break;
                    }
                }while(choicecase2 != 3);
               
                
                break;
    
            case 3: 
                int case3orderID;
                Order case3order = new Order();
                while(!exceptionLoop){
                    try{
                        System.out.println("Enter your order ID:");
                        case3orderID = Integer.parseInt(sc.nextLine()); 
                        case3order = TotalOrders.get(case3orderID);
                        exceptionLoop = true;

                    }catch(Exception e){
                        System.out.println("Invalid Order ID!");
                    }
                }
                exceptionLoop = false;
                System.out.println();
                case3order.printOrder();
                break;

            case 4: 
                int choicecase4 = 0;
                do{
                    System.out.println("Enter choice:");
                    System.out.println("(1): Make a Reservation");
                    System.out.println("(2): Remove a Reservation");
                    System.out.println("(3): Check a Reservation");
                    System.out.println("(4): Exit");
                    try {
                        choicecase4 = Integer.parseInt(sc.nextLine());

                    }catch (Exception e){
                        System.out.print("Invalid choice! Try Again! Input an Integer");
                        choicecase4 = 4;
                    }
                    switch(choicecase4){
                        case 1:
                            Reservation newReservation = new Reservation();
                            String staffID = "";
                            while(!exceptionLoop){
                                System.out.println("Enter Staff ID: ");
                                staffID = sc.nextLine();
                                if(newReservation.validateStaffID(staffID)){
                                    exceptionLoop = true;
                                }
                                else{
                                    System.out.println("Invalid StaffID");
                                }
                            }
                            exceptionLoop = false;

                            System.out.println("Enter Name of Customer:");
                            String customerName = sc.next();

                            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                            Timestamp startTime = new Timestamp(System.currentTimeMillis());
                            startTime.setTime(0);
                            boolean dateSet = false;
                            sc.nextLine();
                            while(!dateSet){
                                try{
                                    System.out.println("Enter a Reservation Date and Time:\nformat:yyyy-MM-dd HH:mm:ss\nBooking Hours: 10:00:00 - 20:00:00");
                                    String dateTime = sc.nextLine();
                                    startTime = Timestamp.valueOf(dateTime); 
                                    SimpleDateFormat getDate = new SimpleDateFormat("yyyy-MM-dd");
                                    String reservationDate = getDate.format(startTime);
                                    Timestamp closingTime = Timestamp.valueOf(reservationDate+" 21:01:00");
                                    Timestamp openingTime = Timestamp.valueOf(reservationDate+" 9:59:00");
                                    if (newReservation.validateStartTime(currentTime, startTime, openingTime, closingTime)){
                                        dateSet = true;
                                    }
                                }
                                catch(Exception e){
                                    System.out.println("Enter a valid date and time in yyyy-MM-dd HH:mm:ss format!");
                                }
                            }

                            int reservationPax = 0;
                            while(!exceptionLoop){
                                try{
                                    System.out.println("Enter number of people to be there");
                                    String reservationPaxString = sc.nextLine();
                                    reservationPax = Integer.parseInt(reservationPaxString);
                                }
                                catch(Exception e){
                                    System.out.println("Pleasee enter an integer value for the number of people to be seated!"); 
                                    continue;
                                }
                                if(newReservation.validatecustomerPax(reservationPax)){
                                    exceptionLoop = true;
                                }
                                else{
                                    System.out.println("Number of people for reservation ahould be between 2-10!");
                                }
                            }
                            exceptionLoop = false;
                            
                            int contactNum = 0;
                            while(!exceptionLoop){
                                try{
                                    System.out.println("Enter Customer Contact Number(8 digits):");
                                    String contactNumString = sc.nextLine();
                                    contactNum = Integer.parseInt(contactNumString);
                                }
                                catch(Exception e){
                                    System.out.println("Pleaee enter an integer value for the contact number!"); 
                                    continue;
                                }
                                if(newReservation.validateContactNumber(contactNum)){
                                    exceptionLoop = true;
                                }
                                else{
                                    System.out.println("Invalid contact number, must be 8 digits long");
                                }
                            }
                            exceptionLoop = false;


                            newReservation.setStaff(staffID);
                            newReservation.setCustomerName(customerName);
                            newReservation.setTimestamp(startTime);
                            newReservation.setContactNumber(contactNum);
                            newReservation.setNumPeople(reservationPax);
                            newReservation.FindTable(reservationPax);
                            if (newReservation.getTable() == -1){
                                System.out.println("No Tables Available! Reservation cannot be made the moment!");
                                break;
                            }
                            else{
                                System.out.printf("Table %d has been blocked for you!\n", newReservation.getTable());
                            }
                            newReservation.setReservationID(ReservationID);
                            ReservationID++; // DO NOT EDIT THIS VALUE
                            System.out.printf("Reservation Made! Your reservation ID is:%d\n", newReservation.getReservationID());
                            mainapp.ReservationList.add(newReservation);
                            break;
                        case 2:
                            boolean reservationFound1 = false;
                            int reservationID1 = -1;
                            while(!exceptionLoop){
                                try {
                                    System.out.println("Please enter your Reservation ID:\n");
                                    reservationID1 = Integer.parseInt(sc.nextLine());
                                    exceptionLoop = true;
            
                                }catch (Exception e){
                                    System.out.print("Invalid choice! Try Again! Input an Integer");
                                }
                            }
                            exceptionLoop = false;
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
                            boolean reservationFound2 = false;
                            int reservationID2 = -1;
                            while(!exceptionLoop){
                                try {
                                    System.out.println("Please enter your Reservation ID:\n");
                                    reservationID2 = Integer.parseInt(sc.nextLine());
                                    exceptionLoop = true;
            
                                }catch (Exception e){
                                    System.out.print("Invalid choice! Try Again! Input an Integer");
                                }
                            }
                            exceptionLoop = false;
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
                            choicecase4 = 4;
                        break;
                    }
                }
                while(choicecase4 != 4);
                break;

            case 5: 
                int case5orderID = -1;
                while(!exceptionLoop){
                    try {
                        System.out.println("Please enter your Order ID:\n");
                        case5orderID = Integer.parseInt(sc.nextLine());
                        exceptionLoop = true;
                        Order case5order = TotalOrders.get(case5orderID);
                        System.out.println("View your Order Invoice:");
                        case5order.printInvoice(); 
                        int tableID = TotalOrders.get(case5orderID).getTable();
                        String staffID = TotalOrders.get(case5orderID).getStaff();
                        for (int i=0; i<mainapp.TableList.size();i++){
                            if(tableID == mainapp.TableList.get(i).gettableNum()){
                                mainapp.TableList.get(i).setisAvailable(false);
                                return;
                            }
                        }
                        for (int i = 0 ; i<mainapp.StaffList.size();i++){
                            if(staffID.equals(mainapp.StaffList.get(i).getEmployeeID())){
                                mainapp.StaffList.get(i).setisAvailable(false);;
                                return;
                            }
                        }
                    }catch (Exception e){
                        System.out.print("Invalid choice! Try Again! Input an Integer");
                    }
                }
                exceptionLoop = false;
                break;
            
            case 6:
                int tryAgain = 1, choice=0, count=0;
                String temp;
                Boolean access = false;
                Scanner sc2 = new Scanner(System.in);
                while (count < 3 && tryAgain == 1){
                    System.out.println("Enter EmployeeID: ");
                    temp = sc2.nextLine();
                    for (int i=0; i<StaffList.size();i++){
                        if (StaffList.get(i).getEmployeeID().equals(temp) && StaffList.get(i).isManager()==true){
                            access = true;
                            break;
                        }

                    }
                    
                        if (!access){
                            System.out.println("You are not the manager!");
                            break;
                        }
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
                System.out.println("Wrong Input Try Again!");
                c=0;
                break;
        }
        
      

    }
    sc.close();
    }
 
        
    }
