package com.yedam.java.ch1002;

import java.text.NumberFormat;

public class MainTest {

	public static void main(String[] args) {
		try {
			// 원래 실행하고자 한코드
		} catch (Exception e) {
			// 예외가 발생한 경우 처리코드
		} finally {
			// 정상적으로 실행하든 예외가 발생했든
			// 반드시 실행되야하는 코드
		}

		String data1 = null;
		String data2 = null;

		try {
			int value1 = Integer.parseInt(data1);
			data1 = args[0];
			data2 = args[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace();
			System.out.println("실행 매개값의 수가 부족합니다.");
			return;
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식에 맞춰 입력해주세요.");
			return;
		} catch (Exception e) {
			System.out.println("기타");
			return;
		} finally {
			System.out.println("필수 구문");
		}
		System.out.println("메인 메소드 종료");

		try {
			findClass();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void findClass() throws ClassNotFoundException, NullPointerException {
		Class clazz = Class.forName("java.lang.String");
	}
}
