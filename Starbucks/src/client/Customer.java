package client;

import employee.Worker;
import menus.Americano;
import menus.Coffee;
import menus.Kenya;
import menus.LatteCoffee;
import menus.MochaCoffee;
import static utils.Define.*;

public class Customer extends Thread{
	private Coffee myCoffee;
	private boolean isStillWaiting = true;
	private Counter counter = Counter.getInstance();
	
	
	/* 초기화 */
	public Customer(){
		setCoffee();
	}
	
	
	/* Getter Setter */
	public void setStillWaiting(boolean isStillWaiting) {
		this.isStillWaiting = isStillWaiting;
	}
	
	
	/* 주문할 커피 설정 */
	public void setCoffee(){
		setDecorator(setBaseCoffee());
	}
	
	public Coffee setBaseCoffee(){
		int baseCoffee = (int)(Math.random()*(BASE_COFFEES+1));
		switch(baseCoffee){
			case AMERICANO : return new Americano(); 
			case KENYA : return new Kenya(); 
			default : return new Americano();
		}
	}
	
	public void setDecorator(Coffee base) {
		int decorator = (int)(Math.random()*(DECORATIONS+1));
		switch(decorator){
			case NO_DECO : this.myCoffee = base; return;
			case LATTE : this.myCoffee = new LatteCoffee(base); return;
			case MOCHA : this.myCoffee = new MochaCoffee(base); return;
			default : this.myCoffee = new LatteCoffee(new MochaCoffee(base)); return;
		}
	}
	
	
	/* 주문하기 */
	public void run(){
		while(isStillWaiting){
			try {
				Worker worker = counter.orderCoffee(myCoffee);		// 카운터에서 주문하면, 주문받은 일꾼이 반환됨
				sleep(myCoffee.getTotalBrewingTime());
				counter.pickupCoffee(worker, myCoffee);
				isStillWaiting=false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
