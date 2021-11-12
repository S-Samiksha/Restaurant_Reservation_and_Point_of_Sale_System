package src;

//this one also, parse using flat file 
// Honestly do not need set functions but we should discuss this!
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
	private String JobTitle;  //this is needed but not inside the class diagram 
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
		//throw new UnsupportedOperationException();
		return this.Name;
	}

	/**Gets the gender of this staff.
	 * @param String This Staff's gender.
	 */
	public String getGender() {
		//throw new UnsupportedOperationException();
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
	 * 
	 * @param String
	 */
	/*protected void setGender(String Gender) { //i dont think we need this 
		//checking the various type of inputs 
		switch(Gender){
			case "Female":
			case "female":
			case "F":
			case "f":
				this.Gender = "Female";
				break;
			case "Male":
			case "male":
			case "M" :
			case "m":
				this.Gender = "Male";
				break;
			default:
				this.Gender = "Not Specified";
				break;

		}

	}*/

	/**
	 * Gets the ID of this staff.
	 * @return This Staff's employee ID.
	 */
	public String getEmployeeID() {
		// throw new UnsupportedOperationException();
		return this.EmployeeID;
	}


	/**
	 * Gets the contact number of this staff.
	 * @return This Staff's contact number.
	 */
	public int getContactNumber() {
		// throw new UnsupportedOperationException();
		return this.ContactNumber;
	}


	/*protected void setContactNumber(int ContactNumber) { //this one also dont need 
		// throw new UnsupportedOperationException();
		//check if the string length is 8 digits or not, and valid (in terms of singapore number)
		temp = ContactNumber;
		length = 0; //reinitialize this method may be called twice 
		while (temp>0){
			temp /= 10;
			length++;
		}
		if (length == 8){
			this.ContactNumber = ContactNumber;
		}else{
			System.out.println("Not valid contact number");
			return;
		}

	}*/

	/**
	 * Checks is this staff is manage.
	 * @return If this Staff is manager
	 * 			Return true if is manager and false if is not.
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
	 * @param Available This Staff's availability.
	 */
	public void setisAvailable(boolean available){
		this.isAvailable = available;
	}

}
