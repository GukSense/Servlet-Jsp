package com.lcomputerstudy.testmvc.service;

import com.lcomputerstudy.testmvc.dao.BoardDAO;
import com.lcomputerstudy.testmvc.vo.Board;

public class BoardService {
	private static BoardService service = null;
	private static BoardDAO dao = null;
	
	public BoardService() {
		
	}
	
	public static BoardService getInstance() {
		if(service == null) {
			service = new BoardService();
			dao = BoardDAO.getInstance();
		}
		return service;
	}
	
	public Board writingRegiStraion(Board board) {
		return dao.writingRegiStraion(board);
	} 
}