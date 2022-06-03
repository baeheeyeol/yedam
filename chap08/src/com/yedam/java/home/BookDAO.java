package com.yedam.java.home;

public class BookDAO implements Access {
	// 3
	// 싱글톤
	private static BookDAO instance = new BookDAO();

	private BookDAO() {
		init();
	}

	public static BookDAO getInstance() {
		return instance;
	}

	// 실제 사용할 필드 및 메소드
	private Book[] dataList;
	private int listIndex;

	private void init() {
		dataList = new Book[100];
		listIndex = -1;
	}

	@Override
	public void insert(Book book) {
		dataList[++listIndex] = book;
	}

	@Override
	public void update(Book book) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getIsbn() == book.getIsbn()) {
				dataList[i] = book;
			}
		}
	}

	@Override
	public void delete(int isbn) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getIsbn() == isbn) {
				dataList[i] = null;
			}
		}
		cleanDataList();

	}

	void cleanDataList() {
		// 기존 필드 -> 임시변수로 값 복사
		Book[] tempList = dataList;
		int tempIndex = listIndex;
		// 기존 필드 초기화
		init();
		// 임시변수 -> 기존필드로 갑을 옮김
		for (int i = 0; i <= tempIndex; i++) {
			if (tempList[i] != null) {
				dataList[++listIndex] = tempList[i];
			}
		}
	};

	@Override
	public Book[] selectAll() {
		Book[] list = new Book[listIndex + 1];
		for (int i = 0; i <= listIndex; i++) {
			list[i] = dataList[i];
		}
		return list;
	}

	@Override
	public Book selectOne(int isbn) {
		Book book = null;
		//int index = 0;
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getIsbn() == isbn) {
				// index = i;
				book = dataList[i];
				break;

			}
		}
		return book;
		//return dataList[index];
	}

}
