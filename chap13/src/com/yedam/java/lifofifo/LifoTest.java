package com.yedam.java.lifofifo;

import java.util.Stack;

public class LifoTest {
	public static void main(String[] args) {
		Stack<Integer> box = new Stack<>();

		box.push(1);
		box.push(2);
		box.push(3);
		box.push(4);
		while (!box.isEmpty()) {
			int value = box.pop();
			System.out.println("\tbox 값 : " + box.size());
			System.out.println("꺼내온 값 : " + value);
		}
	}
}
