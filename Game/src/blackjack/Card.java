package blackjack;

public class Card {

	String denomination;

	String pattern;

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String number) {
		this.denomination = number;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void showInfo() {
		System.out.println(pattern + " " + denomination);
	}
}
