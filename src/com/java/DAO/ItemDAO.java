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

public class ItemDAO {

	private final String DRIVER = MenuDAO.getDriver();
	private final String URL = MenuDAO.getUrl();
	private final String USER = MenuDAO.getUser();
	private final String PW = MenuDAO.getPw();

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	static private ItemDAO instance = new ItemDAO();

	public static ItemDAO getInstance() {
		return instance;
	}
	public ItemDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ItemDTO getItem(String pdtNum) {
		System.out.println(pdtNum);
		String sql = "select * from items where item_number=?";
		ItemDTO item = null;

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pdtNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String cate = rs.getString("category");
				String item_number = rs.getString("item_number");
				System.out.println(item_number);
				String item_name = rs.getString("item_name");
				String dc_price = rs.getString("dc_price");
				String origin_price = rs.getString("origin_price");
				String descr = rs.getString("descr");
				String unit = rs.getString("unit");
				String weight = rs.getString("weight");
				String delivery = rs.getString("delivery");
				String packing = rs.getString("packing");
				String filename = rs.getString("filename");
				
			

				item = new ItemDTO(cate, item_number, item_name, dc_price, origin_price, descr, unit, weight, delivery,
						packing, filename);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return item;
	}

	public ArrayList<ItemDTO> getCateAllItem(String category) {
		System.out.println("getItem");
		String sql = "select * from items where category=?";
		ArrayList<ItemDTO> ItemList = new ArrayList<>();

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String cate = rs.getString("category");
				String item_number = rs.getString("item_number");
				System.out.println(item_number);
				String item_name = rs.getString("item_name");
				String dc_price = rs.getString("dc_price");
				String origin_price = rs.getString("origin_price");
				String descr = rs.getString("descr");
				String unit = rs.getString("unit");
				String weight = rs.getString("weight");
				String delivery = rs.getString("delivery");
				String packing = rs.getString("packing");
				String filename = rs.getString("filename");

				ItemDTO temp = new ItemDTO(cate, item_number, item_name, dc_price, origin_price, descr, unit, weight,
						delivery, packing, filename);
				ItemList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return ItemList;
	}

	public ArrayList<ItemDTO> getCartList(String[] cartArr) {
		System.out.println("getCartList");
		String sql = "select * from items where item_number=?";
		ArrayList<ItemDTO> cartList = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			for (String i : cartArr) {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, i);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					String cate = rs.getString("category");
					String item_number = rs.getString("item_number");
					System.out.println(item_number);
					String item_name = rs.getString("item_name");
					System.out.println(item_name);
					String dc_price = rs.getString("dc_price");
					String origin_price = rs.getString("origin_price");
					String descr = rs.getString("descr");
					String unit = rs.getString("unit");
					String weight = rs.getString("weight");
					String delivery = rs.getString("delivery");
					String packing = rs.getString("packing");
					String filename = rs.getString("filename");

					ItemDTO temp = new ItemDTO(cate, item_number, item_name, dc_price, origin_price, descr, unit,
							weight, delivery, packing, filename);
					cartList.add(temp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return cartList;

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
