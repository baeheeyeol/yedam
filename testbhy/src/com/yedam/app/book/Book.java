package com.yedam.app.book;

public class Book {

	@Override
	public String toString() {
		String info = "책제목 : " + name + ", 저자명 : " + writer + ", 내용 : " + content + ", 대여여부 : ";
		if (rental != 0) {
			info += "대여중";
		} else {
			info += "대여가능";
		}
		return info;
	}

	String name;
	String writer;
	String content;
	int rental;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRental() {
		return rental;
	}

	public void setRental(int rental) {
		this.rental = rental;
	}
}
