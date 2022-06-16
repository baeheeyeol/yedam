package com.yedam.app.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ProductDAO extends DAO {

	// 싱글톤
	private ProductDAO() {
	};

	private static ProductDAO productDAO = null;

	public static ProductDAO getInstance() {
		if (productDAO == null) {
			productDAO = new ProductDAO();
		}
		return productDAO;
	}

	// CRUD

	// 등록
	public void insert(Product product) {
		try {
			connect();
			String sql = "INSERT INTO product VALUES (produst_seq.nextval,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 - 가격
	public void update(Product product) {
		try {
			connect();
			String sql = "UPDATE product SET product_price =? WHERE product_id =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductPrice());
			pstmt.setInt(2, product.getProductId());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("정상적으로 수정되었습니다.");
			} else {
				System.out.println("정상적으로 수정되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public void delete(Product product) {
		try {
			connect();
			String sql = "DELETE FROM product WHERE product_id =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductId());
			int result = pstmt.executeUpdate();
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

	// 단건조회 - 제품번호
	public Product selectOne(int productId) {
		Product pro = new Product();
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_id =" + productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getNString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return pro;
	}

	// 단건조회 - 제품이름
	public Product selectOne(String productName) {
		Product pro = new Product();
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_id =" + productName;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getNString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return pro;
	}

	// 전체조회
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		try {
			connect();
			String sql = "SELECT * FROM product ORDER BY product_id";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Product pro = new Product();
				pro.setProductId(rs.getInt("product_id"));
				pro.setProductName(rs.getNString("product_name"));
				pro.setProductPrice(rs.getInt("product_price"));
				list.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
