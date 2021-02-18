package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.ItemDAO;
import com.java.DTO.ItemDTO;

public class ItemDetail implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String pdtNumber=request.getParameter("pdtNumber");
		ItemDAO itemDAO=ItemDAO.getInstance();
		ItemDTO item=itemDAO.getItem(pdtNumber);
		request.setAttribute("item", item);
		
		return "itemDetail.jsp";
	}

}
