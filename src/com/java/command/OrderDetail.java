package com.java.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.DAO.BoardDAO;
import com.java.DAO.ItemDAO;
import com.java.DAO.OrderDAO;
import com.java.DTO.BoardDTO;
import com.java.DTO.ItemDTO;
import com.java.DTO.OrderDTO;
import com.java.DTO.OrderListDTO;
import com.java.DTO.OrderSummary;

public class OrderDetail implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("id");

		OrderDAO orderDAO = OrderDAO.getInstance();
	/*	List<String> ordNoList=orderDAO.getOrderNo(userId);
		
		List<List<OrderDTO>> allOrdList=new ArrayList<>();
		for(int i=0; i<ordNoList.size();i++) {
			List<OrderDTO> list=orderDAO.getOrdDetailByOrdNo(ordNoList.get(i));
			allOrdList.add(list);
		}
		
		List<OrderSummary> arr=new ArrayList<>();
	
	
		for(int i=0; i<allOrdList.size(); i++) {
			int cnt=allOrdList.get(i).size()-1;
			System.out.println("cnt:"+cnt);
			String date="";
			String ordNo="";
		
			String itemName="";
			String fileName="";
			int total=0;
			
			for(int j=0; j<allOrdList.get(i).size(); j++) {
				if(j==0) {
					date=allOrdList.get(i).get(j).getOrderDate();
					ordNo=allOrdList.get(i).get(j).getOrderNo();
					
					String itemNo=allOrdList.get(i).get(j).getItemNo();
					
					ItemDAO itemDAO=ItemDAO.getInstance();
					ItemDTO item=itemDAO.getItem(itemNo);

					itemName=item.getItemName();
					fileName=item.getFilename();
					String ship=allOrdList.get(i).get(j).getShippingFee();
					if(ship.equals("C")) {
						total+=3000;
					}
				}
			total+=Integer.parseInt(allOrdList.get(i).get(j).getItemCnt())*1000;
			
			
			System.out.println("total:"+total);
		
			}
			
			OrderSummary ords=new OrderSummary(date,ordNo,cnt,itemName,fileName,total);
			arr.add(ords);
		}
		
		request.setAttribute("arr", arr);*/
		
		List<OrderDTO> orderList = orderDAO.getOrders(userId);
		List<OrderListDTO> list = orderDAO.sortOrderDetail(orderList);
		List<OrderSummary> orderSummaryList = orderDAO.getOrderSummaryList(list);
		
		
		BoardDAO boardDAO=BoardDAO.getInstance();
		List<BoardDTO> checkInq=boardDAO.getBoard(userId);
		System.out.println(checkInq.size());
		
		List<String> check=new ArrayList<>(); 
	
		for(int i=0; i<orderSummaryList.size(); i++) {
			String ordNo=orderSummaryList.get(i).getOrderNo();
			boolean exist=false;
			
			for(int j=0; j<checkInq.size(); j++) {
				String ordNoCheck=checkInq.get(j).getOrderNo();
				System.out.println(ordNoCheck);
				if(ordNo.equals(ordNoCheck)) {
					exist=true;
					System.out.println("ordNoCheck"+ordNoCheck);
				}
			}
			if(exist==true) {
				check.add("1");
			}else if(exist==false){
				check.add("-1");
			}
		}
		
		request.setAttribute("orderSummaryList", orderSummaryList);
		request.setAttribute("check", check);
		
		return "orderDetail.jsp";
	}

}
