package com.yedam.java.ch1201;

public class User extends Thread {
	private static int serial = 0;
	private Calculator cal;
	private int numInfo;

	public void setCalculator(Calculator cal) {
		this.setName("User" + (++serial));
		this.cal = cal;
		this.numInfo = serial;
	}

	@Override
	public void run() {
		cal.setMemory(100 + numInfo);
	}

}
