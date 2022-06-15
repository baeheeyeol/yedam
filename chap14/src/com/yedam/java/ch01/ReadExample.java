package com.yedam.java.ch01;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("D:/dev/temp/test1.db");
		while (true) {
			int data = is.read();
			if (data == -1)
				break;
			System.out.println(data);
		}
		is.close();
		System.out.println("------------------------------");

		is = new FileInputStream("D:/dev/temp/test2.db");
		byte[] buffer = new byte[100];
		while (true) {
			int readByteNum = is.read(buffer);
			if (readByteNum == -1)
				break;
			for (int i = 0; i < readByteNum; i++) {
				System.out.println(buffer[i]);
			}
			System.out.println();
		}
		is.close();
		
		System.out.println("------------------------------");

		is = new FileInputStream("D:/dev/temp/test3.db");
		int readByteNum = is.read(buffer,3,5);
		for (int i = 0; i < (3 + readByteNum); i++) {
			System.out.println(buffer[i]);
		}
		is.close();
		System.out.println("------------------------------");

	}
}
