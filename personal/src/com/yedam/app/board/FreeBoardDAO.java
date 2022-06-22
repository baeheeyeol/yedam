package com.yedam.app.board;

import java.sql.SQLException;

import com.yedam.app.common.DAO;

public class FreeBoardDAO extends DAO {

	// 싱글톤
	private FreeBoardDAO() {
	};

	private static FreeBoardDAO dao = null;

	public static FreeBoardDAO getInstance() {
		if (dao == null) {
			dao = new FreeBoardDAO();
		}
		return dao;
	}

	// 등록
	void insert(FreeBoard freeBoard) {
		try {
			connect();
			String sql = "INSERT INTO Freeboard valuse(fr_bd_seq.nextval,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, freeBoard.getFreeBoardTitle());
			pstmt.setString(2, freeBoard.getFreeBoardContent());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("등록이 완료되었습니다.");
			} else {
				System.out.println("등록되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 - 제목
	void updateTitle(String freeBoardId) {
		try {
			connect();
			String sql = "UPDATE FreeBoard SET fr_bd_title WHERE FR_BD_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, freeBoardId);
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("수정이 완료되었습니다.");
			} else {
				System.out.println("수정되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 수정 - 내용
	void updateContent(String freeBoardId) {
		try {
			connect();
			String sql = "UPDATE FreeBoard SET fr_BD_Content WHERE FR_BD_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, freeBoardId);
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("수정이 완료되었습니다.");
			} else {
				System.out.println("수정되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
}
