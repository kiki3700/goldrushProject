package com.goldrush.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goldrush.dto.UserDTO;

@Controller
public class BigFuck {		
	@RequestMapping(value="/dto", method=RequestMethod.GET)
	@ResponseBody
	public UserDTO dto() {
		UserDTO dto = new UserDTO();
		dto.setId("5");
		dto.setName("dodo");
		dto.setToken("tonawa");
		dto.setBalance("9000");
		System.out.println(dto);
		return dto;
	}
}