import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("User's name: ");
		String name = keyboard.nextLine();
		
		System.out.println("User's age: ");
		int age = keyboard.nextInt();
		
		System.out.println("User's height: ");
		double height = keyboard.nextDouble();
		
		System.out.println("User's weight: ");
		double weight = keyboard.nextDouble();
		
		menu();
		System.out.println("Choose a category number: ");
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
		
		Person person = new Person(name, age, height, weight, exercise);
	
		
	}
	
	public static void menu() {
		System.out.println("Exercise Options:");
		System.out.println("1. Little(to no exercise)");
		System.out.println("2. Light(1-3 days per week)");
		System.out.println("3. Moderate(3-5 days per week)");
		System.out.println("4. Heavy(6-7 days per week)");
		System.out.println("5. Very Heavy(twice per day, extra heavy workouts)");
		
		
	}
}
