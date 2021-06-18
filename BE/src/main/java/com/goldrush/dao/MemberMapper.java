package com.goldrush.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.goldrush.dto.MemberDTO;

public class MemberMapper implements MemberDAO {
	private SqlSessionFactory factory;
	private SqlSession session;
	private String nameSpace="mapper.memberMapper.";
	public MemberMapper() {
		
	}
	public SqlSessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}
	public SqlSession getSession() {
		return session;
	}
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public MemberDTO selectByUserId(String userId) {
		// TODO Auto-generated method stub
		session= factory.openSession();
		MemberDTO result = session.selectOne(nameSpace+"selectByUserId",userId);
		result.setUserId(userId);
		session.close();
		return result;
	}

	@Override
	public int insertNewMemeber(MemberDTO dto) {
		// TODO Auto-generated method stub
		session = factory.openSession();
		int suc = session.insert(nameSpace+"insertNewMember", dto);
		if(suc>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return suc;
	}

	@Override
	public int updatePassword(int membersId, String password) {
		// TODO Auto-generated method stub
		session = factory.openSession();
		MemberDTO dto= new MemberDTO();
		dto.setMembersId(membersId);
		dto.setPassword(password);
		int suc = session.update(nameSpace+"updatePassword",dto);
		if(suc>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return suc;
	}

	@Override
	public int signout(int membersId) {
		// TODO Auto-generated method stub
		session =factory.openSession();
		int suc =session.update(nameSpace+"signuot",membersId);
		if(suc>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return suc;
	}

}
