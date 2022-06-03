package com.yedam.java.ch0901;

public class Main {
	public static void main(String[] args) {
		A a = new A();
		System.out.println();
		A.B b = a.new B();
		b.method1();

		System.out.println();
		A.C.field2 = 2;
		A.C c = new A.C();
		c.method1();

		// 로컬 클래스
		a.method1();

	}
}
