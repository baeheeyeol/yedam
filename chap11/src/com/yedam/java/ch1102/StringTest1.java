package com.yedam.java.ch1102;

import java.io.UnsupportedEncodingException;

public class StringTest1 {
	public static void main(String[] args) {
		// byte -> String
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };

		String str1 = new String(bytes);
		System.out.println(str1);

		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);

		System.out.println();
		// String -> byte -> String
		String str = "안녕하세요";

		byte[] bytes1 = str.getBytes();
		System.out.println(bytes1);
		String strs1 = new String(bytes1);
		System.out.println(strs1);

		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println(bytes2);
			String strs2 = new String(bytes2, "EUC-KR");
			System.out.println(strs2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		// charAt
		String ssn = "010624-1230123";
		char gender = ssn.charAt(7);
		switch (gender) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
		}
		for (int i = 0; i < ssn.length(); i++) {
			System.out.println(ssn.charAt(i));
		}
		System.out.println();

		// equls
		String val1 = "신민철";
		String val2 = "신민철";
		String val3 = new String("신민철");

		if (val1.equals(val2)) {
			System.out.println("val1과 val2는 값이 같습니다.");
		} else
			System.out.println("val1과 val2는 값이 다릅니다.");
		if (val1.equals(val3)) {
			System.out.println("val1과 val3는 값이 같습니다.");
		} else
			System.out.println("val1과 val3는 값이 다릅니다.");
		System.out.println();
		if (val1 == val2) {
			System.out.println("val1과 val2는 같은 인스턴스입니다.");
		} else {
			System.out.println("val1과 val2는 다른 인스턴스입니다.");
		}
		if (val1 == val3) {
			System.out.println("val1과 val3는 같은 인스턴스입니다.");
		} else {
			System.out.println("val1과 val3는 다른 인스턴스입니다.");
		}

		System.out.println();

		// indexOf
		String subject = "자바 프로그래밍 & 스프링 정석";
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);

		if (subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 관련없는 책");
		}

		// substring
		String result1 = subject.substring(subject.indexOf("프로그래밍"));
		System.out.println(result1);
		System.out.println();
		String ssn1 = "880815-1234567";
		System.out.println("생년월일 : " + ssn1.substring(0, 6));
		System.out.println("생년월일 : " + ssn1.substring(0, ssn1.indexOf("-")));
		System.out.println("개별정보 : " + ssn1.substring(7));

		// length
		String[] temp = { "1", "2" };
		int val = temp.length;

		System.out.println(ssn1.length());

		// replace
		String oldStr = "Java 프로그래밍";
		String newStr = oldStr.replace("Java", "자바");
		System.out.println(oldStr + " -> " + newStr);
	}

}
