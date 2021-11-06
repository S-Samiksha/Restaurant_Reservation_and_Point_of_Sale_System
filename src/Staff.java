package src;

//this one also, parse using flat file 
// Honestly do not need set functions but we should discuss this!

public class Staff {
	private String Name;
	private String Gender;
	private String EmployeeID;
	private int ContactNumber;
	private String JobTitle;  //this is needed but not inside the class diagram 
	private int temp, length;


	public Staff(String EmployeeID, String Name, String Gender, int ContactNumber, String JobTitle){
		this.Name = Name;
		this.Gender = Gender;
		this.EmployeeID = EmployeeID;
		this.ContactNumber = ContactNumber;
		this.JobTitle = JobTitle;
	}

	public String getName() {
		//throw new UnsupportedOperationException();
		return this.Name;
	}

	/**
	 * 
	 * @param String
	 */

	public String getGender() {
		//throw new UnsupportedOperationException();
		return this.Gender;
	}

	/**
	 * 
	 * @param String
	 */
	protected void setGender(String Gender) { //i dont think we need this 
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

	}

	public String getEmployeeID() {
		// throw new UnsupportedOperationException();
		return this.EmployeeID;
	}


	public int getContactNumber() {
		// throw new UnsupportedOperationException();
		return this.ContactNumber;
	}

	/**
	 * 
	 * @param Double
	 */
	protected void setContactNumber(int ContactNumber) { //this one also dont need 
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


	public boolean isManager(){
		if (this.JobTitle == "manager"){
			return true;
		}else{
			return false; 
		}
	}


}