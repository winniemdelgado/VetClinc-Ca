package entities.animal;

import entities.staff.health.HealthProfessional;
import enums.AnimalType;

    //This class represents the animal entity
    public class Animal {

	private String name;
	private AnimalType type;
	private Float age;
	private String medicalCondition;
	private HealthProfessional healthProfessional;
    
	//Here we call the constructor to create an animal
	public Animal(String name, Float age, AnimalType type, String medicalCondition) {
		this.name = name;
		this.age = age;
		this.type = type;
		this.medicalCondition = medicalCondition;
	}

	//This set the staff to take care of the animal
	public void setHealthProfessional(HealthProfessional healthProfessional) {
		this.healthProfessional = healthProfessional;
	}
    //This get and return a health staff member.
	public HealthProfessional getHealthProfessional() {
		return this.healthProfessional;
	}
    //This get and return the animal name.
	public String getName() {
		return this.name;
	}
    //This brings the type of animal.
	public AnimalType getType() {
		return this.type;
	}

	//That is how it will print the details on the system.
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nType of Animal: ");
		sb.append(this.type.getName());
		sb.append("\nName of animal: ");
		sb.append(this.name);
		sb.append("\nAge: ");
		sb.append(this.age);
		sb.append("\nMedical Condition: ");
		sb.append(this.medicalCondition);
		sb.append("\nHealth Professional: ");
		sb.append(this.healthProfessional.getName() + " - " + this.healthProfessional.getTeamNumber() + "\n");

		return sb.toString();
	}

}
