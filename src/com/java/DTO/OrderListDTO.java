package com.java.DTO;

import java.util.List;

public class OrderListDTO {


	String orderNo;
	List<OrderDTO> orderList;
	
	public OrderListDTO(String orderNo, List<OrderDTO> orderList) {
		this.orderNo = orderNo;
		this.orderList = orderList;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	public List<OrderDTO> getOrderList() {
		return orderList;
	}
	
	
}
