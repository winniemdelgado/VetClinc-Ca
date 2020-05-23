package entities.staff.admin;

import entities.staff.Staff;
import enums.AdminType;
import enums.Task;

    //That details the administrative staff.
    public class AdminProfessional extends Staff {
 
	private Task task;
	private AdminType type;

	//Here we call the constructor to create an administrative staff.
	public AdminProfessional(String name, Integer teamNumber, Float salary, AdminType type) {
		this.name = name;
		this.teamNumber = teamNumber;
		this.salary = salary;
		this.type = type;
	}
    //This get the task per staff.
	public Task getTask() {
		return this.task;
	}
	//This set the task per staff.
	public void setTask(Task task) {
		this.task = task;
	}
    //This get and return the animal type.
	public AdminType getType() {
		return this.type;
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
		sb.append(this.salary);
		sb.append("\nTask: ");
		sb.append(this.task.getName() + "\n");

		return sb.toString();
	}

}
