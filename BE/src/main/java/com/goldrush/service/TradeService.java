package com.goldrush.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

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

public class TradeService {
	OfferDAO offerDAO;
	TradeDAO tradeDAO;
	AccountDAO accountDAO;
	InventoryDAO inventoryDAO;
	ItemDAO itemDAO;
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
		System.out.println(offeredPrice);
		int balance = accountDAO.selectBalacne(membersId);
		System.out.println(balance);
		int offeringPrice = price*quantity;
		System.out.println(offeringPrice);
		boolean result;
		if(offeringPrice<=(balance-offeredPrice)) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}
	public boolean checkEnoughQuantity(int membersId, int itemsId, int quantity) {
		int inventoryBalance = inventoryDAO.checkEnoughQuantity(membersId, itemsId);
		System.out.println(inventoryBalance);
		int offeredQuantity = offerDAO.checkOfferedQuantity(membersId, itemsId);
		System.out.println(offeredQuantity);
		int offeringQuantity = quantity;
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
			offerCondition = checkEnoughBalance(offerDTO.getMembersId(), offerDTO.getOfferPrice(), offerDTO.getQuantity());
		}else {
			offerCondition = checkEnoughQuantity(offerDTO.getMembersId(), offerDTO.getItemsId(), offerDTO.getQuantity());
		}
		if(!offerCondition) return new ResponseDTO(0, "조건을 충족하지 못했습니다.");
		return offerDAO.insertNewOffer(offerDTO);
	}
	
	public ResponseDTO makeSubscription(OfferDTO offerDTO) {
		int subscriptedQuantity = offerDAO.checkQuantityBalance(offerDTO.getItemsId());
		ItemDTO itemDTO = new ItemDTO();
		itemDTO = itemDAO.selectItem(offerDTO.getItemsId());
		int ipoQuantity = itemDTO.getQuantity();
		System.out.println("물량 : "+ipoQuantity+ " 소진된 물량 : "+subscriptedQuantity + "이번에 소진할 물량 : "+offerDTO.getQuantity());
		if(!(ipoQuantity-subscriptedQuantity-offerDTO.getQuantity()>=0)) return new ResponseDTO(0,"청약 물량이 소진되었습니다.");
		int price = itemDTO.getCost()/itemDTO.getQuantity();
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
		System.out.println("트레이드 시작");
		System.out.println(traderDTO);
		boolean condition;
		if(traderDTO.isBuy()) {
			condition = checkEnoughBalance(traderDTO.getMembersId(),traderDTO.getPrice(),traderDTO.getQuantity());
		}else {
			condition = checkEnoughQuantity(traderDTO.getMembersId(),traderDTO.getItemsId(),traderDTO.getQuantity());
		}
		if(!condition) return new ResponseDTO(0, "조건을 충족하지 못했습니다.");
		System.out.println("조건 충족");
		int quantityBalance = traderDTO.getQuantity();
	
		//일단 트레이트만 기록 
		while(quantityBalance>0) {
			int totalAmount=0;
			System.out.println("사야될 양"+quantityBalance);
			OfferDTO offerDTO = offerDAO.selectOfferBytrade(traderDTO);
			System.out.println(offerDTO);
			if(offerDTO.getQuantity()==0) return new ResponseDTO(1, totalAmount+"주 거래에 성공했습니다.");
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
					payToQuantity = quantityBalance;
					quantityBalance=0;
					System.out.println(offerDAO.updateCompeleteOffer(offerDTO));
					System.out.println(tradeDAO.insertTrade(dto));
					
			}else {
				payToQuantity =	 offerDTO.getQuantity();
					System.out.println(offerDAO.updateCompeleteOffer(offerDTO));
					System.out.println(tradeDAO.insertTrade(dto));					
					quantityBalance= quantityBalance-offerDTO.getQuantity();
				}
				totalAmount+=payToQuantity;
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
		return new ResponseDTO(1," 거래에 성공했습니다.");
	}
	
	public ResponseDTO initialPublicOffering(int itemsId) {
		List<OfferDTO> offers =offerDAO.selectOffersForIpo(itemsId);
		ItemDTO itemDTO= itemDAO.selectItem(itemsId);
		int quantity = itemDTO.getQuantity();
		int price = itemDTO.getCost()/quantity;
		for(OfferDTO dto : offers) {
			int i =1;
			System.out.println(i+"th ipo");
			System.out.println(dto);
			TradeDTO tradeDTO = new TradeDTO();
			tradeDTO.setOffersId(dto.getOffersId());
			tradeDTO.setMembersId(1);
			System.out.println(tradeDAO.insertTrade(tradeDTO));
			System.out.println(accountDAO.insertIpoResult(dto.getItemsId(), -dto.getQuantity()*dto.getOfferPrice()));
			InventoryDTO inventoryDTO = new InventoryDTO();
			inventoryDTO.setItemsId(itemsId);
			inventoryDTO.setPrice(dto.getOfferPrice());
			inventoryDTO.setQuantity(dto.getQuantity());
			inventoryDTO.setMembersId(dto.getMembersId());
			System.out.println(inventoryDAO.insertInventory(inventoryDTO));
			quantity -= dto.getQuantity();
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
		}
		return new ResponseDTO(1, "IPO 완료");
	}
	public ResponseDTO clearing(int itemsId, int price) {
		offerDAO.deleteOffersForClearing(itemsId);
		List<InventoryDTO> listdto = inventoryDAO.selectItems(itemsId);
		for(InventoryDTO dto : listdto) {
			OfferDTO offerDTO = new OfferDTO();
			offerDTO.setBuy(false);
			offerDTO.setItemsId(itemsId);
			offerDTO.setComplete(true);
			offerDTO.setOfferPrice(price);
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
			inventoryDAO.insertInventory(inventoryDTO);
			accountDAO.insertClearingResult(offerDTO.getItemsId(), offerDTO.getQuantity()*price);
		}
		return new ResponseDTO(1,"청산 완료");
	}
	
	public void changeStage() {
		List<ItemDTO> listDTO = itemDAO.selectItemList();
		LocalDate currentDate = LocalDate.now();
		for(ItemDTO item : listDTO) {
			System.out.println("before"+item);
			switch(item.getStage()) {
			case "unopen":
				if(item.getOpeningDate().toLocalDateTime().toLocalDate().compareTo(currentDate)>=0) {
					itemDAO.updateStage("open", item.getItemsId());
				}
				break;
			case "open":
				if(item.getIpoDate().toLocalDateTime().toLocalDate().compareTo(currentDate)>=0) {
					itemDAO.updateStage("trade", item.getItemsId());
					System.out.println("ipo start");
					initialPublicOffering(item.getItemsId());
				}
				break;
			case "trade":
				if(item.getClearingDate().toLocalDateTime().toLocalDate().compareTo(currentDate)>=0) {
					itemDAO.updateStage("clear", item.getItemsId());
				}
				break;
			default: System.out.println("머야 이거"+item); 
		System.out.println("after : "+item);
			}
		}
	}
	
}
