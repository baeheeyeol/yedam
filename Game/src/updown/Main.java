package updown;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		String name;
		GameSystem gs = new GameSystem();
		User us = new User();
		while (run) {
			System.out.println("1.게임시작 2.기록조회 3.게임종료");
			int num = Integer.parseInt(sc.nextLine());
			if (num == 1) {
				System.out.println("이름 입력 : ");
				name = sc.nextLine();
				us.setUserInfo(name);
				us.setGame();
				us.playGame();

			} else if (num == 2) {
				us.userInfoInquiry();
			} else if (num == 3) {
				run = false;
			}
		}
	}
}
