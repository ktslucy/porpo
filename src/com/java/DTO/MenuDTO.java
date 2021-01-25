package com.java.DTO;

public class MenuDTO {
	
	private String menuNum;
	private String menuName;
	private String ico_on;
	private String ico_off;

	public MenuDTO(String menuNum, String menuName, String ico_on, String ico_off) {
		this.menuNum=menuNum;
		this.menuName=menuName;
		this.ico_on=ico_on;
		this.ico_off=ico_off;
	}

	public String getMenuNum() {
		return menuNum;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getIco_on() {
		return ico_on;
	}

	public String getIco_off() {
		return ico_off;
	}
	
}
