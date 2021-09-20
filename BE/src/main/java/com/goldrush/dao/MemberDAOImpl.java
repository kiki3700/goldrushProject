package com.goldrush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import com.goldrush.dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO{

	SqlSession session;

	public MemberDAOImpl() {
	}
	
	public SqlSession getSqlSession() {
		return session;
	}
	
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
		

	@Override
	public MemberDTO selectByUserId(String userId) {
		MemberDTO dto = session.selectOne("mapper.memberMapper.selectByUserId", userId);
		return dto;
	}
	@Override
	public int insertNewMemeber(MemberDTO dto) {
		int result= session.insert("mapper.memberMapper.insertNewMember", dto);
		return result;		
	}
	@Override
	public int updatePassword(int membersId, String password) {
		String SQL = "UPDATE members SET password = ? WHERE members_id= ?";
		int result=session.insert("mapper.memberMapper.updatePassword",password);
//		try {
//			con = db.connect();
//			pstmt = con.prepareStatement(SQL);
//			pstmt.setString(1, password);
//			pstmt.setInt(2, membersId);
//			if(pstmt.executeUpdate()==1) {
//				result=1;
//			}else {
//				result=0;
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		if (con != null) {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }	
		return result;	
	}

	@Override
	public int signout(int membersId) {
		String SQL = "UPDATE members SET user_id = signoutMember WHERE members_id= ?";
		int result=session.update("mapper.memberMapper.signout",membersId);
//		PreparedStatement pstmt= null;
//		Connection con= null;
//		try {
//			con = db.connect();
//			pstmt = con.prepareStatement(SQL);
//			pstmt.setInt(1, membersId);
//			if(pstmt.executeUpdate()==1) {
//				result=1;
//			}else {
//				result=0;
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//			result=0;
//		}
//		if (con != null) {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }	
		return result;	
	}
}

