package com.yedam.java.ch1601;

public class MainTest {
	public static void main(String[] args) {
		MyFunctionalInterface fi = () -> {
			System.out.println("람다식 실행");
		};
		fi.method();

		MyFunctionalInterface mfi = new MyFunctionalInterface() {

			@Override
			public void method() {
				System.out.println("익명 구현 객체 실행");
			}
		};
		mfi.method();
	}
}
