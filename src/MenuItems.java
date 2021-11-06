package src;
/**
 * MenuItems
 */


 //itemID is always AC<no>
 //AC stands for ala carte 
public class MenuItems {
	//private enum MenuType { MAINCOURSE, DRINKS, DESERT, SETPACKAGE}; whether we wanna use enum 
	private String Type;
	private String Name;
	private float Price;
	private String itemID;
	private String Description;
	//DO NOT USE NAME TO DO anything
	//always use ID because ID is unique 
	 
	/*no setting functions at all


	*/

	public MenuItems(String Name,String Type, String Description, float Price) {
        this.Name = Name;
        this.Type = Type;
        this.Description = Description;
        this.Price = Price;
		//remember this needs to be parsed through flat file 
	}

	public String getitemID(){
		return this.itemID;
	}

	public String setItemID(String itemID){
		return this.itemID = itemID;
	}

	public float getPrice(){
		return this.Price;
	}

	public String getName() {
		return this.Name;
	}

	/**
	 * 
	 * @param Name
	 */
	public void setName(String Name) {
		this.Name = Name;
	}

	public String getType() {
		return this.Type;
	}

	/**
	 * 
	 * @param Type
	 */
	public void setType(String Type) {
		this.Type = Type;
	}

	public String getDescription() {
		return this.Description;
	}

	/**
	 * 
	 * @param Description
	 */
	public void setDescription(String Description) {
		this.Description = Description;
	}

	/**
	 * 
	 * @param Price
	 */
	public void setPrice(float Price) {
		this.Price = Price;
	}

	public void printMenuItems(){
		System.out.println(this.Name);
	}



	
}