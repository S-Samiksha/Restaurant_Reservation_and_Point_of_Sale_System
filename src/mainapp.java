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
            System.out.println("Restaurant Opening.....\n");
            FileToObject.staff();
            FileToObject.table();
            FileToObject.MenuItems();
            FileToObject.setPackage();
            FileToObject.Order();
            FileToObject.reservation();
            Scanner sc = new Scanner(System.in);
            Date date = new Date();

            // code to delete reservations that have expired ///
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask(){
                @Override
                public void run(){
                    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                    int size = mainapp.ReservationList.size();
                    int i = 0;
                    while(i < size){
                        if (((currentTime.getTime()-mainapp.ReservationList.get(i).getTimestamp().getTime())/1000)/60 >= 240){
                            System.out.println("----------------------------------------------------------------------------------------------------------");
                            System.out.printf("|NOTICE:Reservation with ID %d has been deleted due to reservation period expiry at %s|\n", mainapp.ReservationList.get(i).getReservationID(), new Timestamp(System.currentTimeMillis()));
                            System.out.println("----------------------------------------------------------------------------------------------------------");
                            int tableID = mainapp.ReservationList.get(i).getTable();
                            String StaffID = mainapp.ReservationList.get(i).getStaffID();
                            int j;
                            for (j=0; j<mainapp.TableList.size();j++){
                                    if(tableID == mainapp.TableList.get(j).gettableNum()){
                                        mainapp.TableList.get(i).setisAvailable(true);
                                    
                                }
                                for (j = 0 ; j<mainapp.StaffList.size();j++){
                                    if(StaffID.equals(mainapp.StaffList.get(j).getEmployeeID())){
                                        mainapp.StaffList.get(i).setisAvailable(true);;
                                    }
                            }
                            mainapp.ReservationList.remove(i);
                            size = mainapp.ReservationList.size();
                            i = 0;
                            }
                        }
                        else{
                            i++;
                        }
                    }
                }
                },0,5000);
            /// end of code to delete expired reservations ///
        System.out.println("---------------------" + new Timestamp(date.getTime()) + "---------------------"); 
        int c = 0;
        System.out.println("~~~~~~~~~~~~Welcome to Sally's Burger Town Restaurant!~~~~~~~~~~~~");

        while (c >= 0){
            System.out.println("----------------------------STAFF ACCESS---------------------------");
            System.out.println("| (1) Create An Order                                             |");
            System.out.println("| (2) Place/Remove An item from Order                             |");
            System.out.println("| (3) View an Order                                               |");
            System.out.println("| (4) Reservation (Make, Remove, Check)                           |");
            System.out.println("| (5) Print Order Invoice                                         |");
            System.out.println("| (6) Check Table Availability                                    |");
            System.out.println("| (7) Manager Access Only (Menu Item, Promotion, Sales Revenue)   |");
            System.out.println("| (8) Close Shop                                                  |");
            System.out.println("-------------------------------------------------------------------");
            try{
                c = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                c = 9;
            } 
            
        switch(c){
            case 1:
                int choicecase1 = 0; 
                do{
                    System.out.println("Enter choice:");
                    System.out.println("(1): Create Order (Made Reservation)");
                    System.out.println("(2): Create Order (Walk-in)");
                    System.out.println("(3): Exit ");
                    try {
                        choicecase1 = Integer.parseInt(sc.nextLine());

                    }catch (Exception e){
                        System.out.println("Please input an Integer value.");
                        choicecase1 = 0;
                    }
                
                    switch(choicecase1){
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
                                        if (timeNow.getTime()-mainapp.ReservationList.get(i).getTimestamp().getTime()/1000/60 >= -30 && timeNow.getTime()-mainapp.ReservationList.get(i).getTimestamp().getTime()/1000/60 <= 240){
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
                                            System.out.printf("You are allocated to Table %d!\n",reservationOrder.getTable());
                                            System.out.printf("OrderID:%d\n",reservationOrder.getOrderID());
                                        }
                                        else{
                                            System.out.println("Your reservation is not yet active! Please come back later!");
                                        }
                                    }
                                }
                            }
                            if(!reservationFound){
                                if(!reserved){
                                    System.out.println("You need to hold an existing reservation first!"); 
                                }
                                else{
                                System.out.println("The ID you entered does not belong to an existing reservation!");
                                }
                            }
                            break;

                        case 2:
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
                                break;
                            }
                            else{
                                System.out.printf("Staff %s will be helping you!\n",case1order.getStaff());
                            }

                            int tableFound = case1order.FindTable(customerPax);
                            if (tableFound == 0){
                                System.out.println("No table available at the moment!\n");
                                break;
                            }
                            else{
                                System.out.printf("You are allocated to Table %d!\n",case1order.getTable());
                            }

                            case1order.setOrderID(OrderID);
                            System.out.printf("OrderID:%d\n",case1order.getOrderID());
                            case1order.setTimestamp();
                            TotalOrders.add(OrderID, case1order);
                            int tableID = case1order.getTable();
                            System.out.println(tableID);
                            String staffID = case1order.getStaff();
                            for (int i=0; i< mainapp.TableList.size();i++){
                                if(tableID == mainapp.TableList.get(i).gettableNum()){
                                    mainapp.TableList.get(i).setisAvailable(false);
                                }
                            }
                            for (int i = 0 ; i< mainapp.StaffList.size();i++){
                                if(staffID.equals(mainapp.StaffList.get(i).getEmployeeID())){
                                    mainapp.StaffList.get(i).setisAvailable(false);
                                }
                            }
                            OrderID++; // DO NOT EDIT THIS VARIABLE 
                            break;
                        case 3:
                            break;
                        default:
                            choicecase1 = 0;
                            break;
                    }
                }while(choicecase1 != 3);
                break;


            case 2: 
                int case2orderID=0;
                int choicecase2 = 0;
                Order case2order = new Order();
                while(!exceptionLoop){
                    try{
                        System.out.println("Enter your order ID:");
                        case2orderID = Integer.parseInt(sc.nextLine());
                        case2order = TotalOrders.get(case2orderID); 
                        exceptionLoop = true;

                    }catch(Exception e){
                        System.out.println("Invalid Order ID");
                    }
                }
                exceptionLoop = false;
                do{ 
                    System.out.println("Enter choice:");
                    System.out.println("(1): Add item to Order");
                    System.out.println("(2): Remove Item From Order ");
                    System.out.println("(3): Exit ");
                    try {
                        choicecase2 = Integer.parseInt(sc.nextLine());

                    }catch (Exception e){
                        System.out.print("Please input an Integer");
                        choicecase2 = 0;
                    }
                    
                    switch(choicecase2){
                        case 1:
                            case2order.printMenu(); 
                            String menuitem;
                            while(!exceptionLoop){
                                try{
                                    System.out.println("Enter the menu item you want to order from the menu:");
                                    menuitem = sc.nextLine();
                                    System.out.println("Enter the quantity");
                                    int quantity = Integer.parseInt(sc.nextLine());
                                    case2order.addOrder(menuitem,quantity); 
                                    System.out.println("This is your updated order");
                                    case2order.printOrder();
                                    exceptionLoop = true;
                                }catch(Exception e){
                                    System.out.println("Invalid menu item/quantity value\n"); 
                                }
                            }
                            exceptionLoop = false;
                            
                            break;
                        case 2:
                            case2order.printOrder();
                            while(!exceptionLoop){
                                try{
                                    System.out.println("Select an item to remove from order and enter the number:\n");
                                    int orderNumber = Integer.parseInt(sc.nextLine());
                                    case2order.removeFromOrder(orderNumber-1);
                                    System.out.println("This is your updated order\n");
                                    case2order.printOrder();
                                    exceptionLoop = true;
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
                        System.out.print("Pleae input an Integer");
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
                                    System.out.println("Enter a Reservation Date and Time:\n\nFormat: yyyy-MM-dd HH:mm:ss\n\nBooking Hours: 10:00:00 - 20:00:00");
                                    String dateTime = sc.nextLine();
                                    startTime = Timestamp.valueOf(dateTime); 
                                    SimpleDateFormat getDate = new SimpleDateFormat("yyyy-MM-dd");
                                    String reservationDate = getDate.format(startTime);
                                    Timestamp closingTime = Timestamp.valueOf(reservationDate+" 20:01:00");
                                    Timestamp openingTime = Timestamp.valueOf(reservationDate+" 09:59:00");
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
                                    System.out.println("Please enter an integer value for the number of people to be seated!"); 
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
                            int tableFound = newReservation.FindTable(reservationPax);
                            if (tableFound == -1){
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
                                    System.out.println("Please enter your Reservation ID:");
                                    reservationID1 = Integer.parseInt(sc.nextLine());
                                    exceptionLoop = true;
            
                                }catch (Exception e){
                                    System.out.print("Please Input an Integer");
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
                                    System.out.printf("Reservation Details are as follows:\n\n");
                                    mainapp.ReservationList.get(i).printReservation();
                                    System.out.println("\n");
                                    reservationFound2 = true;
                                }
                            }
                            if(!reservationFound2){
                                System.out.printf("No reservation with ID %d found!\n",reservationID2);
                            }
                            break;
                        default:
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
                        Order case5order = TotalOrders.get(case5orderID);
                        System.out.println("View your Order Invoice:");
                        case5order.printInvoice(); 
                        int tableID = TotalOrders.get(case5orderID).getTable();
                        String staffID = TotalOrders.get(case5orderID).getStaff();
                        for (int i = 0; i<mainapp.TableList.size();i++){
                            if(tableID == mainapp.TableList.get(i).gettableNum()){
                                mainapp.TableList.get(i).setisAvailable(true);
                            }
                        }
                        for (int i = 0 ; i<mainapp.StaffList.size();i++){
                            if(staffID.equals(mainapp.StaffList.get(i).getEmployeeID())){
                                mainapp.StaffList.get(i).setisAvailable(true);
                            }
                        }
                        exceptionLoop = true;
                    }catch (Exception e){
                        System.out.print("Please input an Integer!");
                    }
                }
                exceptionLoop = false;
                break;
            case 6:
                System.out.println("Table Availability:\n");
                for(int i = 0; i < mainapp.TableList.size();i++){
                    System.out.printf("Table Number: %d Availability: %b\n", mainapp.TableList.get(i).gettableNum(), mainapp.TableList.get(i).isAvailable());
                }
                break;
            case 7:
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
            case 8:
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
