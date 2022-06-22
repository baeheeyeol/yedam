package com.yedam.app.deal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class TakeOutGoodsDAO extends DAO {
	// 싱글톤
	private TakeOutGoodsDAO() {
	};

	private static TakeOutGoodsDAO dao = null;

	public static TakeOutGoodsDAO getInstance() {
		if (dao == null) {
			dao = new TakeOutGoodsDAO();
		}
		return dao;
	}

	// 등록
	public void insert(DealInfo info) {
		try {
			connect();
			String sql = "INSERT INTO take_out_goods (product_id,product_amount) VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	//단건 수량
	public int selectAmount(int productId) {
		int amount = 0;
		try {
			connect();
			String sql = "SELECT NVL(SUM(product_amount),0) as sum FROM take_out_goods WHERE product_id =" + productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				amount = rs.getInt("sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return amount;
	}

	//전체 -내역
	public List<DealInfo> selectAll() {
		List<DealInfo> list = new ArrayList<DealInfo>();
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id,p.product_name,r.product_amount"
					+ " FROM products p JOIN take_out_goods r" + " ON p.product_id = r.product_id"
					+ " ORDER BY r.deal_date";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductAmount(rs.getInt("product_amount"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//전체 -날짜 
	public List<DealInfo> selectAll(Date dealDate) {
		List<DealInfo> list = new ArrayList<DealInfo>();
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id,p.product_name,r.product_amount"
					+ "FROM prodcuts p JOIN take_out_goods r" + "ON p.product_id = r.product_id" + "WHERE deal_date = ?"
					+ "ORDER BY r.deal_date";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, dealDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductAmount(rs.getInt("product_amount"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//전체 - 아이디
	public List<DealInfo> selectAll(int productId) {
		List<DealInfo> list = new ArrayList<DealInfo>();
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id,p.product_name,r.product_amount"
					+ "FROM prodcuts p JOIN take_out_goods r" + "ON p.product_id = r.product_id"
					+ "WHERE product_id = ?" + "ORDER BY r.deal_date";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductAmount(rs.getInt("product_amount"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
