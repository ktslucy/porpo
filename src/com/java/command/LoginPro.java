package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.UserDAO;

public class LoginPro implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
	
		UserDAO userDAO=UserDAO.getInstance();
		int check=userDAO.login(id, pw);
	
		request.setAttribute("check", check);
		request.setAttribute("id", id);
		
		return "loginOK.jsp";
	}
}
