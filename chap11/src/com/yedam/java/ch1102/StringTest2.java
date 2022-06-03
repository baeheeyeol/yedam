package com.yedam.java.ch1102;

public class StringTest2 {
	public static void main(String[] args) {
		// toLowerCase &toUpperCase
		String str1 = "Java Programing";
		String str2 = "JAVA PROGRAMING";
		if (str1.equals(str2)) {
			System.out.println("str1 과 str2는 같은 값입니다.");

		} else {
			System.out.println("str1 과 str2는 다른 값입니다.");
		}

		String val1 = str1.toLowerCase();
		String val2 = str2.toLowerCase();
		System.out.println();
		if (val1.equals(val2)) {
			System.out.println("val1 과 val2는 같은 값입니다.");
		} else {
			System.out.println("val1 과 val2는 다른 값입니다.");
		}

		System.out.println();
		if (str1.equalsIgnoreCase(str2)) {
			System.out.println("str1 과 str2는 같은 값입니다.");
		} else {
			System.out.println("str1 과 str2는 다른 값입니다.");
		}

		System.out.println();
		// trim
		String subject = "         자바     프로그램         ";
		System.out.println(subject);
		String newData = subject.trim();
		System.out.println(newData);
		String a = newData.substring(0, newData.indexOf(" "));
		System.out.println(a);
		String b = newData.substring(newData.indexOf(" 프"), newData.length());
		System.out.println(b);
		String c = a + b;
		System.out.println(c);

		// valueOf
		String value1 = String.valueOf(10);
		String value2 = String.valueOf(10.5);
		String value3 = String.valueOf(true);
		
		String value4 ="" + 100;

	}

}
