package com.goldrush.service;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.goldrush.dao.AccountDAO;
import com.goldrush.dao.InventoryDAO;
import com.goldrush.dao.ItemDAO;
import com.goldrush.dao.OfferDAO;
import com.goldrush.dao.TradeDAO;

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
		this.inventoryDAO = (InventoryDAO) ctx.getBean("InventoryBean");
	}
}
