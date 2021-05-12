package com.goldrush.controller;

import java.lang.annotation.Annotation;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.goldrush.dto.AccountDTO;
import com.goldrush.dto.MemberDTO;
import com.goldrush.dto.OfferLogDTO;
import com.goldrush.dto.PortfolioDTO;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.service.MemberService;


/**
 * Handles requests for the application home page.
 */

@RestController
@CrossOrigin
@RequestMapping(value="/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static MemberService memberService =new MemberService();
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody  ResponseEntity<ResponseDTO> signup(@RequestBody MemberDTO dto) {
		logger.info(dto.getUserId()+"is trying to signup");
		ResponseDTO result=memberService.signup(dto);
//		System.out.println(result);
		if(result.getResult()==1) {
			logger.info("success to signup");
			return new ResponseEntity<ResponseDTO>(result,HttpStatus.ACCEPTED);
		}else {
			logger.info("fail to signup");
			return new ResponseEntity<ResponseDTO>(result,HttpStatus.BAD_REQUEST);
		}
		
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<ResponseDTO> login(@RequestBody MemberDTO dto, HttpServletResponse response) {
		logger.info(dto.getUserId()+"is trying to login");
		ResponseDTO result = memberService.login(dto);
		if(result.getResult()==0) {
			logger.info(result.getMessage());
			return new ResponseEntity<ResponseDTO>(result,HttpStatus.BAD_REQUEST);
		}else {
			logger.info(result.getMessage());
			return new ResponseEntity<ResponseDTO>(result,HttpStatus.ACCEPTED);
		}
	}
	
	//폐기해야할 것
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> logout(HttpServletResponse response){
		Cookie membersIdCookie = new Cookie("memberId",null);
		Cookie nameCookie = new Cookie("name",null);
		membersIdCookie.setMaxAge(0);
		nameCookie.setMaxAge(0);
		response.addCookie(nameCookie);
		response.addCookie(membersIdCookie);
		return new ResponseEntity<String>("로그아웃 되었습니다.",HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<ResponseDTO> changePassword(@RequestBody MemberDTO memberDTO){
		logger.info(memberDTO.getUserId()+"is trying to change pw");
		int membersId = memberDTO.getMembersId();
		String newPassword = memberDTO.getPassword();
		ResponseDTO response = memberService.changePassword(membersId, newPassword);
		
		if(response.getResult()==1) {
			logger.info("password change is sucess");
			return new ResponseEntity<ResponseDTO>(response,HttpStatus.ACCEPTED);
		}else {
			logger.info("password change is fail");
			return new ResponseEntity<ResponseDTO>(response,HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/portfolio", method = RequestMethod.GET)
	public @ResponseBody List<PortfolioDTO> getPortfolio(@RequestParam("membersId") int membersId ){
		logger.info(membersId+"looks up portfolio");
		return memberService.getPortfolio(membersId);
	}
	@RequestMapping(value = "/offer", method = RequestMethod.GET)
	public @ResponseBody List<OfferLogDTO> getOfferLog(@RequestParam("membersId") int membersId ){
		logger.info(membersId+"th member looks up offerLog");
		return memberService.getOfferLog(membersId);
	}
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public @ResponseBody List<AccountDTO> getAccountLog(@RequestParam("membersId") int membersId ){
		logger.info(membersId+"looks up accountLog");
		return memberService.getAccountLog(membersId);
	}
}
