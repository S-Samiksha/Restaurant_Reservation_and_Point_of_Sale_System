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
	public void removeFromOrder(Food MenuItems) {
		// TODO - implement Order.removeFromOrder
		throw new UnsupportedOperationException();
	}

	public void printOrder() {
		// TODO - implement Order.printOrder
		throw new UnsupportedOperationException();
	}

	public void PrintMenu() {
		// TODO - implement Order.PrintMenu
		throw new UnsupportedOperationException();
	}

	public boolean confirmOrder() {
		// TODO - implement Order.confirmOrder
		throw new UnsupportedOperationException();
	}

	public void getTable() {
		// TODO - implement Order.getTable
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Table
	 */
	public void setTable(table Table) {
		// TODO - implement Order.setTable
		throw new UnsupportedOperationException();
	}

	public void printOrderInvoice() {
		// TODO - implement Order.printOrderInvoice
		throw new UnsupportedOperationException();
	}

}