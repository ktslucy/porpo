package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.DAO.BoardDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

public class SetBoard implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");	
		HttpSession session = request.getSession();
		
		String brdDate = format.format(date);
		String writer=(String)session.getAttribute("id");
		System.out.println();
		String brdType=request.getParameter("select");
		String title=request.getParameter("subject");
		String orderNo=request.getParameter("ordno");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String contents=request.getParameter("contents");
	

		BoardDAO boardDAO=BoardDAO.getInstance();
		int check=boardDAO.upload(brdDate, writer, brdType, title, orderNo, email, mobile, contents);
		
		if(check==-1) {
			return "index.jsp";
		}

		return "inquiryPro.jsp";
	}

}
