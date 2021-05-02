package com.goldrush.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goldrush.dto.ItemListDTO;
import com.goldrush.service.ItemService;

@Controller
@CrossOrigin
@RequestMapping(value="/item")
public class ItemController {
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public @ResponseBody List<ItemListDTO> getItemList(){
		ItemService ser = new ItemService();
		return ser.getItemList();
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody List<ItemListDTO> getItemListByStage(@RequestParam("stage") String stage){
		ItemService ser = new ItemService();
		return ser.getItemListByStage(stage);
	}
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public @ResponseBody ItemListDTO getItem(@RequestParam("itemsId") int itemsId){
		ItemService ser = new ItemService();
		return ser.getItem(itemsId);
	}
}
