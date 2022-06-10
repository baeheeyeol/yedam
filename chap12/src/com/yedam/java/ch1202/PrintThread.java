package com.yedam.java.ch1202;

public class PrintThread extends Thread {

	@Override
	public void run() {
		//interrupt -> 작업 중 일시적인 추가작업이 필요한 경우
		while (true) {
			System.out.println("실행중");
			try {
					Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("interrut method 발생");
			}
		}
		System.out.println("자원정리");
		System.out.println("종료");
	}
}
