
public class Person {
	
	private String name;
	private int age;
	private double height;
	private double weight;
	private Diet dietName;
	private double BMI;
	private Gender gender;
	private double BMR;
	private Exercise exercise;
	private double caloriesNeeded;
	
	public Person(String name, int age, double height, double weight, Exercise exercise) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
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
				caloriesNeeded= BMR * 2;
				break;
			
		}
			
	}
	
	public Diet getDiet() {

		if(BMI < 18.5) {
			if(gender == Gender.FEMALE) {
				 dietName = new Diet("UnderWeight", 10, 100);
			}else {
				
			}
		}else if(BMI < 24.9) {
		}else if(BMI < 29.9) {
			
		}else {
			
		}
	}
	
	public void setBMI() { 
		BMI = (weight/Math.pow(height, 2)) * 703;
		BMI = Math.round(BMI * 10) / 10;
	}
	
	public void setBMR() {
		if(gender == Gender.MALE) {
			BMR = 66 + (6.23 * weight) + (12.7 *height) - (6.8 * age);
		}else {
			BMR = 665 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
		}
	}
	

}
