package com.lcomputerstudy.testmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lcomputerstudy.testmvc.database.DBConnection;
import com.lcomputerstudy.testmvc.vo.Pagination;
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

	public ArrayList<User> getUsers(Pagination pagination) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<User> list = null;
		int pageNum = pagination.getPageNum();
		
		try {
			conn = DBConnection.getConnection();
			//String query = "select * from user";
			String query = new StringBuilder()
					.append("SELECT 	@ROWNUM := @ROWNUM -1 AS ROWNUM,\n")
					.append("			ta.*\n")
					.append("FROM		user ta\n")
					.append("LEFT JOIN	(SELECT @rownum := (SELECT COUNT(*)-?+1 FROM user ta)) tb ON 1=1\n")
					.append("LIMIT		?, ?\n")
					.toString();
			
			
	       	pstmt = conn.prepareStatement(query);
	       	pstmt.setInt(1, pageNum);
	       	pstmt.setInt(2, pageNum);
	       	pstmt.setInt(3, Pagination.perPage);
	        rs = pstmt.executeQuery();
	        list = new ArrayList<User>();

	        while(rs.next()){     
	        	User user = new User();
       	       	user.setRownum(rs.getInt("ROWNUM"));
	        	user.setU_idx(rs.getInt("u_idx"));
       	       	user.setU_id(rs.getString("u_id"));
       	       	user.setU_name(rs.getString("u_name"));
       	       	user.setU_tel(rs.getString("u_tel"));
       	       	user.setU_age(rs.getString("u_age"));
       	       	list.add(user);
	        }
		} catch (Exception e) {
			
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
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
			String sql = "insert into user(u_id,u_pw,u_name,u_tel,u_age) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getU_id());
			pstmt.setString(2, user.getU_pw());
			pstmt.setString(3, user.getU_name());
			pstmt.setString(4, user.getU_tel());
			pstmt.setString(5, user.getU_age());
			pstmt.executeUpdate();
		} catch( Exception ex) {
			System.out.println("SQLException : "+ex.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	

	}
	public User detailUserInfo(User user) {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		User resultUser = null;
		String idx = Integer.toString(user.getU_idx());
		try {
			conn = DBConnection.getConnection();
			String query = "select * from user where u_idx=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, idx);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				resultUser = new User();
				resultUser.setU_idx(Integer.parseInt(rs.getString("u_idx")));
				resultUser.setU_id(rs.getString("u_id"));
				resultUser.setU_pw(rs.getString("u_pw"));
				resultUser.setU_name(rs.getString("u_name"));
				resultUser.setU_tel(rs.getString("u_tel"));
				resultUser.setU_age(rs.getString("u_age"));
				
				
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(rs != null) {
					rs.close();
				}				
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
				
		}
		return resultUser;
	}
	
	public void editUsers(User user) {
		String idx = Integer.toString(user.getU_idx());
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String query = "update user set u_id=?, u_pw=?, u_name=?, u_tel=?, u_age=? where u_idx=?";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, user.getU_id() );
			pstmt.setString(2, user.getU_pw() );
			pstmt.setString(3, user.getU_name());
			pstmt.setString(4, user.getU_tel());
			pstmt.setString(5, user.getU_age());
			pstmt.setString(6, idx);
			pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void deleteUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String idx = Integer.toString(user.getU_idx());
		
		try {
			String query = "delete from user where u_idx=?";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, idx);
			pstmt.executeUpdate();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			
		}
		
	}
	
	public int getUserCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			String query = "SELECT COUNT(*) AS COUNT FROM user";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(conn != null) {conn.close();}
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
		
		return count;
	}


}
