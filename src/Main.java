import java.time.LocalDate;
import java.util.*;

public class Main { 
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Person person = createProfile(keyboard);
		person.setDiet();
		
		chooseDiet(keyboard,person);
		System.out.println("\n" + person.getDiet().toString());
		
		calorieCounter(keyboard, person);
		System.out.println("\nThank you for using our calorie counter app.");
		System.out.println("We would love to hear your feedback at feedback@caloriecounter.com");
		System.exit(0);
	}
	
	
	
	public static Person createProfile(Scanner keyboard) {
		System.out.print("User's name: ");
		String name = keyboard.nextLine();
		
		System.out.print("User's age: ");
		int age = keyboard.nextInt();
		while(age < 0 || age > 120) {
			System.out.print("Invalid! Please re-enter user's age: ");
			age = keyboard.nextInt();
		}
		System.out.print("User's height (inches): ");
		double height = keyboard.nextDouble();
		while(height < 0) {
			System.out.print("Invalid! User's height (inches): ");
			height = keyboard.nextDouble();
		}
		System.out.print("User's weight (pounds): ");
		double weight = keyboard.nextDouble();
		while(weight<=0) {
			System.out.print("User's weight (pounds): ");
			weight = keyboard.nextDouble();
		}
		keyboard.nextLine();
		
		System.out.print("User's Gender (M/F): ");
		String gend = keyboard.nextLine().toLowerCase();
		Gender gender;
		
		while(!gend.equals("m") && !gend.equals("f")) {
			System.out.println("Please enter 'm' or 'f'");
			gend = keyboard.nextLine().toLowerCase();
		}
		if(gend.equalsIgnoreCase("m")) {
			gender = Gender.MALE;
		}
		else {
			gender = Gender.FEMALE;
		}
		
		exerciseMenu();
		Exercise exercise = getExercise(keyboard);
		
		displayRecExercise(age);
		
		return new Person(name, age, height, weight, gender, exercise);
	}
	
	public static void exerciseMenu() {
		System.out.println("\nStandard Weekly Exercise:");
		System.out.println("1. Little(to no exercise)");
		System.out.println("2. Light(1-3 days per week)");
		System.out.println("3. Moderate(3-5 days per week)");
		System.out.println("4. Heavy(6-7 days per week)");
		System.out.println("5. Very Heavy(twice per day, extra heavy workouts)");
	}
	
	
	public static Exercise getExercise(Scanner keyboard) {
		System.out.print("Choose a category number: ");
		Exercise exercise = Exercise.LITTLE;
		int choice = keyboard.nextInt();
		while(choice < 1 || choice > 5) {
			System.out.print("Choose a category number: ");
			exercise = Exercise.LITTLE;
			choice = keyboard.nextInt();
		}
		switch(choice) {
			case 1:
				exercise = Exercise.LITTLE;
				break;
			case 2:
				exercise = Exercise.LIGHT;
				break;
			case 3:
				exercise = Exercise.MODERATE;
				break;
			case 4:
				exercise = Exercise.HEAVY;
				break;
			case 5:
				exercise = Exercise.VERY_HEAVY;
				break;
		}
		return exercise;
	}
	
	private static void displayRecExercise(int age) {
		if(age < 18) {
			System.out.println("Fun Fact: As a child, recommended exercise is 1 hour of daily physical activity. ");
		}
		else if(age >= 18 && age <= 64) {
			System.out.println("Fun Fact: As an adult, recommended exercise is 2 hours and 30 minutes a week. ");
		}
		else {
			System.out.println("Fun Fact: As an older adult, recommended exercise is based on ability and condition of the individual. ");
		}
	}
	
	public static void chooseDiet(Scanner keyboard, Person person) {
		System.out.println("\nWe have four diet options available");
		System.out.println("1. Weight Gain \n2. Maintenance \n3. Weight Loss \n4. Extreme weight loss");
		System.out.println("\nBased on your profile we recommend " + person.getDiet() + " \nYou can pick any of our diet options, though");
		System.out.print("Choose which diet number you wish to start with: ");
		int recommendedDiet = person.getDiet().getDietNumber();
		int dietChoice = keyboard.nextInt();
		while(dietChoice < 1 || dietChoice > 4) {
			System.out.println("Please choose numbers 1-4 as they correspond to the diets");
			dietChoice = keyboard.nextInt();
		}
	
		if(dietChoice != recommendedDiet) {
			person.getDiet().setDiet(dietChoice);	
		}
	}
	
	public static void calorieCounter(Scanner keyboard, Person person) {
		HashMap<String, Integer> foodList = createFoodCalList();
		int calChoice = 0;
		Day day = new Day(person.getDiet().getCalories());
		while(calChoice != 3) {
			System.out.println("\n1. Add Calorie Intake");
			System.out.println("2. Check Today's Calorie Count");
			System.out.println("3. Exit program");
			System.out.print("Please choose an option:");
			calChoice = keyboard.nextInt();
			while(calChoice < 1 || calChoice > 3) {
				System.out.println("Invalid choice. Please enter a valid choice");
				calChoice = keyboard.nextInt();
			}
			System.out.println();
			day.checkDate();
			if(calChoice == 1) {
				addCalories(keyboard, day, foodList);
			}else if(calChoice == 2) {
				System.out.println("Today's calorie count: " +  day.getCurrentCalories());
				System.out.println("Remaining calories: " + (day.getMaxCalories() - day.getCurrentCalories()));
			}
		}
	}
	
	public static HashMap<String, Integer> createFoodCalList() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("CHOCOLATE MILK(CUP)", 208);
		map.put("SKIM MILK(CUP)", 86);
		map.put("APPLE", 81);
		map.put("APPLE JUICE(CUP)", 111);
		map.put("APPLE SAUCE(CUP)", 232);
		map.put("BANANA", 105);
		map.put("ORANGE", 65);
		map.put("PEAR", 98);
		map.put("BAGEL", 165);
		map.put("SLICE WHITE BREAD", 61);
		map.put("SLICE WW BREAD", 55);
		map.put("HOT DOG BUN", 119);
		map.put("PIZZA", 290);
		map.put("POPCORN", 26);
		map.put("SALTINES(5)",60);
		map.put("NOODLES", 159);
		map.put("GRAHAM CRACKERS(2)", 60);
		map.put("FRUIT ROLL-UP", 50);
		return map;
	}

	private static void addCalories(Scanner keyboard, Day day, HashMap<String, Integer> foodList) {
		System.out.println("\n1. Display food list");
		System.out.println("2. Add food/calorie to food list");
		System.out.println("3. Add calorie intake");
		System.out.println("4. Add food intake");
		System.out.print("Please choose an option:");
		
		int choice = keyboard.nextInt();
		while(choice < 1 || choice > 4) {
			System.out.println("Invalid choice. Please enter a valid choice");
			choice = keyboard.nextInt();
		}
		
		if(choice == 1) {
			displayFood(foodList);
			addCalories(keyboard, day, foodList);
		}
		else if(choice == 2) {
			addFoodToList(keyboard, foodList);
		}
		else if(choice == 3) {
			addCalorieNumber(keyboard, day);
		}
		else if(choice == 4) {
			addFood(foodList, keyboard, day);
		}
		
	}

	
	private static void addFoodToList(Scanner keyboard, HashMap<String, Integer> foodList) {
		keyboard.nextLine();
		System.out.print("Please enter the name of the food: ");
		String food = keyboard.nextLine().toUpperCase();

		if(foodList.containsKey(food)) {
			System.out.println("Food already exists!");
			return;
		}
		
		System.out.print("Please enter the calorie amount: ");
		int calAmount = keyboard.nextInt();
		foodList.put(food, calAmount);

	
	}

	private static void displayFood(HashMap<String, Integer> foodList) {
		String str2 = "CALORIES    FOOD\n";
		for(String food: foodList.keySet()) {
			str2 += String.format("%-15d %-15s%n", foodList.get(food), foodList.get(food)>=100 ? food: " " + food);
		}
		new FoodOptionsPane(str2.toString());
	}
	
	private static void addCalorieNumber(Scanner keyboard, Day day) {
		System.out.print("How many calories would you like to add to your daily count? ");
		int calAmount = keyboard.nextInt();
		while(calAmount <= 0) {
			System.out.println("Invalid! Please enter a valid calorie amount ");
			calAmount = keyboard.nextInt();
		}
		System.out.println(day.addCalories(calAmount));
	}
	
	private static void addFood(HashMap<String, Integer> foodList, Scanner keyboard, Day day) {
		System.out.println("Which food would you like to add to your overall calorie intake?");
		System.out.println("Note: please enter the food exactly as it appears on the list");
		keyboard.nextLine();
		String food = keyboard.nextLine().toUpperCase();
		while(!foodList.containsKey(food)) {
			System.out.println("Invalid entry. Please enter the food name as it appears on the list");
			displayFood(foodList);
			food = keyboard.nextLine().toUpperCase();
		}
		day.addCalories(foodList.get(food));
		System.out.println(foodList.get(food) + " calories added to your daily count");
	}
	
	
}
