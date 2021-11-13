package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.sql.Timestamp; //import this 

/**
 * Only authorized personnel is able to access this class to edit menu, set package and view the sales revenue.
 */
public class SecurityAccess{

	/**
	 * Temporary value used.
	 */
    private String temp;
    /**
     * Name of the food item.
     */
    private String name;
    /**
     * Type of the food item.
     */
    private String type;
    /**
     * Detailed description of the food item.
     */
    private String description;
    /**
     * ID of the food item.
     */
    private String item;
    /**
     * Specific price of the food item.
     */
    private float price;
    /**
     * Choice made by the authorized person to select the function.
     */
    private int choice;

    private Scanner sc = new Scanner(System.in);

    public SecurityAccess(){

    }

    /**
     * Prints out the option available for the authorized personnel.
     */
    public void showOptions(){
        System.out.println("---------------------------------------------");
        System.out.println("|------------Manager Access Only-------------|");
        System.out.println("| (1) Create Menu Item                       |");
        System.out.println("| (2) Update Menu Item                       |");
        System.out.println("| (3) Create Set Package Item                |");
        System.out.println("| (4) Update Set Package Item                |");
        System.out.println("| (5) Remove MenuItem / Set Package          |");
        System.out.println("| (6) See Sales Revenue Report               |");
        System.out.println("| (7) Exit                                   |");
        System.out.println("---------------------------------------------");
    }

    /**
     * Creates and add new items into a new menu.
     */
    public void createMenu(){
        System.out.println("Here is the Menu: ");
        printMenu();
        String tempID;
        try{
            int i = mainapp.MenuList.size()+1;
            tempID = "AC"+ String.valueOf(i);
            System.out.println("Enter the new name");
            name = sc.nextLine();
        }catch(Exception e){
            System.out.println("You entered an invalid name. Please try again!");
            return;
        }

        try{
            System.out.println("Enter the new type");
            type = sc.nextLine();
        }catch (Exception e){
            System.out.println("You entered an invalid type. Please try again!");
            return;
        }

        try{
            System.out.println("Enter the new description");
            description = sc.nextLine();
            
        }catch(Exception e){
            System.out.println("You entered an invalid description. Please try again!");
            return;
        }

        try{
            System.out.println("Enter the new price");
            price = Float.parseFloat(sc.nextLine());
            

        }catch(Exception e){
            System.out.println("You entered an invalid price. Please try again!");
            return;
        }
        try{
            mainapp.MenuList.add(new MenuItems(tempID, name,type, price, description));
            System.out.println("Successfully added the MenuItems!");

        }catch(Exception e){
            System.out.println("Something wrong with the creation. Try Again!");
            return;
        }
        System.out.println("Here is the new Menu: ");
        printMenu();
        
        
    }
    
    /**
     * Creates and add new a set package using items in menu.
     */
    public void createSet(){ 
        System.out.println("Here is the Menu: ");
        printMenu();
        try{
        int i = mainapp.SPList.size()+1;
        String tempID = "SP"+ String.valueOf(i);
        System.out.println("Enter the new name");
        name = sc.nextLine();
        System.out.println("Enter the new type");
        type = sc.nextLine();
        System.out.println("Enter the new description");
        description = sc.nextLine();
        System.out.println("Enter in the list of Menuitems(type z to stop): ");

        List <MenuItems> list = new ArrayList<>();
        System.out.println("Enter MenuItem ID press z to exit: ");
        item = sc.nextLine();
        do{
            
            for (int x=0; x<mainapp.MenuList.size(); x++){
                if (item.equals(mainapp.MenuList.get(x).getitemID())){
                    list.add(new MenuItems(mainapp.MenuList.get(i).getName(), mainapp.MenuList.get(i).getType(), mainapp.MenuList.get(i).getDescription(), mainapp.MenuList.get(i).getPrice() , item));
                }
            }
            //j++;
            System.out.println("Enter MenuItem ID: ");
            item = sc.nextLine();
            
        }while (!item.equals("z"));
        System.out.println("Would you like to add Promotion on this set package? Enter '1' for yes: ");
        boolean promo = Boolean.parseBoolean(sc.nextLine());
        MenuItems[] listb = new MenuItems[list.size()];
        list.toArray(listb);
        mainapp.SPList.add(new SetPackage(tempID, listb, name, promo, description));
        }catch(Exception e){
            System.out.println("Invalid Input! Please follow the correct format!");
            return;
        }   
        System.out.println("Here is the new Menu: ");
        printMenu();





    }
    
