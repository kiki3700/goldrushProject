package com.goldrush.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.dto.accountDto.LookupResList;
import com.goldrush.dto.accountDto.RequestToken3legger;
import com.goldrush.dto.accountDto.ResponseLookupInfo;
import com.goldrush.dto.accountDto.ResponseOAuth3legger;
import com.goldrush.dto.accountDto.ResponseToken3legger;
import com.goldrush.dto.accountDto.ResponseWithdraw;
import com.goldrush.service.accountService.AccountService;

@Controller
@CrossOrigin
@RequestMapping(value="/bank")
public class AccountController {
	AccountService ser = new AccountService();
	@RequestMapping(value="/oauth")
	public String oauth1(@CookieValue(name="membersId") int membersId, @CookieValue(name="amount") int amount, @CookieValue(name="withdraw") boolean withdraw) {
		ser.checkWithdrawCondition(withdraw, membersId, amount);
		return "redirect:"+ser.OAuth3legged();
		}
	@RequestMapping(value="/auth_second", method=RequestMethod.GET)
	public String oauth2(@CookieValue(name="withdraw") boolean withdraw, HttpServletRequest request,@RequestParam("code") String code, @RequestParam("scope") String scope, HttpServletResponse response) {

		RequestToken3legger dto = new RequestToken3legger();
		dto.setCode(code);
		ResponseToken3legger token = ser.getToken3legger(dto);
		ResponseLookupInfo information = ser.getUserInfo(token);
		String cookieString;
		try {
			cookieString = ser.makeCookieString(token, information);
			Cookie cookie = new Cookie("open-banking",cookieString);
			cookie.setMaxAge(token.getExpires_in());
			response.addCookie(cookie);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(withdraw) return "withdraw";
		return "deposit";
	}
	@RequestMapping(value="withdraw")
	public @ResponseBody ResponseEntity<String> withdraw(@CookieValue(name="open-banking") String banking,
			@CookieValue(name="amount") int amount, @CookieValue(name="membersId") int membersId) {
		try {
			ser.withdraw(banking, amount, membersId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity("fase",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("success",HttpStatus.ACCEPTED);
	}
	
}

