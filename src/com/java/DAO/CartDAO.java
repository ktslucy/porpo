package com.java.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.java.DTO.CartDTO;
import com.java.DTO.ItemDTO;
import com.java.DTO.MenuDTO;

public class CartDAO {

	private final String DRIVER = MenuDAO.getDriver();
	private final String URL = MenuDAO.getUrl();
	private final String USER = MenuDAO.getUser();
	private final String PW = MenuDAO.getPw();
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	static private CartDAO instance = new CartDAO();

	public static CartDAO getInstance() {
		return instance;
	}

	public CartDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<CartDTO> parseCartList(String cartList) {
		
		List<CartDTO> list=new ArrayList<>();
		JsonParser jsonParser = new JsonParser();
		JsonArray jsonArray = (JsonArray) jsonParser.parse(cartList);
		
		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject object = (JsonObject) jsonArray.get(i);
			String itemNumber = object.get("itemNumber").getAsString();
			String cartCnt = object.get("cartCnt").getAsString();
			CartDTO cartDTO=getCartPdt(itemNumber,cartCnt);
			list.add(cartDTO);
		}
		return list;
	}
	
	public CartDTO getCartPdt(String itemNumber, String cartCnt) {
		
		CartDTO cart=null;
		try {
			ItemDAO itemDAO=ItemDAO.getInstance();
			ItemDTO item=itemDAO.getItem(itemNumber);
			cart=new CartDTO(item,cartCnt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return cart;
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
