	package menus;


public class LatteCoffee extends Decorator{
	private static int decoPrice;
	private String name = " Latte";
	private long decoBrewingTime = 5;
	
	public LatteCoffee(Coffee coffee){
		super(coffee);
	}
	
	public static void setDecoPrice(int price) {
		LatteCoffee.decoPrice = price;
	}
	
	@Override
	public void brewing() {
		super.sumTotalDecoName(name);
		super.sumTotalDecoPrice(decoPrice);
		super.sumTotalDecoBrewingTime(decoBrewingTime);
		super.brewing();		
	}
}
