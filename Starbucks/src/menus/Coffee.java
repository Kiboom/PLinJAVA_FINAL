package menus;

public abstract class Coffee {
	
	private String totalName;
	private int totalPrice=0;
	private long totalBrewingTime=0;
	
	
	public abstract void brewing();

	
	/* Getter */
	public int getTotalPrice() {
		return totalPrice;
	}
	public String getTotalName() {
		return totalName;
	}
	public long getTotalBrewingTime() {
		return totalBrewingTime;
	}
	
	
	/* Setter (커피를 구성하는 각각의 요소들이 가진 정보들을 한군데에 합침) */
	public void sumTotalPrice(int price) {
		totalPrice += price;
	}
	public void sumTotalName(String name) {
		if(name.startsWith("Americano") || name.startsWith("Kenya")){
			totalName = name;
			return;
		}
		totalName = totalName + name;	// 베이스 커피를 먼저 깔고, 데코레이터는 그 위에 추가하는 식
	}
	public void sumTotalBrewingTime(long time) {
		totalBrewingTime += time;
	}
	
}
