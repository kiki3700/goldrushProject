package com.goldrush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goldrush.dto.PortfolioDTO;

public class InventoryDAOImpl implements InventoryDAO{
	DB db;
	public InventoryDAOImpl() {
	}
	public DB getDb() {
		return db;
	}
	public void setDb(DB db) {
		this.db = db;
	}
	public InventoryDAOImpl(DB db) {
		this.db=db;
	}
	//portfolio method
	public List<PortfolioDTO> selectPortfolio(int membersId){
		List<PortfolioDTO> listInv = new ArrayList<PortfolioDTO>();
		String SQLForInventory ="SELECT * From inventories WHERE members_id=?";
		String SQLForPrice = "SELECT trades.unit_price, offers.itmes_ FROM trades INNSER JOIN offers "
				+ "ON offers.items_id = ? ORDER BY trades.trades_id decs LIMIT 1";
		String SQLForCode = "SELECT code FROM items WHERE items_id = ?";
		ResultSet rsByInventory =null;
		ResultSet rsByOffer=null;
		ResultSet rsByItem=null;
		Connection con = db.connect();
		try{
			PreparedStatement pstmtForInventory = con.prepareStatement(SQLForInventory);
			pstmtForInventory.setInt(1, membersId);
			rsByInventory = pstmtForInventory.executeQuery();
			while(rsByInventory.next()) {
				int offersId = rsByInventory.getInt("offers_id");
				int itemsId = rsByInventory.getInt("items_id");
				int quantity = rsByInventory.getInt("quantity");
				int avePrice = rsByInventory.getInt("ave_price");
				PreparedStatement pstmtForOffer = con.prepareStatement(SQLForPrice);
				pstmtForOffer.setInt(1, offersId);
				rsByOffer = pstmtForOffer.executeQuery();
				rsByOffer.next();
				int price = rsByOffer.getInt("unit_price");
				float rateOfReturn = (price-avePrice)/avePrice*100;
				PreparedStatement pstmtForCode = con.prepareStatement(SQLForCode);
				pstmtForCode.setInt(1, itemsId);
				rsByItem = pstmtForCode.executeQuery();
				rsByItem.next();
				String code = rsByItem.getString("code");
				listInv.add(new PortfolioDTO(code, avePrice, quantity, price, rateOfReturn));
				con.isClosed();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return listInv;
	}
	
	
}

