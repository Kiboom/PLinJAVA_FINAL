package utils;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import client.Customer;
import client.WaitingLine;

public class IntervalTimer {
	long delay, period;
	private ArrayList<Customer> customerQueue;
	private static boolean isSimulating = true;
	
	public static void setSimulating(boolean isSimulating){
		IntervalTimer.isSimulating = isSimulating;
	}
	
	public void set(String task, long delay, long period){
		this.delay = delay;
		this.period = period;
		this.customerQueue = WaitingLine.getCustomerQueue();
		switch(task){
			case "addCustomer" : addCustomer(); break;
			case "deleteCustomer" : deleteCustomer(); break;
		}
	}

	private void addCustomer() {
		while(isSimulating){
			new Timer().scheduleAtFixedRate(new TimerTask(){
				@Override
				public void run() {
					Customer customer = new Customer();
					System.out.println("[ I N ] " + customer.getId() + "번 손님이 가게에 들어왔습니다.");
					customerQueue.add(new Customer());
					customer.start();
				}
			}, delay, period);
		}
	}

	private void deleteCustomer() {
		new Timer().scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				if(isSimulating){
					Customer customer = customerQueue.remove(customerQueue.size()-1);
					customer.setStillWaiting(false);
					System.out.println("[O U T] " + customer.getId() + "번 손님이 기다리다 지쳐서 나갔습니다.");
				}
			}
		}, delay, period);
	}
}
