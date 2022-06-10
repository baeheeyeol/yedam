package com.yedam.java.ch1201;

public class MultiThreadTest {

	public static void main(String[] args) {
		Thread main =Thread.currentThread();
		System.out.println("메인 스레드 : " +main.getName());
//	Runnable a = new ThreadA();
//  Thread thread = new Thread(a);
		ThreadB thread =new ThreadB();
		thread.setName("threadA");
		System.out.println("작업 스레드 : " + thread.getName());
		thread.start();
		
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "번째 출력");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
