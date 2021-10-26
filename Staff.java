public class Staff {

	private String Name;
	private String Gender;
	private String EmployeeID;
	private int ContactNumber;
	private int temp, length;

	public String getName() {

		//throw new UnsupportedOperationException();
		return this.Name;
	}

	/**
	 * 
	 * @param String
	 */
	protected void setName(String Name) {
		//throw new UnsupportedOperationException();
		this.Name = Name; 
	}

	public String getGender() {
		//throw new UnsupportedOperationException();
		return this.Gender;
	}

	/**
	 * 
	 * @param String
	 */
	protected void setGender(String Gender) {
		//throw new UnsupportedOperationException();
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

	}

	public String getEmployeeID() {
		// throw new UnsupportedOperationException();
		return this.EmployeeID;
	}

	/**
	 * 
	 * @param String
	 */
	protected void setEmployeeID( String EmployeeID) {
		// throw new UnsupportedOperationException();
		this.EmployeeID = EmployeeID;

		
	}

	public int getContactNumber() {
		// throw new UnsupportedOperationException();
		return this.ContactNumber;
	}

	/**
	 * 
	 * @param Double
	 */
	protected void setContactNumber(int ContactNumber) {
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

	}

}