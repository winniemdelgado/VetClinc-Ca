package entities.animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import entities.staff.health.HealthProfessional;
import enums.AnimalType;

    //This class is responsible to manage the animals.
    public class AnimalRepository {

	final private static int MAX_ANIMAL_AGE = 18;
	final private static int BEGIN_OF_ARRAY = 0;
	final private static int MINIMUM_TYPES = 3;

	final private static Random RANDOM = new Random();
	
	//This is the list of possible animal names on the system.
	final private static String[] ANIMAL_NAMES = { "ABBEY", "ABBIE", "ABBY", "ABEL", "ABIGAIL", "ACE", "ADAM", "ADDIE",
			"ADMIRAL", "AGGIE", "AIRES", "AJ", "AJAX", "ALDO", "ALEX", "ALEXUS", "ALF", "ALFIE", "ALLIE", "ALLY",
			"AMBER", "AMIE", "AMIGO", "AMOS", "AMY", "ANDY", "ANGEL", "ANGUS", "ANNIE", "APOLLO", "APRIL", "ARCHIE",
			"ARGUS", "ARIES", "ARMANTI", "ARNIE", "ARROW", "ASHES", "ASHLEY", "ASTRO", "ATHENA", "ATLAS", "AUDI",
			"AUGIE", "AUSSIE", "AUSTIN", "AUTUMN", "AXEL", "AXLE", "BABBLES", "BABE", "BABY", "BABY-DOLL", "BABYKINS",
			"BACCHUS", "BAILEY", "BAM-BAM", "BAMBI", "BANDIT", "BANJO", "BARBIE", "BARCLAY", "BARKER", "BARKLEY",
			"BARLEY", "BARNABY", "BARNEY", "BARON", "BART", "BASIL", "BAXTER", "BB", "BEAMER", "BEANIE", "BEANS",
			"BEAR", "BEAU", "BEAUTY", "BEAUX", "BEBE", "BEETLE", "BELLA", "BELLE", "BEN", "BENJI", "BENNY", "BENSON",
			"BENTLEY", "BERNIE", "BESSIE", "BIABLO", "BIBBLES", "BIG BOY", "BIG FOOT", "BIGGIE", "BILLIE", "BILLY",
			"BINGO", "BINKY", "BIRDIE", "BIRDY", "BISCUIT", "BISHOP", "BITS", "BITSY", "BIZZY", "BJ", "BLACKIE",
			"BLACK-JACK", "BLANCHE", "BLAST", "BLAZE", "BLONDIE", "BLOSSOM", "BLUE", "BO", "BO", "BOB", "BOBBIE",
			"BOBBY", "BOBO", "BODIE", "BOGEY", "BONES", "BONGO", "BONNIE", "BOO", "BOO-BOO", "BOOKER", "BOOMER",
			"BOONE", "BOOSTER", "BOOTIE", "BOOTS", "BOOZER", "BORIS", "BOSCO", "BOSLEY", "BOSS", "BOY", "BOZLEY",
			"BRADLEY", "BRADY", "BRAGGS", "BRANDI", "BRANDO", "BRANDY", "BRIDGETT", "BRIDGETTE", "BRIE", "BRINDLE",
			"BRIT", "BRITTANY", "BRODIE", "BROOK", "BROOKE", "BROWNIE", "BRUISER", "BRUNO", "BRUTUS", "BUBBA",
			"BUBBLES", "BUCK", "BUCKEYE", "BUCKO", "BUCKY", "BUD", "BUDDA", "BUDDIE", "BUDDY", "BUDDY BOY", "BUFFIE",
			"BUFFY", "BUG", "BUGSEY", "BUGSY", "BULLET", "BULLWINKLE", "BULLY", "BUMPER", "BUNKY", "BUSTER",
			"BUSTER-BROWN", "BUTCH", "BUTCHY", "BUTTER", "BUTTERBALL", "BUTTERCUP", "BUTTERSCOTCH", "BUTTONS", "BUZZY",
			"CAESAR", "CALI", "CALLIE", "CALVIN", "CAMEO", "CAMILLE", "CANDY", "CAPONE", "CAPTAIN", "CARLEY", "CASEY",
			"CASPER", "CASSIE", "CASSIS", "CHA CHA", "CHAD", "CHAMBERLAIN", "CHAMP", "CHANCE", "CHANEL", "CHAOS",
			"CHARISMA", "CHARLES", "CHARLIE", "CHARLIE BROWN", "CHARMER", "CHASE", "CHAUNCEY", "CHAZ", "CHECKERS",
			"CHELSEA", "CHEROKEE", "CHESSIE", "CHESTER", "CHEVY", "CHEWIE", "CHEWY", "CHEYENNE", "CHI CHI", "CHIC",
			"CHICO", "CHIEF", "CHILI", "CHINA", "CHIP", "CHIPPER", "CHIPPY", "CHIPS", "CHIQUITA", "CHIVAS", "CHLOE",
			"CHOCOLATE", "CHRISSY", "CHUBBS", "CHUCKY", "CHYNA", "CINDER", "CINDY", "CINNAMON", "CISCO", "CLAIRE",
			"CLANCY", "CLEO", "CLEOPATRA", "CLICKER", "CLIFFORD", "CLOVER", "CLYDE", "COAL", "COBWEB", "COCO", "COCOA",
			"COCONUT", "CODI", "CODY", "COLE", "COMET", "COMMANDO", "CONAN", "CONNOR", "COOKIE", "COOPER", "COPPER",
			"CORKY", "COSMO", "COTTON", "COZMO", "CRACKERS", "CRICKET", "CRYSTAL", "CUBBY", "CUBS", "CUJO", "CUPCAKE",
			"CURLY", "CURRY", "CUTIE", "CUTIE-PIE", "CYRUS", "DAFFY", "DAISEY-MAE", "DAISY", "DAKOTA", "DALLAS",
			"DANDY", "DANTE", "DAPHNE", "DARBY", "DARCY", "DARWIN", "DASH", "DAVE", "DEACON", "DEE", "DEE DEE",
			"DEMPSEY", "DESTINI", "DEWEY", "DEXTER", "DHARMA", "DIAMOND", "DICKENS", "DIEGO", "DIESEL", "DIGGER",
			"DILLON", "DINKY", "DINO", "DIVA", "DIXIE", "DOBIE", "DOC", "DODGER", "DOGGON", "DOLLY", "DOMINO",
			"DOODLES", "DOOGIE", "DOTS", "DOTTIE", "DOZER", "DRAGSTER", "DREAMER", "DUCHESS", "DUDE", "DUDLEY", "DUFFY",
			"DUKE", "DUNCAN", "DUNN", "DUSTY", "DUTCHES", "DUTCHESS", "DYLAN", "EARL", "EBONY", "ECHO", "EDDIE", "EDDY",
			"EDGAR", "EDSEL", "EIFEL", "EINSTEIN", "ELLIE", "ELLIOT", "ELMO", "ELVIS", "ELWOOD", "EMBER", "EMILY",
			"EMMA", "EMMY", "ERIN", "ERNIE", "EVA", "FAITH", "FANCY", "FELIX", "FERGIE", "FERRIS", "FIDO", "FIFI",
			"FIGARO", "FINNEGAN", "FIONA", "FLAKE", "FLAKEY", "FLASH", "FLINT", "FLOPSY", "FLOWER", "FLOYD", "FLUFFY",
			"FONZIE", "FOXY", "FRANCAIS", "FRANKIE", "FRANKY", "FRECKLES", "FRED", "FREDDIE", "FREDDY", "FREEDOM",
			"FREEWAY", "FRESIER", "FRIDAY", "FRISCO", "FRISKY", "FRITZ", "FRODO", "FROSTY", "FURBALL", "FUZZY", "GABBY",
			"GABRIELLA", "GARFIELD", "GASBY", "GATOR", "GAVIN", "GENIE", "GEORGE", "GEORGIA", "GEORGIE", "GIANT",
			"GIBSON", "GIDGET", "GIGI", "GILBERT", "GILDA", "GINGER", "GINNY", "GIRL", "GIZMO", "GODIVA", "GOLDIE",
			"GOOBER", "GOOSE", "GORDON", "GRACE", "GRACE", "GRACIE", "GRACIE", "GRADY", "GREENIE", "GRETA", "GRETCHEN",
			"GRETEL", "GRETTA", "GRIFFEN", "GRINGO", "GRIZZLY", "GROMIT", "GROVER", "GUCCI", "GUIDO", "GUINNESS",
			"GUNNER", "GUNTHER", "GUS", "GUY", "GYPSY", "HAILEY", "HALEY", "HALLIE", "HAMLET", "HAMMER", "HANK",
			"HANNA", "HANNAH", "HANS", "HAPPYT", "HARDY", "HARLEY", "HARPO", "HARRISON", "HARRY", "HARVEY", "HEATHER",
			"HEIDI", "HENRY", "HERCULES", "HERSHEY", "HIGGINS", "HOBBES", "HOLLY", "HOMER", "HONEY", "HONEY-BEAR",
			"HOOCH", "HOOVER", "HOPE", "HOUDINI", "HOWIE", "HUDSON", "HUEY", "HUGH", "HUGO", "HUMPHREY", "HUNTER",
			"INDIA", "INDY", "IRIS", "ISABELLA", "ISABELLE", "ITSY", "ITSY-BITSY", "IVORY", "IVY", "IZZY", "JACK",
			"JACKIE", "JACKPOT", "JACKSON", "JADE", "JAGGER", "JAGS", "JAGUAR", "JAKE", "JAMIE", "JASMINE", "JASPER",
			"JAXSON", "JAZMIE", "JAZZ", "JELLY", "JELLY-BEAN", "JENNA", "JENNY", "JERRY", "JERSEY", "JESS", "JESSE",
			"JESSE JAMES", "JESSIE", "JESTER", "JET", "JETHRO", "JETT", "JETTA", "JEWEL", "JEWELS", "JIMMUY", "JINGLES",
			"JJ", "JOE", "JOEY", "JOHNNY", "JOJO", "JOKER", "JOLIE", "JOLLY", "JORDAN", "JOSIE", "JOY", "JR", "JUDY",
			"JULIUS", "JUNE", "JUNIOR", "JUSTICE", "KALI", "KALLIE", "KANE", "KARMA", "KASEY", "KATIE", "KATO", "KATZ",
			"KAYLA", "KC", "KEESHA", "KELLIE", "KELLY", "KELSEY", "KENYA", "KERRY", "KIBBLES", "KID", "KIKI", "KILLIAN",
			"KING", "KIPPER", "KIRA", "KIRBY", "KISMET", "KISSY", "KITTY", "KIWI", "KLAUS", "KOBA", "KOBE", "KODA",
			"KOKO", "KONA", "KOSMO", "KOTY", "KRAMER", "KUJO", "KURLY", "KYRA", "LACEY", "LADDIE", "LADY", "LADYBUG",
			"LANEY", "LASSIE", "LATTE", "LAYLA", "LAZARUS", "LEFTY", "LEO", "LEVI", "LEXI", "LEXIE", "LEXUS", "LIBBY",
			"LIGHTNING", "LILI", "LILLY", "LILY", "LINCOLN", "LINUS", "LITTLE BIT", "LITTLE-GUY", "LITTLE-ONE",
			"LITTLE-RASCAL", "LIZZY", "LOGAN", "LOKI", "LOLA", "LOU", "LOUIE", "LOUIS", "LOVEY", "LUCAS", "LUCI",
			"LUCIFER", "LUCKY", "LUCY", "LUKE", "LULU", "LUNA", "LYNX", "MAC", "MACHO", "MACINTOSH", "MACK",
			"MACKENZIE", "MACY", "MADDIE", "MADDY", "MADISON", "MAGGIE", "MAGGIE-MAE", "MAGGIE-MOO", "MAGGY", "MAGIC",
			"MAGNOLIA", "MAJOR", "MANDI", "MANDY", "MANGO", "MARBLE", "MARIAH", "MARLEY", "MARY", "MARY JANE", "MASON",
			"MATTIE", "MAVERICK", "MAX", "MAXIMUS", "MAXINE", "MAXWELL", "MAY", "MAYA", "MCDUFF", "MCKENZIE", "MEADOW",
			"MEGAN", "MEGGIE", "MERCEDES", "MERCLE", "MERLIN", "MIA", "MIASY", "MICHAEL", "MICKEY", "MIDNIGHT", "MIKEY",
			"MIKO", "MILES", "MILLER", "MILLIE", "MILO", "MIMI", "MINDY", "MING", "MINI", "MINNIE", "MISCHIEF", "MISHA",
			"MISS KITTY", "MISS PRISS", "MISSIE", "MISSY", "MISTER", "MISTY", "MITCH", "MITTENS", "MITZI", "MITZY",
			"MO", "MOCHA", "MOJO", "MOLLIE", "MOLLY", "MONA", "MONKEY", "MONSTER", "MONTANA", "MONTGOMERY", "MONTY",
			"MOOCHER", "MOOCHIE", "MOOKIE", "MOONSHINE", "MOOSE", "MORGAN", "MOSES", "MOUSE", "MR KITTY", "MUFFIN",
			"MUFFY", "MUGSY", "MULLIGAN", "MUNCHKIN", "MURPHY", "NAKITA", "NALA", "NANA", "NAPOLEON", "NATASHA",
			"NATHAN", "NELLIE", "NEMO", "NENA", "NERO", "NESTLE", "NEWT", "NEWTON", "NIBBLES", "NIBBY", "NIBBY-NOSE",
			"NICK", "NICKERS", "NICKIE", "NICKY", "NICO", "NIKE", "NIKI", "NIKITA", "NIKKI", "NIKO", "NINA", "NITRO",
			"NOBEL", "NOEL", "NONA", "NOODLES", "NORTON", "NOSEY", "NUGGET", "NUTMEG", "OAKLEY", "OBIE", "ODIE",
			"OLD GLORY", "OLIVE", "OLIVER", "OLIVIA", "OLLIE", "ONIE", "ONYX", "OPIE", "OREO", "OSCAR", "OTIS", "OTTO",
			"OZ", "OZZIE", "OZZY", "PABLO", "PACO", "PADDINGTON", "PADDY", "PANDA", "PANDORA", "PANTHER", "PAPA",
			"PARIS", "PARKER", "PASHA", "PATCH", "PATCHES", "PATRICKY", "PATSY", "PATTY", "PEACHES", "PEANUT",
			"PEANUTS", "PEARL", "PEBBLES", "PEDRO", "PENNY", "PEPE", "PEPPER", "PEPPY", "PEPSI", "PERSY", "PETE",
			"PETER", "PETEY", "PETIE", "PHANTOM", "PHOEBE", "PHOENIX", "PICASSO", "PICKLES", "PIERRE", "PIGGY",
			"PIGLET", "PINK PANTHER", "PINKY", "PINTO", "PIPER", "PIPPIN", "PIPPY", "PIP-SQUEEK", "PIRATE", "PIXIE",
			"PLATO", "PLUTO", "POCKETS", "POGO", "POKEY", "POLLY", "PONCHO", "PONGO", "POOCH", "POOCHIE", "POOH",
			"POOH-BEAR", "POOKIE", "POOKY", "POPCORN", "POPPY", "PORCHE", "PORKCHOP", "PORKY", "PORTER", "POWDER",
			"PRANCER", "PRECIOUS", "PRESLEY", "PRETTY", "PRETTY-GIRL", "PRINCE", "PRINCESS", "PRISSY", "PUCK",
			"PUDDLES", "PUDGE", "PUFFY", "PUGSLEY", "PUMPKIN", "PUNKIN", "PUPPY", "PURDY", "QUEEN", "QUEENIE", "QUINCY",
			"QUINN", "RAGS", "RAISON", "RALPH", "RALPHIE", "RAMBLER", "RAMBO", "RANGER", "RASCAL", "RAVEN", "REBEL",
			"RED", "REGGIE", "REILLY", "REMY", "REX", "REXY", "RHETT", "RICKY", "RICO", "RIGGS", "RILEY", "RIN TIN TIN",
			"RINGO", "RIPLEY", "ROCCO", "ROCK", "ROCKET", "ROCKO", "ROCKY", "ROLAND", "ROLEX", "ROLLIE", "ROMAN",
			"ROMEO", "ROSA", "ROSCOE", "ROSEBUD", "ROSIE", "ROSY", "ROVER", "ROWDY", "ROXANNE", "ROXIE", "ROXY", "RUBY",
			"RUCHUS", "RUDY", "RUFFE", "RUFFER", "RUFFLES", "RUFUS", "RUGER", "RUSTY", "RUTHIE", "RYDER", "SABINE",
			"SABLE", "SABRINA", "SADIE", "SAGE", "SAILOR", "SALEM", "SALLY", "SALTY", "SAM", "SAMANTHA", "SAMMY",
			"SAMPSON", "SAMSON", "SANDY", "SARA", "SARAH", "SARGE", "SASHA", "SASSIE", "SASSY", "SAVANNAH", "SAWYER",
			"SCARLETT", "SCHOTZIE", "SCHULTZ", "SCOOBIE", "SCOOBY", "SCOOBY-DOO", "SCOOTER", "SCOTTIE", "SCOUT",
			"SCRAPPY", "SCRUFFY", "SEBASTIAN", "SHADOW", "SHADY", "SHAGGY", "SHASTA", "SHEBA", "SHEENA", "SHELBY",
			"SHELLY", "SHERMAN", "SHILOH", "SHINER", "SHORTY", "SIENNA", "SIERRA", "SILKY", "SILVER", "SILVESTER",
			"SIMBA", "SIMON", "SIMONE", "SISSY", "SKEETER", "SKINNY", "SKIP", "SKIPPER", "SKIPPY", "SKITTLES", "SKY",
			"SKYE", "SKYLER", "SLICK", "SLINKY", "SLY", "SMARTY", "SMOKE", "SMOKEY", "SMUDGE", "SNEAKERS", "SNICKERS",
			"SNOOP", "SNOOPY", "SNOWBALL", "SNOWFLAKE", "SNOWY", "SNUFFLES", "SNUGGLES", "SOLOMON", "SONNY", "SOPHIA",
			"SOPHIE", "SOX", "SPANKY", "SPARKLE", "SPARKY", "SPEED", "SPEEDO", "SPEEDY", "SPENCER", "SPIKE", "SPIRIT",
			"SPOOKEY", "SPOT", "SPOTTY", "SPUD", "SPUNKY", "SQUEEKY", "SQUIRT", "STANLEY", "STAR", "STARR", "STELLA",
			"STERLING", "STICH", "STINKY", "STORMY", "STUART", "SUGAR", "SUGAR-BABY", "SUMMER", "SUMO", "SUNDANCE",
			"SUNDAY", "SUNNY", "SUNSHINE", "SUSIE", "SUSIE-Q", "SUZY", "SWEETIE", "SWEETIE-PIE", "SWEET-PEA", "SYDNEY",
			"TABBY", "TABETHA", "TACO", "TAFFY", "TALLY", "TAMMY" };
	
	//This is the list of possible medical conditions.
	final private static String[] MEDICAL_CONDITIONS = { "Bovine viral diarrhoea virus", "Brucellosis",
			"Caprine arthritis encephalitis", "Cat-scratch disease", "Botulism", "Giardiasis", "Fowl pox", "Blackhead",
			"Melioidosis", "Nipah virus", "Rabies", "Ringworm", "Tetanus", "Wooden tongue" };
	final private static AnimalType[] ANIMAL_TYPES = AnimalType.values();
	final public static ArrayList<String> ANIMAL_TYPES_NAMES = AnimalType.getAllNames();

	private ArrayList<Animal> animals = new ArrayList<Animal>();

	public ArrayList<Animal> getAnimals() {
		return this.animals;
	} 
	//This will build an animal with a random type.
	public void buildObjects(int numberOf) {
		for (int i = BEGIN_OF_ARRAY; i < numberOf; i++) {
			int typeIndex = RANDOM.nextInt(ANIMAL_TYPES.length);
			this.createAnimal(ANIMAL_TYPES[typeIndex]);
		}

		this.completeRequeriments();
	}
    //This ensures that at least 3 different types of animals will be generated.
	private void completeRequeriments() {
		AnimalType[] miniumTypes = Arrays.copyOfRange(ANIMAL_TYPES, BEGIN_OF_ARRAY, MINIMUM_TYPES);
		for (AnimalType animalType : miniumTypes) {
			this.createAnimal(animalType);
		}
	}
    //This generate an animal name, age and what type of the medical condition, randomly.
	private void createAnimal(AnimalType animalType) {
		float age = RANDOM.nextInt(MAX_ANIMAL_AGE) + 0.1f;
		int nameIndex = RANDOM.nextInt(ANIMAL_NAMES.length);
		int conditionIndex = RANDOM.nextInt(MEDICAL_CONDITIONS.length);

		Animal animal = new Animal(ANIMAL_NAMES[nameIndex], age, animalType, MEDICAL_CONDITIONS[conditionIndex]);

		this.animals.add(animal);
	}
    //This method brings all the animals on the list.
	public void listAll() {
		for (Animal animal : this.animals) {
			System.out.println(animal);
		}
	}
	//This method brings all the animals on the list by name, if not will print the error message.
	public void listByName(String name) {
		ArrayList<Animal> foundAnimals = new ArrayList<Animal>();
		for (Animal animal : this.animals) {
			if (animal.getName().equals(name)) {
				foundAnimals.add(animal);
				System.out.println(animal);
			}
		}

		if (foundAnimals.size() == 0) {
			System.out.println("No results found!");
		}
	}
    //This is responsible to list the animals by type.
	public ArrayList<Animal> listByType(String type) {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		for (Animal animal : this.animals) {
			if (animal.getType().getName().equals(type)) {
				animals.add(animal);
				System.out.println(animal);
			}
		}

		if (animals.size() == 0) {
			System.out.println("No results found!");
		}

		return animals;
	}
    //This is responsible for listing the health staff and what animal is being treated at the moment.
	public ArrayList<Animal> listByHealthProfessional(HealthProfessional healthProfessional) {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		for (Animal animal : this.animals) {
			if (animal.getHealthProfessional().equals(healthProfessional)) {
				animals.add(animal);
			}
		}
		return animals;
	}
    //This code list the queue of animals per health staff member.
	public ArrayList<Animal> getHealthProfessionalQueue(HealthProfessional healthProfessional) {
		return this.listByHealthProfessional(healthProfessional);
	}

	//That removes and prints the first animal in the queue.
	public Animal getHealthProfessionalNextAnimal(HealthProfessional healthProfessional) {
		ArrayList<Animal> animalsQueue = this.getHealthProfessionalQueue(healthProfessional);
		if (animalsQueue.size() == 0) {
			return null;
		}

		//This code get and return the first animal in the queue.
		Animal firstAnimalOnQueue = animalsQueue.get(0);
		//This code get and remove the first animal in the queue in case to show the next animal.
		this.animals.remove(firstAnimalOnQueue);

		//This return the first(next) animal in the queue. 
		return firstAnimalOnQueue;
	}

}
