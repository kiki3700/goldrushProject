package com.goldrush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.goldrush.dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO{
	DB db;
	public MemberDAOImpl() {
		
	}

	public DB getDb() {
		return db;
	}

	public void setDb(DB db) {
		this.db = db;
	}

	@Override
	public MemberDTO selectByUserId(String userId) {
		MemberDTO dto = new MemberDTO();
		Statement stmt= null;
		ResultSet rs = null;
		Connection con= null;
		String SQL = "SELECT * FROM members WHERE user_id ='"+userId+"'";
		try {
			 con = db.connect();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			if(rs.next()) {
				int id = rs.getInt("members_id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				dto = new MemberDTO(id, userId,name, password);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }	
		return dto;
	}
	@Override
	public int insertNewMemeber(MemberDTO dto) {
		String SQL = "INSERT INTO members(user_id, name, password) values(?, ?,?)";
		int result=0;
		PreparedStatement pstmt= null;
		Connection con= null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPassword());
			if(pstmt.execute()) result=1;
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }	
		return result;		
	}
	@Override
	public int updatePassword(int membersId, String password) {
		String SQL = "UPDATE members SET password = ? WHERE members_id= ?";
		int result=0;
		PreparedStatement pstmt= null;
		Connection con= null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, password);
			pstmt.setInt(2, membersId);
			if(pstmt.executeUpdate()==1) {
				result=1;
			}else {
				result=0;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }	
		return result;	
	}

	@Override
	public int signout(int membersId) {
		String SQL = "UPDATE members SET user_id = signoutMember WHERE members_id= ?";
		int result=0;
		PreparedStatement pstmt= null;
		Connection con= null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			if(pstmt.executeUpdate()==1) {
				result=1;
			}else {
				result=0;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			result=0;
		}
		if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }	
		return result;	
	}
}