    /**
     * Updates new item into the menu.
     */
    public void updateMenu(){
        System.out.println("Here is the Menu: ");
        printMenu();
        System.out.println("Which Item would you like to update? Enter the itemID:");
        temp = sc.nextLine();
        try{
            for (int i=0;i<mainapp.MenuList.size();i++){
                if (temp.equals(mainapp.MenuList.get(i).getitemID())){
                    System.out.println("Enter the new name");
                    name = sc.nextLine();
                    mainapp.MenuList.get(i).setName(name);
                    System.out.println("Enter the new type");
                    type = sc.nextLine();
                    mainapp.MenuList.get(i).setType(type);
                    System.out.println("Enter the new description");
                    description = sc.nextLine();
                    mainapp.MenuList.get(i).setDescription(description);
                    System.out.println("Enter the new price");
                    price = Float.parseFloat(sc.nextLine());
                    mainapp.MenuList.get(i).setPrice(price);
                    System.out.println("Menu Item Updated!");
                    return;
    
                }
            }
        }catch(Exception e){
            System.out.println("No such item ID found");
            return;
        }
        System.out.println("Here is the new Menu: ");
        printMenu();
        
        

    }
    
    /**
     * Updates the new set package in the set package.
     */
    public void updateSet(){//Done!
        System.out.println("Here is the Menu: ");
        printMenu();
        System.out.println("Which Item would you like to update? Enter the itemID:");
        temp = sc.nextLine();
        try{
            for (int i=0;i<mainapp.SPList.size();i++){
                if (temp.equals(mainapp.SPList.get(i).getitemID())){
                    mainapp.SPList.get(i).setType("Set Item");
                    System.out.println("Enter the new name");
                    name = sc.nextLine();
                    mainapp.SPList.get(i).setName(name);
                    System.out.println("Enter the new description");
                    description = sc.nextLine();
                    mainapp.SPList.get(i).setDescription(description);
                    System.out.println("Enter in the list of Menuitems(type z to stop): ");
                    List <MenuItems> list = new ArrayList<>();
                    System.out.println("Enter MenuItem ID press z to exit: ");
                    item = sc.nextLine();
                    do{
                        
                        for (int x=0; x<mainapp.MenuList.size(); x++){
                            if (item.equals(mainapp.MenuList.get(x).getitemID())){
                                list.add(new MenuItems(mainapp.MenuList.get(i).getName(), mainapp.MenuList.get(i).getType(), mainapp.MenuList.get(i).getDescription(), mainapp.MenuList.get(i).getPrice() , item));
                            }
                        }
                        //j++;
                        System.out.println("Enter MenuItem ID: ");
                        item = sc.nextLine();
                        
                    }while (!item.equals("z"));
                    MenuItems[] listb = new MenuItems[list.size()];
                    list.toArray(listb);
                    mainapp.SPList.get(i).setSetList(listb);
                    System.out.println("Would you like to add Promotion on this set package? Enter '1' for yes: ");
                    boolean promo = Boolean.parseBoolean(sc.nextLine());
                    mainapp.SPList.get(i).setPromo(promo);
                    System.out.println("Successfully updated!");
                    return;
    
    
    
                }
            }

        }catch(Exception e){
            System.out.println("Invalid Set Package Item ID");
            return;
        }
        System.out.println("Here is the new Menu: ");
        printMenu();
 


    }
    
    /**
     * Removes an item from menu.
     */
    public void removeItem(){
        System.out.println("Here is the Menu: ");
        printMenu();
        System.out.println("Are you removing Menu or Set Package?");
        System.out.println("(1) Menu ");
        System.out.println("(2) Set Package");
        choice = Integer.parseInt(sc.nextLine());
        try{
            if (choice == 1){
                System.out.println("Which Item would you like to remove?");
                System.out.println("Enter the ItemID: ");
                temp = sc.nextLine();
                for (int i=0;i<mainapp.MenuList.size();i++){
                    if (temp.equals(mainapp.MenuList.get(i).getitemID())){
                        mainapp.MenuList.remove(i);
                        System.out.println("Removed Successfully!");
                        return;
    
                    }
                }
                
            }else if(choice == 2){
                System.out.println("Which Item would you like to remove?");
                System.out.println("Enter the ItemID: ");
                temp = sc.nextLine();
                for (int i=0;i<mainapp.SPList.size();i++){
                    if (temp.equals(mainapp.SPList.get(i).getitemID())){
                        mainapp.SPList.remove(i);
                        System.out.println("Removed Successfully!");
                        return;
                    }
                }
            }

        }catch(Exception e){
            System.out.println("Wrong choice try again!");
            return;
        }
            System.out.println("Here is the new Menu: ");
            printMenu();
        
        

    }
    
