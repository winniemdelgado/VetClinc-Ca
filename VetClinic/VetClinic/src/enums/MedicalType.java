package enums;

import java.util.ArrayList;

    //This enumerate possible type for medical staff.
    public enum MedicalType {

	VETERINARIAN("Veterinarian"), NURSE("Nurse"), TRAINEE_VET("Trainee Vet");

    //This brings the description per medical type.
	private final String name;

	MedicalType(String name) {
		this.name = name;
	}
    //This return the name.
	public String getName() {
		return name;
	}

	//This return a list containing all medical types.
	public static ArrayList<String> getAllNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (MedicalType medicalType : MedicalType.values()) {
			names.add(medicalType.name);
		}

		return names;
	}

}
