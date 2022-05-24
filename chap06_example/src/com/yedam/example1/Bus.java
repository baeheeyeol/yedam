package com.yedam.example1;

public class Bus {

	private String lineNumber;
	private int money;
	private int passengerCount;
	private int pay;

	// 생성자
	public Bus(String lineNumber, int pay) {
		this.lineNumber = lineNumber;
		this.pay = pay;
	}

	// 메서드
	public int getPay() {
		return pay;
	}

	public void take(int money) {
		this.money += money;
		this.passengerCount++;
	}

	public void showInfo() {
		System.out.println(lineNumber + "의 승객은 " + passengerCount + "명이고, 수입은 : " + money + "원 입니다.");
	}

}
