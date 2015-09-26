package utils;

public class StopWatch {
	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;
	
	public void start() {
	    this.startTime = System.currentTimeMillis();
	    this.running = true;
	}

	public void stop() {
		this.stopTime = System.currentTimeMillis();
	    this.running = false;
	}

	/* 경과 시간 */
	public long getElapsedTime() {
		long elapsed;
	    if (running) {
	      elapsed = (System.currentTimeMillis() - startTime);
	    }
	    else {
	      elapsed = (stopTime - startTime);
	    }
	    return elapsed;
	}

	/* 경과 시간을 초로 환산 */
	public long getElapsedTimeSecs() {
	    long elapsed;
	    if (running) {
	      elapsed = ((System.currentTimeMillis() - startTime) / 1000);
	    }
	    else {
	      elapsed = ((stopTime - startTime) / 1000);
	    }
	    return elapsed;
	}
}
