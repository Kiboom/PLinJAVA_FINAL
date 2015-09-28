package menus;


public abstract class Decorator extends Coffee{
	private Coffee coffee;
	private int totalDecoPrice;
	private String totalDecoName="";
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
	public void addTotalDecoPrice(int price) {
		totalDecoPrice += price;
	}
	public void addTotalDecoName(String name) {
		totalDecoName = totalDecoName + name;
	}
	public void addTotalDecoBrewingTime(long time) {
		totalDecoBrewingTime += time;
	}

	@Override
	public void brewing(){
		coffee.brewing();
		super.addTotalName(totalDecoName);
		super.addTotalName(coffee.getTotalName());
		super.addTotalPrice(coffee.getTotalPrice() + totalDecoPrice);
		super.addTotalBrewingTime(coffee.getTotalBrewingTime() + totalDecoBrewingTime);
	}
}
