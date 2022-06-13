package updown;

import java.util.Scanner;

public class GameSystem {

	Scanner sc = new Scanner(System.in);
	protected int point;
	private int inputNum;
	boolean endCheck;
	public int round = 10;

	public GameSystem() {
	}

	public void setGame() {
		this.point = (int) (Math.random() * 100) + 1;
		this.endCheck = false;
		this.round = 10;
	}

	public void playGame() {
		while (!endCheck) {
			System.out.println("남은 기회 : " + round);
			round--;
			inputNum();
			compareValue();
			if (round <= 0) {
				endCheck = true;
			}
		}
		System.out.println("실패");
	}

	public void inputNum() {
		System.out.println("1~100사이 숫자를 입력하세요 :");
		this.inputNum = Integer.parseInt(sc.nextLine());
	}

	void compareValue() {
		if (this.inputNum > this.point) {
			upSitu();
		} else if (this.inputNum < this.point) {
			downSitu();
		} else {
			resultSitu();
		}
	}

	private void upSitu() {
		System.out.println("Up");
	}

	private void downSitu() {
		System.out.println("Down");
	}

	private void resultSitu() {
		System.out.println("정답입니다.");
		this.endCheck = true;
	}


}
