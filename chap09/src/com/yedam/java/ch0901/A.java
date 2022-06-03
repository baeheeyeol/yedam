package com.yedam.java.ch0901;

public class A {
	A() {
		System.out.println("A 인스턴스가 생성됨.");
	}

	// 인스터스 멤버 클래스
	class B {

		// 필드
		int feild1;

		// 생성자
		B() {
//			System.out.println("B 인스턴스가 생성됨.");
		}

		// 메소드
		void method1() {
			System.out.println("B 인스턴스가 생성됨.");
		}
	}

	// 정적 멤버 클래스
	static class C {
		// 필드
		int field1;
		static int field2;

		// 생성자
		C() {
			System.out.println("C 인스턴스가 생성됨");
		}

		// 메소드
		void method1() {
			System.out.println(field2);
		}

		static void method2() {
		};
	}

	void method1() {
		class D {
			// 필드
			int field1;

			// 생성자
			D() {
				System.out.println("D 인스턴스가 생성됨");
			}

			// 메소드
			void method1() {
			}

		}
		D d = new D();
		d.field1 = 1;
		d.method1();
	}

}
