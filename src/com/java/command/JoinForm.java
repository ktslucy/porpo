package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinForm implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "joinForm.jsp";
	}

}
