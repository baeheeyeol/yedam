package com.yedam.java.ch0902;

public class RemotControlTest {
	public static void main(String[] args) {
		Product product = new Product();

		// 필드 - 익명 구현 객체
		product.field.turnOff();
		product.field.turnOn();
		System.out.println();
		// 로컬 변수 - 익명 구현 객체
		product.method1();
		System.out.println();
		// 매개변수 - 익명 구현 객체
		product.method2(new RemoteControl() { // 필드
			String message = "노트북";

			// 메소드
			void print() {
				System.out.println("제품 종류 : " + message);
			}

			@Override
			public void turnOn() {
				print();
				System.out.println("노트북을 켭니다.");
			}

			@Override
			public void turnOff() {
				print();
				System.out.println("노트북을 끕니다.");
			}
		});
	}
}
