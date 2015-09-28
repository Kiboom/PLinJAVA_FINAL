package employee;

import manager.accounting.Sales;
import menus.Coffee;

public class SeniorWorker extends Worker{
	private Coffee coffee;
	private static int salaryPerHour;
	private String level = "Senior Worker";

	/* Getter Setter */
	@Override
	public String getLevel() {
		return level;
	}
	public int getSalaryPerHour() {
		return salaryPerHour;
	}
	public static void setSalaryPerHour(int salary) {
		SeniorWorker.salaryPerHour = salary; 
	}

	@Override
	public void brewing(Coffee coffee) {
		this.coffee = coffee;
		this.coffee.brewing();
		Sales.addTotalSales(coffee.getTotalPrice());
	}
}
