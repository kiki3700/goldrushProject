package com.goldrush.dao;

import java.util.List;

import com.goldrush.dto.InventoryDTO;
import com.goldrush.dto.OfferDTO;
import com.goldrush.dto.PortfolioDTO;
import com.goldrush.dto.ResponseDTO;

public interface InventoryDAO {
	public List<PortfolioDTO> selectPortfolio(int membersId);
	public List<InventoryDTO> selectInv(int membersId);
	public ResponseDTO insertInventory(InventoryDTO dto);
	public ResponseDTO updateInventoryprice(InventoryDTO dto);
	public ResponseDTO deleteInventory(InventoryDTO dto);
	int checkEnoughQuantity(OfferDTO dto);
}
