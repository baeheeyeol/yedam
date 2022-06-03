package com.yedam.java.ch0902;

public class PersonTest {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();

		// 필드 - 익명 객체
		anony.field.wake();
		System.out.println();

		// 로컬변수 -익명 객체
		anony.method1();
		System.out.println();

		// 매개변수 -익명 객체
		anony.method2(new Person() {
			// 필드
			String job = "자영업자";

			// 메소드
			void study() {
				System.out.println("공부합니다.");
			}

			@Override
			void wake() {
				System.out.println("8시에 일어납니다.");
				study();
			}
		});

	}
}
