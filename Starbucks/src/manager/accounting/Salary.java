package manager.accounting;

import java.util.ArrayList;

import employee.Worker;
import manager.strategy.EmployStrategy;
import test.MainTimer;

public class Salary {
	private static int totalSalary;
	private static ArrayList<Worker> employeeList;
	
	public static void setEmployeeList(ArrayList<Worker> employeeList){
		Salary.employeeList = employeeList;
	}

	public static int calculateSalary() {
		employeeList = EmployStrategy.getEmployeeList();
		for(Worker worker : employeeList){
			totalSalary += worker.getSalaryPerHour();
		}
		totalSalary *= (int) MainTimer.getSimulateTime()/600;
		return totalSalary;
	}
}
