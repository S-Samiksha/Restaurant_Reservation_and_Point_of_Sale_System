package src;

 //itemID is always AC<no>
 //AC stands for ala carte 
	/**
	 * Shows the details of different item in the menu.
	 * A table can order many items.
	 *
	 */
public class MenuItems {
	//private enum MenuType { MAINCOURSE, DRINKS, DESERT, SETPACKAGE}; whether we wanna use enum 
	/**
	 * Main course, drinks, desert or setpackage.
	 */
	private String Type;
	/**
	 * Name of the item in the menu.
	 */
	private String Name;
	/**
	 * Individual price of item in the menu.
	 */
	private float Price;
	/**
	 * Unique ID of the item in menu. key in by staff.
	 */
	private String itemID;
	/**
	 * Clear description of item in menu for customer.
	 */
	private String Description;
	//DO NOT USE NAME TO DO anything
	//always use ID because ID is unique 
	 
	/*no setting functions at all


	*/

	
	/**
	 * Create a new item in menu.
	 * 
	 * @param itemID This item's ID.
	 * @param Name This item's name.
	 * @param Type This item's type.
	 * @param Price This item's price.
	 * @param Description This item's description.
	 */
	public MenuItems(String itemID, String Name,String Type,float Price,String Description) {
        this.Name = Name;
        this.Type = Type;
        this.Description = Description;
        this.Price = Price;
		this.itemID = itemID;
		//remember this needs to be parsed through flat file 
	}

	/**
	 * Gets the specific item ID in the menu.
	 * @return this item's ID.
	 */
	public String getitemID(){
		return this.itemID;
	}

	/**
	 * Change the ID of the item.
	 * @param itemID.
	 * @return
	 */
	public String setItemID(String itemID){
		return this.itemID = itemID;
	}

	/**
	 * Specific individual price of the item in menu.
	 * @return This item's price.
	 */
	public float getPrice(){
		return this.Price;
	}

	/**
	 * Name of item in menu.
	 * @return This item's name.
	 */
	public String getName() {
		return this.Name;
	}

	/**
	 * Changes the name of the item.
	 * Needs to update in menu to prevent confusion for customer.
	 * @param Name This item's name .
	 * 				Should not be the same name as before.
	 */
	public void setName(String Name) {
		this.Name = Name;
	}

	/**
	 * Gets the type of item in the menu.
	 * @return This item's type.
	 */
	public String getType() {
		return this.Type;
	}

	/**
	 * Changes the type of item.
	 * Should not be the same as before.
	 * @param Type This item's type.
	 */
	public void setType(String Type) {
		this.Type = Type;
	}

	/**
	 * Gets the specific description of the item.
	 * Able to prevent allergies for customer.
	 * @return This item's description.
	 */
	public String getDescription() {
		return this.Description;
	}

	/**
	 * Changes the item's description.
	 * This might be due to change in ingredient/cooking method.
	 * @param Description This item's description.
	 * 						Should include possible allergies.
	 */
	public void setDescription(String Description) {
		this.Description = Description;
	}

	/**
	 * Changes the price of the item.
	 * Might change customer preference and total revenue.
	 * @param Price This item's price.
	 */
	public void setPrice(float Price) {
		this.Price = Price;
	}

	// print menu moved to order	
}
