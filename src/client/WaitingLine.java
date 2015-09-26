package client;

import java.util.ArrayList;
import utils.IntervalTimer;
import static utils.Define.*;

public class WaitingLine {
	private IntervalTimer intervalTimer = new IntervalTimer();
	private static ArrayList<Customer> customerQueue = new ArrayList<Customer>();

	public static ArrayList<Customer> getCustomerQueue(){
		return WaitingLine.customerQueue;
	}

	public void init(int customerNum) {
		System.out.println("\n[최초 대기자]");
		System.out.println("최초 대기자는 " + customerNum +"명입니다.");
		for (int n = 0; n < customerNum; n++) {
			customerQueue.add(new Customer());
		}
	}

	public void customerComeSimulator(){
		intervalTimer.set("addCustomer", (long)0, (long)COME_INTERVAL);	// 20ms(2분)마다 대기자 증가
	}
	
	public void customerOutSimulator(){
		intervalTimer.set("deleteCustomer", (long)0, (long)OUT_INTERVAL); // 50ms(5분)마다 지친 대기자 이탈
	}
	public void orderingSimulator() {
		for(Customer customer : customerQueue){
			customer.start();
		}
	}
}
