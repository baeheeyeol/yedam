package blackjack;

public interface Action {

	void hit(CardList list);

	void stay();

	void draw(CardList list);
}
