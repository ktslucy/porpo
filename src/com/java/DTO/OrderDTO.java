package com.java.DTO;

public class OrderDTO {
	
	String orderNo;
	String orderDate;
	String itemNo;
	String itemCnt;
	String shippingFee;
	String userId;
	String orderer;
	String phone;
	String email;
	String address;
	String finalArrival;
	
	public OrderDTO(OrderDTO order) {
		this.orderNo = order.getOrderNo();
		this.orderDate = order.getOrderDate();
		this.itemNo = order.getItemNo();
		this.itemCnt = order.getItemCnt();
		this.shippingFee = order.getShippingFee();
		this.userId = order.getUserId();
		this.orderer = order.getOrderer();
		this.phone = order.getPhone();
		this.email = order.getEmail();
		this.address = order.getAddress();
		this.finalArrival = order.getFinalArrival();
	}
	
	public OrderDTO(String orderNo, String orderDate, String itemNo, String itemCnt, String shippingFee, String userId,
			String orderer, String phone, String email, String address, String finalArrival) {

		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.itemNo = itemNo;
		this.itemCnt = itemCnt;
		this.shippingFee = shippingFee;
		this.userId = userId;
		this.orderer = orderer;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.finalArrival = finalArrival;
	}
	
	public String getOrderNo() {
		return orderNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getItemNo() {
		return itemNo;
	}

	public String getItemCnt() {
		return itemCnt;
	}

	public String getShippingFee() {
		return shippingFee;
	}

	public String getUserId() {
		return userId;
	}

	public String getOrderer() {
		return orderer;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getFinalArrival() {
		return finalArrival;
	}



	
	
	
	
	

}