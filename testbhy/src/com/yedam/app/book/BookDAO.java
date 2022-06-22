package com.yedam.app.book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class BookDAO extends DAO {

	private static BookDAO dao = null;

	private BookDAO() {
	};

	public static BookDAO getInstance() {
		if (dao == null) {
			dao = new BookDAO();
		}
		return dao;
	}

	// 책등록

	public void insert(Book book) {
		try {
			connect();
			String sql = "INSERT INTO books (book_name,book_writer,book_content) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getContent());
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

	// 렌탄조회
	public List<Book> selectRental() {
		List<Book> list = new ArrayList<Book>();
		try {
			connect();
			String sql = "SELECT *FROM books WHERE book_retal =0";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Book book = new Book();
				book.setContent(rs.getString("book_content"));
				book.setName(rs.getString("book_name"));
				book.setWriter(rs.getString("book_writer"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 대여
	public Book Rental(String name) {
		Book book = null;
		try {
			connect();
			String sql = "UPDATE BOOKS SET BOOK_RETAL =1 WHERE BOOK_NAME =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("대여되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return book;
	}

	// 반납
	public Book Returm(String name) {
		Book book = null;
		try {
			connect();
			String sql = "UPDATE BOOKS SET BOOK_RETAL =0 WHERE BOOK_NAME =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("반납되었습니다.");
			} else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return book;
	}

	// 단건조회
	public Book seleceOne(String name) {
		Book book = null;
		try {
			connect();
			String sql = "SELECT * FROM books WHERE book_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setContent(rs.getString("book_content"));
				book.setName(rs.getString("book_name"));
				book.setWriter(rs.getString("book_writer"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return book;
	}

	// 내용검색
	public List<Book> selectWrite(String write) {
		List<Book> list = new ArrayList<Book>();
		try {
			connect();
			String sql = "SELECT *FROM books WHERE book_CONTENT like '%자바%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Book book = new Book();
				book.setContent(rs.getString("book_content"));
				book.setName(rs.getString("book_name"));
				book.setWriter(rs.getString("book_writer"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 전체조회
	public List<Book> selectAll() {
		List<Book> list = new ArrayList<Book>();
		try {
			connect();
			String sql = "SELECT *FROM books";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Book book = new Book();
				book.setContent(rs.getString("book_content"));
				book.setName(rs.getString("book_name"));
				book.setWriter(rs.getString("book_writer"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
