package com.goldrush.service;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.goldrush.dao.AccountDAO;
import com.goldrush.dao.InventoryDAO;
import com.goldrush.dao.MemberDAO;
import com.goldrush.dao.OfferDAO;
import com.goldrush.dao.TradeDAO;
import com.goldrush.dto.AccountDTO;
import com.goldrush.dto.MemberDTO;
import com.goldrush.dto.OfferDTO;
import com.goldrush.dto.OfferLogDTO;
import com.goldrush.dto.PortfolioDTO;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.dto.TradeLogDTO;

public class MemberService {
	private MemberDAO memberDAO;
	private InventoryDAO inventoryDAO;
	private AccountDAO accountDAO;
	private OfferDAO offerDAO;
	private TradeDAO tradeDAO;
	public MemberService() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
		this.inventoryDAO = (InventoryDAO) ctx.getBean("InventoryDAO");
		this.memberDAO = (MemberDAO) ctx.getBean("MemberDAO");
		this.accountDAO = (AccountDAO) ctx.getBean("AccountDAO");
		this.offerDAO = (OfferDAO) ctx.getBean("OfferDAO");
		this.tradeDAO = (TradeDAO) ctx.getBean("TradeDAO");
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
	
	public ResponseDTO signout(int membersId) {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ctx.load("classpath:dao-context.xml");
//		MemberDAO memberDAO = (MemberDAO) ctx.getBean("MemberDAO");
		int result = memberDAO.signout(membersId);
		if(result==1) {
			return new ResponseDTO(1, "회원탈퇴되었습니다..");
		}else {
			return new ResponseDTO(0, "회원탈퇴를 실패했습니다..");
		}
	}
	
	public List<PortfolioDTO> getPortfolio(int membersId) {
		return inventoryDAO.selectPortfolio(membersId);
	}
	public List<AccountDTO> getAccountLog(int membersId){
		return accountDAO.selectAccountLog(membersId);
	}
	
	public List<OfferLogDTO> getOfferLog(int membersId){
		return offerDAO.selectOffersByMembersId(membersId);
	}
	public List<TradeLogDTO> getTradeLog(int membersId){
		return tradeDAO.selectTradeLog(membersId);
	}
}
