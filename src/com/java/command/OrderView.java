package com.java.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.DAO.BoardDAO;
import com.java.DAO.CartDAO;
import com.java.DAO.OrderDAO;
import com.java.DTO.BoardDTO;
import com.java.DTO.CartDTO;
import com.java.DTO.OrderDTO;

public class OrderView implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("id");
		
		String ordNo=request.getParameter("ordNo");
		
		
		//배송정보
		BoardDAO boardDAO=BoardDAO.getInstance();
		BoardDTO brd=boardDAO.getOrderView(ordNo, userId);
	
		
		//주문내역안에서 상품 번호 가져와서
		OrderDAO orderDAO=OrderDAO.getInstance();
		List<OrderDTO> ordList=orderDAO.getOrdDetailByOrdNo(ordNo);
		
		List<CartDTO> list=new ArrayList<>();
		
		CartDAO cartDAO=CartDAO.getInstance();
	
		//상품번호에 따른 상품상세정보가져오기
		for(int i=0; i<ordList.size(); i++) {
			CartDTO item=cartDAO.getCartPdt(ordList.get(i).getItemNo(), ordList.get(i).getItemCnt());
			list.add(item);
		}
		
		System.out.println(ordList.size());
		request.setAttribute("ord", ordList.get(0)); //배송정보
		request.setAttribute("list", list); //아이템정보
	
		
		
		
		return "orderView.jsp";
	}

}
