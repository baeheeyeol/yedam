package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExample {
	public static void main(String[] args) throws Exception {
		// 1. JDBC Driver 로딩하기
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. DB 서버 접속하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pws = "hr";

		Connection con = DriverManager.getConnection(url, id, pws);

		// 3. Statement or preparedStatement 객체 생성하기
		Statement stmt = con.createStatement();

		// 4. Query 구성
		String sql = "SELECT *FROM employees";

		// 5. Query 실행
		ResultSet rs = stmt.executeQuery(sql);

		// 6. 결과값 출력하기
		while (rs.next()) {
			String name = rs.getString("first_name") + " " + rs.getString("last_name");
			System.out.println(name);
		}

		// 7. 자원해제하기
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
	}
}
