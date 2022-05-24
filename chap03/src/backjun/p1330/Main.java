package backjun.p1330;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int C = scan.nextInt();

		for (int i = 0; i < C; i++) {
			double result = 0;
			int total = 0;
			double avg = 0;
			double count = 0; // 학생들 수 입력
			int num = scan.nextInt(); // 과목 수 입력
			int[] std = new int[num];
			for (int j = 0; j < num; j++) {
				std[j] = scan.nextInt(); // 과목 점수 입력
				total += std[j];
			}
			avg = (double) total / num;

			for (int j = 0; j < num; j++) {
				if (std[j] > avg) {
					++count;
				}
			}
			result = (double) (count / num) * 100;
			System.out.printf("%.3f%%\n", result);
		}
	}
}
