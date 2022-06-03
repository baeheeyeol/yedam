package com.yedam.java.home;

//2.
public interface Access {
	//등록
	void insert(Book book);
	//수정
	void update(Book book);
	//삭제
	void delete(int isbn);
	//전체조회
	Book[] selectAll();
	//단건조회
	Book selectOne(int isbn);
}
