package com.goldrush.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.http.HttpHeaders;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.util.FileCopyUtils;

import com.goldrush.dto.ItemDTO;
import com.goldrush.dto.MemberDTO;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.dto.test;
import com.goldrush.dto.accountDto.ResponseToken2legger;
import com.goldrush.service.ItemService;
import com.goldrush.service.MemberService;
import com.goldrush.service.accountService.AccountService;
import com.goldrush.util.ImgUtils;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.");
		HttpSession session = request.getSession();
		if(session.getAttribute("responseToken2legger")==null) {
			AccountService ser = new AccountService();
			ResponseToken2legger dto = ser.getTokenOAuth2legger();
			session.setAttribute("goldrush_openbanking", dto);
			session.setMaxInactiveInterval(dto.getExpires_in());
		}
		

	
		return "index";
	}
	

//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public String post(@RequestBody test test) {
//		System.out.println(test);
//		
//		
//		return "form";
//	}



	
//	@RequestMapping(value = "/fuck", method = RequestMethod.GET)
//	public String fuck() {
//
//		
//		return "fuck";
//	}
	
	@RequestMapping(value="/god")
	public String  registerItem(MultipartHttpServletRequest request) throws IOException{
		ItemService it = new ItemService();
		it.postPicture("1wer", request);

		return "form";
	}
	
	
}
