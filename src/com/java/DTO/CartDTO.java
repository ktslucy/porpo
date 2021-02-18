package com.java.DTO;

public class CartDTO {
	private ItemDTO item;
	private String cnt;
	
	public CartDTO(ItemDTO item, String cnt) {
		this.item = item;
		this.cnt = cnt;
	}

	public ItemDTO getItem() {
		return item;
	}

	public String getCnt() {
		return cnt;
	}
	
}
