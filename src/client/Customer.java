package client;

import employee.Worker;
import menus.Americano;
import menus.Coffee;
import menus.Kenya;
import menus.LatteCoffee;
import menus.MochaCoffee;
import static utils.Define.*;

public class Customer extends Thread{
	private int number;
	private static int numbering = 1;
	private Coffee coffee;
	private boolean isStillWaiting = true;
	
	/* 초기화 */
	public Customer(){
		number = numbering();
		setCoffee();
	}
	public int numbering(){
		return numbering++;
	}
	
	/* Getter Setter */
	public int getNumber() {
		return number;
	}
	public void setStillWaiting(boolean isStillWaiting) {
		this.isStillWaiting = isStillWaiting;
	}
	
	/* 주문할 커피 설정 */
	public void setCoffee(){
		int baseCoffee = (int)(Math.random()*BASE_COFFEES);
		int decoration = (int)(Math.random()*DECORATIONS);
		
		Coffee base;
		switch(baseCoffee){
		case NO_DECO : base = new Americano(); break; 
		case LATTE : base = new Kenya(); break; 
		default : base = new Americano();
		}
		
		if(decoration == NO_DECO){
			this.coffee = base;
		}
		else if(decoration == LATTE){
			this.coffee = new LatteCoffee(base);
		}
		else{
			this.coffee = new MochaCoffee(base);
		}
	}
	
	/* 주문하기 */
	public void run(){
		while(isStillWaiting){
			try {
				Counter counter = Counter.getInstance();
				Worker worker = counter.orderCoffee(coffee);
				sleep(coffee.getTotalBrewingTime());
				counter.pickupCoffee(worker, coffee);
				isStillWaiting=false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
