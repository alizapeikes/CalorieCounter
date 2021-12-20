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

	}
	
	public static void menu() {
		System.out.println("Standard Daily Exercise:");
		System.out.println("1. Little(to no exercise)");
		System.out.println("2. Light(1-3 days per week)");
		System.out.println("3. Moderate(3-5 days per week)");
		System.out.println("4. Heavy(6-7 days per week)");
		System.out.println("5. Very Heavy(twice per day, extra heavy workouts)");
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
		
		menu();
		Exercise exercise = getExercise(keyboard);
		
		if(age < 18) {
			System.out.println("As a child, recommended exercise is 1 hour of daily physical activity. ");
		}
		else if(age >= 18 && age <= 64) {
			System.out.println("As an adult, recommended exercise is 2 hours and 30 minutes a week. ");
		}
		else {
			System.out.println("As an older adult, recommended exercise is based on ability and condition of the individual. ");
		}
		
		return new Person(name, age, height, weight, gender, exercise);
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
	
	public static void chooseDiet(Scanner keyboard, Person person) {
		System.out.println("\nWe have four diet options available");
		System.out.println("1. Weight Gain \n2. Maintenance \n3. Weight Loss \n4. Extreme weight loss");
		System.out.println("We recommend: " + person.getDiet());
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
		int calChoice = 0;
		int today = LocalDate.now().getDayOfYear();
		Day day = new Day(person.getDiet().getCalories());
		while(calChoice != 3) {
			if(LocalDate.now().getDayOfYear() != today) {
				today = LocalDate.now().getDayOfYear();
				day = new Day(person.getDiet().getCalories());
			}
			System.out.println("\n1. Add Calories");
			System.out.println("2. Check Calorie Counter");
			System.out.println("3. Exit program");
			System.out.print("Please choose an option:");
			calChoice = keyboard.nextInt();
			while(calChoice < 1 || calChoice > 3) {
				System.out.println("Invalid choice. Please enter a valid choice");
				calChoice = keyboard.nextInt();
			}
			if(calChoice == 1) {
				System.out.print("How many calories would you like to add? ");
				int calAmount = keyboard.nextInt();
				while(calAmount <= 0) {
					System.out.println("Invalid! Please enter a valid calorie amount ");
					calAmount = keyboard.nextInt();
				}
				System.out.println(day.addCalories(calAmount));
			}else if(calChoice == 2) {
				System.out.println("Current calorie count: " +  day.getCurrentCalories());
				System.out.println("Remaining calories: " + (day.getMaxCalories() - day.getCurrentCalories()));
			}
		}
	}
}
/*https://www.momsteam.com/nutrition/sports-nutrition-basics/nutritional-needs-guidelines/carbohydrate-and-calorie-content-of-foods
add common food calories
*/