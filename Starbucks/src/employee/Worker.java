package employee;

import menus.Coffee;

public abstract class Worker extends Thread{

	public abstract int getSalaryPerHour();
	public abstract String getLevel();
	public abstract void brewing(Coffee coffee);

}
