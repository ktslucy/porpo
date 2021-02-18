package com.java.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.DTO.ItemDTO;
import com.java.DTO.MenuDTO;

public class MenuDAO {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/kurly?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PW = "tiger";

	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	static private MenuDAO instance = new MenuDAO();

	public static MenuDAO getInstance() {
		return instance;
	}

	public static String getDriver() {
		return DRIVER;
	}

	public static String getUrl() {
		return URL;
	}

	public static String getUser() {
		return USER;
	}

	public static String getPw() {
		return PW;
	}

	public MenuDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public MenuDTO getCate(String cateNum) {
		System.out.println("getCate");
		System.out.println(cateNum);

		String sql = "select * from category where catenum=?";
		MenuDTO menu = new MenuDTO();

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,cateNum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String catenum = rs.getString("catenum");
				String catename= rs.getString("catename");
				System.out.println(catenum);
				String ico_on= rs.getString("ico_on");
				String ico_off= rs.getString("ico_off");
		
				menu=new MenuDTO(catenum,catename,ico_on,ico_off);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return menu;
	}

	public ArrayList<MenuDTO> getAllCate() {
		System.out.println("getAllCate");
		String sql = "select * from category";
		/* System.out.println("Sfddsf"); */

		ArrayList<MenuDTO> cateList = new ArrayList<>();

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String num = rs.getString("catenum");
				String name = rs.getString("catename");
				/* System.out.println(name); */
				String ico_on = rs.getString("ico_on");
				String ico_off = rs.getString("ico_off");
				MenuDTO temp = new MenuDTO(num, name, ico_on, ico_off);
				cateList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}

		return cateList;
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
		if (pstmt != null) {
			try {
				pstmt.close();
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
