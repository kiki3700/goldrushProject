package com.goldrush.dao;

import java.util.List;

import com.goldrush.dto.ItemDTO;
import com.goldrush.dto.ResponseDTO;

public interface ItemDAO {
	public DB getDb();
	public void setDb(DB db);
	public List<ItemDTO> selectItemList();
	public List<ItemDTO> selectItemListByStage(String stage);
	public ItemDTO selectItem(int itemsId) ;
	public ResponseDTO insertNewItem(ItemDTO dto);
	public ResponseDTO deleteItem(int itemsId);
	public ResponseDTO updateItem(ItemDTO dto);
}
