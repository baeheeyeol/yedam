package com.yedam.java.ch1103;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println();

		for(int i=1;i<100000000;i++) {
			
		}
		
		String result = sdf.format(new Date());
		System.out.println(result);
	}

}
