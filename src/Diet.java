public class Diet {

	private double BMI;
	private double caloriesNeeded;
	private int adjustedCalories;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return adjustedCalories;
	}

	public void setCalories(int calories) {
		this.adjustedCalories = calories;
	}
	
	public int getDietNumber() {
		if(name.equals("Weight Loss")) 
			return 1;
		if(name.equals("Maintenance"))
			return 2;
		if(name.equals("Weight Loss"))
			return 3;
		if(name.equals("Extreme Weight Loss"))
			return 4;
		return 0;
	}
	
	public void setDiet(int diet) {
		if(diet == 1) {
			name = "Weight Gain";
			adjustedCalories = Math.round((float)(caloriesNeeded * 1.2 /10)) * 10;
		}
		if(diet == 2) {
			name = "Maintenance";
			adjustedCalories = Math.round((float)(caloriesNeeded /10)) * 10;
		}
		if(diet == 3) {
			name = "Weight Loss";
			adjustedCalories = Math.round((float)(caloriesNeeded * .8 /10)) * 10;
		}
		if(diet==4) {
			name = "Extreme Weight Loss";
			adjustedCalories = Math.round((float)(caloriesNeeded * .6 /10))*10;
		}
	}
	
	public void setRecommendedDiet(double BMI, double caloriesNeeded) {
		if(BMI < 18.5) {
			this.caloriesNeeded = caloriesNeeded;
			setDiet(1);
		}
		else if(BMI < 24.9) {
			this.caloriesNeeded = caloriesNeeded;
			setDiet(2);
		}
		else if(BMI < 29.9) {
			this.caloriesNeeded = caloriesNeeded;
			setDiet(3);
		}
		else {
			this.caloriesNeeded = caloriesNeeded;
			setDiet(4);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(name);
		string.append("\nGoal calories per day: " + adjustedCalories);
		return string.toString();
	}
}
