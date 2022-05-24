package com.yedam.example1;

public class TakeTrans {

	public static void main(String[] args) {
		Student hong = new Student("hong", 5000);
		Subway green = new Subway("2호선", 1500);
		Bus gre = new Bus("1번", 1000);
		hong.take(green);
		hong.showInfo();
		hong.take(gre);
		green.showInfo();
		hong.showInfo();
		gre.showInfo();
		hong.take(gre);
		hong.showInfo();
		gre.showInfo();

	}

}
