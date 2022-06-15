package com.yedam.java.ch03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class CharterConvertExample {
	public static void main(String[] args) throws Exception {

		System.out.println("입력 문장>");
		String data = new Scanner(System.in).nextLine();
		write(data);
		read();
	}

	public static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream("D:/dev/temp/text1.txt");
		Writer writer = new OutputStreamWriter(os);
		writer.write(str);
		writer.flush();
		writer.close();
	}

	public static void read() throws Exception {
		InputStream is = new FileInputStream("D:/dev/temp/text1.txt");
		Reader reader = new InputStreamReader(is);

		char[] buffer = new char[100];
		int readCharNum = reader.read(buffer);
		reader.close();

		String data = new String(buffer,0,readCharNum);
		System.out.println(data);
	}
}
