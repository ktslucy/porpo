package com.java.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.DAO.CartDAO;
import com.java.DAO.UserDAO;
import com.java.DTO.CartDTO;
import com.java.DTO.UserDTO;

public class Order implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session  = request.getSession();
		String userId = (String)session.getAttribute("id");
		System.out.println("userId:"+userId);
		  
		String cartList = request.getParameter("cartList");
		if(cartList!="") {
			CartDAO cartDAO = CartDAO.getInstance();
			List<CartDTO> list = cartDAO.parseCartList(cartList);
			request.setAttribute("cartList", list);
			
			UserDAO userDAO=UserDAO.getInstance();
			UserDTO user=userDAO.getUser(userId);
			request.setAttribute("user", user);
		}
		return "order.jsp";
	}
}
