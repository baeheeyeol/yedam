package com.yedam.java.ch0701_01;

import com.yedam.java.ch0701.Phone;

public class SmartPhone extends Phone {

	public SmartPhone(String model, String color) {
		super(model, color);
	}

	@Override
	void powerOff() {
		System.out.println("휴대폰이 종료됩니다.");
		super.powerOff();
		super.print();
	}

	@Override
	protected
	void bell() {
		super.bell();
		System.out.println("벨 소리 : 싸이 - that that!");
	}

	@Override
	void call() {
		super.call();
		System.out.println("안내 문구 : 전화는 용건만 간단히");
	}

	void print() {
		super.bell();
	}
}
