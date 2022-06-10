package com.yedam.java.list;

import java.util.ArrayList;
import java.util.List;

public class ArraryListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");

		System.out.println("총 객체 수 : " + list.size());
		System.out.println();

		String skill = list.get(2);
		System.out.println(skill);
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}

		System.out.println();
		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");
		for (String data : list) {
			System.out.println(data);
		}
	}
}
