package test;

import java.util.Timer;
import java.util.TimerTask;


public class MainTimer {
	private static long simulateTime;

	public static long getSimulateTime() {
		return simulateTime;
	}

	/* 싱글톤 패턴 */
	private static MainTimer instance = new MainTimer();
	private MainTimer(){};
	public static MainTimer getInstance(){
		if(instance == null){
			instance = new MainTimer();
		}
		return instance;
	}
	
	/* 생성 및 소멸 */
	public void init(long time){
		simulateTime = time;
		System.out.println("\n[시뮬레이팅 시간]");
		System.out.println("설정된 시뮬레이팅 시간은 " + simulateTime/600 + "시간입니다.");
	}
	
	public void start(){
		new Timer().schedule(new TimerTask(){
			@Override
			public void run() {
				end();
			}
		}, simulateTime);
	}
	
	public void end() {
		MainSimulator.end();
	}
}
