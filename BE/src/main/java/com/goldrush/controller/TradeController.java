package com.goldrush.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.goldrush.dto.OfferDTO;
import com.goldrush.dto.OffersListDTO;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.service.TradeService;

/**
 * Handles requests for the application home page.
 */
@RestController
@CrossOrigin
@RequestMapping(value="/trade")
public class TradeController {
	
	private static final Logger logger = LoggerFactory.getLogger(TradeController.class);
	TradeService tradeService = new TradeService();
	/**
	 * Simply selects the home view to render by returning its name.
	 */


	
	@RequestMapping(value = "/offer", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<ResponseDTO> makeOffer(@RequestBody OfferDTO offerDTO ) {
		ResponseDTO response = tradeService.makeOffer(offerDTO);
		if(response.getResult()==1) {
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
		}	
	}
	@RequestMapping(value="/offer", method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<ResponseDTO> deleteOffer(@RequestParam("offersId") int offersId){
		OfferDTO dto = new OfferDTO();
		dto.setOffersId(offersId);
		ResponseDTO response = tradeService.cancelOffer(dto);
		if(response.getResult()==1) {
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value="/offer", method=RequestMethod.GET)
	public @ResponseBody List<OffersListDTO> getOfferList(@RequestParam("itemsId") int itemsId, @RequestParam("buy") boolean buy){
		OfferDTO dto = new OfferDTO();
		dto.setBuy(buy);
		dto.setItemsId(itemsId);
		return tradeService.getOfferList(dto);
	}
	
	
}