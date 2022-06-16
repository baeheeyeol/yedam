package com.yedam.java.emp;

import java.util.List;
import java.util.Scanner;

public class DepSystem {
	private DepartDAO dao = DepartDAO.getInstance();
	private Scanner sc = new Scanner(System.in);

	public DepSystem() {
		while (true) {
			menuPrint();

			int menuNo = selectMenu();

			if (menuNo == 1) {
				insertDepartment();
			} else if (menuNo == 2) {
				updateDepartment();
			} else if (menuNo == 3) {
				deleteDepartment();
			} else if (menuNo == 4) {
				selectDepartment();
			} else if (menuNo == 5) {
				selectAllDepartment();
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
		System.out.println("프로그램을 종룍합니다.");
	}

	private void inputError() {
		System.out.println("메뉴에 맞게 입력해주세요.");
	}

	private void insertDepartment() {
		Department dep = inpuAll();
		dao.insert(dep);
	}

	private void updateDepartment() {
		Department dep = inputUpdateInfo();
		dao.update(dep);
	}

	private void deleteDepartment() {
		int departmentId = inputDepartmentId();
		dao.delete(departmentId);
	}

	private void selectDepartment() {
		int departmentId = inputDepartmentId();
		Department dep = dao.selectOne(departmentId);
		if (dep != null) {
			System.out.println(dep);

		} else {
			System.out.println("원하는 정보가 존재하지 않습니다.");
		}
	}

	private void selectAllDepartment() {
		List<Department> list = dao.selectAll();
		for (Department dep : list) {
			System.out.println(dep);
		
		}
	}

	private Department inpuAll() {
		Department dep = new Department();
		System.out.println("부서번호>>");
		dep.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.println("부서이름>>");
		dep.setDepartmentName(sc.nextLine());
		System.out.println("상사>>");
		dep.setManagerId(Integer.parseInt(sc.nextLine()));
		System.out.println("위치>>");
		dep.setLocationId(Integer.parseInt(sc.nextLine()));

		return dep;
	}

	private Department inputUpdateInfo() {
		Department dep = new Department();
		System.out.println("부서이름>>");
		dep.setDepartmentName(sc.nextLine());
		System.out.println("부서번호>>");
		dep.setDepartmentId(Integer.parseInt(sc.nextLine()));
		return dep;
	}

	private int inputDepartmentId() {
		System.out.println("번호>>");
		return Integer.parseInt(sc.nextLine());
	}
}
