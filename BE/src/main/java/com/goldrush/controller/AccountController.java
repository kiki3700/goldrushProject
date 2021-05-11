package com.goldrush.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.dto.accountDto.LookupResList;
import com.goldrush.dto.accountDto.RequestToken3legger;
import com.goldrush.dto.accountDto.ResponseLookupInfo;
import com.goldrush.dto.accountDto.ResponseOAuth3legger;
import com.goldrush.dto.accountDto.ResponseToken3legger;
import com.goldrush.dto.accountDto.ResponseWithdraw;
import com.goldrush.service.AccountService;

@Controller
@CrossOrigin
@RequestMapping(value="/bank")
public class AccountController {
	AccountService ser = new AccountService();
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@RequestMapping(value="/oauth")
	public RedirectView oauth1(@CookieValue(name="open-banking") String banking, @CookieValue(name="membersId") int membersId, @CookieValue(name="amount") int amount, @CookieValue(name="withdraw") boolean withdraw, RedirectAttributes attributes) {
		logger.info(membersId+"th is trying to Oaut");
		if(ser.checkWithdrawCondition(withdraw, membersId, amount)) return new RedirectView("/bank/noEnoughMoney");
	          attributes.addAttribute("Access-Control-Allow-Origin", "*");
	          return new RedirectView(ser.OAuth3legged());
		}
	
	@RequestMapping(value="/noEnoughMoney")
	public String noMoney() {
		logger.info("OAuth is fail because of account balance");
		return "redirect:http://192.168.1.70:8080/#userInfo?result=false";
		}
	
	@RequestMapping(value="/auth_second", method=RequestMethod.GET)
	public String oauth2(@CookieValue(name="withdraw") boolean withdraw, HttpServletRequest request,@RequestParam("code") String code, @RequestParam("scope") String scope, HttpServletResponse response) {
		logger.info("token is try to release");
		RequestToken3legger dto = new RequestToken3legger();
		dto.setCode(code);
		ResponseToken3legger token = ser.getToken3legger(dto);
		ResponseLookupInfo information = ser.getUserInfo(token);
		String cookieString;
		try {
			cookieString = ser.makeCookieString(token, information);
			System.out.println(cookieString);
			Cookie cookie = new Cookie("open-banking",URLEncoder.encode(cookieString,"UTF-8"));
			cookie.setMaxAge(token.getExpires_in());
			response.addCookie(cookie);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(withdraw) return "redirect:/bank/withdraw";
		return "redirect:/bank/deposit";
	}
	@RequestMapping(value="withdraw")
	public String withdraw(@CookieValue(name="open-banking") String banking,
			@CookieValue(name="amount") int amount, @CookieValue(name="membersId") int membersId) {
		logger.info(membersId+"th member trying to withdraw");
		try {
			ser.withdraw(banking, amount, membersId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("withdraw is failed");
			return "redirect:http://192.168.1.70:8080/#userInfo?result=false";
		}
		logger.info("withdraw is success");
		return "redirect:http://192.168.1.70:8080/#userInfo?result=true";
	}
	@RequestMapping(value="deposit")
	public String deposit(HttpServletRequest request,@CookieValue(name="open-banking") String banking,
			@CookieValue(name="amount") int amount, @CookieValue(name="membersId") int membersId){
		logger.info(membersId+"th member is trying to deposit");
		try {
			System.out.println(banking);
			ser.deposit(request, banking, membersId, amount);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("deposit is failed");
			return "redirect:http://192.168.1.70:8080/#userInfo?result=false";
		}
		logger.info("deposit is success");
		return  "redirect:http://192.168.1.70:8080/#userInfo?result=true";
	}
}

