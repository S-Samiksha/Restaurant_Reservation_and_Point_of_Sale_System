package src;


import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

//for conversion of flat file into objects 
	/**
	 * Read and converts various flat file (eg text file) into object.
	 * Return and store update object into the original text file.
	 */
public class FileToObject {

	/**
	 * Read and converts staff text file into object to be used in the main function.
	 */
	public static void staff(){
		System.out.println("Staff are taking attendance....."); 
        try {
            FileReader Staff = new FileReader("data/staff.txt"); 
			BufferedReader file = new BufferedReader(Staff); 
			String line; 
			String[] staffObject; 
			line = file.readLine(); 
            while(line!= null) { 
                staffObject = line.split("[|]"); 
				mainapp.StaffList.add(new Staff(staffObject[0], staffObject[1], staffObject[2], Integer.parseInt(staffObject[3]), staffObject[4], Boolean.parseBoolean(staffObject[5])));

				line = file.readLine();
            }

			file.close();
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Read and converts set package text file into object to be used in the main function.
	 */
	public static void setPackage(){
		System.out.println("Cooking Set Package Food......");
		try {
            FileReader setPackage = new FileReader("data/setPackage.txt"); 
			BufferedReader file = new BufferedReader(setPackage); 
			String line; 
			String[] SetPackageObject; 
			line = file.readLine(); 
            while(line!= null) { 
				MenuItems[] newList = {};
                SetPackageObject = line.split("[|]"); 
				String[] list = SetPackageObject[1].split("[,]");
				//add for loop to parse everything rom string to int
				for (String temp:list){
					for (int x=0; x<mainapp.MenuList.size(); x++){
                        if (temp.equals(mainapp.MenuList.get(x).getitemID().substring(2).intern())){
							newList = Arrays.copyOf(newList, newList.length+1);
							newList[newList.length-1] = new MenuItems(mainapp.MenuList.get(x).getName(), mainapp.MenuList.get(x).getType(), mainapp.MenuList.get(x).getDescription(), mainapp.MenuList.get(x).getPrice() , temp);
                        }
                    }	
				}
				mainapp.SPList.add(new SetPackage(SetPackageObject[0], newList , SetPackageObject[2],Boolean.parseBoolean(SetPackageObject[3]),SetPackageObject[4]));
				line = file.readLine();
            }

			file.close();
			

			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read and converts menuItem text file into object to be used in the main function.
	 */
	public static void MenuItems(){
		System.out.println("Cooking Ala Carte Food......");
		try {
            FileReader MenuItems = new FileReader("data/MenuItems.txt"); 
			BufferedReader file = new BufferedReader(MenuItems); 
			String line; 
			String[] MenuItemsObject; 
			line = file.readLine();
            while(line!= null) { 
                MenuItemsObject = line.split("[|]"); 

				mainapp.MenuList.add(new MenuItems(MenuItemsObject[0], MenuItemsObject[1], MenuItemsObject[2],Float.parseFloat(MenuItemsObject[3]),MenuItemsObject[4]));

				line = file.readLine();
            }

			file.close();
			

			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Read and converts order text file into object to be used in the main function.
	 */
	public static void Order(){
		System.out.println("Loading Order Data......");
		try {
            FileReader Order = new FileReader("data/order.txt"); 
			BufferedReader file = new BufferedReader(Order); 
			String line;
			String[] OrderObject; 
			line = file.readLine();
            while(line!= null) { 
                OrderObject = line.split("[|]");
				String[] listb = OrderObject[5].split("[,]");

				ArrayList<MenuItems> newListb = new ArrayList<>(30);
				for (String temp:listb){
					for (int x=0; x<mainapp.MenuList.size(); x++){
                        if (temp.equals(mainapp.MenuList.get(x).getitemID())){
                            newListb.add(mainapp.MenuList.get(x));
                        }
                    }
					for(int y=0;y<mainapp.SPList.size();y++){
						if(temp.equals(mainapp.SPList.get(y).getitemID())){
							newListb.add(mainapp.SPList.get(y));
						}
					}	
				}


				mainapp.TotalOrders.add(new Order(Integer.parseInt(OrderObject[0]),OrderObject[1],Integer.parseInt(OrderObject[2]),Timestamp.valueOf(OrderObject[3]),Float.parseFloat(OrderObject[4]), newListb));
				line = file.readLine();
            }

			file.close();
			

			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Read and converts staff text file into object to be used in the main function.
	 */
	public static void table(){
		System.out.println("Cleaning and Sanitizing Table......"); 
        try {
            FileReader Table = new FileReader("data/table.txt"); 
			BufferedReader file = new BufferedReader(Table); 
			String line; 
			String[] TableObject; 
			line = file.readLine(); 
            while(line!= null) { 
                TableObject = line.split("[|]");  
				mainapp.TableList.add(new Table(Integer.parseInt(TableObject[0]), Integer.parseInt(TableObject[1]), Boolean.parseBoolean(TableObject[2])));

				line = file.readLine();
            }

			file.close();
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Read and converts reservation text file into object to be used in the main function.
	 */
	public static void reservation(){
		System.out.println("Checking the Reservation Logs......"); 
        try {
        	FileReader fr = new FileReader("data/reservation.txt"); 
			BufferedReader br = new BufferedReader(fr); 
			String line;
			String[] reservationObject; 
			line = br.readLine();
        	while(line!= null) { 
            	reservationObject = line.split("[|]"); 
            	Timestamp DateTime = Timestamp.valueOf(reservationObject[2]);
				mainapp.ReservationList.add(new Reservation(reservationObject[0], reservationObject[1], DateTime,Integer.parseInt(reservationObject[3]),Integer.parseInt(reservationObject[4]),Integer.parseInt(reservationObject[5]), Integer.parseInt(reservationObject[6])));
				System.out.println(mainapp.ReservationList.size());
				line = br.readLine();

        	}
        	
			br.close();
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Return and update changed item in menu into the original menuItem text file.
	 */
	public static void MenuItemStore(){
		try{
			FileWriter fw = new FileWriter("data/MenuItems.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int j=0; j<mainapp.MenuList.size() ; j++) {
				String stritem = mainapp.MenuList.get(j).getitemID() + "|" + mainapp.MenuList.get(j).getName() +  "|" + mainapp.MenuList.get(j).getType() + "|" + String.valueOf(mainapp.MenuList.get(j).getPrice()) + "|" + mainapp.MenuList.get(j).getDescription() + "|";
				bw.write(stritem);
				bw.newLine();
				}
			System.out.println("Write Menu Items Data successful....");
			bw.close();
			return;
		}catch(Exception e){
			System.out.println("Wrong File");
			return;
		}
		
		
	}

	/**
	 * Return and update changed item into the original set package text file.
	 */
	public static void SPitemsStore(){
		try{
			FileWriter fw = new FileWriter("data/setPackage.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			String menulist = "";
			for (int j=0; j<mainapp.SPList.size() ; j++) {
				menulist = "";
				for (int i=0; i<mainapp.SPList.get(j).getSetList().length;i++){
					menulist += (mainapp.SPList.get(j).getSetList())[i].getDescription(); //why is this returning me Menulist ID??
					if (mainapp.SPList.get(j).getSetList().length-1>i){
						menulist += ",";
					}
					
				}
				
				String stritem = mainapp.SPList.get(j).getitemID() + "|" +  menulist + "|" +mainapp.SPList.get(j).getName() +  "|" + String.valueOf(mainapp.SPList.get(j).getPromo()) + "|" + mainapp.SPList.get(j).getDescription() + "|";
				bw.write(stritem);
				bw.newLine();
				}
			System.out.println("Write Set Package Items Data successful....");
			bw.close();
		}
		catch (Exception e) {
			System.out.println("Wrong File");
		}
	}

	/**
	 * Return and update changed order into the original order text file.
	 */
	public static void OrderStore() throws IOException{
		try{
			FileWriter fw = new FileWriter("data/order.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			String customerOrderList = "";
			for (int j=0; j<mainapp.TotalOrders.size() ; j++) {
				customerOrderList = "";
				for (int i=0; i<mainapp.TotalOrders.get(j).getOrdersList().size();i++){
					customerOrderList += mainapp.TotalOrders.get(j).getOrdersList().get(i).getitemID();
					if (mainapp.TotalOrders.get(j).getOrdersList().size()-1>i){
						customerOrderList += ",";
					}
				}
				//System.out.println(customerOrderList);
				String stritem = mainapp.TotalOrders.get(j).getOrderID() + "|" +  mainapp.TotalOrders.get(j).getStaff() + "|" + String.valueOf(mainapp.TotalOrders.get(j).getTable()) +"|" + (mainapp.TotalOrders.get(j).getDateTime()).toString() +  "|" + String.valueOf(mainapp.TotalOrders.get(j).getTotalprice()) +"|" + customerOrderList + "|";
				bw.write(stritem);
				bw.newLine();
			}
			System.out.println("Write Menu Items Data successful....");
			bw.close();
		}catch(Exception e){
			System.out.println("Exception thrown!");
		}
		
	}


	/**
	 * Return and update changed table into the original table text file.
	 */
	public static void TableStore() throws IOException{
		FileWriter fw = new FileWriter("data/table.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (int j = 0; j < mainapp.TableList.size() ; j++) {
			Table table1 = mainapp.TableList.get(j);
			String strTable = String.valueOf(table1.gettableNum()) + "|" + String.valueOf(table1.gettableCapacity()) + "|" + String.valueOf(table1.isAvailable()) ;
			bw.write(strTable);
			bw.newLine();
		}
		System.out.println("Write table Data successful....");
		bw.close();
	}


	/**
	 * Return and update changed reservation into the original reservation text file.
	 */
	public static void ReservationStore() throws IOException{
		FileWriter fw = new FileWriter("data/reservation.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int j=0; j<mainapp.ReservationList.size() ; j++) {
				Reservation reservation1 = mainapp.ReservationList.get(j);
				String DateTimeStr = reservation1.getTimestamp().toString();
				String strReservation = String.valueOf(reservation1.getTableNumber()) + "|" +DateTimeStr +  "|" + String.valueOf(reservation1.getNumPeople()) + "|" + reservation1.getCustomerName() + String.valueOf(reservation1.getContactNumber()) + "|" + String.valueOf(reservation1.getStaffID()) + "|";
				bw.write(strReservation);
				bw.newLine();
			}
			System.out.println("Write reservation Data successful....");
			bw.close();
	}		
						
	}



	
	// write to file
	
	// data = ArrayList
	// try{
	// 	PrintWriter pr = new PrintWriter("cz2002table.csv");    
	// 	for (int i=0; i<data.size() ; i++){
	// 		pr.println(data.get(i));
	// 	}
	// 	pr.close();
	// }

	// catch (Exception e){
	// 	e.printStackTrace();
	// 	System.out.println("No such file exists.");
	// }





