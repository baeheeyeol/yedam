package blackjack;

import java.util.LinkedList;
import java.util.List;

public class CardList {

	List<Card> list = new LinkedList<>();
	String[] pattern = { "S", "C", "D", "H" };
	String[] denomination = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J", "A" };

	public CardList() {
		Card card = new Card();
		setCard(card);
	}

	void setCard(Card card) {
		Card input = card;
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < denomination.length; j++) {
				input.setPattern(pattern[i]);
				input.setDenomination(denomination[j]);
				list.add(0, input);
			}
		}
	}
	
	void showInfo() 
	{
	}
	
}
