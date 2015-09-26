package menus;

public class Kenya extends Coffee{
	private static int price;
	private String name = "Kenya";
	private long brewingTime = 20;
	
	/* Getter Setter */
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public long getBrewingTime() {
		return brewingTime;
	}
	public static void setPrice(int price) {
		Kenya.price = price;
	}
	
	@Override
	public void brewing() {
		super.addTotalBrewingTime(brewingTime);
		super.addTotalPrice(price);
		super.addTotalName(name);
	}
}
