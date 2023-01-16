package com.lcomputerstudy.testmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lcomputerstudy.testmvc.database.DBConnection;
import com.lcomputerstudy.testmvc.vo.Board;

public class BoardDAO {
	private static BoardDAO dao = null;
	
	public BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		if(dao != null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	public void writingRegiStraion(Board board) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String query = "insert into board(b_title,b_content) values(?,?) ";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}