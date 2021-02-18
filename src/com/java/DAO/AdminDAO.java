package com.java.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.DTO.AdminDTO;
import com.java.DTO.UserDTO;

public class AdminDAO {
	private final String DRIVER = MenuDAO.getDriver();
	private final String URL = MenuDAO.getUrl();
	private final String USER = MenuDAO.getUser();
	private final String PW = MenuDAO.getPw();

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	static private AdminDAO instance = new AdminDAO();

	public static AdminDAO getInstance() {
		return instance;
	}

	public AdminDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int login(String id, String pw) {

		String query = "select pw from adminInfo where id=?";
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
