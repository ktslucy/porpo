package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.UserDAO;

public class FindPw implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String email=request.getParameter("email");
		
		UserDAO userDAO=UserDAO.getInstance();
		String pw=userDAO.findPw(name,id,email);
	
		request.setAttribute("pw", pw);
		
		return "findPwPro.jsp";
	}

}
