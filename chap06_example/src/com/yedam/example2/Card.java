package com.yedam.example2;

public class Card {

	private static int serialNum = 1100;
	
	private int cardId;

	public Card() {
		serialNum++;
		this.cardId = serialNum;
	}
	
	public static int getSerialNum() {
		return serialNum;
	}

	public int getCardId() {
		return cardId;
	}
	
}
