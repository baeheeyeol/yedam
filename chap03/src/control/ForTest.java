package control;

public class ForTest {

	public static void main(String[] args) {

		test1();
	}

	public static void test1() {
		// 10번실행
		for (int i = 1; i < 10; i++) {
			{
				for (int j = 1; j < i*2; j++)
					System.out.print("*");
			}
			System.out.println();
		}
	}
}
