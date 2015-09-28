package employee;

import menus.Coffee;

public abstract class Worker extends Thread{

	public abstract String getLevel();
	public abstract int getSalaryPerHour();
	public abstract void brewing(Coffee coffee);

}
