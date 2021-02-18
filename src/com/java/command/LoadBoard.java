package com.java.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.DAO.BoardDAO;
import com.java.DTO.BoardDTO;

public class LoadBoard implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("id");

		BoardDAO boardDAO = BoardDAO.getInstance();

		// String[] ordNo = boardDAO.getOrderNo(userId);

		List<BoardDTO> brdList = boardDAO.getBoard(userId);
		request.setAttribute("boardList", brdList);
		System.out.println(brdList.size());

		return "board.jsp";
	}
}
