package com.goldrush.service;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.goldrush.dao.AccountDAO;
import com.goldrush.dao.InventoryDAO;
import com.goldrush.dao.ItemDAO;
import com.goldrush.dao.OfferDAO;
import com.goldrush.dao.TradeDAO;
import com.goldrush.dto.InventoryDTO;
import com.goldrush.dto.OfferDTO;
import com.goldrush.dto.OffersListDTO;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.dto.TradeDTO;
import com.goldrush.dto.TraderDTO;

public class TradeService {
	OfferDAO offerDAO;
	TradeDAO tradeDAO;
	AccountDAO accountDAO;
	InventoryDAO inventoryDAO;
	
	public TradeService() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
		this.offerDAO = (OfferDAO) ctx.getBean("OfferDAO");
		this.tradeDAO = (TradeDAO) ctx.getBean("TradeDAO");
		this.accountDAO = (AccountDAO) ctx.getBean("AccountDAO");
		this.inventoryDAO = (InventoryDAO) ctx.getBean("InventoryDAO");
	}
	
	public boolean checkEnoughBalance(OfferDTO offerDTO) {
		int offeredPrice = offerDAO.checkEnoughBalance(offerDTO);
		System.out.println(offeredPrice);
		int balance = accountDAO.selectBalacne(offerDTO.getMembersId());
		System.out.println(balance);
		int offeringPrice = offerDTO.getOfferPrice()*offerDTO.getQuantity();
		System.out.println(offeringPrice);
		boolean result;
		if(offeringPrice<=(balance-offeredPrice)) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}
	public boolean checkEnoughQuantity(OfferDTO offerDTO) {
		int inventoryBalance = inventoryDAO.checkEnoughQuantity(offerDTO);
		System.out.println(inventoryBalance);
		int offeredQuantity = offerDAO.checkOfferedQuantity(offerDTO);
		System.out.println(offeredQuantity);
		int offeringQuantity = offerDTO.getQuantity();
		System.out.println(offeringQuantity);
		boolean result;
		if(offeringQuantity <=( inventoryBalance - offeredQuantity)) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}
	
	public ResponseDTO makeOffer(OfferDTO offerDTO) {
		boolean offerCondition;
		if(offerDTO.isBuy()) {
			offerCondition = checkEnoughBalance(offerDTO);
		}else {
			offerCondition = checkEnoughQuantity(offerDTO);
		}
		if(!offerCondition) return new ResponseDTO(0, "조건을 충족하지 못했습니다.");
		return offerDAO.insertNewOffer(offerDTO);
	}
	public ResponseDTO cancelOffer(OfferDTO offerDTO){
		offerDTO=offerDAO.selectOffer(offerDTO);
		return offerDAO.deleteOffer(offerDTO);
	}
	
	public List<OffersListDTO> getOfferList(OfferDTO dto){
		if(dto.isBuy()) {
			return offerDAO.selectBuyOfferList(dto);
		}else {
			return offerDAO.selectSellOfferList(dto);
		}
	}
	
	public ResponseDTO trade(TraderDTO traderDTO) {
		System.out.println("트래이드 시작");
		boolean condition;
		OfferDTO offerDTO = new OfferDTO();
		offerDTO.setBuy(traderDTO.isBuy());
		offerDTO.setMembersId(traderDTO.getMembersId());
		offerDTO.setItemsId(traderDTO.getItemsId());
		offerDTO.setOfferPrice(traderDTO.getPrice());
		offerDTO.setQuantity(traderDTO.getQuantity());
		if(traderDTO.isBuy()) {
			condition = checkEnoughBalance(offerDTO);
		}else {
			condition = checkEnoughQuantity(offerDTO);
		}
		if(!condition) return new ResponseDTO(0, "조건을 충족하지 못했습니다.");
		System.out.println("조건 충족");
		int quantityBalance = traderDTO.getQuantity();

		//일단 트레이트만 기록 
		try {
		while(quantityBalance>0) {
			System.out.println("사야될 양"+quantityBalance);
			offerDTO = offerDAO.selectOfferBytrade(traderDTO);
			System.out.println(offerDTO);
			if(offerDTO.getQuantity()==0) return null;
			System.out.println("이번 거래 대상자"+offerDTO);
			TradeDTO dto = new TradeDTO();
			dto.setMembersId(traderDTO.getMembersId());
			dto.setOffersId(offerDTO.getOffersId());	
			int payToQuantity = 0;
			if(offerDTO.getQuantity()>quantityBalance) {
				int newQuantity = offerDTO.getQuantity()-quantityBalance;
				offerDTO.setQuantity(quantityBalance);
				payToQuantity = quantityBalance;
				offerDAO.updateOfferByTrade(offerDTO);
				offerDTO.setQuantity(newQuantity);
				offerDAO.insertOffer(offerDTO);
				quantityBalance=0;
				tradeDAO.insertTrade(dto);
				}else if(offerDTO.getQuantity()==quantityBalance){
					offerDAO.updateCompeleteOffer(offerDTO);
					payToQuantity = quantityBalance;
					quantityBalance=0;
					tradeDAO.insertTrade(dto);
				}else {
					payToQuantity = offerDTO.getQuantity();
					offerDAO.updateCompeleteOffer(offerDTO);
					tradeDAO.insertTrade(dto);
					quantityBalance= quantityBalance-offerDTO.getQuantity();
				}
				System.out.println("거래후 남은양: "+quantityBalance);
				int amount = payToQuantity*offerDTO.getOfferPrice();
				System.out.println("얼마 냐?"+amount);
			if(traderDTO.isBuy()) {
				accountDAO.insertSellResult(offerDTO.getMembersId(), amount);
				System.out.println("입급완료");
				accountDAO.insertBuyResult(dto.getMembersId(),-amount);
				System.out.println("출금완료");
				InventoryDTO buyerDTO = new InventoryDTO();
				
				buyerDTO.setMembersId(dto.getMembersId());
				buyerDTO.setItemsId(offerDTO.getItemsId());
				buyerDTO.setQuantity(payToQuantity);
				buyerDTO.setPrice(offerDTO.getOfferPrice());
				InventoryDTO sellerDTO = new InventoryDTO();
				System.out.println(buyerDTO);
				sellerDTO.setMembersId(offerDTO.getMembersId());
				sellerDTO.setItemsId(offerDTO.getItemsId());
				sellerDTO.setQuantity(-payToQuantity);
				sellerDTO.setPrice(offerDTO.getOfferPrice());
				System.out.println(sellerDTO);
				inventoryDAO.insertInventory(buyerDTO);
				inventoryDAO.insertInventory(sellerDTO);
			}else {
				accountDAO.insertSellResult(dto.getMembersId(), amount);
				accountDAO.insertBuyResult(offerDTO.getMembersId(),-amount);
				InventoryDTO buyerDTO = new InventoryDTO();
				buyerDTO.setMembersId(offerDTO.getMembersId());
				buyerDTO.setItemsId(offerDTO.getItemsId());
				buyerDTO.setQuantity(payToQuantity);
				buyerDTO.setPrice(offerDTO.getOfferPrice());
				InventoryDTO sellerDTO = new InventoryDTO();
				sellerDTO.setMembersId(dto.getMembersId());
				sellerDTO.setItemsId(offerDTO.getItemsId());
				sellerDTO.setQuantity(-payToQuantity);
				sellerDTO.setPrice(offerDTO.getOfferPrice());
				inventoryDAO.insertInventory(buyerDTO);
				inventoryDAO.insertInventory(sellerDTO);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseDTO(1, "거래에 성공했습니다.");
	}		
}
