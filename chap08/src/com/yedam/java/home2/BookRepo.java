package com.yedam.java.home2;

public class BookRepo implements Access {
//dao
	private static BookRepo instance = new BookRepo();
	private Book[] dataList;
	private int listIndex;

	public static BookRepo getInstance() {
		return instance;
	}

	// 생성자
	private BookRepo() {
		init();
	}

	// 입력
	public void insert(Book book) {
		dataList[++listIndex] = book;
	}

	// 초기화
	private void init() {
		dataList = new Book[100];
		listIndex = -1;
	}

	@Override
	public Book[] selectAll() {
		Book[] list = new Book[listIndex + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = dataList[i];
		}
		return list;
	}

	@Override
	public Book selectOne(int isbn) {
		Book selected = null;
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getIsbn() == isbn) {
				selected = dataList[i];
			}
		}
		return selected;
	}

	@Override
	public void isbnsorting(int num) {
		System.out.println(num);
		if (num == 1) {
			isbnForwardSorting();
		} else if (num == 2) {
			isbnReverseSorting();
		}
	}

	void isbnForwardSorting() {
		Book[] temp = new Book[listIndex + 1];
		for (int i = 0; i < listIndex; i++) {
			for (int j = 0; j < listIndex; j++) {
				if (dataList[j].getIsbn() < dataList[j + 1].getIsbn()) {
					temp[j] = dataList[j];
					dataList[j] = dataList[j + 1];
					dataList[j + 1] = temp[j];
				}
			}
		}
	}

	void isbnReverseSorting() {
		Book[] temp = new Book[listIndex + 1];
		for (int i = 0; i < listIndex; i++) {
			for (int j = 0; j < listIndex; j++) {
				if (dataList[j].getIsbn() > dataList[j + 1].getIsbn()) {
					temp[j] = dataList[j];
					dataList[j] = dataList[j + 1];
					dataList[j + 1] = temp[j];
				}
			}
		}
	}

	@Override
	public void pricesorting(int num) {
		System.out.println(num);
		if (num == 1) {
			priceForwardSorting();
		} else if (num == 2) {
			priceReverseSorting();
		}

	}

	void priceForwardSorting() {
		Book[] temp = new Book[listIndex + 1];
		for (int i = 0; i < listIndex; i++) {
			for (int j = 0; j < listIndex; j++) {
				if (dataList[j].getPrice() < dataList[j + 1].getPrice()) {
					temp[j] = dataList[j];
					dataList[j] = dataList[j + 1];
					dataList[j + 1] = temp[j];
				}
			}
		}
	}

	void priceReverseSorting() {
		Book[] temp = new Book[listIndex + 1];
		for (int i = 0; i < listIndex; i++) {
			for (int j = 0; j < listIndex; j++) {
				if (dataList[j].getPrice() > dataList[j + 1].getPrice()) {
					temp[j] = dataList[j];
					dataList[j] = dataList[j + 1];
					dataList[j + 1] = temp[j];
				}
			}
		}
	}

	@Override
	public void report() {
		System.out.println();
	}


	@Override
	public void update(Book book) {

	}

	@Override
	public void delete(int studentid) {

	}
}
