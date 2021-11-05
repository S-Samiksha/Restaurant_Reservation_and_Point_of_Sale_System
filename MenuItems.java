public class MenuItems {

	private String Name;
	private String Type;
	private String Description;
	private Double Price;

	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getType() {
        	return this.Type;
	}

	public void setType(String Type) {
        	this.Type = Type;
	}

	public String getDescription() {
        	return this.Description;
	}

	public void setDescription(String Description) {
        	this.Description = Description;
	}

	public Double getPrice() {
        	return this.Price;
	}

	public void setPrice(Double Price) {
        	this.Price = Price;
	}

	public MenuItems(String Name,String Type, String Description, Double Price) {
        this.Name = Name;
        this.Type = Type;
        this.Description = Description;
        this.Price = Price;
	}
}
