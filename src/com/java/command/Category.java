package com.java.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.ItemDAO;
import com.java.DTO.ItemDTO;

public class Category implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String category=request.getParameter("category");
		System.out.println(category);
		ItemDAO itemDAO=ItemDAO.getInstance();
		ArrayList<ItemDTO> itemList=itemDAO.getItem(category);
		
		
		
		request.setAttribute("itemList", itemList);
		
		return "category.jsp?category="+category;
		
	}

}