    /**
     * Prints out the total sales for the specific day or month.
     */
    public void totalSales(){
        ArrayList<MenuItems> TotalItems = new ArrayList<>(10000);
        int count =0;
        float totalrevenue=0;
        try{
        System.out.println("Do you want to see revenue for a day or for a month?");
        System.out.println("(1) Day");
        System.out.println("(2) Month");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 1){
            System.out.println("Enter month (e.g. 01, 02 ...12): ");
            String month = sc.nextLine();
            System.out.println("Enter day (e.g 00, 01, 02..., 21)");
            String day = sc.nextLine();
            String start = "2021-"+month+"-"+day+" 00:00:00";
            String end = "2021-"+month+"-"+day+" 23:59:00";
            //System.out.println(start);
            //ask the user for time
            //end = "2021-"+month+"-"+day+"-" +temp[0]+ temp[1] +"-" +temp[2]+temp[3] 
            //1450 temp 
            //Timestamp.valueOf(start)) 
            
            for(int i=0; i< mainapp.TotalOrders.size(); i++){
                if (mainapp.TotalOrders.get(i).getDateTime().after(Timestamp.valueOf(start)) && mainapp.TotalOrders.get(i).getDateTime().before(Timestamp.valueOf(end))){
                    TotalItems.addAll(mainapp.TotalOrders.get(i).getOrdersList());
                    //System.out.println(mainapp.TotalOrders.get(i).getOrdersList());

                }    
                
             }
        }else if (choice == 2){
            System.out.println("Enter month (int): ");
            String month = sc.nextLine();
            String start = "2021-"+month+"-01 00:00:00";
            String end = "2021-"+month+"-31 23:59:59";
            for(int i=0; i< mainapp.TotalOrders.size(); i++){
                //string to datetime 
                if (mainapp.TotalOrders.get(i).getDateTime().after(Timestamp.valueOf(start)) && mainapp.TotalOrders.get(i).getDateTime().before(Timestamp.valueOf(end))){
                    //System.out.println(mainapp.TotalOrders.get(i).getOrdersList());
                    TotalItems.addAll(mainapp.TotalOrders.get(i).getOrdersList());

                }
             }
        }
        }catch(Exception e){
            System.out.println("Invalid Input! Please Input the correct format!");
            return;
        }

        if (choice != 1 || choice != 2){
            System.out.println("Invalid Input! Please Input the correct format!");
            return;

        }


        //System.out.println(TotalItems.size());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("                      Sales Revenue                    ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("ItemId   ItemName                     Qty   Total Price");
        System.out.println();
        for (int i=0; i<mainapp.MenuList.size();i++){
            count = 0;
            temp = mainapp.MenuList.get(i).getitemID();
            
            for (int j=0; j<TotalItems.size();j++){
                //System.out.println(TotalItems.get(i).getitemID());
                if (TotalItems.get(j).getitemID().equals(temp)){
                    count++;
                }
            }
            totalrevenue += (float)count * mainapp.MenuList.get(i).getPrice();
            //System.out.println(count);
            System.out.printf("%s     %-20s          %d         $%.2f", mainapp.MenuList.get(i).getitemID(), mainapp.MenuList.get(i).getName(), count, (float)count*mainapp.MenuList.get(i).getPrice());
            System.out.println();
            
        }

        for (int i=0; i<mainapp.SPList.size();i++){
            count = 0;
            temp = mainapp.SPList.get(i).getitemID();
            for (int j=0; j<TotalItems.size();j++){
                if (TotalItems.get(j).getitemID().equals(temp)){
                    count++;
                }
                
            }
            totalrevenue += (float)count * mainapp.MenuList.get(i).getPrice();
            System.out.printf("%s     %-20s          %d         $%.2f", mainapp.SPList.get(i).getitemID(), mainapp.SPList.get(i).getName(), count, (float)count*mainapp.SPList.get(i).getPrice());
            System.out.println();
        }

        System.out.printf("Total Revenue: $%.2f", totalrevenue);
        System.out.println();

    }

    /**
     * Prints out all the item in the menu.
     */
    public static void printMenu(){
		int i = 0;
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Ala Carte Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
		List<MenuItems> menuitems = mainapp.MenuList; 
		while (i < menuitems.size()){ 
            System.out.println();
			System.out.printf("ID: %s Name: %s Type: %s       Price: $%f\n",menuitems.get(i).getitemID(), menuitems.get(i).getName(), menuitems.get(i).getType(),menuitems.get(i).getPrice());
            System.out.printf("Description: %s ", menuitems.get(i).getDescription());
            System.out.println();
            System.out.println("                                                 -----                                                   ");
			i++;
		}
		List<SetPackage> setpackages = mainapp.SPList; 
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Set Package Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		i = 0;
		while (i < setpackages.size()){ 
            System.out.println();
			System.out.printf("ID: %s Name: %s Type: %s Price: $%f\n",setpackages.get(i).getitemID(), setpackages.get(i).getName(), setpackages.get(i).getType(),setpackages.get(i).getPrice());
            System.out.printf("Description: %s ", setpackages.get(i).getDescription());
            System.out.println();
            System.out.println("                                                 -----                                                   ");
            i++;
		}
        System.out.println("---------------------------------------------------------------------------------------------------------");
	}
    

}
