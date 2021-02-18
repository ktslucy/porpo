package com.java.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.java.DAO.ItemDAO;
import com.java.DTO.ItemDTO;

public class MdCate implements Command{

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String category=request.getParameter("category");
		ItemDAO itemDAO=ItemDAO.getInstance();
		ArrayList<ItemDTO> mdList=itemDAO.getCateAllItem(category);

		Gson menu = new Gson();
		String list=menu.toJson(mdList);
		System.out.println(list);
		request.setAttribute("mdList", list);
		
		return "mdCate.jsp";
	}

}
