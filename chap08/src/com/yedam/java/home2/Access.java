package com.yedam.java.home2;

public interface Access {
	// 저장소에 대해 사용방법을 정의
	// 등록
	public void insert(Book book);

	// 수정
	public void update(Book book);

	// 삭제
	public void delete(int studentid);

	// 전체 조회
	public Book[] selectAll();

	// 단건 조회
	public Book selectOne(int studentId);

	public void isbnsorting(int num);

	public void pricesorting(int num);
	
	//분석
	public void report();
}
