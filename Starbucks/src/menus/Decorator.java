package menus;


public abstract class Decorator extends Coffee{
	private Coffee coffee;
	private int totalDecoPrice;
	private String totalDecoName="";
	private long totalDecoBrewingTime;
	
	public Decorator(Coffee coffee) {
		this.coffee = coffee;				
	}
	
	/* Getter Setter */
	public String getTotalDecoName() {
		return totalDecoName;
	}
	public void addTotalDecoName(String name) {
		totalDecoName = totalDecoName + name;
	}
	public long getTotalDecoBrewingTime() {
		return totalDecoBrewingTime;
	}
	public void addTotalDecoBrewingTime(long time) {
		totalDecoBrewingTime += time;
	}
	public int getTotalDecoPrice() {
		return totalDecoPrice;
	}
	public void addTotalDecoPrice(int price) {
		totalDecoPrice += price;
	}

	@Override
	public void brewing(){
		coffee.brewing();
		super.addTotalName(coffee.getTotalName());
		super.addTotalName(totalDecoName);
		super.addTotalPrice(coffee.getTotalPrice() + totalDecoPrice);
		super.addTotalBrewingTime(coffee.getTotalBrewingTime() + totalDecoBrewingTime);
	}
}
