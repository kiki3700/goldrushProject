package com.goldrush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.goldrush.dto.MemberDTO;

public class MemberDAO {
	DB db;
	public MemberDAO(DB db) {
		this.db = db;
	}
	
	public MemberDTO selectByUserId(String userId) {
		MemberDTO dto = new MemberDTO();
		
		try {
			Connection con = db.connect();
			String SQL = "SELECT * FROM members WHERE user_id ='"+userId+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			if(rs.next()) {
				int id = rs.getInt("members_id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				dto = new MemberDTO(id, userId,name, password);
				con.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return dto;
	}
	
	public int insertNewMemeber(MemberDTO dto) {
		String SQL = "INSERT INTO members(user_id, name, password) values(?, ?,?)";
		int result=0;
		try {
			Connection con = db.connect();
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, dto.getUsersId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPassword());
			if(pstmt.execute()) result=1;
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;		
	}
	public int updatePassword(String userId, String password) {
		String SQL = "UPDATE members SET password = ? WHERE user_id= ?";
		int result=0;
		try {
			Connection con = db.connect();
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, password);
			pstmt.setString(2, userId);
			if(pstmt.execute()) result=1;
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;	
	}
}

