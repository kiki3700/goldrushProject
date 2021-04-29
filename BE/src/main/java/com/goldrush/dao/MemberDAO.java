package com.goldrush.dao;

import com.goldrush.dto.MemberDTO;

public interface MemberDAO {


	
	MemberDTO selectByUserId(String userId);

	int insertNewMemeber(MemberDTO dto);

	int updatePassword(int membersId, String password);

	int signOut(String userId);

}
