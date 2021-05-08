package com.goldrush.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.goldrush.dto.accountDto.RequestToken3legger;
import com.goldrush.dto.accountDto.ResponseOAuth3legger;
import com.goldrush.dto.accountDto.ResponseToken3legger;
import com.goldrush.service.accountService.AccountService;

@Controller
@CrossOrigin
@RequestMapping(value="/bank")
public class AccountController {
	AccountService ser = new AccountService();
	@RequestMapping(value="/oauth")
	public String join() {
		System.out.println("가라 네이버");
		return "redirect:"+ser.OAuth3legged();
		}
	@RequestMapping(value="/auth_second", method=RequestMethod.GET)
	public @ResponseBody ResponseToken3legger test(HttpServletRequest request,@RequestParam("code") String code, @RequestParam("scope") String scope, HttpServletResponse response) {

		RequestToken3legger dto = new RequestToken3legger();
		dto.setCode(code);
		ResponseToken3legger res = ser.getToken3legger(dto);
		HttpSession session = request.getSession();
		session.setAttribute("user_openbanking", res);
		session.setMaxInactiveInterval(res.getExpires_in());			
		return res;

	}
}

