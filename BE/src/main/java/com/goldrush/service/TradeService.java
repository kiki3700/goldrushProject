package com.goldrush.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.goldrush.dao.AccountDAO;
import com.goldrush.dao.InventoryDAO;
import com.goldrush.dao.ItemDAO;
import com.goldrush.dao.OfferDAO;
import com.goldrush.dao.TradeDAO;
import com.goldrush.dto.InventoryDTO;
import com.goldrush.dto.ItemDTO;
import com.goldrush.dto.OfferDTO;
import com.goldrush.dto.OffersListDTO;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.dto.TradeDTO;
import com.goldrush.dto.TraderDTO;
@Transactional
public class TradeService {
	OfferDAO offerDAO;
	TradeDAO tradeDAO;
	AccountDAO accountDAO;
	InventoryDAO inventoryDAO;
	ItemDAO itemDAO;
	private static final Logger logger = LoggerFactory.getLogger(TradeService.class);
	public TradeService() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
		this.offerDAO = (OfferDAO) ctx.getBean("OfferDAO");
		this.tradeDAO = (TradeDAO) ctx.getBean("TradeDAO");
		this.accountDAO = (AccountDAO) ctx.getBean("AccountDAO");
		this.inventoryDAO = (InventoryDAO) ctx.getBean("InventoryDAO");
		this.itemDAO = (ItemDAO) ctx.getBean("ItemDAO");
	}
	
	public boolean checkEnoughBalance(int membersId, int price, int quantity) {
		int offeredPrice = offerDAO.checkEnoughBalance(membersId);
		int balance = accountDAO.selectBalacne(membersId);
		int offeringPrice = price*quantity;
		boolean result;
		logger.info("checkBalance: balance : "+balance+", offeredPrice : "+offeredPrice+", offring price: "+offeringPrice);
		if(offeringPrice<=(balance-offeredPrice)) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}
	public boolean checkEnoughQuantity(int membersId, int itemsId, int quantity) {
		int inventoryBalance = inventoryDAO.checkEnoughQuantity(membersId, itemsId);
		int offeredQuantity = offerDAO.checkOfferedQuantity(membersId, itemsId);
		int offeringQuantity = quantity;
		boolean result;
		logger.info("check Quantity = inventoryBalance : "+inventoryBalance+", offeredQuantity : "+offeredQuantity+", offeringQuantity : "+offeringQuantity);
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
			offerCondition = checkEnoughBalance(offerDTO.getMembersId(), offerDTO.getOfferPrice(), offerDTO.getQuantity());
		}else {
			offerCondition = checkEnoughQuantity(offerDTO.getMembersId(), offerDTO.getItemsId(), offerDTO.getQuantity());
		}
		if(!offerCondition) return new ResponseDTO(0, "????????? ???????????? ???????????????.");
		logger.info("offer insert");
		return offerDAO.insertNewOffer(offerDTO);
	}
	
	public ResponseDTO makeSubscription(OfferDTO offerDTO) {
		int subscriptedQuantity = offerDAO.checkQuantityBalance(offerDTO.getItemsId());
		ItemDTO itemDTO = new ItemDTO();
		itemDTO = itemDAO.selectItem(offerDTO.getItemsId());
		int ipoQuantity = itemDTO.getQuantity();
//		System.out.println("?????? : "+ipoQuantity+ " ????????? ?????? : "+subscriptedQuantity + "????????? ????????? ?????? : "+offerDTO.getQuantity());
		if(!(ipoQuantity-subscriptedQuantity-offerDTO.getQuantity()>=0)) return new ResponseDTO(0,"?????? ????????? ?????????????????????.");
		int price = itemDTO.getCost()/itemDTO.getQuantity();
		if(!checkEnoughBalance(offerDTO.getMembersId(),price,offerDTO.getQuantity())) return new ResponseDTO(0, "????????? ???????????????.");
		logger.info("????????? ??????????????????.");
		offerDTO.setOfferPrice(price);
		offerDTO.setBuy(true);
		return makeOffer(offerDTO);
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
		boolean condition;
		if(traderDTO.isBuy()) {
			condition = checkEnoughBalance(traderDTO.getMembersId(),traderDTO.getPrice(),traderDTO.getQuantity());
		}else {
			condition = checkEnoughQuantity(traderDTO.getMembersId(),traderDTO.getItemsId(),traderDTO.getQuantity());
		}
		if(!condition) return new ResponseDTO(0, "????????? ???????????? ???????????????.");
		logger.info("trade condition is satisfied");
		int quantityBalance = traderDTO.getQuantity();
	
		//?????? ??????????????? ?????? 
		while(quantityBalance>0) {
			logger.info("quantity balance : "+quantityBalance);
			OfferDTO offerDTO = offerDAO.selectOfferBytrade(traderDTO);
			logger.info("offer to trade : "+offerDTO);
			int payToQuantity = 0; //?????? ??????
//			if(offerDTO.getQuantity()==0) return new ResponseDTO(1, quantityBalance+"??? ????????? ??????????????????."); // ?????? ???????????? ?????? ??? offer??? 0?????? ????????? ???????????????
			TradeDTO dto = new TradeDTO();
			dto.setMembersId(traderDTO.getMembersId());
			dto.setOffersId(offerDTO.getOffersId());	
			
			
			if(offerDTO.getQuantity()>quantityBalance) {
				logger.info("1th divergence");
				int newQuantity = offerDTO.getQuantity()-quantityBalance;
				offerDTO.setQuantity(quantityBalance);
				payToQuantity = quantityBalance;
				offerDAO.updateOfferByTrade(offerDTO);
				offerDTO.setQuantity(newQuantity);
				offerDAO.insertOffer(offerDTO);
				quantityBalance=0;
				tradeDAO.insertTrade(dto);
				logger.info("trade date insert complete");
				}else {
					logger.info("2th divergence");
					payToQuantity =	 offerDTO.getQuantity();
						offerDAO.updateCompleteOffer(offerDTO);
						tradeDAO.insertTrade(dto);					
						quantityBalance= quantityBalance-offerDTO.getQuantity();
						logger.info("trade date insert complete");
					}
		int amount = payToQuantity*offerDTO.getOfferPrice();
		transferStock(dto, offerDTO, payToQuantity);
		transferCash(dto, offerDTO, amount);
		}
		return new ResponseDTO(1," ????????? ??????????????????.");
	}
	
	public void transferStock(TradeDTO tradeDTO, OfferDTO offerDTO, int payToQuantity) {
		if(!offerDTO.isBuy()) {
			if(offerDTO.getMembersId()!=1) {
				InventoryDTO sellerDTO = new InventoryDTO();
				sellerDTO.setMembersId(offerDTO.getMembersId());
				sellerDTO.setItemsId(offerDTO.getItemsId());
				sellerDTO.setQuantity(-payToQuantity);
				sellerDTO.setPrice(inventoryDAO.selectAvgPrice(offerDTO.getMembersId(), offerDTO.getItemsId()));
				inventoryDAO.insertInventory(sellerDTO);
			}
			InventoryDTO buyerDTO = new InventoryDTO();
			buyerDTO.setMembersId(tradeDTO.getMembersId());
			buyerDTO.setItemsId(offerDTO.getItemsId());
			buyerDTO.setQuantity(payToQuantity);
			buyerDTO.setPrice(offerDTO.getOfferPrice());
			inventoryDAO.insertInventory(buyerDTO);

		}else {
			InventoryDTO buyerDTO = new InventoryDTO();
			buyerDTO.setMembersId(offerDTO.getMembersId());
			buyerDTO.setItemsId(offerDTO.getItemsId());
			buyerDTO.setQuantity(payToQuantity);
			buyerDTO.setPrice(offerDTO.getOfferPrice());
			InventoryDTO sellerDTO = new InventoryDTO();
			sellerDTO.setMembersId(tradeDTO.getMembersId());
			sellerDTO.setItemsId(offerDTO.getItemsId());
			sellerDTO.setQuantity(-payToQuantity);
			sellerDTO.setPrice(inventoryDAO.selectAvgPrice(offerDTO.getMembersId(), offerDTO.getItemsId()));
			inventoryDAO.insertInventory(buyerDTO);
			inventoryDAO.insertInventory(sellerDTO);
		}
	logger.info("transfer stock data insert complete");
	}
	
	
	public void transferCash(TradeDTO tradeDTO, OfferDTO offerDTO, int amount) {
		HashMap<String, Object> map =new HashMap<>();

		if(!offerDTO.isBuy()) {
			if(offerDTO.getMembersId()!=1) {
				map.put("members_id", offerDTO.getMembersId());
				map.put("amount", amount);
				map.put("action", "sell");
			accountDAO.insertResult(map);
			}
			map.put("members_id", tradeDTO.getMembersId());
			map.put("amount", -amount);
			map.put("action", "buy");
			accountDAO.insertResult(map);
		}else {
			map.put("members_id", tradeDTO.getMembersId());
			map.put("amount", amount);
			map.put("action", "sell");
			accountDAO.insertResult(map);
			if(offerDTO.getMembersId()!=1) {
				map.put("members_id", offerDTO.getMembersId());
				map.put("amount", -amount);
				map.put("action", "buy");
			accountDAO.insertResult(map);
			}
		}
		logger.info("transfer stock data insert complete");
	}
	
	
	
	public ResponseDTO initialPublicOffering(int itemsId) {
		List<OfferDTO> offers =offerDAO.selectOffersForIpo(itemsId);
		ItemDTO itemDTO= itemDAO.selectItem(itemsId);
		int quantity = itemDTO.getQuantity();
		int price = itemDTO.getCost()/quantity;
		for(OfferDTO dto : offers) {
			offerDAO.updateCompleteOffer(dto);
			TradeDTO tradeDTO = new TradeDTO();
			tradeDTO.setOffersId(dto.getOffersId());
			tradeDTO.setMembersId(1);
			tradeDAO.insertTrade(tradeDTO);
			InventoryDTO inventoryDTO = new InventoryDTO();
			inventoryDTO.setItemsId(itemsId);
			inventoryDTO.setPrice(dto.getOfferPrice());
			inventoryDTO.setQuantity(dto.getQuantity());
			inventoryDTO.setMembersId(dto.getMembersId());
			inventoryDAO.insertInventory(inventoryDTO);
			HashMap<String, Object> map =new HashMap<>();
			map.put("members_id", dto.getMembersId());
			map.put("amount", -dto.getQuantity()*price);
			map.put("action", "ipo");
			
			accountDAO.insertResult(map);
			quantity -= dto.getQuantity();
			logger.info(dto.getMembersId()+"th members offer is satisfied by ipo");
		}

		if(quantity>0) {
			OfferDTO offerDTO = new OfferDTO();
			offerDTO.setBuy(false);
			offerDTO.setItemsId(itemsId);
			offerDTO.setOfferPrice(price);
			offerDTO.setQuantity(quantity);
			offerDTO.setMembersId(1);
			offerDAO.insertNewOffer(offerDTO);
			InventoryDTO inventoryDTO = new InventoryDTO();
			inventoryDTO.setMembersId(1);
			inventoryDTO.setItemsId(itemsId);
			inventoryDTO.setQuantity(quantity);
			inventoryDTO.setPrice(price);
			inventoryDAO.insertInventory(inventoryDTO);	
			logger.info("admin offers "+quantity+" * "+ itemsId+"th itme.");
		}
		return new ResponseDTO(1, "IPO ??????");
	}
	public ResponseDTO clear(int itemsId, int price) {
		List<InventoryDTO> inventoryList = inventoryDAO.selectItems(itemsId);
		ItemDTO itemDTO = itemDAO.selectItem(itemsId);
		int totalQuantity = itemDTO.getQuantity();
		int returnForMember = price/totalQuantity;
		for(InventoryDTO dto : inventoryList) {

			logger.info(" inventory have to be processed : "+dto);
			OfferDTO offerDTO = new OfferDTO();
			offerDTO.setBuy(false);
			offerDTO.setItemsId(itemsId);
			offerDTO.setComplete(true);
			offerDTO.setOfferPrice(returnForMember);
			offerDTO.setQuantity(dto.getQuantity());
			offerDTO.setMembersId(dto.getMembersId());
			offerDAO.insertOfferForClear(offerDTO);
			OfferDTO insertedOfferDTO = offerDAO.selectOfferForClearing(offerDTO);
			TradeDTO tradeDTO = new TradeDTO();
			tradeDTO.setMembersId(1);
			tradeDTO.setOffersId(insertedOfferDTO.getOffersId());
			tradeDAO.insertTrade(tradeDTO);
			InventoryDTO inventoryDTO = new InventoryDTO();
			inventoryDTO.setItemsId(offerDTO.getItemsId());
			inventoryDTO.setMembersId(offerDTO.getMembersId());
			inventoryDTO.setQuantity(-offerDTO.getQuantity());
			inventoryDTO.setPrice(inventoryDAO.selectAvgPrice(offerDTO.getMembersId(), offerDTO.getItemsId()));
			inventoryDAO.insertInventory(inventoryDTO);
			
			HashMap<String, Object> map =new HashMap<>();
			map.put("members_id", offerDTO.getMembersId());
			map.put("amount", offerDTO.getQuantity()*returnForMember);
			map.put("action", "clear");
			
			accountDAO.insertResult(map);
			logger.info("process complete");
			
		}
		itemDAO.updateStage("close", itemsId);
		logger.info("item is closed");
		return new ResponseDTO(1,"?????? ??????");
	}
	
	
	public void changeStage() {
		List<ItemDTO> listDTO = itemDAO.selectItemList();
		LocalDate currentDate = LocalDate.now();
		for(ItemDTO item : listDTO) {
			switch(item.getStage()) {
			case "unopen":
				if(item.getOpeningDate().toLocalDateTime().toLocalDate().compareTo(currentDate)<=0) {
					logger.info(item.getItemsId()+"th item is open");
					itemDAO.updateStage("open", item.getItemsId());
				}
				break;
			case "open":
				if(item.getIpoDate().toLocalDateTime().toLocalDate().compareTo(currentDate)<=0) {
					logger.info(item.getItemsId()+"th item is trading");
					itemDAO.updateStage("trade", item.getItemsId());
					initialPublicOffering(item.getItemsId());
				}
				break;
			case "trade":
				if(item.getClearingDate().toLocalDateTime().toLocalDate().compareTo(currentDate)<=0) {
					logger.info(item.getItemsId()+"th item is clear");
					offerDAO.deleteOffersForClearing(item.getItemsId());
					itemDAO.updateStage("clear", item.getItemsId());					
				}
				break;
			default: System.out.println("?????? ??????"+item); 
			}
		}
	}
	
}
