public class SetPackage extends MenuItems {

	private boolean Promo;
	
	public SetPackage(MenuItems[] SetList, String Name, String Description, boolean promo) {
		super(Name,"Set Item",Description, (double)0);
		this.setPromo(promo);
		super.setPrice(calculatePrice(SetList));
	}

	protected Double calculatePrice(MenuItems[] SetList) {
		Double price = (double) 0;
		int i;
		for (i =0; i < SetList.length; i++) {
			price += SetList[i].getPrice();
		}
		
		if (getPromo()) {
			price = price * 0.8;
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
