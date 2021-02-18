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
import com.java.DTO.OrderDTO;
import com.java.DTO.OrderListDTO;
import com.java.DTO.OrderSummary;
import com.java.DTO.UserDTO;

public class OrderDAO {

	private final String DRIVER = MenuDAO.getDriver();
	private final String URL = MenuDAO.getUrl();
	private final String USER = MenuDAO.getUser();
	private final String PW = MenuDAO.getPw();

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	static private OrderDAO instance = new OrderDAO();

	public static OrderDAO getInstance() {
		return instance;
	}

	public OrderDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int getLastSeq() {
		String sql = "SELECT autoSeq FROM orderdetail ORDER BY autoSeq DESC LIMIT 1";

		int lastNum = 0;

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				lastNum = rs.getInt("autoSeq");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return lastNum;
	}

	public int insertOrder(OrderDTO order) {
		System.out.println("insertOrder");
		String query = "INSERT INTO `kurly`.`orderdetail` (`orderNo`, `orderDate`, `itemNo`, `itemCnt`, `shippingFee`, `userId`, `orderer`, `phone`, `email`, `address`, `finalArrival` ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		int check = -1;
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, order.getOrderNo());
			pstmt.setString(2, order.getOrderDate());
			pstmt.setString(3, order.getItemNo());
			pstmt.setString(4, order.getItemCnt());
			pstmt.setString(5, order.getShippingFee());
			pstmt.setString(6, order.getUserId());
			pstmt.setString(7, order.getOrderer());
			pstmt.setString(8, order.getPhone());
			pstmt.setString(9, order.getEmail());
			pstmt.setString(10, order.getAddress());
			pstmt.setString(11, order.getFinalArrival());
			pstmt.executeUpdate();
			check = 1;
			System.out.println(check);

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return check;
	}
	
	public List<String> getOrderNo(String userId){
		
		String query = "select distinct orderNo from orderdetail where userId=?";
		List<String> arr = new ArrayList<>();

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				arr.add(rs.getString("orderNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return arr;
	}

	
	
	
	public List<OrderDTO> getOrders(String id) {
		String query = "select * from orderdetail where userId=?";
		List<OrderDTO> arr = new ArrayList<>();

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String orderNo = rs.getString("orderNo");
				String orderDate = rs.getString("orderDate");
				String itemNo = rs.getString("itemNo");
				String itemCnt = rs.getString("itemCnt");
				String shippingFee = rs.getString("shippingFee");
				String userId = rs.getString("userId");
				String orderer = rs.getString("orderer");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String finalArrival = rs.getString("finalArrival");

				OrderDTO orderDetail = new OrderDTO(orderNo, orderDate, itemNo, itemCnt, shippingFee, userId, orderer,
						phone, email, address, finalArrival);
				arr.add(orderDetail);
				// System.out.println(orderDetail.getOrderNo());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return arr;
	}

	public List<OrderDTO> getOrdDetailByOrdNo(String ordNo) {
		String query = "select * from orderdetail where orderNo=?";
		
		List<OrderDTO> arr = new ArrayList<>();

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ordNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String orderNo = rs.getString("orderNo");
				String orderDate = rs.getString("orderDate");
				String itemNo = rs.getString("itemNo");
				String itemCnt = rs.getString("itemCnt");
				String shippingFee = rs.getString("shippingFee");
				String userId = rs.getString("userId");
				String orderer = rs.getString("orderer");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String finalArrival = rs.getString("finalArrival");

				OrderDTO orderDetail = new OrderDTO(orderNo, orderDate, itemNo, itemCnt, shippingFee, userId, orderer,
						phone, email, address, finalArrival);
				arr.add(orderDetail);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return arr;
	}
	
	public List<OrderListDTO> sortOrderDetail(List<OrderDTO> arr) { // userId가 1234인 주문내역 다 가져옴
		
		List<OrderListDTO> list = new ArrayList<>(); // 분류해서 담을 배열,

		for (int i = 0; i < arr.size(); i++) { // 전체 주문내역 하나씩 꺼내서
			String orderNo = arr.get(i).getOrderNo(); // 주문번호를 담는다

			if (list.size() == 0) { // 분류작업이 처음일 때,

				List<OrderDTO> order = new ArrayList<>(); // 같은 주문번호끼리 담을 배열
				order.add(arr.get(i)); // 추가

				OrderListDTO temp = new OrderListDTO(orderNo, order);
				list.add(temp);

			} else if (list.size() > 0) {// 분류작업이 처음이 아닐때
				int idx = -1;
				for (int j = 0; j < list.size(); j++) {
					if (orderNo.equals(list.get(j).getOrderNo())) { // 같은 주문번호 있나 확인
						idx = j; // 있으면 인덱스 담기
						break;
					}
				}
				if (idx != -1) { // 같은 주문번호가 있으면
					list.get(idx).getOrderList().add(arr.get(i));
				} else if (idx == -1) { // 같은 주문번호가 없으면

					List<OrderDTO> order = new ArrayList<>(); // 같은 주문번호끼리 담을 배열
					order.add(arr.get(i)); // 추가

					OrderListDTO temp = new OrderListDTO(orderNo, order);
					list.add(temp);
				}
			}
		}
		
		return list;
	}

	public List<OrderSummary> getOrderSummaryList(List<OrderListDTO> list){
		
		ItemDAO itemDAO=ItemDAO.getInstance();
		List<OrderSummary> orderSummaryList=new ArrayList<>();
	
		for (int i = 0; i < list.size(); i++) {
			String date ="";
			String orderNo ="";
			int cnt=0;
			String itemName="";
			String fileName="";
			int total=0;
			
			orderNo = list.get(i).getOrderNo(); //주문번호
			
			List<OrderDTO> temp = list.get(i).getOrderList();
			cnt=temp.size()-1; //주문상품 개수-1(첫번쨰상품)
			for (int j = 0; j < temp.size(); j++) {
				
				date = temp.get(j).getOrderDate(); //날짜
				String itemNo= temp.get(j).getItemNo(); //상품번호
				ItemDTO item=itemDAO.getItem(itemNo);
			
				int pdtCnt=Integer.parseInt(temp.get(j).getItemCnt());
				pdtCnt=pdtCnt*1000;
				total+=pdtCnt; //전체가격
				
				if(j==0) {
					itemName=item.getItemName(); //상품명
					fileName=item.getFilename(); //상품이미지
					String shipping=temp.get(j).getShippingFee();
					if(shipping.equals("C")) { //charging
						total+=3000; //배송비 있을 때 3000원 추가
					}
				}
			}
			OrderSummary os=new OrderSummary(date,orderNo,cnt,itemName,fileName,total);
			orderSummaryList.add(os);
		}
		return orderSummaryList;
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
