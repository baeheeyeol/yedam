package com.yedam.java.lifofifo;

import java.util.LinkedList;
import java.util.Queue;

public class FifoTest {
	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<>();

		que.offer(1);
		que.offer(2);
		que.offer(3);
		que.offer(4);
		while (!que.isEmpty()) {
			int value = que.poll();
			System.out.println("\tQueue 값 : " + que.size());
			System.out.println("꺼내온 값 : " + value);
		}
	}
}
