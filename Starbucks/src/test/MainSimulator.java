package test;

import java.util.ArrayList;
import static utils.Define.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import client.Customer;
import client.WaitingLine;
import manager.accounting.Salary;
import manager.accounting.Sales;
import manager.strategy.EmployStrategy;
import manager.strategy.PriceStrategy;
import utils.IntervalTimer;
import utils.StopWatch;

public class MainSimulator {
	private WaitingLine waitingLine = new WaitingLine();
	private static StopWatch stopWatch = new StopWatch();
	private MainTimer mainTimer = MainTimer.getInstance();
	private static final Logger logger = LoggerFactory.getLogger(MainSimulator.class);
	
	public void start() {
		simulatorInit();
		System.out.println("\n\n--------------------------------------------------------------\n");
		System.out.println("\n[Starbucks Simulator Start!]\n");
		mainTimer.start();
		stopWatch.start(); 
		waitingLine.orderingSimulator();
		//waitingLine.customerOutSimulator();		// 주기적으로 손님이 증가하는 시뮬레이터
		//waitingLine.customerComeSimulator();		// 주기적으로 손님이 이탈하는 시뮬레이터
	}

	public void simulatorInit(){
		System.out.println("시뮬레이터 초기화 시작...");
		PriceStrategy.initPriceInfo();
		EmployStrategy.initEmployeeInfo();
		waitingLine.init(INITIAL_CUSTOMERS);
		mainTimer.init(SIMULATING_TIME);			// 시뮬레이터 진행 시간 설정
	}
	
	public static void end() {
		System.out.println("\n\n--------------------------------------------------------------\n\n[Starbucks Simulator Finished!]\n");
		
		stopWatch.stop();
		stopAllThreads();
		
		int totalSales = Sales.getTotalSales();
		int totalSalary = Salary.calculateSalary(); 
		logger.info("총 매출액 : " + totalSales + "원");
		logger.info("직원 임금 : " + totalSalary + "원");
		logger.info("순 이익 : " + (totalSales-totalSalary) + "원");
		logger.info("설정 시뮬레이션 시간 : " + MainTimer.getSimulateTime() + "ms");
		logger.info("실제 시뮬레이션 시간 : " + stopWatch.getElapsedTime() + "ms");
	}

	private static void stopAllThreads() {
		IntervalTimer.setSimulating(false);
		ArrayList<Customer> customerQueue = WaitingLine.getCustomerQueue();
		for(Customer customer : customerQueue){
			customer.setStillWaiting(false);
		}	
	}
	
}
