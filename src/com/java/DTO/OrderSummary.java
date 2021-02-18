package com.java.DTO;

public class OrderSummary {


	String date;
	String orderNo;
	int cnt;
	String itemName;
	String fileName;
	int total;
	
	public OrderSummary(String date, String orderNo, int cnt, String itemName, String fileName, int total) {
		this.date = date;
		this.orderNo = orderNo;
		this.cnt = cnt;
		this.itemName = itemName;
		this.fileName = fileName;
		this.total = total;
	}
	
	public String getDate() {
		return date;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public int getCnt() {
		return cnt;
	}
	public String getItemName() {
		return itemName;
	}
	public String getFileName() {
		return fileName;
	}
	public int getTotal() {
		return total;
	}
	
	
	
	

	
}
