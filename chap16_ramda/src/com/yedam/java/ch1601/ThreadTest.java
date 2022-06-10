package com.yedam.java.ch1601;

public class ThreadTest {
	public static void main(String[] args) {
		Runnable rn = () -> {
			System.out.println("람다식으로 구현");
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		};

		Thread thread = new Thread(rn);
		thread.start();

		thread = new Thread(() -> {
			System.out.println("매개변수 -> 람다식");
			for (int i = 10; i <= 100; i += 10) {
				System.out.println(i);
			}
		});
		thread.start();

	}
}
