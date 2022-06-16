package com.yedam.java.emp;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmpSystem {
	private EmpDAO dao = EmpDAO.getInstance();
	private Scanner sc = new Scanner(System.in);

	public EmpSystem() {
		while (true) {
			// 메뉴 출력
			menuPrint();
			// 메뉴 입력
			int menuNo = selectMenu();
			// 각 기능별 실행
			if (menuNo == 1) {
				// 등록
				insertEmployee();
			} else if (menuNo == 2) {
				// 수정
				updateEmployee();
			} else if (menuNo == 3) {
				// 삭제
				deleteEmployee();
			} else if (menuNo == 4) {
				// 사원조회(단건조회)
				selectEmployee();
			} else if (menuNo == 5) {
				// 전체조회
				selectAllEmployee();
			} else if (menuNo == 9) {
				exit();
				break;
			} else {
				inputError();
			}
		}
	}

	private void menuPrint() {
		System.out.println("=========================================");
		System.out.println(" 1.등록 2.수정 3.삭제 4.사원조회 5.전체조회 9.종료");
		System.out.println("=========================================");
	}

	private int selectMenu() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");
		}
		return menu;
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	private void inputError() {
		System.out.println("메뉴에 맞게 입력해주세요.");
	}

	private void insertEmployee() {
		// 사원정보 입력
		Employee emp = inputAll();
		// DB에 전달
		dao.insert(emp);
	}

	private void updateEmployee() {
		// 수정하는 정보 입력
		Employee emp = inputUpdateInfo();
		// DB에 전달
		dao.update(emp);
	}

	private void deleteEmployee() {
		// 사원번호 입력
		int employeeId = inputEmployeeId();
		// DB에 전달
		dao.delete(employeeId);
	}

	private void selectEmployee() {
		// 사원번호 입력
		int employeeId = inputEmployeeId();
		// DB 검색
		Employee emp = dao.selectOne(employeeId);
		// 결과 출력
		if (emp != null) {
			System.out.println(emp);
		} else {
			System.out.println("원하는 정보가 존재하지 않습니다.");
		}
	}

	private void selectAllEmployee() {
		List<Employee> list = dao.selectAll();
		for (Employee emp : list) {
			System.out.println(emp);
		}
	}

	private Employee inputAll() {
		Employee emp = new Employee();
		System.out.print("사번>>");
		emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
		System.out.println("이름>>");
		emp.setFirstName(sc.nextLine());
		System.out.println("성>>");
		emp.setLastName(sc.nextLine());
		System.out.println("이메일>>");
		emp.setEmail(sc.nextLine());
		System.out.println("전화번호");
		emp.setCommissionPct(Integer.parseInt(sc.nextLine()));
		System.out.println("입사일(YYYY-MM-DD)>>");
		emp.setHireDate(Date.valueOf(sc.nextLine()));
		System.out.println("직급>>");
		emp.setJobId(sc.nextLine());
		System.out.println("연봉>>");
		emp.setSalary(Double.parseDouble(sc.nextLine()));
		System.out.println("상여>>");
		emp.setCommissionPct(Double.parseDouble(sc.nextLine()));
		System.out.println("상사>>");
		emp.setManagerId(Integer.parseInt(sc.nextLine()));
		System.out.println("부서>>");
		emp.setDepartmentId(Integer.parseInt(sc.nextLine()));

		return emp;
	}

	private Employee inputUpdateInfo() {
		Employee emp = new Employee();
		System.out.println("사번>>");
		emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
		System.out.println("연봉>>");
		emp.setSalary(Integer.parseInt(sc.nextLine()));
		return emp;
	}

	private int inputEmployeeId() {
		System.out.println("사번>>");
		return Integer.parseInt(sc.nextLine());
	}
}
