package com.yedam.java.ch0801;

public interface RemoteControl {
	// 상수 필드
	public static final int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;

	// 추상 메소드
	public abstract void turnOn();

	public void turnOff();

	public void setVolume(int volume);

//	// 일반 메소드
//	public default void show() {
//		System.out.println("추가한 메소드");
//	}
//	// 정적 메소드

}
