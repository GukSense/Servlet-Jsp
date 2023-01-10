package com.lcomputerstudy.testmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import com.lcomputerstudy.testmvc.database.DBConnection;
import com.lcomputerstudy.testmvc.vo.User;

public class UserDAO {
	
	private static UserDAO dao = null;
	
	private UserDAO() {
		
	}
	
	public static UserDAO getInstance() {
		if(dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}
	
	public ArrayList<User> getUsers(){
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<User> list = null;
			
			try {
				conn = DBConnection.getConnection();
				String query = "select * from user";
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				list = new ArrayList<User>();
				
				while(rs.next()) {
					User user = new User();
					user.setU_idx(rs.getInt("u_idx"));
					user.setU_id(rs.getString("u_id"));
					user.setU_name(rs.getString("u_name"));
					user.setU_tel(rs.getString("u_tel"));
					user.setU_age(rs.getString("u_age"));
					list.add(user);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			return list;
	}
			
	public void insertUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into user(u_id,u_pw,u_name,u_tel,u_age) value(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getU_id());
			pstmt.setString(2, user.getU_pw());
			pstmt.setString(3, user.getU_name());
			pstmt.setString(4, user.getU_tel());
			pstmt.setString(5, user.getU_age());
			pstmt.executeUpdate();					
		} catch(Exception ex) {
			System.out.println("SQLException : " + ex.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public User viewUserDetail(User user) {
		String idx = Integer.toString(user.getU_idx());
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User resultUser = null;
		
		
		try {
			conn = DBConnection.getConnection();
			String query = "select * from user where u_idx =?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, idx);
			
			rs = pstmt.executeQuery();
			 while(rs.next()) {     
				 resultUser = new User();
				 resultUser.setU_idx(Integer.parseInt(rs.getString("u_idx")));
				 resultUser.setU_id(rs.getString("u_id"));
		   	     resultUser.setU_pw(rs.getString("u_pw"));
		         resultUser.setU_name(rs.getString("u_name"));  
		   	     resultUser.setU_tel(rs.getString("u_tel"));
		   	     resultUser.setU_age(rs.getString("u_age"));
			 }

			
		} catch(Exception ex) {
			System.out.println("SQLException : " + ex.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
		return resultUser;
	}
	
	public void EditUsers(User user){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String idx = Integer.toString(user.getU_idx());
		
		try {
			conn = DBConnection.getConnection();
			String query = "update user set u_id=?, u_pw=?,u_name=?,u_tel=?,u_age=? where u_idx=?";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, user.getU_id());
			pstmt.setString(2, user.getU_pw());
			pstmt.setString(3, user.getU_name());
			pstmt.setString(4, user.getU_tel());
			pstmt.setString(5, user.getU_age());
			pstmt.setString(6, idx);
			pstmt.executeUpdate();	
		
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try{
				conn.close();
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void deleteUser(User user) {
		
		String idx = Integer.toString(user.getU_idx());
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String query = "delete from user where u_idx=?";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, idx);
			pstmt.executeUpdate();
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try{
				if(conn != null) {conn.close();}
				if(pstmt != null) {pstmt.close();}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public int getUsersCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			String query = "SELECT COUNT(*) AS count FROM user ";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return count;
	}
	
	public ArrayList<User> getUsers(int page) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<User> list = null;
		
		try {
			String query = "select * from user limit ?,3";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, page);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while (rs.next()) {
				User user = new User();
				user.setU_idx(rs.getInt("u_idx"));
				user.setU_id(rs.getString("u_id"));
				user.setU_name(rs.getString("u_name"));
				user.setU_tel(rs.getString("u_tel"));
				user.setU_age(rs.getString("u_age"));
				list.add(user);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}