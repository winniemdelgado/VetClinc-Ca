package main;

import java.util.ArrayList;
import java.util.Random;

import entities.animal.Animal;
import entities.animal.AnimalRepository;
import entities.staff.admin.AdminProfessional;
import entities.staff.admin.AdminProfessionalsRepository;
import entities.staff.health.HealthProfessional;
import entities.staff.health.HealthProfessionalsRepository;
import enums.Task;
    
    //This class initiate the system that contains the administrative, health and animals on init.
    public class Initiator {

    //Here is the quantity required of each list of data.	
	private static Integer ADMINS_ON_INIT = 30;
	private static Integer HEALTHS_ON_INIT = 10;
	private static Integer ANIMALS_ON_INIT = 1000;

	//This initiate the repositories randomly on the menu and bring all the data waiting just the user's input.
	private AnimalRepository animalRepository;
	private HealthProfessionalsRepository healthProfessionalsRepository;
	private AdminProfessionalsRepository adminProfessionalsRepository;
	private Menu menu;
	private Random random;
    
	//The class constructor that is responsible for instantiating like other classes that will be used.
	public Initiator() {
		this.animalRepository = new AnimalRepository();
		this.healthProfessionalsRepository = new HealthProfessionalsRepository();
		this.adminProfessionalsRepository = new AdminProfessionalsRepository();
		this.menu = new Menu();
		this.random = new Random();
	}
    
	public void initializeProgram() {
		System.out.print("Initializing program...");

		//This create the entities on init.
		this.animalRepository.buildObjects(ANIMALS_ON_INIT);
		this.healthProfessionalsRepository.buildObjects(HEALTHS_ON_INIT);
		this.adminProfessionalsRepository.buildObjects(ADMINS_ON_INIT);

		//Here, we assign each animal to a member of medical staff.
		for (Animal animal : this.animalRepository.getAnimals()) {
			ArrayList<HealthProfessional> healthProfessionals = this.healthProfessionalsRepository
					.listAllHealthProfessionals();
			Integer healthProfessionalIndex = random.nextInt(healthProfessionals.size());
			animal.setHealthProfessional(healthProfessionals.get(healthProfessionalIndex));
		}

		//Here, we assign a task to each member of the administrative staff and at the end print the message.
		for (AdminProfessional adminProfessional : this.adminProfessionalsRepository.listAllAdminProfessionals()) {
			Task[] tasks = AdminProfessionalsRepository.TASKS;
			Integer taskIndex = this.random.nextInt(tasks.length);
			adminProfessional.setTask(tasks[taskIndex]);
		}

		System.out.println("complete!");
		this.showMenu();
	}
    
	//This are the codes that gets info from other classes by the user's correct input.
	private void showMenu() {
		int option;

		do {
			option = this.menu.showMenu();

			switch (option) {
			case 0:
				System.out.println("Finished.");
				break;
			case 1:
				this.healthProfessionalsRepository.listAll();
				break;
			case 2:
				this.listStaffsByCategory();
				break;
			case 3:
				this.listStaffsByTask();
				break;
			case 4:
				this.listStaffsByName();
				break;
			case 5:
				this.animalRepository.listAll();
				break;
			case 6:
				this.listAnimalsByCategory();
				break;
			case 7:
				this.listAnimalsByName();
				break;
			case 8:
				this.listByHealthProfessional();
				break;
			case 9:
				this.getHealthProfessionalQueue();
				break;
			case 10:
				this.getHealthProfessionalNextAnimal();
				break;
			default:
				System.out.println("\nInvalid option!\n");
				break;
			}
		} while (option != 0);

		System.exit(0);
	}

	//The sub menu list is showed based on the user's option, the code below verify the number inserted and give one response.
	private int showSubMenu(ArrayList<String> options) {
		int option;

		do {
			option = this.menu.showSubMenu(options);

			//If the option is less than zero or a number in addition to the options, it will print Invalid option.
			if (option < 0 || option > options.size()) {
				System.out.println("\nInvalid option\n");
			}

		} while (option != 0 && (option < 0 || option > options.size()));

		return option - 1;
	}
    //Here is the code to separate the types of staffs.
	private void listStaffsByCategory() {
		ArrayList<String> types = new ArrayList<String>();
		types.addAll(HealthProfessionalsRepository.MEDICAL_TYPES_NAMES);
		types.addAll(AdminProfessionalsRepository.ADMIN_TYPES_NAMES);

		int subOption = this.showSubMenu(types);
		if (subOption >= 0) {
			String option = types.get(subOption);
			this.adminProfessionalsRepository.listByCategory(option);
		}
	}
    //The code is responsible to list a health professional by number, if not find print the message.
	private void listByHealthProfessional() {
		HealthProfessional healthProfessional = this.getHealthProfessionalByTeamNumber();
		ArrayList<Animal> results = this.animalRepository.listByHealthProfessional(healthProfessional);

		for (Animal animal : results) {
			System.out.println(animal);
		}

		if (results.size() == 0) {
			System.out.println("No results found!");
		}
	}
	//That is responsible to get the staff queue of animals that it will be carried, if not find print the message.
	private void getHealthProfessionalQueue() {
		HealthProfessional healthProfessional = this.getHealthProfessionalByTeamNumber();
		ArrayList<Animal> results = this.animalRepository.getHealthProfessionalQueue(healthProfessional);

		if (results.size() == 0) {
			System.out.println("No results found!");
		}
	}
	//That is responsible to get the next patient of an health staff.
	private void getHealthProfessionalNextAnimal() {
		HealthProfessional healthProfessional = this.getHealthProfessionalByTeamNumber();
		Animal result = this.animalRepository.getHealthProfessionalNextAnimal(healthProfessional);

		if (result == null) {
			System.out.println("No results found!");
		} else {
			System.out.println(result);
		}
	}
    //That is responsible to get an health staff by your teamNumber.
	private HealthProfessional getHealthProfessionalByTeamNumber() {
		String teamNumber = this.menu.readInput("Enter a Health Professional Team Number: ");
		return this.healthProfessionalsRepository.getByTeamNumber(Integer.parseInt(teamNumber));
	}
	//Here we can see the list that contains the categories of the animals.
	private void listAnimalsByCategory() {
		ArrayList<String> types = AnimalRepository.ANIMAL_TYPES_NAMES;

		int subOption = this.showSubMenu(types);
		if (subOption >= 0) {
			String option = types.get(subOption);
			this.animalRepository.listByType(option);
		}
	}
    //Here we can see the list that contains the task per staff.
	private void listStaffsByTask() {
		ArrayList<String> tasks = AdminProfessionalsRepository.TASKS_NAMES;

		int subOption = this.showSubMenu(tasks);
		if (subOption >= 0) {
			String option = tasks.get(subOption);
			this.adminProfessionalsRepository.listByTask(option);
		}
	}
	//This code read the user's input and contains the list of staffs by name.
	private void listStaffsByName() {
		String name = this.menu.readInput("Enter a Staff name: ");
		this.healthProfessionalsRepository.listByName(name);
	}
	//This code read the user's input and contains the list of animals by name.
	private void listAnimalsByName() {
		String name = this.menu.readInput("Enter a Animal name: ");
		this.animalRepository.listByName(name);
	}

}
