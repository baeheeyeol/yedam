package com.yedam.java.ch1601;

public class RamdaTest {
	public static void main(String[] args) {
		// 매개변수도 리턴타입도 없는 람다식
		MyFuncInertfaceA fa = () -> {
			String str = "method call1";
			System.out.println(str);
		};

		fa.method();
		fa = () -> {
			System.out.println("method call2");
		};
		fa.method();
		fa = () -> System.out.println("method call3");
		fa.method();

		// 매개변수가 있고 리턴타입이 없는 람다식
		MyFuncInertfaceB fb = (int x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		fb.method(5);

		fb = (x) -> {
			System.out.println(x * 5);
		};
		fb.method(7);

		fb = x -> System.out.println(x * 5);
		fb.method(3);

		// 매개변수가 있고 리턴타입이 있는 경우
		MyFuncInertfaceC fc = (int x, int y) -> {
			int result = x + y;
			return result;
		};

		System.out.println(fc.method(1, 3));

		fc = (x, y) -> {
			return x + y;
		};
		System.out.println(fc.method(1, 5));

		fc = (x, y) -> x + y;
		System.out.println(fc.method(2, 6));

		fc = (x, y) -> Math.max(x, y);
		System.out.println(fc.method(2, 6));

		int val1 = 10;
		int val2 = 20;

		fa = () -> {
			int result = val1 + val2;
			System.out.println(result);
		};
		fa.method();

//		val1 = 100;
//		fa.method();
		
		

	}
}
