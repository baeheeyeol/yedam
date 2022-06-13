package updown;

public class User extends GameSystem {

	protected String name;
	private User[] list;
	private int index;
	private int userNum = 100;
	private int score;

	public User() {
		index = -1;
		setUsSize();
	};

	@Override
	public void setGame() {
		this.point = (int) (Math.random() * 100) + 1;
		this.endCheck = false;
		this.round = 10;
	};

	@Override
	public void playGame() {
		while (!endCheck) {
			System.out.println("남은 기회 : " + round);
			round--;
			inputNum();
			compareValue();
			if (round == 0) {
				endCheck = true;
				System.out.println("실패");
			}
		}
		list[index].score = getScore();
	}

	public void setUserInfo(String name) {
		User us = new User();
		us.score = this.score;
		us.name =name;
		list[++index] = us;
	}

	public void userInfoInquiry() {
		for (int i = 0; i <= index; i++) {
			list[i].showInfo();
		}
	};

	public void showInfo() {
		System.out.println("이름 : " + name + " 점수 : " + score);
	}

	public void setScore() {

		this.score = round;
	}

	public int getScore() {
		return this.score = round;
	}

//	private void setName(String name) {
//		this.name = name;
//	}

	public String getName() {
		return this.name;
	}

	public void setUsSize() {
		list = new User[userNum];
	}
}