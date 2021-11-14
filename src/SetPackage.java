package src;

//item id is SP<no.>
//SP stands for set package

	/**
	 * Combines specific items in the menu into set packages.
	 * A set package can have many item in the menu.
	 */
public class SetPackage extends MenuItems {

	/**
	 * Indicates the availability of promotion for this set package.
	 */
	private boolean Promo;
	/**
	 * List of item in this set package.
	 */
	private MenuItems[] SetList;
	
	/**
	 * Gets the list of item in this set package.
	 * @return This Set Package's list of item.
	 */
	public MenuItems[] getSetList(){
		return this.SetList;
	}

	/**
	 * Changes the list of item and price for this set package.
	 * @param NewSetList This Set Package's new list.
	 */
	public void setSetList(MenuItems[] NewSetList){
		this.SetList = NewSetList;
		this.setPrice(calculatePrice(NewSetList));
	}

	/**
	 * Creates a new set package with required detail. 
	 * This new set package should not be the same as other set package.
	 * @param itemID This Set Package's item ID.
	 * @param SetList This Set Package's list of items.
	 * @param Name This Set Package's name.
	 * @param promo This Set Package's promotional availability.
	 * @param Description This Set Package's description.
	 */
	public SetPackage(String itemID, MenuItems[] SetList, String Name,boolean promo, String Description) {
		super(itemID,Name,"Set Item",(float)0,Description);
		this.setPromo(promo);
		this.SetList = SetList;
		super.setPrice(calculatePrice(SetList));
	}


	/**
	 * Calculates the total price of item in the set package with promotion (if available).
	 * @param SetList This Set Package's list of item.
	 * @return This Set Package's total price.
	 */
	protected float calculatePrice(MenuItems[] SetList) {
		float price = (float) 0;
		int i;
		for (i =0; i < SetList.length; i++) {
			price += SetList[i].getPrice();
		}
		price = price * (float)0.9;
		if (getPromo()) {
			price = price * (float)0.85;
		}
		return price;
	}

	/**
	 * Gets this set package's promotional status.
	 * @return This Set Package's promotional status.
	 */
	public boolean getPromo() {
		return this.Promo;
	}

	/**
	 * Changes this set package's promotional status.
	 * @param promo This Set Package's promotional status. 
	 */
	public void setPromo(boolean promo) {
		this.Promo = promo;
	}

}
