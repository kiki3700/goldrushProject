package com.goldrush.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.goldrush.dto.ItemDTO;
import com.goldrush.dto.ItemListDTO;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.service.ItemService;

@Controller
@CrossOrigin
@RequestMapping(value="/item")
public class ItemController {
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	ItemService ser = new ItemService();
	@RequestMapping(value="/", method = RequestMethod.GET)
	public @ResponseBody List<ItemListDTO> getItemList(){
		return ser.getItemList();
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody List<ItemListDTO> getItemListByStage(@RequestParam("stage") String stage){
		return ser.getItemListByStage(stage);
	}
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public @ResponseBody ItemListDTO getItem(@RequestParam("itemsId") int itemsId){
		return ser.getItem(itemsId);
	}
	
	@RequestMapping(value="/list", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<ResponseDTO> postNewItem(MultipartHttpServletRequest request){
		ItemDTO dto = new ItemDTO();
		dto.setCode(request.getParameter("code"));
		dto.setCategory(request.getParameter("category"));
		dto.setName(request.getParameter("name"));
		dto.setCost(Integer.parseInt(request.getParameter("cost")));
		dto.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		dto.setOpeningDate(Timestamp.valueOf(request.getParameter("openingDate")+" 09:00:00.0"));
		dto.setIpoDate(Timestamp.valueOf(request.getParameter("ipoDate")+" 09:00:00.0"));
		dto.setTradingDate(Timestamp.valueOf(request.getParameter("tradingDate")+" 09:00:00.0"));
		dto.setClearingDate(Timestamp.valueOf(request.getParameter("clearingDate")+" 09:00:00.0"));
		dto.setDescription(request.getParameter("description"));
		String address = ser.postPicture(request.getParameter("code"), request);
		dto.setImgAddress(address);
		ResponseDTO response = ser.postNewItem(dto);
		if(response.getResult()==1) {
			return new ResponseEntity(response, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/list", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<ResponseDTO> putItem(MultipartHttpServletRequest request){
		ItemDTO dto = new ItemDTO();
		dto.setItemsId(Integer.parseInt(request.getParameter("itemsId")));
		dto.setCode(request.getParameter("code"));
		dto.setCategory(request.getParameter("category"));
		dto.setName(request.getParameter("name"));
		dto.setCost(Integer.parseInt(request.getParameter("cost")));
		dto.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		dto.setOpeningDate(Timestamp.valueOf(request.getParameter("openingDate")+" 09:00:00.0"));
		dto.setIpoDate(Timestamp.valueOf(request.getParameter("ipoDate")+" 09:00:00.0"));
		dto.setTradingDate(Timestamp.valueOf(request.getParameter("tradingDate")+" 09:00:00.0"));
		dto.setClearingDate(Timestamp.valueOf(request.getParameter("clearingDate")+" 09:00:00.0"));
		dto.setStage(request.getParameter("stage"));
		dto.setDescription(request.getParameter("description"));
		String address = ser.postPicture(request.getParameter("code"), request);
		dto.setImgAddress(address);
		ResponseDTO response = ser.putItem(dto);
		if(response.getResult()==1) {
			return new ResponseEntity(response, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/list", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<ResponseDTO> deleteItem(MultipartHttpServletRequest request){
		ItemDTO dto = new ItemDTO();
		dto.setItemsId(Integer.parseInt(request.getParameter("itemsId")));
		ResponseDTO response = ser.deleteItem(dto);
		if(response.getResult()==1) {
			return new ResponseEntity(response, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		}
	}
}
