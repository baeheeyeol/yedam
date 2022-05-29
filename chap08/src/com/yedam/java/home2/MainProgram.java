package com.yedam.java.home2;

import java.util.Scanner;

public class MainProgram {
	private Scanner sc = new Scanner(System.in);
	private Access dao = BookRepo.getInstance();
	private Program pro = new BookProgram();

	public MainProgram() {
		while (true) {
			pro.menuPrint();
			int menuNo = menuSelect();
			if (menuNo == 1) {
				pro.inputInfo(dao);
			} else if (menuNo == 2) {
				pro.printAllInfo(dao);
			} else if (menuNo == 3) {
				pro.printInfo(dao);
			} else if (menuNo == 4) {
				pro.printRepot(dao);
			} else if (menuNo == 5) {
				exit();
				break;
			}
		}
	}

	private int menuSelect() {
		System.out.println("선택 > ");
		return Integer.parseInt(sc.nextLine());
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

}
