package com.yedam.java.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();

		long start;
		long end;

		start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			list1.add(0, String.valueOf(1));
		}
		end = System.nanoTime();
		System.out.println("ArrayList  걸린시간 : " + (end - start) + "ns");

		start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			list2.add(0, String.valueOf(1));
		}
		end = System.nanoTime();
		System.out.println("LinkedList 걸린시간 : " + (end - start) + "ns");
	}
}
