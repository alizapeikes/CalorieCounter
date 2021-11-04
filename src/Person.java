
public class Person {
	
	private String name;
	private int age;
	private double height;
	private double weight;
	private Diet diet;
	private double BMI;
	private Gender gender;
	private double BMR;
	private Exercise exercise;
	private double caloriesNeeded;
	
	public Person(String name, int age, double height, double weight, Gender gender, Exercise exercise) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.exercise = exercise;
		setBMI();
		setBMR();
	}
	
	public void setCaloriesNeeded() {
		switch(exercise) {
			case LITTLE:
				caloriesNeeded = BMR * 1.2;
				break;
			case LIGHT:
				caloriesNeeded = BMR * 1.375;
				break;
			case MODERATE:
				caloriesNeeded = BMR * 1.55;
				break;
			case HEAVY:
				caloriesNeeded = BMR * 1.725;
				break;
			case VERY_HEAVY:
				caloriesNeeded = BMR * 2;
				break;
			
		}
			
	}
	
	public Diet getDiet() {
		setCaloriesNeeded();

		if(BMI < 18.5) {
			diet = new Diet("Weight Gain", Math.round((float)(caloriesNeeded * 1.2)));
		}
		else if(BMI < 24.9) {
			diet = new Diet("Maintenance", Math.round((float)(caloriesNeeded)));
		}
		else if(BMI < 29.9) {
			diet = new Diet("Weight Loss", Math.round((float)(caloriesNeeded * .8)));
		}
		else {
			diet = new Diet("Extreme Weight Loss", Math.round((float)(caloriesNeeded * .6)));
		}
		
		return diet;
	}
	
	public void setBMI() { 
		BMI = (weight/Math.pow(height, 2)) * 703;
		BMI = Math.round(BMI * 10) / 10;
	}
	
	public void setBMR() {
		if(gender == Gender.MALE) {
			BMR = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
		}else {
			BMR = 665 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
		}
	}
	
	/*
	 * https://www.calculator.net/calorie-calculator.html?ctype=standard&cage=70&csex=f&cheightfeet=5&cheightinch=6&cpound=160&cheightmeter=180&ckg=65&cactivity=1.375&cmop=0&coutunit=c&cformula=m&cfatpct=20&printit=0&x=94&y=22
	 * we are going to display all the different diet option before we display the recommended diet.
	 * We want to make a while loop for the duration of the diet
	 * every new day, the total calories restarts from zero. 
	 */
	

}

