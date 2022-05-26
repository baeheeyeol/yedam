package com.yedam.java.ch0701;

public class DmbPhone extends Phone {
	int ch;

	public DmbPhone(String model, String color) {
		super(model,color);
//		super.model = model;
//		super.color = color;
		this.ch = 10;
	}

	void turnOnDmb() {
		System.out.println("채널 " + ch + "번 방송 수신을 시작합니다.");
	}

	void turnOffDmb() {
		System.out.println("방송 수신을 멈춥니다.");
	}

	void changeChannel(int ch) {
		this.ch = ch;
		System.out.println("채널 " + ch + "번으로 바귑니다.");
	}

	@Override
	protected void bell() {
		// TODO Auto-generated method stub
		super.bell();
	}

	@Override
	void call() {
		// TODO Auto-generated method stub
		super.call();
	}
	

}
