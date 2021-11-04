import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("User's name: ");
		String name = keyboard.nextLine();
		
		System.out.print("User's age: ");
		int age = keyboard.nextInt();
		
		System.out.print("User's height (inches): ");
		double height = keyboard.nextDouble();
		
		System.out.print("User's weight (pounds): ");
		double weight = keyboard.nextDouble();
		keyboard.nextLine();
		
		System.out.print("User's Gender: choose M/F");
		String gend = keyboard.nextLine();
		Gender gender;
		
		while(!gend.equals("m") && !gend.equals("f")) {
			System.out.println("Please enter 'm' or 'f'");
			gend = keyboard.nextLine();
		}
		if(gend.equalsIgnoreCase("m")) {
			gender = Gender.MALE;
		}
		else {
			gender = Gender.FEMALE;
		}
		
		
		menu();
		System.out.print("Choose a category number: ");
		Exercise exercise = Exercise.LITTLE;
		int choice = keyboard.nextInt();
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
		
		Person person = new Person(name, age, height, weight, gender, exercise);
		System.out.println("Recommended Diet: " + person.getDiet());
	
		
	}
	
	public static void menu() {
		System.out.println("Standard Daily Exercise:");
		System.out.println("1. Little(to no exercise)");
		System.out.println("2. Light(1-3 days per week)");
		System.out.println("3. Moderate(3-5 days per week)");
		System.out.println("4. Heavy(6-7 days per week)");
		System.out.println("5. Very Heavy(twice per day, extra heavy workouts)");
		
		
	}
}
