package com.lcomputerstudy.testmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lcomputerstudy.testmvc.database.DBConnection;
import com.lcomputerstudy.testmvc.vo.Board;

public class BoardDAO {
	private static BoardDAO dao = null;
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	public ArrayList<Board> getBoardList() {
		ArrayList<Board> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String query = "select b_title,b_content,DATE_FORMAT(b_date,'%Y-%m-%d') AS b_date from board";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rs.next()) {
				Board board = new Board();
				board.setB_idx(rs.getInt("b_idx"));
				board.setTitle(rs.getString("b_title"));
				board.setContent(rs.getString("b_content"));
				board.setDate(rs.getString("b_date"));
				list.add(board);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(conn != null) {conn.close();}
				if(pstmt != null) {pstmt.close();}
				if(rs != null) {rs.close();}
			} catch(SQLException e) {
				e.printStackTrace();
			} 
		}
		
		return list; 
	}
	
	
	
	public void writingRegiStraion(Board board) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String query = "insert into board(b_title,b_content,b_date) values(?,?,NOW())";
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
	public void getDate() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String query = new StringBuilder()
					.append("SELECT		\n")
					.append("		CASE WHEN date > TO_CHAR(SYSDATE,'YYYY-MM-DD') THEN	TO CHAR(date,'HH')\n")
					.append("		ELSE \n")
					.append("		END	")
					.append("")
.
		} 
	}

}