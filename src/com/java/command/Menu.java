package com.java.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.java.DAO.MenuDAO;
import com.java.DTO.MenuDTO;

public class Menu implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		System.out.println("menu.do");
		MenuDAO menuDAO=MenuDAO.getInstance();
		ArrayList<MenuDTO> menuList=menuDAO.getAllCate();
		
		Gson menu = new Gson();
		String list=menu.toJson(menuList);
		request.setAttribute("list", list);
		 
		return "menu.jsp";
	}
}
