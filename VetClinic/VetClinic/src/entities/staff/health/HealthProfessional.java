package entities.staff.health;

import entities.staff.Staff;
import enums.MedicalType;

    //That details the medical staff.
    public class HealthProfessional extends Staff {

	private MedicalType type;
   
	//Here we call the constructor to create an medical staff.
	public HealthProfessional(String name, Integer teamNumber, Float salary, MedicalType type) {
		this.name = name;
		this.teamNumber = teamNumber;
		this.salary = salary;
		this.type = type;
	}

	//This get and return a medical type.
	public MedicalType getType() {
		return type;
	}

	//That is how it will print the details on the system.
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nName: ");
		sb.append(this.name);
		sb.append("\nType: ");
		sb.append(this.type);
		sb.append("\nTeam Number: ");
		sb.append(this.teamNumber);
		sb.append("\nSalary: ");
		sb.append(this.salary + "\n");

		return sb.toString();
	}

}
