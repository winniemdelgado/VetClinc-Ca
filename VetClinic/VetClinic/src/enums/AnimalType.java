package enums;

import java.util.ArrayList;

   //This enumerate possible animal types.
   public enum AnimalType {
	
	DOG("Dog"),
	CAT("Cat"),
	TURTLE("Turtle"),
	RABBIT("Rabbit"),
	MOUSE("Mouse"),
	HAMSTER("Hamster"),
	FISH("Fish"),
	GOAT("Goat"),
	COW("Cow"),
	DUCK("Duck"),
	HORSE("Horse"),
	PARROT("Parrot"),
	HAWK("Hawk"),
	PIG("Pig"),
	RACCOON("Raccoon"),
	PANDA("Panda"),
	LION("Lion"),
	KOALA("Koala"),
	MONKEY("Monkey"),
	TIGER("Tiger"),
	FOX("Fox"),
	SHEEP("Sheep"),
	ELEPHANT("Elephant"),
	GORILLA("Gorilla"),
	FROG("Frog"),
	SNAKE("Snake"),
	WOLF("Wolf"),
	ALLIGATOR("Alligator"),
	OWL("Owl"),
	GIRAFFE("Giraffe"),
	ZEBRA("Zebra");
	
	  
	//This brings a few description per animal type.
	private final String name;

	AnimalType(String name) {
		this.name = name;
	}
    //This get the name.
	public String getName() {
		return name;
	}
	
	//This return a list containing all animal types.
	public static ArrayList<String> getAllNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (AnimalType animalType : AnimalType.values()) {
			names.add(animalType.name);
		}

		return names;
	}

}
