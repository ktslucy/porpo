package com.java.DTO;

public class BoardDTO {
	
	int brdNo;
	String brdDate;
	String brdType;
	String title;
	String orderNo;
	String writer;
	String email;
	String mobile;
	String contents;
	int ref;
	int restep;
	String cmt;
	
	public BoardDTO(int brdNo, String brdDate, String brdType, String title, String orderNo, String writer,
			String email, String mobile, String contents, int ref, int restep, String cmt) {
	
		this.brdNo = brdNo;
		this.brdDate = brdDate;
		this.brdType = brdType;
		this.title = title;
		this.orderNo = orderNo;
		this.writer = writer;
		this.email = email;
		this.mobile = mobile;
		this.contents = contents;
		this.ref = ref;
		this.restep = restep;
		this.cmt = cmt;
	}
	public int getBrdNo() {
		return brdNo;
	}
	public String getBrdDate() {
		return brdDate;
	}
	public String getBrdType() {
		return brdType;
	}
	public String getTitle() {
		return title;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public String getWriter() {
		return writer;
	}
	public String getEmail() {
		return email;
	}
	public String getMobile() {
		return mobile;
	}
	public String getContents() {
		return contents;
	}
	public int getRef() {
		return ref;
	}
	public int getRestep() {
		return restep;
	}
	public String getCmt() {
		return cmt;
	}
	



}
