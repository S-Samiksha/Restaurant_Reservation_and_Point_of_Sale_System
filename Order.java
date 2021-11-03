import java.util.*;

public class Order {

	Collection<SetPackage> setPackages;
	Collection<MenuItems> Alacarte; //this is not private --> do we change?
	Staff Staff;   
	Table Table;
	private Double TotalPrice;
	private Order[] MenuItems;

	public void getOrder() {
		// TODO - implement Order.getOrder
		throw new UnsupportedOperationException();
	}
	//how is getorder a void???

	/**
	 * 
	 * @param MenuItems
	 * @param SetPackage
	 */
	public void setOrder(Order[] MenuItems, Package[] SetPackage) {
		// TODO - implement Order.setOrder
		throw new UnsupportedOperationException();
	}

	public Double getTotalPrice() {
		// TODO - implement Order.getTotalPrice
		throw new UnsupportedOperationException();
	}

	public void getStaff() {
		// TODO - implement Order.getStaff
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Staff
	 */
	public void setStaff(staff Staff) {
		// TODO - implement Order.setStaff
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param MenuItems
	 */
	public void removeFromOrder(String MenuItems) { //pass in the item to be removed
		// TODO - implement Order.removeFromOrder
		//throw new UnsupportedOperationException();
		int i = 0;
		int size;
		size = MenuItems.length; //get size of array
		for (i =0; i<size;i++) { //point at every item to find a match
			if(Order[i] == MenuItems) {
				//remove that item
			}else {
				System.out.println("Item cannot be removed.");
			}
		}
		System.out.println("Order removed.");
		
	}

	public void printOrder() {
		// TODO - implement Order.printOrder
		//throw new UnsupportedOperationException();
		int i;
		int size;
		size = MenuItems.length;
		for(i=0;i<size;i++) {
			System.out.println("The order list is: "+ Order[i].MenuItems);
		}
	}

	public void PrintMenu() {
		// TODO - implement Order.PrintMenu
		//throw new UnsupportedOperationException();
		//to print the full menu--> the below collection 
		//Collection<SetPackage> setPackages;
		//Collection<MenuItems> Alacarte;
	}

	public boolean confirmOrder(int i) {
		// TODO - implement Order.confirmOrder
		//throw new UnsupportedOperationException();
		//require a scanner to ask for confirmation of order in main function
		if(i == 1) {
			System.out.println("Your order is confirmed");
			return true;
		}else {
			System.out.println("Order is not confirmed.Please enter '1' to confirm.");
			return false;
		}
	}

	public int getTable() {
		// TODO - implement Order.getTable
		//throw new UnsupportedOperationException();
		return this.TableNumber;
	}

	/**
	 * 
	 * @param Table
	 */
	public void setTable(int TableNumber) {
		// TODO - implement Order.setTable
		//throw new UnsupportedOperationException();
		this.TableNumber = TableNumber;
	}

	public void printOrderInvoice() {
		// TODO - implement Order.printOrderInvoice
		//throw new UnsupportedOperationException();
		System.out.println("Printing order invoice...");
	}

}
