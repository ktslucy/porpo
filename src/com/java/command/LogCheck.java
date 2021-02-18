package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogCheck implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		int check=0;
		if(id==null) {
			check=-1; //session에 id 없을 때,
		}else {
			check=0; //session에 id 있을 때,
		}
		
		request.setAttribute("check", check);
		return "logCheckPro.jsp";
	}

}
