package enums;

import java.util.ArrayList;

    //This enumerate possible types for administrative staff.
    public enum AdminType {

	RECEPTIONIST("Receptionist"), IT("IT Nerd");
    
    //This get a few description per administrative type.
	private final String name;

	AdminType(String name) {
		this.name = name;
	}
    //This brings the name.
	public String getName() {
		return name;
	}
    
	//The code return a list containing all the administrative types.
	public static ArrayList<String> getAllNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (AdminType adminType : AdminType.values()) {
			names.add(adminType.name);
		}

		return names;
	}

}
