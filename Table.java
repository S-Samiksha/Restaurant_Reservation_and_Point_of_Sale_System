public class Table {

	private Int Capacity;
	public static final int MAX_CAPACITY = 50;
	private Int TableNumber;

	protected Int getCapacity() {
		// TODO - implement Table.getCapacity
		return this.Capacity;
	}

	/**
	 * 
	 * @param Int
	 */
	protected void setCapacity(Capacity Int) {
		// TODO - implement Table.setCapacity
		if (Capacity > MAX_CAPACITY) {
			System.out.println("Table is full");
		}else {
			this.Capacity = this.Capacity + Capacity;
		}
	}

	protected Int getTableNumber() {
		// TODO - implement Table.getTableNumber
		return this.Capacity;
	}

	/**
	 * 
	 * @param Int
	 */
	protected void setTableNumber(TableNumber Int) {
		// TODO - implement Table.setTableNumber
		this.TableNum = TableNum;
	}

	/**
	 * 
	 * @param Int
	 */
	public Table(Capacity Int) {
		// TODO - implement Table.Table
		throw new UnsupportedOperationException();
	}

}
