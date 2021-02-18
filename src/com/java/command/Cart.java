package com.java.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.CartDAO;
import com.java.DTO.CartDTO;

public class Cart implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String cartList = request.getParameter("cartList");
		if(cartList!="") {
			CartDAO cartDAO = CartDAO.getInstance();
			List<CartDTO> list = cartDAO.parseCartList(cartList);
			request.setAttribute("cartList", list);
		}
		
		return "cartList.jsp";
	}
}
