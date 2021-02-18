package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.AdminDAO;
import com.java.DAO.UserDAO;

public class AdminPro implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
	
		AdminDAO adminDAO=AdminDAO.getInstance();
		int check=adminDAO.login(id, pw);
		request.setAttribute("check", check);
		request.setAttribute("admin", id);
		
		
		return "adminPro.jsp";
	}

}
