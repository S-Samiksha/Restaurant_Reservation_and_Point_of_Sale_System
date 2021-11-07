package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.sql.Timestamp; //import this 

public class SecurityAccess{

    private String temp, name, type, description, item;
    private float price;
    //private MenuItems[] list; 
    private int choice;
    private Scanner sc = new Scanner(System.in);

    public SecurityAccess(){

    }

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

    public void createMenu(){
        try{
            int i = mainapp.MenuList.size()+1;
            String tempID = "AC"+ Integer.toHexString(i);
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
            price = Integer.parseInt(sc.nextLine());
            mainapp.MenuList.get(i).setPrice(price);
            mainapp.MenuList.add(new MenuItems(name,type, description, price,  tempID));
            System.out.println("Successfully added the MenuItems!");
            

        }catch(Exception e){
            System.out.println("You entered smth wrong. Please try again!");
        }
        
        
    }
    public void createSet(){ //Done!
        int i = mainapp.SPList.size()+1;
        String tempID = "SP"+ Integer.toHexString(i);
        System.out.println("Enter the new name");
        name = sc.nextLine();
        System.out.println("Enter the new type");
        type = sc.nextLine();
        System.out.println("Enter the new description");
        description = sc.nextLine();
        System.out.println("Enter in the list of Menuitems(type z to stop): ");
        int j=0;
        MenuItems[] list = new MenuItems[10];
        System.out.println("Enter MenuItem ID press z to exit: ");
        item = sc.nextLine();
        do{
            
            for (int x=0; x<mainapp.MenuList.size(); x++){
                if (item.equals(mainapp.MenuList.get(x).getitemID())){
                    list[j] = new MenuItems(mainapp.MenuList.get(i).getName(), mainapp.MenuList.get(i).getType(), mainapp.MenuList.get(i).getDescription(), mainapp.MenuList.get(i).getPrice() , item);
                }
            }
            j++;
            System.out.println("Enter MenuItem ID: ");
            item = sc.nextLine();
            
        }while (item != "z");
        System.out.println("Would you like to add Promotion on this set package? Enter 'Y' for yes: ");
        boolean promo = Boolean.parseBoolean(sc.nextLine());
        mainapp.SPList.add(new SetPackage(tempID, list, name, promo, description));





    }
    public void updateMenu(){//Done!
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
                    price = Integer.parseInt(sc.nextLine());
                    mainapp.MenuList.get(i).setPrice(price);
                    System.out.println("Menu Item Updated!");
                    return;
    
                }
            }
        }catch(Exception e){
            System.out.println("No such item ID found");
        }
        
        

    }
    public void updateSet(){//Done!
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
                    int j=0;
                    MenuItems[] list = new MenuItems[10];
                    System.out.println("Enter MenuItem ID press z to exit: ");
                    item = sc.nextLine();
                    do{
                        
                        for (int x=0; x<mainapp.MenuList.size(); x++){
                            if (item.equals(mainapp.MenuList.get(x).getitemID())){
                                list[j] = new MenuItems(mainapp.MenuList.get(i).getName(), mainapp.MenuList.get(i).getType(), mainapp.MenuList.get(i).getDescription(), mainapp.MenuList.get(i).getPrice() , item);
                            }
                        }
                        j++;
                        System.out.println("Enter MenuItem ID: ");
                        item = sc.nextLine();
                        
                    }while (item != "z");
    
                    mainapp.SPList.get(i).setSetList(list);
                    System.out.println("Successfully updated!");
                    return;
    
    
    
                }
            }

        }catch(Exception e){
            System.out.println("Invalid Set Package Item ID");
        }
 


    }
    public void removeItem(){
        System.out.println("Are you removing Menu or Set Package?");
        System.out.println("(1) Menu ");
        System.out.println("(2) Set Package");
        choice = sc.nextInt();
        try{
            if (choice == 1){
                System.out.println("Which Item would you like to remove? Enter the itemID");
                temp = sc.nextLine();
                for (int i=0;i<mainapp.MenuList.size();i++){
                    if (temp.equals(mainapp.MenuList.get(i).getitemID())){
                        mainapp.MenuList.remove(i);
                        System.out.println("Removed Successfully!");
                        return;
    
                    }
                }
            }else if(choice == 2){
                System.out.println("Which Item would you like to remove? Enter the itemID");
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
        }
        

    }
    public void totalSales(){
        List<MenuItems> TotalItems = new ArrayList<>(10000);
        float count =0;
        float totalrevenue=0;
        System.out.println("Do you want to see revenue for a day or for a month?");
        System.out.println("(1) Day");
        System.out.println("(2) Month");
        int choice = sc.nextInt();
        if (choice == 1){
            System.out.println("Enter month (e.g. 01, 02 ...12): ");
            String month = sc.nextLine();
            System.out.println("Enter day (e.g 00, 01, 02..., 21)");
            String day = sc.nextLine();
            String start = "2021-"+month+"-"+day+"-00-00";
            String end = "2021-"+month+"-"+day+"-23-59";
            //ask the user for time
            //end = "2021-"+month+"-"+day+"-" +temp[0]+ temp[1] +"-" +temp[2]+temp[3] 
            //1450 temp 
            //Timestamp.valueOf(start)) 
            
            for(int i=0; i< mainapp.TotalOrders.size(); i++){
                if (mainapp.TotalOrders.get(i).getDateTime().after(Timestamp.valueOf(start)) && mainapp.TotalOrders.get(i).getDateTime().before(Timestamp.valueOf(end))){
                    TotalItems.addAll(mainapp.TotalOrders.get(i).getOrdersList());
                }    
                
             }
        }else if (choice == 2){
            System.out.println("Enter month (int): ");
            String month = sc.nextLine();
            String start = "2021-"+month+"-01-00-00";
            String end = "2021-"+month+"-31-23-59";
            for(int i=0; i< mainapp.TotalOrders.size(); i++){
                //string to datetime 
                if (mainapp.TotalOrders.get(i).getDateTime().after(Timestamp.valueOf(start)) && mainapp.TotalOrders.get(i).getDateTime().before(Timestamp.valueOf(end))){
                    TotalItems.addAll(mainapp.TotalOrders.get(i).getOrdersList());
                }
             }
        }

        System.out.println("ItemId  ItemName Qty  Total Price");
        for (int i=0; i<mainapp.MenuList.size();i++){
            temp = mainapp.MenuList.get(i).getitemID();
            for (int j=0; j<TotalItems.size();j++){
                if (TotalItems.get(i).getitemID().equals(temp)){
                    count++;
                }
                totalrevenue += count * mainapp.MenuList.get(i).getPrice();
                System.out.printf("%s     %s      %d     %.2f", mainapp.MenuList.get(i).getitemID(), mainapp.MenuList.get(i).getName(), count, (float)count*mainapp.MenuList.get(i).getPrice());
                System.out.println();
            }
        }

        for (int i=0; i<mainapp.MenuList.size();i++){
            temp = mainapp.SPList.get(i).getitemID();
            for (int j=0; j<TotalItems.size();j++){
                if (TotalItems.get(i).getitemID().equals(temp)){
                    count++;
                }
                totalrevenue += count * mainapp.MenuList.get(i).getPrice();
                System.out.printf("%s     %s      %d     %.2f", mainapp.SPList.get(i).getitemID(), mainapp.SPList.get(i).getName(), count, (float)count*mainapp.SPList.get(i).getPrice());
                System.out.println();
            }
        }

        System.out.printf("Total Revenue: %.2f", totalrevenue);
        System.out.println();







        


    }
    

}