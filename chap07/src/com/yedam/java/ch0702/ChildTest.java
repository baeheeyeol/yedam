package com.yedam.java.ch0702;

public class ChildTest {

	public static void main(String[] args) {
		Father father = new Father();
		Uncle uncle = new Uncle();
		Child child = new Child();
		Cousin cousin = new Cousin();

		GranPa pa = father;
		pa.method();
		pa = uncle;
		pa.method();
		pa = child;
		pa.method();
		pa = cousin;
		pa.method();

		Father fa = child;
//		fa = uncle;
//		fa = cousin;
		fa.method();
		
		Child ch =(Child)fa;
//		Cousin co =(Cousin)fa;
		System.out.println();
		Uncle un = cousin;
//		un = father;
//		un =child;
		un.method();
	}
}
