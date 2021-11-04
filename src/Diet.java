
public class Diet {

	private String name;
	private int calories;

	public Diet(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Diet Name: " + name);
		string.append("\nCalories per day: " + calories);
		return string.toString();
	}
}
