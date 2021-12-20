public class Day {
	private int currentCalories;
	private int maxCalories;
	
	public Day(int maxCalorie) {
		this.maxCalories = maxCalorie;
		currentCalories = 0;
	}
	
	public String addCalories(int amount) {
		if(amount > 0) {
			currentCalories += amount;
			String message = amount + " calories added.\n";
			return message+=checkCalories();
		}else {
			return "Invalid calorie amount";
		}
	}
	
	public String checkCalories() {
		if(currentCalories > maxCalories) {
			return "You have exceeded your daily calorie allowance by " + Math.abs(maxCalories - currentCalories) + " calories.";
		}else if(currentCalories == maxCalories) {
			return "You have reached your daily calorie allowance.";
		}else if(currentCalories > (maxCalories - 100)){
			return "Warning! You have almost reached your max calorie allowance. You have " + (maxCalories - currentCalories) + " left" ;
		}else {
			return "";
		}
	}
	public int getCurrentCalories() {
		return currentCalories;
	}
	public int getMaxCalories() {
		return maxCalories;
	}
}

