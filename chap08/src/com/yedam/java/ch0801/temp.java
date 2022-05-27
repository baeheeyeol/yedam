package com.yedam.java.ch0801;

public interface temp {
	// 상수 필드
		public static final int MAX_VOLUME = 10;
		public int MIN_VOLUME = 0;

		// 추상 메소드
		public abstract void turnOn();

		public void turnOff();

		public void setVolume(int volume);
}
