package com.lcomputerstudy.testmvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lcomputerstudy.testmvc.service.BoardService;
import com.lcomputerstudy.testmvc.vo.Board;



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

		BoardService boardService = null;
		Board board = null;
		
		command = checkSession(request, response, command);
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		switch (command) {
			case "/board-list.do":
				boardService = new BoardService();
				view = "board/list";
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
				view = "";
				
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