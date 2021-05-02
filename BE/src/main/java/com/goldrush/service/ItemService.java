package com.goldrush.service;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.goldrush.dao.ItemDAO;
import com.goldrush.dao.MemberDAO;
import com.goldrush.dto.ItemListDTO;
import com.goldrush.dto.ResponseDTO;

public class ItemService {
	private ItemDAO itemDAO;
	
	public ItemService() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
		this.itemDAO = (ItemDAO) ctx.getBean("ItemDAO");
	}
	
	public List<ItemListDTO> getItemList(){
		return itemDAO.selectItemListForView();
	}
	
	public List<ItemListDTO> getItemListByStage(String stgae){
		return itemDAO.selectItemListForViewByStage(stgae);
	}
	
	public ItemListDTO getItem(int itemsId) {
		return itemDAO.selectItemForView(itemsId);
	}
}
