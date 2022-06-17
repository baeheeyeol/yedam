package com.yedam.app.history;

import java.nio.file.ClosedDirectoryStreamException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yedam.app.common.DAO;

public class HistoryDAO extends DAO {
	// 싱글톤
	private HistoryDAO() {
	};

	private static HistoryDAO historyDAO = null;

	public static HistoryDAO getInstance() {
		if (historyDAO == null) {
			historyDAO = new HistoryDAO();
		}
		return historyDAO;
	}

	// CRUD

	// 등록
	public void insert(History history) {
		try {
			connect();
			String sql = "INSERT INTO product_history VALUES (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductId());
			pstmt.setInt(2, history.getProductCategory());
			pstmt.setInt(3, history.getProductAmount());
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

	// 수정 - 수량
	void update(History history) {
		try {
			connect();
			String sql = "UPDATE history SET product_amount = ? WHERE product_Id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductAmount());
			pstmt.setInt(2, history.getProductId());
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

	// 삭제
	void delete(History history) {
		try {
			connect();
			String sql = "DELETE FROM history WHERE product_Id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductId());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("삭제가 완료되었습니다.");
			} else {
				System.out.println("삭제되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 단건 조회 - 각 상품에 대한 재고
	public int selectInAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql = "SELECT SUM(product_amount) as sum FROM product_history WHERE product_id =? AND product_category =1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 단건 조회 - 각 상품에 대한 출고량
	public int selectOutAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql = "SELECT SUM(product_amount) as sum FROM product_history WHERE product_id =? AND product_category =2";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	// 전체 조회 - 전체 상품의 각 재고

	public Map<Integer, Integer> selectAllAmout() {
		Map<Integer, Integer> list = new HashMap<>();
		try {
			connect();
			// 각 제품에 따른 입고량과 출고량
			String sql = "SELECT product_id,product_category, SUM(product_amount) as amount FROM product_history GROUP BY product_id,product_category";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// 입고와 출고에 따른 각각의 목록
			Map<Integer, Integer> inList = new HashMap<>();
			Map<Integer, Integer> outList = new HashMap<>();
			while (rs.next()) {
				int category = rs.getInt("product_category");
				if (category == 1) {
					inList.put(rs.getInt("product_id"), rs.getInt("amount"));
				} else {
					outList.put(rs.getInt("product_id"), rs.getInt("amount"));
				}
			}
			Set<Integer> keySet = inList.keySet();
			for (int key : keySet) {
				int inAmount = inList.get(key);
				Integer outAmount = outList.get(key);
				if (outAmount != null) {
					list.put(key, (inAmount - outAmount));
				} else {
					list.put(key, inAmount);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	public List<History> selectAll() {
		List<History> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM Product_history ORDER BY product_id";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				History history = new History();
				history.setProductAmount(rs.getInt("product_aomunt"));
				history.setProductCategory(rs.getInt("product_category"));
				history.setProductId(rs.getInt("product_id"));
				list.add(history);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
