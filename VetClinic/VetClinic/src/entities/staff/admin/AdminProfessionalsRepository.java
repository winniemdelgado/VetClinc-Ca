package entities.staff.admin;

import java.util.ArrayList;
import java.util.Arrays;

import entities.staff.Staff;
import entities.staff.StaffProfessionalsRepository;
import enums.AdminType;
import enums.Task;

    //This class is responsible to manage the administrative staffs.
    public class AdminProfessionalsRepository extends StaffProfessionalsRepository {

	//This method include a minimum of 2 different types of administrative staff and brings the details of it.
	final private int MINIMUM_TYPES = 2;
	final private static AdminType[] ADMIN_TYPES = AdminType.values();
	final public static ArrayList<String> ADMIN_TYPES_NAMES = AdminType.getAllNames();
	final public static ArrayList<String> TASKS_NAMES = Task.getAllNames();
	final public static Task[] TASKS = Task.values();

	////The code below build the list randomly of the administrative types.
	public void buildObjects(Integer numberOf) {
		for (int i = BEGIN_OF_ARRAY; i < numberOf; i++) {
			Integer typeIndex = RANDOM.nextInt(ADMIN_TYPES.length);
			createAdminProfessional(ADMIN_TYPES[typeIndex]);
		}

		completeRequeriments();
	}

	//That ensures at least 2 different types of administrative staff will be generated.
	private void completeRequeriments() {
		AdminType[] miniumTypes = Arrays.copyOfRange(ADMIN_TYPES, BEGIN_OF_ARRAY, MINIMUM_TYPES);
		for (AdminType adminType : miniumTypes) {
			createAdminProfessional(adminType);
		}
	}

	//This method generate an administrative staff with random salary.
	private void createAdminProfessional(AdminType adminTypes) {
		Float salary = RANDOM.nextFloat() + SALARY_BASE;

		//This turn negative number into positive, just in case.
		if (salary < BEGIN_OF_ARRAY) {
			salary = salary * BECOME_POSITIVE;
		}
		Integer nameIndex = RANDOM.nextInt(STAFF_NAMES.length);

		AdminProfessional AdminProfessional = new AdminProfessional(STAFF_NAMES[nameIndex], generateUniqueTeamNumber(),
				salary, adminTypes);
		staffs.add(AdminProfessional);
	}

	//This list contains all the administrative professionals in the clinic.
	public ArrayList<AdminProfessional> listAllAdminProfessionals() {
		ArrayList<AdminProfessional> adminProfessionals = new ArrayList<AdminProfessional>();
		for (Staff staff : staffs) {
			if (staff instanceof AdminProfessional) {
				adminProfessionals.add((AdminProfessional) staff);
			}
		}

		return adminProfessionals;
	}

	//The code below list by task per administrative staff, if not find print the message.
	public void listByTask(String task) {
		ArrayList<Staff> foundStaffs = new ArrayList<Staff>();
		for (Staff staff : staffs) {
			if (staff instanceof AdminProfessional) {
				if (((AdminProfessional) staff).getTask().getName() == task) {
					foundStaffs.add(staff);
					System.out.println(staff);
				}
			}
		}

		if (foundStaffs.size() == 0) {
			System.out.println("No results found!");
		}
	}

}
