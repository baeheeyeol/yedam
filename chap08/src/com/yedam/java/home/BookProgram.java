package com.yedam.java.home;

import java.util.Scanner;

public class BookProgram implements Program {

	private Access dao = BookDAO.getInstance();
	private Scanner sc = new Scanner(System.in);

	@Override
	public void menuPrint() {
		System.out.println("==========================================");
		System.out.println("1.정보입력 | 2.전체조회 | 3.검색 | 4.분석 | 5.종료");
		System.out.println("==========================================");
	}

	@Override
	public void inputInfo() {
		Book data = inputAll();
		dao.insert(data);
	}

	private Book inputAll() {
		System.out.print("제목 >");
		String title = sc.nextLine();
		System.out.println("가격 >");
		int price = Integer.parseInt(sc.nextLine());
		return new Book(title, price);
	}

	@Override
	public void printAllinfo() {
		Book[] list = dao.selectAll();
		for (Book data : list) {
			data.showInfo();
		}
	}

	@Override
	public void printInfo() {
		// isbn 정보 입력
		int keyword = inputOne();
		// DAO에서 검색
		Book data = dao.selectOne(keyword);
		// 출력
		data.showInfo();
	}

	private int inputOne() {
		System.out.println("isbn >");
		return Integer.parseInt(sc.nextLine());
	}

	@Override
	public void printRepot() {
		// 가장 비싼 책
		Book maxInfo = selectMaxInfo();
		System.out.println("가장 가격이 비싼 책>");
		maxInfo.showInfo();

		// 가장 가격이 낮은 책
		Book minInfo = selectMinInfo();
		System.out.println("가장 가격이 낮은 책>");
		minInfo.showInfo();
		System.out.println();
		// 두 가지를 제외한 책들의 정보와 평균 가격
		calcAvgInfo();

	}

	private void calcAvgInfo() {
		Book maxInfo = selectMaxInfo();
		Book minInfo = selectMinInfo();

		Book[] list = dao.selectAll();
		int sum = 0;
		for (Book data : list) {
			if (data.getPrice() > minInfo.getPrice() && data.getIsbn() < maxInfo.getIsbn()) {

				// 조건에 만족하는 경우의 총합
				sum += data.getPrice();
				// 조건에 만족하는 경우의 정보를 출력
				data.showInfo();
			}
		}
		double avg = (double) sum / (list.length - 2);

		System.out.println("최고 가격과 최저 가격을 제외한 평균 >");
		System.out.printf("%.2f\n", avg);
	}

	private Book selectMaxInfo() {
		// 전체 조회
		Book[] list = dao.selectAll();

		// 검색
		Book maxInfo = list[0];
		for (Book data : list) {
			if (maxInfo.getPrice() < data.getPrice()) {
				maxInfo = data;
			}
		}
		// 반환
		return maxInfo;
	}

	private Book selectMinInfo() {
		// 전체 조회
		Book[] list = dao.selectAll();

		// 검색
		Book minInfo = list[0];
		for (Book data : list) {
			if (minInfo.getPrice() > data.getPrice()) {
				minInfo = data;
			}
		}
		// 반환
		return minInfo;
	}
}
