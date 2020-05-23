package enums;

import java.util.ArrayList;

    
   //This enumerate possible tasks for administrative staff.
    public enum Task {
	
	VACATION("Vacation"),
	FILING("Filing"),
	PHONE_CALLS("Phone Calls"),
	POINT_CHECK("Point Check"),
	COMPUTER_MAINTENANCE("Computer Maintenance");
	
    //That is the description per task.
	private final String name;

	Task(String name) {
		this.name = name;
	}
    //This return the name.
	public String getName() {
		return name;
	}
	
	//This return a list containing all tasks.
	public static ArrayList<String> getAllNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (Task task : Task.values()) {
			names.add(task.name);
		}

		return names;
	}

}
