package com.yedam.example2;

public class CardFactory {
	// 필드
	private static CardFactory instance = new CardFactory();

	// 생성자
	private CardFactory() {
	}

	// 메소드
	public static CardFactory gerInstance() {
		return instance;
	}

	public Card createCard() {
		return new Card();
	}
}
