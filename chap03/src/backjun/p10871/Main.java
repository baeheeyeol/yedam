package backjun.p10871;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		int x;
		int num; //입력변수
		int i = 1; //반복횟수

		n = scan.nextInt(); 
		x = scan.nextInt();
		do {
			num = scan.nextInt(); 
			if (num < x) { 
				System.out.println(num + "");
			}
			i++; 
		} while (i <= n);  
	}
}
