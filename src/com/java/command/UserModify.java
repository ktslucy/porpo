package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.UserDAO;
import com.java.DTO.UserDTO;

public class UserModify implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		
		UserDTO user=new UserDTO(id,passwd,name,email,phone,address);
		UserDAO userDAO=UserDAO.getInstance();
		int check=userDAO.updateUser(user);
		
		if(check==-1) {
			return "userModifyForm.jsp";
		}
		
		return "index.jsp";
	}

}
