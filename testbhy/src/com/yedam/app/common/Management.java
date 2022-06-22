package com.yedam.app.common;

import java.util.List;
import java.util.Scanner;

import com.yedam.app.book.Book;
import com.yedam.app.book.BookDAO;

public class Management {

	protected Scanner sc = new Scanner(System.in);
	protected BookDAO bDAO = BookDAO.getInstance();

	public void run() {
		while (true) {
			menuPrint();
			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 전체조회
				selectAll();
			} else if (menuNo == 2) {
				// 단건조회
				selectOne();
			} else if (menuNo == 3) {
				// 내용검색
				search();
			} else if (menuNo == 4) {
				// 대여가능
				rental();
			} else if (menuNo == 5) {
				// 책 대여
				bookRental();
			} else if (menuNo == 6) {
				// 책 반납
				returm();
			} else if (menuNo == 7) {
				// 책 등록
				insert();
			} else if (menuNo == 9) {
				exit();
				break;
			} else {
				showInputError();
			}
		}
	}

	private void returm() {
		String name = inputName();
		bDAO.Returm(name);
	}

	private void bookRental() {
		String name = inputName();
		bDAO.Rental(name);
	}

	private void insert() {
		Book book = inputAll();
		bDAO.insert(book);
	}

	private void search() {
		String BookContent = inputContent();
		List<Book>list = bDAO.selectWrite(BookContent);
		if (list == null) {
			System.out.println("등록되지 않았습니다.");
			return;
		}
		for (Book Book : list) {
			System.out.println(Book);
		}
	}

	private Book inputAll() {
		Book book = new Book();
		System.out.println("책이름>");
		book.setName(sc.nextLine());
		System.out.println("저자명>");
		book.setWriter(sc.nextLine());
		System.out.println("내용>");
		book.setContent(sc.nextLine());
		return book;
	}

	private void rental() {
		List<Book> list = bDAO.selectRental();
		for (Book Book : list) {
			System.out.println(Book);
		}
	}

	private String inputContent() {
		System.out.println("책내용>");
		return sc.nextLine();
	}

	private void selectAll() {
		List<Book> list = bDAO.selectAll();
		for (Book Book : list) {
			System.out.println(Book);
		}
	}

	private void selectOne() {
		String BookName = inputName();
		Book book = bDAO.seleceOne(BookName);
		if (book == null) {
			System.out.println("등록되지 않았습니다.");
			return;
		}
		System.out.println(book);
	}

	private String inputName() {
		System.out.println("책이름>");
		return sc.nextLine();
	}

	void menuPrint() {
		System.out.println("===================================");
		System.out.println("1.전체조회 | 2.단건조회 | 3.내용검색 | 4.대여가능 | 5.책 대여 |6.책 반납 | 7.책 등록 | 9.종료");
		System.out.println("===================================");
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
