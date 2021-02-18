package com.java.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.DAO.BoardDAO;
import com.java.DTO.BoardDTO;

public class AdminBoardDetail implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String ordNo=request.getParameter("ordNo");
		BoardDAO brdDAO=BoardDAO.getInstance();
		List<BoardDTO> brd=brdDAO.printBoardDetail(ordNo);
		
		System.out.println("dsfsdsffs"+brd.size());

		for(int i=0; i<brd.size(); i++) {
			if(brd.get(i).getRestep()==1) {
				request.setAttribute("brd", brd.get(i));
			}
			if(brd.get(i).getRestep()==2) {
				request.setAttribute("cmt", brd.get(i));
			}
		}
		
		return "adminBoardDetail.jsp";
	
	}

}
