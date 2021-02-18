package com.java.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.DAO.CartDAO;
import com.java.DAO.OrderDAO;
import com.java.DTO.CartDTO;
import com.java.DTO.OrderDTO;

public class Pay implements Command {

	@Override
	public String excecute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			
		String list = request.getParameter("orderList"); //주문내역,string
		CartDAO cartDAO = CartDAO.getInstance();
		List<CartDTO> orderList = cartDAO.parseCartList(list); //주문내역,배열 -> 상품번호, 상품명, 상품단가, 상품개수
	
		HttpSession session = request.getSession();
		String userId=(String)session.getAttribute("id"); //아이디
		
		String orderDate=request.getParameter("date"); //주문일자, 2020-01-01
	
		String shippingFee = request.getParameter("shippingFee"); //배송비
		System.out.println(shippingFee);
		if(shippingFee.equals("0")) {
			shippingFee="F"; //free
		}else {
			shippingFee="C"; //charging
		}
		
		String orderer = request.getParameter("orderer"); //주문자
		System.out.println("orderer:"+orderer);
		String phone = request.getParameter("phone"); //주문자연락처
		System.out.println("phone:"+phone);
		String email = request.getParameter("email"); //주문자email
		System.out.println("email:"+email);
		String address = request.getParameter("address"); //배송지
		System.out.println("address:"+address);
		String finalArrival = request.getParameter("finalArrival"); //최종배송지(현관앞)
		System.out.println("finalArrival:"+finalArrival);
		
		
		OrderDAO orderDAO=OrderDAO.getInstance();
		int last=orderDAO.getLastSeq();
		last+=1;

		for(int i=0; i<orderList.size(); i++) {
		
			String orderNo=orderDate+"-"+last; //주문번호)구매일자+마지막 시퀀스
			String itemNo=orderList.get(i).getItem().getItemNumber();
			String itemCnt=orderList.get(i).getCnt();
		
			OrderDTO order=new OrderDTO(orderNo,orderDate,itemNo,itemCnt,shippingFee,userId,orderer,phone,email,address,finalArrival);
			int check=orderDAO.insertOrder(order);
			if(check==-1) break;
			request.setAttribute("check", check);
		}

		return "payPro.jsp";
	}
}
