package com.yedam.java.ch02;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample {
	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("d:/dev/temp/test7.txt");

		char a = 'A';
		char b = 'B';
		char c = 'C';

		writer.write(a);
		writer.write(b);
		writer.write(c);
		writer.flush();
		writer.close();

		writer = new FileWriter("d:/dev/temp/test8.txt");
		char[] array1 = { 'A', 'B', 'C' };
		writer.write(array1);
		writer.flush();
		writer.close();

		writer = new FileWriter("d:/dev/temp/test9.txt");
		char[] array2 = { 'A', 'B', 'C', 'D', 'E' };
		writer.write(array2, 3, 2);
		writer.flush();
		writer.close();

		writer = new FileWriter("d:/dev/temp/test10.txt");

		String str1 = "ABCDE\n";
		String str2 = "abcde";

		writer.write(str1);
		writer.write(str2, 3, 2);
		writer.flush();
		writer.close();
	}
}
