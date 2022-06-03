package com.yedam.java.home;

import java.util.Scanner;

public class MainProgram {
	private Program program = new BookProgram();

	public MainProgram() {

		while (true) {
			program.menuPrint();
			int menuNo = inputMenu();
			if (menuNo == 1) {
				program.inputInfo();
			} else if (menuNo == 2) {
				program.printAllinfo();
			} else if (menuNo == 3) {
				program.printInfo();
			} else if (menuNo == 4) {
				program.printRepot();
			} else if (menuNo == 5) {
				exit();
				break;
			}
		}
	}

	int inputMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 >");
		return Integer.parseInt(sc.nextLine());
	}

	void exit() {
		System.out.println("프로그램 종료.");
	}
}
