package control;

import java.util.Scanner;

/*
 * 숫자맞추기 게임
 */
public class GuessNumber {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int rand = (int) (Math.random() * 100) + 1; // 나중에 난수로 바꿀것임
		int num;
		int count = 0;
		int num1[] = new int[10];
		// 반복
		do {
			System.out.printf("1~100 사이 숫자를 입력하세요:");
			// num = Integer.parseInt(scan.nextLine());
			num = scan.nextInt();
			num1[count] = num;
			if (rand > num) {
				System.out.println("크다");
			} else if (rand < num) {
				System.out.println("작다");
			} else {
				System.out.println("같다");
				break;
			}
			count++;
			if (count >= 5) {
				System.out.println("종료");
				break;
			}

		} while (true);
		for (int i = 0; i < count; i++) {
			System.out.printf("%d ", num1[i]);
		}

		// 반복
		// 키보드 정수값을 읽어서 num 변수에 저장
		// rand > num "크다" 출력
		// rand < num "작다" 출력
		// rand == num break

	}

}
