package com.java.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.ItemDAO;
import com.java.DAO.MenuDAO;
import com.java.DTO.ItemDTO;
import com.java.DTO.MenuDTO;

public class Main implements Command{
	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//gnb 메뉴 가져오기
		MenuDAO menuDAO=MenuDAO.getInstance();
		ArrayList<MenuDTO> menuList=menuDAO.getAllCate();
		request.setAttribute("menuList", menuList);
		
		//첫번째 카테고리 상품 8개 가져오기
		ItemDAO itemDAO=ItemDAO.getInstance();
		ArrayList<ItemDTO> mdList=itemDAO.getCateAllItem("101");
		request.setAttribute("mdList", mdList);
		
		return "main.jsp";
	}
}
