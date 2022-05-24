package control;

import java.util.Scanner;

public class SwitchTset {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// test1();
		// test2();
		test3();
	}

	public static void test3() {
		int score = scan.nextInt();
		switch (score / 10) {
		case 10:
		case 9:
			System.out.println("A등급");
			break;
		case 8:
			System.out.println("B등급");
			break;
		case 7:
			System.out.println("C등급");
			break;
		default:
			System.out.println("D등급");
		}
	}

	public static void test2() {
		int menu = scan.nextInt();
		// 1~5 :평일 6,7 :주말
		switch (menu) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("평일");
			break;
		case 6:
		case 7:
			System.out.println("주말");
		}
	}

	public static void test1() {
		Scanner scan = new Scanner(System.in);
		String menu = scan.next();
		// int,char,string,연산식
		switch (menu) {
		case "부장":
			System.out.println("700만원");
			break;
		case "과장":
			System.out.println("500만원");
			break;
		default:
			System.out.println("300만원");
		}
	}
}
