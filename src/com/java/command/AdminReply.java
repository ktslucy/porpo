package com.java.command;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.BoardDAO;
import com.java.DTO.BoardDTO;

public class AdminReply implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		String brdDate = format.format(date);
		//날짜랑 refstep+1
		String brdNo=request.getParameter("brdNo");
		String ordNo=request.getParameter("ordNo");
		String comment=request.getParameter("contents");
		
		System.out.println(brdDate);
		System.out.println(brdNo);
		System.out.println(ordNo);
		System.out.println(comment);
		
		BoardDAO boardDAO=BoardDAO.getInstance();
		BoardDTO brd=boardDAO.getBoardDetail(brdNo);
		
		int check=boardDAO.writeComment(brd, comment, brdDate);
		if(check==1) {
			boardDAO.updateCmt(brdNo, ordNo);
		}
		
		request.setAttribute("check", check);
		System.out.println("check:"+check);
	
		return "adminBoardDetailPro.jsp";
	}

}
