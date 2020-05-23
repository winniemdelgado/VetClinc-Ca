package entities.staff;

import java.util.ArrayList;
import java.util.Random;

import entities.staff.admin.AdminProfessional;
import entities.staff.health.HealthProfessional;

    //This class is responsible to manage the staffs.
    public abstract class StaffProfessionalsRepository {

	final protected static int BEGIN_OF_ARRAY = 0;
	final protected static int BECOME_POSITIVE = -1;
	
	//All staff members have this salary base.
	
	final protected static int SALARY_BASE = 1000;
	
	//These are the possible names for staff.
	final protected static String[] STAFF_NAMES = { "Oliver", "Jake", "Noah", "James", "Jack", "Connor", "Liam", "John",
			"Harry", "Callum", "Mason", "Robert", "William", "Damian", "Daniel", "Thomas", "Jacob", "Michael",
			"Charlie", "Kyle", "William", "William", "Thomas", "Joe", "Ethan", "David", "George", "Reece", "Michael",
			"Richard", "Oscar", "Rhys", "Alexander", "Joseph", "James", "Charlie", "James", "Charles" };
	final protected static Random RANDOM = new Random();

	protected static ArrayList<Staff> staffs = new ArrayList<Staff>();

	//This method is responsible for generating a unique number per staff.
	public Integer generateUniqueTeamNumber() {
		ArrayList<Integer> existingTeamNumbers;
		Integer teamNumber;
		do {
			teamNumber = RANDOM.nextInt();
			if (teamNumber < BEGIN_OF_ARRAY) {
				teamNumber = teamNumber * BECOME_POSITIVE;
			}
			existingTeamNumbers = this.existingTeamNumbers();
		} while (existingTeamNumbers.contains(teamNumber));

		return teamNumber;
	}

	//This returns all existing team numbers. 
	private ArrayList<Integer> existingTeamNumbers() {
		ArrayList<Integer> teamNumbers = new ArrayList<Integer>();
		for (Staff staff : staffs) {
			teamNumbers.add(staff.teamNumber);
		}
		return teamNumbers;
	}

	//This method groups staffs by categories and return the required staff member, if not will print the error message.
	public void listByCategory(String category) {
		ArrayList<Staff> foundStaffs = new ArrayList<Staff>();
		for (Staff staff : staffs) {
			if (staff instanceof HealthProfessional) {
				if (((HealthProfessional) staff).getType().getName() == category) {
					foundStaffs.add(staff);
					System.out.println(staff);
				}
			} else {
				if (((AdminProfessional) staff).getType().getName() == category) {
					foundStaffs.add(staff);
					System.out.println(staff);
				}
			}
		}

		if (foundStaffs.size() == 0) {
			System.out.println("No results found!");
		}
	}

	//This method list all the staffs and print a staff member.
	public void listAll() {
		for (Staff staff : staffs) {
			System.out.println(staff);
		}
	}

	//This list groups the staffs per name, if not the return will be the error message.
	public void listByName(String name) {
		ArrayList<Staff> foundStaffs = new ArrayList<Staff>();
		for (Staff staff : staffs) {
			if (staff.name.equals(name)) {
				foundStaffs.add(staff);
				System.out.println(staff);
			}
		}

		if (foundStaffs.size() == 0) {
			System.out.println("No results found!");
		}
	}

}
