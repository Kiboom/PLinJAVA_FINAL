package menus;

public abstract class Coffee {
	
	private String totalName;
	private int totalPrice=0;
	private long totalBrewingTime=0;
	
	/* Getter Setter */
	public String getTotalName() {
		return totalName;
	}
	public void addTotalName(String name) {
		if(name.equals("Americano") || name.equals("Kenya")){
			totalName = name;
			return;
		}
		totalName = totalName + name;
	}
	public long getTotalBrewingTime() {
		return totalBrewingTime;
	}
	public void addTotalBrewingTime(long time) {
		totalBrewingTime += time;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void addTotalPrice(int price) {
		totalPrice += price;
	}
	
	public abstract void brewing();
}
