package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.DAO.UserDAO;
import com.java.DTO.UserDTO;

public class Inquiry implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		String orderNo=request.getParameter("orderNo");
		
		HttpSession session = request.getSession();
		String userId=(String)session.getAttribute("id"); //아이디
		
		UserDAO userDAO=UserDAO.getInstance();
		UserDTO userInfo=userDAO.getUser(userId);
		
		request.setAttribute("userInfo", userInfo);
		request.setAttribute("orderNo", orderNo);
		
		
		return "inquiry.jsp";
	}

}
