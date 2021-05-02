package com.goldrush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goldrush.dto.InventoryDTO;
import com.goldrush.dto.PortfolioDTO;
import com.goldrush.dto.ResponseDTO;

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
	@Override
	public List<PortfolioDTO> selectPortfolio(int membersId){
		List<PortfolioDTO> listInv = new ArrayList<PortfolioDTO>();
		String SQLForInventory ="SELECT * From inventories WHERE members_id=?";
		String SQLForOffersId = "SELECT * FROM trades WHERE offers_id = ? ORDER BY trades_id desc LIMIT 1";
		String SQLForPrice ="SELECT * FROM offers WHERE offers_id =?";
		String SQLForCode = "SELECT code FROM items WHERE items_id = ?";
		ResultSet rsByInventory =null;
		ResultSet rsByOffer=null;
		ResultSet rsByPrice=null;
		ResultSet rsByItem=null;
		Connection con = db.connect();
		try{
			PreparedStatement pstmtForInventory = con.prepareStatement(SQLForInventory);
			pstmtForInventory.setInt(1, membersId);
			rsByInventory = pstmtForInventory.executeQuery();
			while(rsByInventory.next()) {
				int itemsId = rsByInventory.getInt("items_id");
				int quantity = rsByInventory.getInt("quantity");
				int avePrice = rsByInventory.getInt("average_price");
				PreparedStatement pstmtForOffer = con.prepareStatement(SQLForOffersId);
				pstmtForOffer.setInt(1, itemsId);
				rsByOffer = pstmtForOffer.executeQuery();
				rsByOffer.next();
				int offersId = rsByOffer.getInt("offers_id");
				PreparedStatement pstmtForPrice = con.prepareStatement(SQLForPrice);
				pstmtForPrice.setInt(1, offersId);
				rsByPrice = pstmtForPrice.executeQuery();
				rsByPrice.next();
				int price = rsByPrice.getInt("offer_price");
				float rateOfReturn = (float)(price-avePrice)/avePrice*100;
				PreparedStatement pstmtForCode = con.prepareStatement(SQLForCode);
				pstmtForCode.setInt(1, itemsId);
				rsByItem = pstmtForCode.executeQuery();
				rsByItem.next();
				String code = rsByItem.getString("code");
				listInv.add(new PortfolioDTO(code, avePrice, quantity, price, rateOfReturn));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				if(!con.isClosed()) db.disconnect();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		return listInv;
	}
	@Override
	public List<InventoryDTO> selectInv(int membersId){
		List<InventoryDTO> listInv = new ArrayList<InventoryDTO>();
		String SQL ="SELECT * From inventories WHERE members_id=?";
		ResultSet rs =null;
		Connection con = db.connect();
		try{
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				InventoryDTO dto = new InventoryDTO();
				System.out.println(dto.getInventoriesId());
				dto.setMembersId(rs.getInt("members_id"));
				dto.setItemsId(rs.getInt("items_id"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setAveragePrice(rs.getInt("average_price"));
				listInv.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }	
		
		return listInv;
	}
	@Override
	public ResponseDTO insertInventory(InventoryDTO dto) {
		String SQL ="INSERT INTO inventories(members_id, items_id, average_price, quantity) value(?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResponseDTO response = null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getMembersId());
			pstmt.setInt(2, dto.getItemsId());
			pstmt.setInt(3, dto.getAveragePrice());
			pstmt.setInt(4, dto.getQuantity());
			if(pstmt.executeUpdate()==1) {
				response = new ResponseDTO(1, "인벤토리에 등록했습니다..");
			}else {
				response = new ResponseDTO(0, "인벤토리에 등록에 실패했습니다..");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
			response = new ResponseDTO(0, "인벤토리에 등록에 실패했습니다..");
		}	
		return response;
	}
	@Override
	public ResponseDTO updateInventoryprice(InventoryDTO dto) {
		String SQL ="UPDATE inventories SET average_price = ?, quantity =? WHERE items_id = ? AND members_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResponseDTO response = null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getAveragePrice());
			pstmt.setInt(2, dto.getQuantity());
			pstmt.setInt(3, dto.getItemsId());
			pstmt.setInt(4, dto.getMembersId());
			if(pstmt.executeUpdate()==1) {
				response = new ResponseDTO(1, "인벤토리가 갱신되었습니다.");
			}else {
				response = new ResponseDTO(0, "인벤토리 갱신이 실패했습니다.");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
			response = new ResponseDTO(0, "인벤토리 갱신이 실패했습니다.");
		}	
		return response;
	}
	@Override
	public ResponseDTO deleteInventory(InventoryDTO dto) {
		String SQL ="DELETE FROM inventories WHERE items_id = ? AND members_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResponseDTO response = null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getItemsId());
			pstmt.setInt(2, dto.getMembersId());
			if(pstmt.executeUpdate()==1) {
				response = new ResponseDTO(1, "인벤토리가 삭제되었습니다.");
			}else {
				response = new ResponseDTO(0, "인벤토리 삭제가 실패했습니다.");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
			response = new ResponseDTO(0, "인벤토리 삭제가 실패했습니다.");
		}	
		return response;
	}
}

