package menus;

public class Americano extends Coffee{
	private static int price;
	private long brewingTime = 15;
	private String name="Americano";
	
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
		Americano.price = price;
	}
	
	@Override
	public void brewing() {
		super.sumTotalName(name);
		super.sumTotalPrice(price);
		super.sumTotalBrewingTime(brewingTime);
	}
}
