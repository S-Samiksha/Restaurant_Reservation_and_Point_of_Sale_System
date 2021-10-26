public class Price {

	private float totalPrice = 0;
	private boolean member;
	private MenuItems[] temp_order;
	private int i=0;

	public float getTotalPrice() {

		return this.totalPrice;
	}

	/**
	 * 
	 * @param Order
	 */
	public float calculatePrice(Order OrderedFood) {
		// throw new UnsupportedOperationException();

		temp_order = OrderedFood.getOrder();
		i=0;
		while(temp_order[i].getPrice() != 0){
			totalPrice += temp_order[i].getPrice();
			i++;
		}
		
		
		return totalPrice;



	}

	public boolean getMember() {
		return this.member;

	}

	/**
	 * 
	 * @param member
	 */
	public void setMember(boolean member) {
		this.member = member;
	}

}