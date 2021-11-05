package src;
/**
 * SetPackage
 */
//if we calling the objects from flat file.... 
//technically we do not need to inherit but let's see how this goes if it throws an error we might have to cancel inheritance
//cuz in flat file we have an array of items, so we need to parse it and then get the total price 
//DO NOT USE NAME TO DO anything
//always use ID because ID is unique 

//item id is SP<no.>
//SP stands for set package
public class SetPackage extends MenuItems {

	private boolean Promo;
	
	public SetPackage(MenuItems[] SetList, String Name, String Description, boolean promo) {
		super(Name,"Set Item",Description, (float)0);
		this.setPromo(promo);
		super.setPrice(calculatePrice(SetList));
	}

	protected float calculatePrice(MenuItems[] SetList) {
		float price = (float) 0;
		int i;
		for (i =0; i < SetList.length; i++) {
			price += SetList[i].getPrice();
		}
		
		if (getPromo()) {
			price = price * (float)0.8;
		}
		return price;
		
	}

	public boolean getPromo() {
		return this.Promo;
	}

	public void setPromo(boolean promo) {
		this.Promo = promo;
	}

}
