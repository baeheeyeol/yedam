package com.yedam.java.ch0802;

public class Bus implements Vehicle {

	@Override
	public void run() {
		System.out.println("버스");
	}

	public void checkFare() {
		System.out.println("승차요금를 체크합니다.");
	}
}
