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
	private PreparedStatement stmt;
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

	
	public  ArrayList<ItemDTO> getMdRecmd(String cateNum){
		String sql = "select * from items where category=?";
		ArrayList<ItemDTO> mdList=new ArrayList<>();
		int cnt=1;
		
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			stmt = con.prepareStatement(sql);
			stmt.setString(1,cateNum);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				if(cnt==9) break;
				
				String cate = rs.getString("category");
				String item_number= rs.getString("item_number");
				System.out.println(item_number);
				String item_name= rs.getString("item_name");
				String dc_price= rs.getString("dc_price");
				String origin_price= rs.getString("origin_price");
				String descr= rs.getString("descr");
				String unit= rs.getString("unit");
				String weight= rs.getString("weight");
				String delivery= rs.getString("delivery");
				String packing= rs.getString("packing");
				String filename= rs.getString("filename");

				ItemDTO temp=new ItemDTO(cate,item_number,item_name,dc_price,origin_price,descr,unit,weight,delivery,packing,filename);
				mdList.add(temp);
				
				cnt+=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		
		return mdList;
	}
	
	public ArrayList<ItemDTO> getItem(String category) {
		System.out.println("select");
		String sql = "select * from items where category=?";
		
		ArrayList<ItemDTO> ItemList=new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			stmt = con.prepareStatement(sql);
			stmt.setString(1,category);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				String cate = rs.getString("category");
				String item_number= rs.getString("item_number");
				System.out.println(item_number);
				String item_name= rs.getString("item_name");
				String dc_price= rs.getString("dc_price");
				String origin_price= rs.getString("origin_price");
				String descr= rs.getString("descr");
				String unit= rs.getString("unit");
				String weight= rs.getString("weight");
				String delivery= rs.getString("delivery");
				String packing= rs.getString("packing");
				String filename= rs.getString("filename");

				ItemDTO temp=new ItemDTO(cate,item_number,item_name,dc_price,origin_price,descr,unit,weight,delivery,packing,filename);
				ItemList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		
		return ItemList;
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
