public class Price {

	private float totalPrice = 0;
	private boolean member;

	public float getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * 
	 * @param Order
	 */
	public float calculatePrice(OrderedFood[] Order) {
		// TODO - implement Price.calculatePrice
		throw new UnsupportedOperationException();
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