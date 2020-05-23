package entities.staff;

    //This class represents an abstract staff entity.
    public abstract class Staff {

	protected String name;
	// Unique entity.
	protected Integer teamNumber;
	protected Float salary;

	public Integer getTeamNumber() {
		return this.teamNumber;
	}

	public String getName() {
		return this.name;
	}

}
