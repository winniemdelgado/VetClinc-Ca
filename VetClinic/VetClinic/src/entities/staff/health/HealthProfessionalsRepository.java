package entities.staff.health;

import java.util.ArrayList;
import java.util.Arrays;

import entities.staff.Staff;
import entities.staff.StaffProfessionalsRepository;
import enums.MedicalType;

    //This class is responsible to manage the medical staffs.
    public class HealthProfessionalsRepository extends StaffProfessionalsRepository {

	//This include minimum quantity of veterinarians, medical types and names, and different types of animals.
	final private static int MINIMUM_VETERINARIAN_NUMBER = 5;
	final private static int MINIMUM_TYPES_NUMBER = 3;
	final private static MedicalType[] MEDICAL_TYPES = MedicalType.values();
	final public static ArrayList<String> MEDICAL_TYPES_NAMES = MedicalType.getAllNames();

	//The code below build the list randomly of the medical types.
	public void buildObjects(Integer numberOf) {
		for (int i = BEGIN_OF_ARRAY; i < numberOf; i++) {
			Integer typeIndex = RANDOM.nextInt(MEDICAL_TYPES.length);
			createHealthProfessional(MEDICAL_TYPES[typeIndex]);
		}

		completeRequeriments();
	}
	//That ensures at least 3 different types of medical and 2 veterinarian will be generated.
	private void completeRequeriments() {
		for (int i = BEGIN_OF_ARRAY; i < MINIMUM_VETERINARIAN_NUMBER; i++) {
			createHealthProfessional(MedicalType.VETERINARIAN);
		}
        //The code below brings the list inserted of medical types agreeing with the minimum type number required. 
		MedicalType[] miniumTypes = Arrays.copyOfRange(MEDICAL_TYPES, BEGIN_OF_ARRAY, MINIMUM_TYPES_NUMBER);
		for (MedicalType medicalType : miniumTypes) {
			createHealthProfessional(medicalType);
		}
	}
    //It creates an health staff with random salary.
	private void createHealthProfessional(MedicalType medicalType) {
		Float salary = RANDOM.nextFloat() + SALARY_BASE;

		//It turns negative number into positive in the salary.
		if (salary < BEGIN_OF_ARRAY) {
			salary = salary * BECOME_POSITIVE;
		}
		//This get a random index from possible staff names.
		Integer nameIndex = RANDOM.nextInt(STAFF_NAMES.length);

		HealthProfessional healthProfessional = new HealthProfessional(STAFF_NAMES[nameIndex],
				generateUniqueTeamNumber(), salary, medicalType);
		staffs.add(healthProfessional);
	}
    //This list all the health staffs.
	public ArrayList<HealthProfessional> listAllHealthProfessionals() {
		ArrayList<HealthProfessional> healthProfessionals = new ArrayList<HealthProfessional>();
		for (Staff staff : staffs) {
			if (staff instanceof HealthProfessional) {
				healthProfessionals.add((HealthProfessional) staff);
			}
		}

		return healthProfessionals;
	}
    //This code returns a health staff by your teamNumber.
	public HealthProfessional getByTeamNumber(Integer teamNumber) {
		HealthProfessional healthProfessional = null;
		for (Staff staff : staffs) {
			if (staff instanceof HealthProfessional) {
				if (((HealthProfessional) staff).getTeamNumber().equals(teamNumber)) {
					healthProfessional = (HealthProfessional) staff;
				}
			}
		}

		return healthProfessional;
	}

}
