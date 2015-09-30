package menus;

public class MochaCoffee extends Decorator{
	private static int decoPrice;
	private long decoBrewingTime = 3;
	private String decoName = " Mocha";
	
	public MochaCoffee(Coffee coffee){
		super(coffee);
	}

	public static void setDecoPrice(int price) {
		MochaCoffee.decoPrice = price;
	}
	
	@Override
	public void brewing() {
		super.sumTotalDecoName(decoName);
		super.sumTotalDecoPrice(decoPrice);
		super.sumTotalDecoBrewingTime(decoBrewingTime);
		super.brewing();		
	}
}
