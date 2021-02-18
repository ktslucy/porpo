package com.java.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.ItemDAO;
import com.java.DAO.MenuDAO;
import com.java.DTO.ItemDTO;
import com.java.DTO.MenuDTO;

public class Category implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("category!!");
		String category=request.getParameter("category");
	
		ItemDAO itemDAO=ItemDAO.getInstance();
		ArrayList<ItemDTO> itemList=itemDAO.getCateAllItem(category);
		request.setAttribute("itemList", itemList);

		MenuDAO menuDAO=MenuDAO.getInstance();
		MenuDTO menu=menuDAO.getCate(category);
		request.setAttribute("menu", menu);
		
		return "category.jsp?category="+category;
		
	}

}
