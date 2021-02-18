package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.UserDAO;

public class FindId implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		UserDAO userDAO=UserDAO.getInstance();
		String id=userDAO.findId(name,email);
	
		request.setAttribute("id", id);
		
		return "findIdPro.jsp";
	}

}
