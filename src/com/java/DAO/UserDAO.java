package com.java.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.java.DTO.UserDTO;

public class UserDAO {

	private final String DRIVER = MenuDAO.getDriver();
	private final String URL = MenuDAO.getUrl();
	private final String USER = MenuDAO.getUser();
	private final String PW = MenuDAO.getPw();

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	static private UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;
	}

	public UserDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void join(UserDTO user) {
		String query = "insert into user VALUES (?,?,?,?,?,?)";
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getAddress());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
	}

	public int login(String id, String pw) {

		String query = "select pw from user where id=?";
		int log = 0;

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("2resultset:" + rs.getString("pw"));
				String pwdb = rs.getString("pw");
				if (pwdb.equals(pw)) {
					log = 1;
				}
			} else {
				log = -1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		System.out.println("log:" + log);
		return log;
	}

	public String findId(String user, String email) {
		
		String query = "select id from user where username=? and email=?";
		String id="";

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				id = rs.getString("id");
			}
			System.out.println("id:" + id);
			return id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		
		return "-1";
	}
	
	public String findPw(String user, String id,String email) {
		
		String query = "select pw from user where username=? and id=? and email=?";
		String pw="";

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user);
			pstmt.setString(2, id);
			pstmt.setString(3, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pw = rs.getString("pw");
			}
			System.out.println("pw:" + pw);
			return pw;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return "-1";
	}
	public int updateCmt(String brdNo, String ordNo) {
		String query = "UPDATE board SET cmt = 'Y' WHERE brdNo = ? and orderNo=?";	
		//String query = " INSERT INTO `kurly`.`board` (`brdDate`, `brdType`, `title`, `orderNo`, `writer`, `email`, `mobile`, `contents`, `ref`, `restep`, `cmt`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, brdNo);
			pstmt.setString(2, ordNo);
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return -1;
	}
	
	public UserDTO getUser(String userId) {
		String query = "select * from user where id=?";
		UserDTO user = null;
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				
				String id = rs.getString("id");
				System.out.println("member:" + id);
				String pw = rs.getString("pw");
				String name = rs.getString("username");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");

				user = new UserDTO(id, pw, name, phone, email, address);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return user;
	}

	public int updateUser(UserDTO user) {
		String query = "UPDATE user SET pw=?, username=?, email=?, phone=?, address=? where id = '1234';";	
		//String query = " INSERT INTO `kurly`.`board` (`brdDate`, `brdType`, `title`, `orderNo`, `writer`, `email`, `mobile`, `contents`, `ref`, `restep`, `cmt`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getPw());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getAddress());
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return -1;
	}
	
	private void close(Connection con, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
}
