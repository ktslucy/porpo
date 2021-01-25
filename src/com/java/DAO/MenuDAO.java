package com.java.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.DTO.MenuDTO;



public class MenuDAO {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/kurly?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PW = "tiger";
	
	private Connection con;
	private Statement stmt;
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

	public ArrayList<MenuDTO> getCate() {
		System.out.println("select");
		String sql = "select * from category";
		
		ArrayList<MenuDTO> cateList=new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String num = rs.getString("catenum");
				String name= rs.getString("catename");
				System.out.println(name);
				String ico_on= rs.getString("ico_on");
				String ico_off= rs.getString("ico_off");
				MenuDTO temp=new MenuDTO(num,name,ico_on,ico_off);
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
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}

}
