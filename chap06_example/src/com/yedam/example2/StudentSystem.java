package com.yedam.example2;

public class StudentSystem {

	public static void main(String[] args) {
		Student lee = new Student("이지원");
		System.out.println(Student.getSerialNum());
		System.out.println(lee.getName() + "의 학번 :" + lee.getStudentId());
		
		Student son = new Student("손수경");
		System.out.println(Student.getSerialNum());
		System.out.println(son.getName() + "의 학번 :" + son.getStudentId());
		System.out.println(lee.getName() + "의 학번 :" + lee.getStudentId());
	}

}
