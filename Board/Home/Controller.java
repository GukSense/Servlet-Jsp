package com.lcomputerstudy.testmvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lcomputerstudy.testmvc.service.BoardService;
import com.lcomputerstudy.testmvc.service.UserService;
import com.lcomputerstudy.testmvc.vo.Board;
import com.lcomputerstudy.testmvc.vo.Pagination;
import com.lcomputerstudy.testmvc.vo.User;



@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		String view = null;
		User user = null;
		UserService userService = null;
		
		BoardService boardService = null;
		Board board = null;
		ArrayList<Board> boardList = null;
		int page = 1;
		int count = 0;
		
		String idx = null;
		String pw = null;
		
		HttpSession session = null;
		
		command = checkSession(request, response, command);
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		switch (command) {
			case "/user-list.do":
				String reqPage = request.getParameter("page");
				if(reqPage != null) {
					page = Integer.parseInt(reqPage);
				}
				userService = UserService.getInstance();
				count = userService.getUsersCount();
				Pagination pagination = new Pagination();
				pagination.setPage(page);
				pagination.setCount(count);
				pagination.init();
				ArrayList<User> list = userService.getUsers(pagination);
				
				
				request.setAttribute("list", list);
				request.setAttribute("pagination", pagination);
				
				view = "user/list";
				
				break;
			case "/user-insert.do":
				view = "user/insert";
				break;
			case "/user-insert-process.do":
				user = new User();
				user.setU_id(request.getParameter("id"));
				user.setU_pw(request.getParameter("password"));
				user.setU_name(request.getParameter("name"));
				user.setU_tel(request.getParameter("tel1") + "-" + request.getParameter("tel2") + "-" + request.getParameter("tel3"));
				user.setU_age(request.getParameter("age"));
				
				userService = UserService.getInstance();
				userService.insertUser(user);
				
				view = "user/insert-result";
				break;
			case "/user-detail.do":
				user = new User();
				user.setU_idx(Integer.parseInt(request.getParameter("u_idx")));
				
				userService = UserService.getInstance();
				user = userService.viewUserDetail(user);
				
				view = "user/user-detail";
				request.setAttribute("user", user);
				break;
			case "/user-edit.do":
				user = new User();
				user.setU_idx(Integer.parseInt(request.getParameter("u_idx")));
				userService = UserService.getInstance();
				user = userService.viewUserDetail(user);
				
				view = "user/userEdit";
				
				request.setAttribute("user", user);
				
				break;
			case"/user-edit-process.do":
				user = new User();
				user.setU_idx(Integer.parseInt(request.getParameter("edit_u_idx")));
				user.setU_id(request.getParameter("edit_id"));
				user.setU_pw(request.getParameter("edit_password"));
				user.setU_name(request.getParameter("edit_name"));
				user.setU_tel(request.getParameter("edit_tel1") + "-" + request.getParameter("edit_tel2") + "-" + request.getParameter("edit_tel3"));
				user.setU_age(request.getParameter("age"));
				
				userService = UserService.getInstance();
				userService.editUsers(user);
				view = "user/editProcess";
	
				break;
			case"/user-delete.do":
				user = new User();
				user.setU_idx(Integer.parseInt(request.getParameter("u_idx")));
				
				userService = UserService.getInstance();
				userService.deleteUser(user);
				view = "user/delete";
				break;
			case"/user-login.do":
				view = "user/login";
				break;
			case"/user-login-process.do":
				idx = request.getParameter("login_id");
				pw = request.getParameter("login_password");
				
				userService = UserService.getInstance();
				user = userService.loginUser(idx,pw);
				if(user != null) {
					session = request.getSession();
//					session.setAttribute("u_idx", user.getU_idx());
//					session.setAttribute("u_id", user.getU_id());
//					session.setAttribute("u_pw", user.getU_pw());
//					session.setAttribute("u_name", user.getU_name());
					session.setAttribute("user", user);
					
					view = "user/login-result";					
				} else {
					view = "user/login-fail";				
				}
				break;
			case "/logout.do":
				session = request.getSession();
				session.invalidate();
				view = "user/login";
				break;
			case "/access-denied.do":
				view=  "user/access-denied";
				break;
//	??????????????? ????????? ?????????	---------------------------------------------------------
				
				
			case "/board-list.do":
				boardService = new BoardService();
				boardList = BoardService.getBoardList();
				
				view = "board/list";
				
				request.setAttribute("list", boardList);
				
				break;
			case "/board-registration.do":
				view = "board/registration";
				break;
			case "/board-process.do":
				board = new Board();
				board.setTitle(request.getParameter("board-title"));
				board.setContent(request.getParameter("board-content"));
				boardService = BoardService.getInstance();
				boardService.writingRegiStraion(board);
				boardList = BoardService.getBoardList();
				
				view = "board/list";
				
				request.setAttribute("list", boardList);
				break;
				
				
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(view + ".jsp");
		rd.forward(request, response);
	
	}
	
	String checkSession(HttpServletRequest request, HttpServletResponse response, String command) {
		HttpSession session = request.getSession();
		
		String[] authList = { 
			"/user-list.do",
			"/user-insert.do",
			"/user-insert-process.do",
			"/user-detail.do",
			"/user-edit-process.do",
			"/user-edit.do",
			"/logout.do"	
		};
		for (String item: authList) {
			if (item.equals(command)) {
				if(session.getAttribute("user") == null) {
					command = "/access-denied.do";
				}
			}
		}
		return command;
	}
	
}