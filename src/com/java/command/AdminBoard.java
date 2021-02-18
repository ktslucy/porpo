package com.java.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.DAO.BoardDAO;
import com.java.DTO.BoardDTO;

public class AdminBoard implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		/*HttpSession session = request.getSession();
		String userId=(String)session.getAttribute("id");*/
		
		BoardDAO boardDAO=BoardDAO.getInstance();
		List<BoardDTO> list=boardDAO.adminGetBoard();
		request.setAttribute("boardList", list);
		
		return "adminBoard.jsp";
	}

}
