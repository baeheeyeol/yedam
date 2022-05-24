package com.yedam.homework;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		ProductSystem pds = new ProductSystem();
		while (run) {
			System.out.println("1.상품 수 입력 2.상품 및 가격 입력 3.가격 출력 4.분석 5.종료");
			int num = sc.nextInt();

			if (num == 1) {
				System.out.println("상품 수 입력 : ");
				int num1 = sc.nextInt();
				pds.setListSize(num1);

			} else if (num == 2) {
				String pdName = sc.next();
				int pdPrice = sc.nextInt();
				pds.putProduct(pdName, pdPrice);

			} else if (num == 3) {
				pds.printList();

			} else if (num == 4) {
				pds.analysis();

			} else if (num == 5) {
				System.out.println("종료");
				run = false;
			}
		}
	}
}
