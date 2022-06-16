package com.yedam.java.emp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DepartDAO {

	private static DepartDAO departDAO = null;

	private DepartDAO() {
	}

	public static DepartDAO getInstance() {
		if (departDAO == null) {
			departDAO = new DepartDAO();
		}
		return departDAO;
	}

	String jdbc_driver;
	String oracle_url;
	String connectedId;
	String connectedPwd;

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	public void connect() {
		dbconfig();
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB접속 실패 ");
		}
	}

	private void dbconfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();
		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		jdbc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("password");
	}

	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 전체조회
	public List<Department> selectAll() {
		List<Department> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT *FROM departments ORDER BY department_id");
			while (rs.next()) {
				Department dep = new Department();
				dep.setDepartmentId(rs.getInt("department_id"));
				dep.setDepartmentName(rs.getString("department_name"));
				dep.setLocationId(rs.getInt("location_id"));
				dep.setManagerId(rs.getInt("manager_id"));
				list.add(dep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 단건조회
	public Department selectOne(int departmentId) {
		Department dep = null;
		try {
			connect();
			String sql = "SELECT *FROM departments WHERE department_id = " + departmentId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				dep = new Department();
				dep.setDepartmentId(rs.getInt("department_id"));
				dep.setDepartmentName(rs.getString("department_name"));
				dep.setLocationId(rs.getInt("location_id"));
				dep.setManagerId(rs.getInt("manager_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return dep;
	}

	public void insert(Department dep) {
		try {
			connect();
			String sql = "INSERT INTO departments VALUE (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dep.getDepartmentId());
			pstmt.setString(2, dep.getDepartmentName());
			pstmt.setInt(3, dep.getLocationId());
			pstmt.setInt(4, dep.getManagerId());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("등록이 완료되었습니다.");
			} else {
				System.out.println("등록되지 않았습니다.");
			}
			System.out.println(result + "건이 완료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정

	public void update(Department dep) {
		try {
			connect();
			String sql = "UPDATE employees Set department_name =? where department_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dep.getDepartmentName());
			pstmt.setInt(2, dep.getDepartmentId());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("수정이 완료되었습니다.");
			} else {
				System.out.println("수저되지 않았습닌다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void delete(int departmentId) {
		try {
			connect();
			String sql = "DELETE FROM departmentId WHERE department_id=" + departmentId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
