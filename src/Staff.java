package src;

/**
 * Represents a staff in the restaurant.
 * A restaurant can have many staff.
 * A staff will be assigned to an order and reservation.
 */
public class Staff {
	/**
	 * Full name of this staff.
	 */
	private String Name;
	/**
	 * Gender of this staff.
	 */
	private String Gender;
	/**
	 * ID of this staff.
	 */
	private String EmployeeID;
	/**
	 * Contact number of this staff.
	 */
	private int ContactNumber;
	/**
	 * Job title of this staff.
	 */
	private String JobTitle; 
	/**
	 * Availability of this staff to server new customer.
	 */
	private boolean isAvailable;

	/**
	 * Creates a new staff with details.
	 * Legal process is required to sign contract with this new staff.
	 * @param EmployeeID This Staff's employee ID.
	 * @param Name This Staff's name.
	 * 				Should include full name.
	 * 				Should not be changed after staff enrollment.
	 * @param Gender This Staff's gender.
	 * 					Should not be changed after staff enrollment.
	 * @param ContactNumber This Staff's contact number.
	 * 						Should not be changed after staff enrollment.
	 * @param JobTitle This Staff's job title.
	 * 					Must be either waiter or manager.
	 * @param isAvailaible This Staff's availability.
	 * 						Staff will always be initialized as available.
	 */
	public Staff(String EmployeeID, String Name, String Gender, int ContactNumber, String JobTitle, boolean isAvailaible){
		this.Name = Name;
		this.Gender = Gender;
		this.EmployeeID = EmployeeID;
		this.ContactNumber = ContactNumber;
		this.JobTitle = JobTitle;
		this.isAvailable = isAvailaible;
	}

	/**
	 * Gets the full name of this staff.
	 * @return This Staff's full name.
	 */
	public String getName() {
		return this.Name;
	}

	/**
	 * Gets the gender of this staff.
	 * @return String This Staff's gender.
	 */
	public String getGender() {
		return this.Gender;
	}

	/**
	 * Gets the availability of this staff.
	 * @return This Staff's availability.
	 * 			Only able to serve new customer when staff is available.
	 */
	public boolean getisAvailable(){
		return this.isAvailable;
	}

	/**
	 * Gets the ID of this staff.
	 * @return This Staff's employee ID.
	 */
	public String getEmployeeID() {
		return this.EmployeeID;
	}


	/**
	 * Gets the contact number of this staff.
	 * @return This Staff's contact number.
	 */
	public int getContactNumber() {
		return this.ContactNumber;
	}

	/**
	 * Checks is this staff a manage.
	 * @return True if is manager and false if is not.
	 */
	public boolean isManager(){
		if (this.JobTitle.equals("Manager")){
			return true;
		}else{
			return false; 
		}
	}
	
	/**
	 * Changes the availability of this staff.
	 * @param available This Staff's availability.
	 */
	public void setisAvailable(boolean available){
		this.isAvailable = available;
	}

}
