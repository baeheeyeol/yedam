package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player implements Action {
	List<Card> p = new ArrayList<>();
	private String name;
	private int myIndex;
	boolean ready;
	List<Integer> num = new ArrayList<>();

	public Player() {
		this.name = "Player";
		myIndex = -1;
		ready = false;
	}

	@Override
	public void draw(CardList list) {
		int index = (int) (Math.random() * list.list.size());
		p.add(++myIndex, list.list.get(index));
	}

	@Override
	public void hit(CardList list) {
		int index = (int) (Math.random() * list.list.size());
		p.add(++myIndex, list.list.get(index));
	}

	@Override
	public void stay() {
		// TODO Auto-generated method stub

	}

	List<Integer> denominationToInt() {
		List<Integer> num = new ArrayList<>();
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i).getDenomination().charAt(0) == 65) {
				num.add(myIndex, 1);
			} else if (p.get(i).getDenomination().charAt(0) >= 75 && p.get(i).getDenomination().charAt(0) <= 81) {
				num.add(myIndex, 10);
			} else {
				num.add(myIndex, Integer.parseInt(p.get(i).getDenomination()));
			}
		}
		return num;
	}

	public void total() 
	{
		
	}
	
	public void bustCheck() {

		for (int i = 0; i < p.size(); i++) {

		}
	}

	public void showInfo() {
		for (int i = 0; i < p.size(); i++) {
			System.out.println("[" + p.get(i).getPattern() + "." + p.get(i).getDenomination() + "]");
			
		}
	}
}
