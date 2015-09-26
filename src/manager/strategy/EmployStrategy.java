package manager.strategy;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import employee.JuniorWorker;
import employee.MiddleWorker;
import employee.SeniorWorker;
import employee.Worker;
import manager.accounting.Salary;

public class EmployStrategy {
	private static int juniorNum, middleNum, seniorNum;
	private static int juniorSalary, middleSalary, seniorSalary;
	private static ArrayList<Worker> employeeList = new ArrayList<Worker>();

	
	public static void initEmployeeList() {
		readStrategyFromFile();
		for (int i = 0; i < juniorNum; i++) {
			employeeList.add(new JuniorWorker());
		}
		for (int i = 0; i < middleNum; i++) {
			employeeList.add(new MiddleWorker());
		}
		for (int i = 0; i < seniorNum; i++) {
			employeeList.add(new SeniorWorker());
		}
		Salary.setEmployeeList(employeeList);
	}

	
	public static void readStrategyFromFile() {
		try {
			FileInputStream files = new FileInputStream("EmployStrategy.properties");
			Properties prop = new Properties();
			prop.load(files);
			
			setSalaryForPay(prop);
			setNumberForEmploy(prop);
			checkPropertyException();
			
			System.out.println("\n[고용된 인원]\njunior worker:" + juniorNum + "명, middle worker:" + middleNum + "명, senior worker:" + seniorNum + "명 고용되었습니다.");
			System.out.println("\n[설정된 시급]\njunior worker:" + juniorSalary + "원, middle worker:" + middleSalary + "원, senior worker:" + seniorSalary + "원을 시급으로 지급합니다.");
			files.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/* 시급 설정 */
	private static void setSalaryForPay(Properties prop) {
		juniorSalary= Integer.parseInt(prop.getProperty("JUNIOR_SALARY"));
		middleSalary = Integer.parseInt(prop.getProperty("MIDDLE_SALARY"));
		seniorSalary = Integer.parseInt(prop.getProperty("SENIOR_SALARY"));
		JuniorWorker.setSalaryPerHour(juniorSalary);
		MiddleWorker.setSalaryPerHour(middleSalary);
		SeniorWorker.setSalaryPerHour(seniorSalary);
	}
	
	
	/* 고용할 인원 */
	private static void setNumberForEmploy(Properties prop) {
		juniorNum = Integer.parseInt(prop.getProperty("JUNIOR_NUM"));
		middleNum = Integer.parseInt(prop.getProperty("MIDDLE_NUM"));
		seniorNum = Integer.parseInt(prop.getProperty("SENIOR_NUM"));
	}

	
	public static void checkPropertyException() throws Exception{
		if (juniorNum<0 || middleNum<0 || seniorNum<0) {
			throw new Exception("고용인원의 값은 자연수만 가능합니다!");
		}
		return;
	}
	
	
	public static ArrayList<Worker> getEmployeeList() {
		return employeeList;
	}
}
