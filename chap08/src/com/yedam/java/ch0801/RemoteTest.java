package com.yedam.java.ch0801;

public class RemoteTest {

	public static void main(String[] args) {
		// RemoteControl rc = new TV();
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		System.out.println();

		SmartControl sc = new TV();
		sc.searchInternet("네이버");
		sc.executeApp("구글");
		System.out.println();

		TV tv = new TV();
		tv.turnOn();
		System.out.println();

		Control con = new TV();
		con.turnOn();
		con.executeApp("게임");
		System.out.println();

	}

}
