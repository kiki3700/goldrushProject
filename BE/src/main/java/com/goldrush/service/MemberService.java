package com.goldrush.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.goldrush.dao.MemberDAO;
import com.goldrush.dao.MemberDAOImpl;
import com.goldrush.dto.MemberDTO;
import com.goldrush.dto.ResponseDTO;

public class MemberService {
	private MemberDAO memberDAO;
	
	public MemberService() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
		this.memberDAO = (MemberDAO) ctx.getBean("MemberDAO");
	}
	
	
	
	public ResponseDTO signup(MemberDTO dto) {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ctx.load("classpath:dao-context.xml");
//		MemberDAO memberDAO = (MemberDAO) ctx.getBean("MemberDAO");
		MemberDTO dtoForCheck = memberDAO.selectByUserId(dto.getUserId());
		if(dtoForCheck.getMembersId()==0) {
		memberDAO.insertNewMemeber(dto);
		return new ResponseDTO(1, "sucess");
		}else{
			return new ResponseDTO(0, "이미 등록된 아이디 입니다..");
		}
	}
	public ResponseDTO login(MemberDTO dto) {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ctx.load("classpath:dao-context.xml");
//		MemberDAO memberDAO = (MemberDAO) ctx.getBean("MemberDAO");
		MemberDTO comparedDto = memberDAO.selectByUserId(dto.getUserId());
		if(comparedDto.getMembersId()==0) return new ResponseDTO(0,"존재하지 않는 아이디 입니다.");
		if(!comparedDto.getPassword().equals(dto.getPassword())) return new ResponseDTO(0, "비밀번호가 틀렸습니다.");
		return new ResponseDTO(1, "로그인 되었습니다.", comparedDto);
	}
	
	public ResponseDTO changePassword(int membersId, String newPassword) {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ctx.load("classpath:dao-context.xml");
//		MemberDAO memberDAO = (MemberDAO) ctx.getBean("MemberDAO");
		int result = memberDAO.updatePassword(membersId, newPassword);
		if(result==1) {
			return new ResponseDTO(1, "비밀번호가 변경되었습니다.");
		}else {
			return new ResponseDTO(0, "비밀번호를 변경할 수 없습니다.다시 시도해 주세요.");
		}
	}
}
