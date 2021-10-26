public class Reservation {

	public static final int MAX_Time = 2200;
	public static final int MIN_Time = 1000;
	public static final int MAX_ContactNum = 99999999;
	public static final int MAX_NumPeople = 10;
	
	private String CustomerName;
	private String Date;
	private Int Time;
	private Int ContactNumber;
	private Int NumPeople;

	public String getCustomerName() {
		// TODO - implement Reservation.getCustomerName
		return this.CustomerName;
	}

	/**
	 * 
	 * @param CustomerName
	 */
	public void setCustomerName(String CustomerName) {
		// TODO - implement Reservation.setCustomerName
		this.CustomerName = CustomerName;
	}

	public String getDate() {
		// TODO - implement Reservation.getDate
		return this.Date;
	}

	/**
	 * 
	 * @param Date
	 */
	public void setDate(String Date) {
		// TODO - implement Reservation.setDate
		this.Date = Date;
	}

	public Int getTime() {
		// TODO - implement Reservation.getTime
		return this.Time;
	}

	/**
	 * 
	 * @param Time
	 */
	public void setTime(Int Time) {
		// TODO - implement Reservation.setTime
		if (Time > MAX_Time && Time < MIN_Time) {
			System.out.println("Please enter a valid time. ");
		}else {
			this.Time = Time ;
		}
	}

	public Int getContactNumber() {
		// TODO - implement Reservation.getContactNumber
		return this.ContactNum ;
	}

	/**
	 * 
	 * @param ContactNumber
	 */
	public void setContactNumber(Int ContactNumber) {
		// TODO - implement Reservation.setContactNumber
		if ( ContactNum > MAX_ContactNum) {
			System.out.println("Please enter a valid contact number. ");
		}else {
			this.ContactNum = ContactNum ;
		}
	}

	public Int getNumPeople() {
		// TODO - implement Reservation.getNumPeople
		return this.NumPeople ;
	}

	/**
	 * 
	 * @param NumPeople
	 */
	public void setNumPeople(Int NumPeople) {
		// TODO - implement Reservation.setNumPeople
		if ( NumPeople > MAX_NumPeople) {
			System.out.println("Sorry, the max numble of people per table is " + MAX_NumPeople);
		}else {
			this.NumPeople = NumPeople;
		}
	}

	public void getAttribute() {
		// TODO - implement Reservation.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement Reservation.setAttribute
		throw new UnsupportedOperationException();
	}

}
