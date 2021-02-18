package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.DAO.UserDAO;
import com.java.DTO.UserDTO;

public class UserModifyForm implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session  = request.getSession();
		String userId = (String)session.getAttribute("id");
		
		UserDAO userDAO=UserDAO.getInstance();
		UserDTO user=userDAO.getUser(userId);
		
		System.out.println(user.getAddress());
		
		request.setAttribute("user", user);
		
		return "userModifyForm.jsp";
	}

	
}
