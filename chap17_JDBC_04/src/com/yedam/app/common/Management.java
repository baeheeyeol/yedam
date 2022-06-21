package com.yedam.app.common;

import java.util.Scanner;

import com.yedam.app.deal.RecivingGoodsDAO;
import com.yedam.app.product.ProductDAO;
import com.yedam.app.product.ProductInfoManagement;

public class Management {
	// 필드
	protected Scanner sc = new Scanner(System.in);
	protected ProductDAO pDAO = ProductDAO.getInstance();
	protected RecivingGoodsDAO rDAO = RecivingGoodsDAO.getInstance();
	protected TakeOutGoodsDAO tDAO = TakeOutGoodsDAO.getInstance();

	// 생성자
	public void run() {
		while (true) {
			menuPrint();
			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 제품 정보관리
				new ProductInfoManagement();
			} else if (menuNo == 2) {
				// 제품 관리
				new ProductStockManagement();
			} else if (menuNo == 9) {
				// 프로그램 종료
				exit();
				break;
			} else {
				showInputError();
			}
		}
	}

	// 메소드
	protected void menuPrint() {
		System.out.println("=============================");
		System.out.println("1.제품정보관리 2. 제품재고관리 9.종료");
		System.out.println("=============================");
	}

	protected int menuSelect() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주시기 바랍니다.");
		}
		return menu;
	}

	protected void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	protected void showInputError() {
		System.out.println("메뉴에서 입력해주시기 바랍니다.");
	}
}
