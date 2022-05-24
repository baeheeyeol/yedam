package Operator;

import java.util.Scanner;

public class 문제7 {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner scan = new Scanner(System.in);
		int num, num1;
		do {
			System.out.println("----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------");
			System.out.println("선택> ");
			num = scan.nextInt();
			if (num == 1) {
				System.out.printf("예금액> ");
				balance += scan.nextInt();
			} else if (num == 2) {
				System.out.printf("출금액> ");
				num1 = scan.nextInt();
				if (balance < num1) {
					System.out.println("소지한 금액을 초과했습니다.");
				} else {
					balance -= num1;
				}
			} else if (num == 3) {
				System.out.println("잔고> " + balance);
			} else if (num == 4) {
				System.out.printf("프로그램 종료");
				run = false;
			}

		} while (run);
	}

}
