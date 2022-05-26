package com.yedam.java.ch0702;

public class ChildTest2 {

	public static void main(String[] args) {
		GranPa pa = new Father();
		pa.method();
//		pa = new Uncle();
		if (pa instanceof Father) {
			Father fa = (Father) pa;
			fa.method();
			fa.mathod2();
		} else {
			System.out.println("pa 변수가 가지고 있는 인스턴스는 Father가 아닙니다.");
		}
	}

}
