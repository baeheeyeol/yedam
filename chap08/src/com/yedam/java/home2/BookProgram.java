package com.yedam.java.home2;

import java.util.Scanner;

public class BookProgram implements Program {
	private Scanner sc = new Scanner(System.in);
	private int isbnRange = 9999;
	private int isbnNum = 1000;

	// 메뉴출력
	@Override
	public void menuPrint() {
		System.out.println("==========***************=========*&&^=========");
		System.out.println("1.정보 입력 | 2.조회 | 3.검색 | 4.분석 | 5.종료");
		System.out.println("====*****=======*****=======*****=======");
	}

	// 값 넣기
	@Override
	public void inputInfo(Access access) {

		Book info = inputAll();
		access.insert(info);
	}

	// 전체값 넣기
	private Book inputAll() {
		// int isbn = (int) (Math.random() * isbnRange) + 1;

		int isbn = isbnNum++;
		System.out.println("제목>");
		String name = sc.nextLine();

		System.out.println("가격>");
		int price = Integer.parseInt(sc.nextLine());

		return new Book(isbn, name, price);
	}

	// 전체 출력
	@Override
	public void printAllInfo(Access access) {
		int num = selectSortingMethod();
		if (num == 1) {
			access.isbnsorting(selectSortingdirection());
		} else if (num == 2) {
			access.pricesorting(selectSortingdirection());
		}
		Book[] list = access.selectAll();
		for (Book book : list) {
			book.showInfo();
		}
	}

	// 한개 가져오기
	@Override
	public void printInfo(Access access) {
		int isbn = inputIsbn();
		Book info = access.selectOne(isbn);
		info.showInfo();
	}

	private int inputIsbn() {
		System.out.println("검색 ISBN>");
		return Integer.parseInt(sc.nextLine());
	}

	@Override
	public void printRepot(Access access) {
		System.out.println("최고 가격 >");
		Book maxPrice = maxPrice(access);
		maxPrice.showInfo();
		System.out.println("최저 가격 >");
		Book minPrice = minPrice(access);
		minPrice.showInfo();
		System.out.println();
		repot(access);

	}

	private Book maxPrice(Access access) {
		Book[] temp = access.selectAll();
		Book maxInfo = temp[0];
		for (int i = 1; i < temp.length; i++) {
			if (maxInfo.getPrice() < temp[i].getPrice()) {
				maxInfo = temp[i];
			}
		}
		return maxInfo;
	}

	private Book minPrice(Access access) {
		Book[] temp = access.selectAll();
		Book minInfo = temp[0];
		for (int i = 1; i < temp.length; i++) {
			if (minInfo.getPrice() > temp[i].getPrice()) {
				minInfo = temp[i];
			}
		}
		return minInfo;
	}

	private void repot(Access access) {
		Book[] temp = access.selectAll();
		int total = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == maxPrice(access) || temp[i] == minPrice(access)) {
				continue;
			}
			total += temp[i].getPrice();

			temp[i].showInfo();
		}
		System.out.println(total);
		System.out.println("최대최소제외 평균값 : " + (double) total / (temp.length - 2));
	}

	private int selectSortingMethod() {
		System.out.println("1.ISBN순 2.가격순");
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}

	private int selectSortingdirection() {
		System.out.println("1.높은순 2.작은순");
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}
}
