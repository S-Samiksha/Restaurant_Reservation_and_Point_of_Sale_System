package src;

 //itemID is always AC<no>
 //AC stands for ala carte 
	/**
	 * Shows the details of different item in the menu.
	 * An order can have many items.
	 *
	 */
public class MenuItems {
	/**
	 * Main course, drinks, desert or set package. 
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


	
	/**
	 * Creates a new item in menu.
	 * 
	 * @param itemID This item's ID.
	 * 				Item ID should be unique.
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
	}

	/**
	 * Gets this item's unique ID in this menu.
	 * @return This item's ID.
	 */
	public String getitemID(){
		return this.itemID;
	}

	/**
	 * Changes the ID of this item.
	 * @param itemID This item's unique ID.
	 * @return This item's unique ID
	 */
	public String setItemID(String itemID){
		return this.itemID = itemID;
	}

	/**
	 * Gets the individual price of this item in this menu.
	 * @return This item's price.
	 */
	public float getPrice(){
		return this.Price;
	}

	/**
	 * Gets the name of this item in this menu.
	 * @return This item's full name.
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
	 * Gets the type of this item in the menu.
	 * @return This item's type.
	 */
	public String getType() {
		return this.Type;
	}

	/**
	 * Changes the type of this item.
	 * @param Type This item's type.
	 */
	public void setType(String Type) {
		this.Type = Type;
	}

	/**
	 * Gets the specific description of the item.
	 * Prevents allergic reaction for customer.
	 * @return This item's detailed description.
	 */
	public String getDescription() {
		return this.Description;
	}

	/**
	 * Changes the item's description.
	 * This might be due to change in ingredient/cooking method.
	 * @param Description This item's description.
	 * 					Includes possible allergies.
	 */
	public void setDescription(String Description) {
		this.Description = Description;
	}

	/**
	 * Changes the price of the item.
	 * Changes customer preference and total revenue.
	 * @param Price This item's price.
	 */
	public void setPrice(float Price) {
		this.Price = Price;
	}

}
