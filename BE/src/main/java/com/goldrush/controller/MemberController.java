package com.goldrush.controller;

import java.lang.annotation.Annotation;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.goldrush.dto.MemberDTO;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.service.MemberService;


/**
 * Handles requests for the application home page.
 */

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody  ResponseEntity<String> signup(@RequestBody MemberDTO dto) {
		MemberService memberService  = new MemberService();
		ResponseDTO result=memberService.signup(dto);
		ResponseEntity<String> response;
		if(result.getResult()==1) {
			return new ResponseEntity<String>(result.getMessage(),HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>(result.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> login(@RequestBody MemberDTO dto, HttpServletResponse response) {
		MemberService memberService  = new MemberService();
		ResponseDTO result = memberService.login(dto);
		if(result.getResult()==0) {
			return new ResponseEntity<String>(result.getMessage(),HttpStatus.BAD_REQUEST);
		}else {
			MemberDTO dtoFromDb =(MemberDTO) result.getObj(); 
			Cookie membersIdCookie = new Cookie("memberId",Integer.toString(dtoFromDb.getMembersId()));
			Cookie nameCookie = new Cookie("name",dtoFromDb.getName());
			response.addCookie(nameCookie);
			response.addCookie(membersIdCookie);
			return new ResponseEntity<String>(result.getMessage(),HttpStatus.ACCEPTED);
		}
	}
	
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
	public @ResponseBody ResponseEntity<String> changePassword(@CookieValue(value="membersId", required=false) Cookie membersIdCookie
								,@RequestBody String newPassword){
		if(membersIdCookie==null) return new ResponseEntity<String>("로그인을 하지 않았습니다.",HttpStatus.BAD_REQUEST);
		MemberService memberService = new MemberService();
		ResponseDTO response = memberService.changePassword(Integer.parseInt(membersIdCookie.getValue()), newPassword);
		
		if(response.getResult()==1) {
			return new ResponseEntity<String>(response.getMessage(),HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>(response.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
//	@RequestMapping(value = "/fuck", method = RequestMethod.GET)
//	public String fuck() {
//
//		
//		return "fuck";
//	}
	

}
