package src;


import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;

//for conversion of flat file into objects 
public class FileToObject {

	public static void staff(){
		System.out.println("Staff is taking attendance....."); 
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

		//end copy here 
	}

	public static void setPackage(){
		System.out.println("Cooking Set Package Food......");
		try {
            FileReader setPackage = new FileReader("data/setPackage.txt"); 
			BufferedReader file = new BufferedReader(setPackage); 
			String line; 
			String[] SetPackageObject; 
			line = file.readLine(); 
            while(line!= null) { 
                SetPackageObject = line.split("[|]"); 
	
				String[] lista = SetPackageObject[1].split("[,]");
				//add for loop to parse everything rom string to int
				int i=0;
				MenuItems[] newList = new MenuItems[10];
				for (String temp:lista){
					for (int x=0; x<mainapp.MenuList.size(); x++){
                        if (temp.equals(mainapp.MenuList.get(x).getitemID())){
                            newList[i] = new MenuItems(mainapp.MenuList.get(i).getName(), mainapp.MenuList.get(i).getType(), mainapp.MenuList.get(i).getDescription(), mainapp.MenuList.get(i).getPrice() , temp);
                        }
                    }	
					i++;
				}
				


				mainapp.SPList.add(new SetPackage(SetPackageObject[0], newList , SetPackageObject[2],Boolean.parseBoolean(SetPackageObject[3]),SetPackageObject[4]));
				
				line = file.readLine();
            }

			file.close();
			

			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

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
				//add for loop to parse everything rom string to int
				int i=0;
				ArrayList<MenuItems> newListb = new ArrayList<>(30);
				for (String temp:listb){
					for (int x=0; x<mainapp.MenuList.size(); x++){
                        if (temp.equals(mainapp.MenuList.get(x).getitemID())){
                            newListb.add(new MenuItems(mainapp.MenuList.get(i).getName(), mainapp.MenuList.get(i).getType(), mainapp.MenuList.get(i).getDescription(), mainapp.MenuList.get(i).getPrice() , temp));
                        }
                    }	
					i++;
				}


				mainapp.TotalOrders.add(new Order(Integer.parseInt(OrderObject[0]),OrderObject[1],Integer.parseInt(OrderObject[2]),Timestamp.valueOf(OrderObject[3]),Float.parseFloat(OrderObject[4]), newListb));

				line = file.readLine();
            }

			file.close();
			

			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
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

		//end copy here 
	}

	public static void reservation(){
		System.out.println("Cleaning and Sanitizing Table......"); 
        try {
           String filePath = new File("").getAbsolutePath();
        	FileReader fr = new FileReader(filePath+"/src/data/reservation.txt"); 
			BufferedReader br = new BufferedReader(fr); 
			String line;
			String[] reservationObject; 
			line = br.readLine();
			int numOfLine = 0;
			
        	while(line!= null) { 
            	reservationObject = line.split("[|]"); 
            	Timestamp DateTimeT = Timestamp.valueOf(reservationObject[2]);
				mainapp.ReservationList.add(new Reservation(reservationObject[0], reservationObject[1], DateTimeT,Integer.parseInt(reservationObject[3]),Integer.parseInt(reservationObject[4]),Integer.parseInt(reservationObject[5]), Integer.parseInt(reservationObject[6])));
				line = br.readLine();
				numOfLine++;
        	}
        	
			br.close();
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public static void MenuItemStore(){
		try{
			FileWriter fw = new FileWriter("data/MenuItems.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int j=0; j<mainapp.MenuList.size() ; j++) {
				MenuItems item = mainapp.MenuList.get(j);
				String stritem = String.valueOf(item.getitemID() + "|" +item.getName() +  "|" + item.getType() + "|" + String.valueOf(item.getPrice()) + "|" + item.getDescription());
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

	public static void SPitemsStore(){
		try{
			FileWriter fw = new FileWriter("data/setPackage.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int j=0; j<mainapp.SPList.size() ; j++) {
				SetPackage item = mainapp.SPList.get(j);
				String stritem = String.valueOf(item.getitemID() + "|" +  String.valueOf(item.getSetList()) + "|" +item.getName() +  "|" + String.valueOf(item.getPromo()) + item.getDescription());
				bw.write(stritem);
				bw.newLine();
				}
			System.out.println("Write Menu Items Data successful....");
			bw.close();
		}
		catch (Exception e) {
			System.out.println("Wrong File");
		}
	}

	public static void OrderStore() throws IOException{
		try{
		FileWriter fw = new FileWriter("data/order.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (int j=0; j<mainapp.TotalOrders.size() ; j++) {
			Order item = mainapp.TotalOrders.get(j);
			String stritem = String.valueOf(String.valueOf(item.getOrderID()) + "|" +  String.valueOf(item.getStaff()) + "|" + String.valueOf(item.getTable()) +"|" + (item.getDateTime()).toString() +  "|" + String.valueOf(item.getTotalprice())) + String.valueOf(item.getOrdersList());
			bw.write(stritem);
			bw.newLine();
		}
		}
		System.out.println("Write Menu Items Data successful....");
		bw.close();
	}










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







