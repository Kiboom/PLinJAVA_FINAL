package client;

import java.util.ArrayList;

import employee.Worker;
import manager.strategy.EmployStrategy;
import menus.Coffee;

public class Counter {
	private static ArrayList<Worker> availableWorkers = new ArrayList<Worker>();
	
	/* 싱글톤 패턴 */
	private Counter(){
		Counter.availableWorkers =  EmployStrategy.getEmployeeList();
	}
	private static Counter instance = new Counter();
	public static Counter getInstance(){
		if(instance == null){
			instance = new Counter();
		}
		return instance;
	}
	
	public synchronized Worker orderCoffee(Coffee coffee) throws InterruptedException{
		Thread customer = Thread.currentThread();
		while(availableWorkers.size() == 0){
			// logger.info("[" + customer.getName() + "] 대기 중");
			this.wait();
		}
		Worker worker = availableWorkers.remove(0);
		worker.brewing(coffee);
		System.out.println("[ORDER] "+customer.getId() + "번 손님이 " + worker.getLevel() + "에게 " + coffee.getTotalName() + " 커피를 주문하였습니다.");
		return worker;
	}
	
	public synchronized void pickupCoffee(Worker worker, Coffee coffee){
		availableWorkers.add(worker);
		this.notifyAll();
		Thread customer = Thread.currentThread();
		System.out.println("[O U T] " + customer.getId() + "번 손님이 " + coffee.getTotalName() + " 커피를 받고 나갔습니다.");
	}
	
}
