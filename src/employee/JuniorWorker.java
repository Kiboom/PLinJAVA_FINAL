package employee;

import manager.accounting.Sales;
import menus.Coffee;

public class JuniorWorker extends Worker {
	private Coffee coffee;
	private static int salaryPerHour;
	private String level = "Junior Worker";

	/* Getter Setter */
	public int getSalaryPerHour() {
		return salaryPerHour;
	}
	public static void setSalaryPerHour(int salary) {
		JuniorWorker.salaryPerHour = salary; 
	}
	public void setCoffee(Coffee coffee){
		this.coffee = coffee;
	}
	@Override
	public String getLevel() {
		return level;
	}

	@Override
	public void brewing(Coffee coffee) {
		this.coffee = coffee;
		this.coffee.brewing();
		Sales.setTotalSales(coffee.getTotalPrice());
	}
}
