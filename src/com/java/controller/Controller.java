package com.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.*;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		String view = null;

		if (url.contains("main.do")) {
			Command command = new Main();
			view = command.excecute(request, response);
		} else if (url.contains("logCheck.do")) {
			Command command = new LogCheck();
			view = command.excecute(request, response);
		} else if (url.contains("login.do")) {
			Command command = new Login();
			view = command.excecute(request, response);
		} else if (url.contains("loginPro.do")) {
			Command command = new LoginPro();
			view = command.excecute(request, response);
		} else if (url.contains("joinForm.do")) {
			Command command = new JoinForm();
			view = command.excecute(request, response);
		} else if (url.contains("join.do")) {
			Command command = new Join();
			view = command.excecute(request, response);
		} else if (url.contains("findIdForm.do")) {
			Command command = new FindIdForm();
			view = command.excecute(request, response);
		} else if (url.contains("findId.do")) {
			Command command = new FindId();
			view = command.excecute(request, response);
		} else if (url.contains("findPwForm.do")) {
			Command command = new FindPwForm();
			view = command.excecute(request, response);
		} else if (url.contains("findPw.do")) {
			Command command = new FindPw();
			view = command.excecute(request, response);
		} else if (url.contains("category.do")) {
			Command command = new Category();
			view = command.excecute(request, response);
		} else if (url.contains("menu.do")) {
			Command command = new Menu();
			view = command.excecute(request, response);
		} else if (url.contains("mdCate.do")) {
			Command command = new MdCate();
			view = command.excecute(request, response);
		} else if (url.contains("itemDetail.do")) {
			Command command = new ItemDetail();
			view = command.excecute(request, response);
		} else if (url.contains("cart.do")) {
			Command command = new Cart();
			view = command.excecute(request, response);
		} else if (url.contains("order.do")) {
			Command command = new Order();
			view = command.excecute(request, response);
		} else if (url.contains("logout.do")) {
			Command command = new Logout();
			view = command.excecute(request, response);
		} else if (url.contains("pay.do")) {
			Command command = new Pay();
			view = command.excecute(request, response);
		} else if (url.contains("orderDetail.do")) {
			Command command = new OrderDetail();
			view = command.excecute(request, response);
		} else if (url.contains("inquiry.do")) {
			Command command = new Inquiry();
			view = command.excecute(request, response);
		} else if (url.contains("setBoard.do")) {
			Command command = new SetBoard();
			view = command.excecute(request, response);
		} else if (url.contains("getBoard.do")) {
			Command command = new LoadBoard();
			view = command.excecute(request, response);
		} else if (url.contains("boardDetail.do")) {
			Command command = new BoardDetail();
			view = command.excecute(request, response);
		} else if (url.contains("admin.do")) {
			Command command = new Admin();
			view = command.excecute(request, response);
		} else if (url.contains("adminPro.do")) {
			Command command = new AdminPro();
			view = command.excecute(request, response);
		} else if (url.contains("adminBoard.do")) {
			Command command = new AdminBoard();
			view = command.excecute(request, response);
		} else if (url.contains("adminBoardDetail.do")) {
			Command command = new AdminBoardDetail();
			view = command.excecute(request, response);
		} else if (url.contains("adminReply.do")) {
			Command command = new AdminReply();
			view = command.excecute(request, response);
		}else if (url.contains("orderView.do")) {
			Command command = new OrderView();
			view = command.excecute(request, response);
		}else if (url.contains("userModifyForm.do")) {
			Command command = new UserModifyForm();
			view = command.excecute(request, response);
		}else if (url.contains("modify.do")) {
			Command command = new UserModify();
			view = command.excecute(request, response);
		}
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher(view);
		dis.forward(request, response);

	}
}
