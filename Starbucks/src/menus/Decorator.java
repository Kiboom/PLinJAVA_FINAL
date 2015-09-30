package menus;


public abstract class Decorator extends Coffee{
	private Coffee coffee;
	private int totalDecoPrice;
	private String totalDecoName;
	private long totalDecoBrewingTime;
	
	public Decorator(Coffee coffee) {
		this.coffee = coffee;				
	}
	
	/* Getter */
	public int getTotalDecoPrice() {
		return totalDecoPrice;
	}
	public String getTotalDecoName() {
		return totalDecoName;
	}
	public long getTotalDecoBrewingTime() {
		return totalDecoBrewingTime;
	}

	/* Setter (하위 데코레이션 정보는 여기서 한번에 합친 다음, 최상위 클래스인 Coffee로 넘김) */
	public void sumTotalDecoPrice(int price) {
		totalDecoPrice += price;
	}
	public void sumTotalDecoName(String name) {
		totalDecoName = totalDecoName + name;
	}
	public void sumTotalDecoBrewingTime(long time) {
		totalDecoBrewingTime += time;
	}

	@Override
	public void brewing(){
		coffee.brewing();
		super.sumTotalName(totalDecoName);
		super.sumTotalName(coffee.getTotalName());
		super.sumTotalPrice(coffee.getTotalPrice() + totalDecoPrice);
		super.sumTotalBrewingTime(coffee.getTotalBrewingTime() + totalDecoBrewingTime);
	}
}
