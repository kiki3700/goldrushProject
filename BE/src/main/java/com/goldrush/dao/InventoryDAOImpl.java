package com.goldrush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goldrush.dto.InventoryDTO;
import com.goldrush.dto.OfferDTO;
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
//	@Override
//	public List<PortfolioDTO> selectPortfolio(int membersId){
//		List<PortfolioDTO> listInv = new ArrayList<PortfolioDTO>();
//		String SQLForInventory ="SELECT * From inventories WHERE members_id=?";
//		String SQLForOffersId = "SELECT * FROM trades WHERE offers_id = ? ORDER BY trades_id desc LIMIT 1";
//		String SQLForPrice ="SELECT * FROM offers WHERE offers_id =?";
//		String SQLForCode = "SELECT code FROM items WHERE items_id = ?";
//		ResultSet rsByInventory =null;
//		ResultSet rsByOffer=null;
//		ResultSet rsByPrice=null;
//		ResultSet rsByItem=null;
//		Connection con = db.connect();
//		try{
//			PreparedStatement pstmtForInventory = con.prepareStatement(SQLForInventory);
//			pstmtForInventory.setInt(1, membersId);
//			rsByInventory = pstmtForInventory.executeQuery();
//			while(rsByInventory.next()) {
//				int itemsId = rsByInventory.getInt("items_id");
//				int quantity = rsByInventory.getInt("quantity");
//				int price = rsByInventory.getInt("price");
//				PreparedStatement pstmtForOffer = con.prepareStatement(SQLForOffersId);
//				pstmtForOffer.setInt(1, itemsId);
//				rsByOffer = pstmtForOffer.executeQuery();
//				rsByOffer.next();
//				int offersId = rsByOffer.getInt("offers_id");
//				PreparedStatement pstmtForPrice = con.prepareStatement(SQLForPrice);
//				pstmtForPrice.setInt(1, offersId);
//				rsByPrice = pstmtForPrice.executeQuery();
//				rsByPrice.next();
//				int price = rsByPrice.getInt("offer_price");
//				float rateOfReturn = (float)(price-avePrice)/avePrice*100;
//				PreparedStatement pstmtForCode = con.prepareStatement(SQLForCode);
//				pstmtForCode.setInt(1, itemsId);
//				rsByItem = pstmtForCode.executeQuery();
//				rsByItem.next();
//				String code = rsByItem.getString("code");
//				listInv.add(new PortfolioDTO(code, avePrice, quantity, price, rateOfReturn));
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			try {
//				if(!con.isClosed()) db.disconnect();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
//		
//		
//		return listInv;
//	}
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
				dto.setPrice(rs.getInt("price"));
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
	public int checkEnoughQuantity(OfferDTO dto){
		String SQL ="SELECT SUM(quantity) as quantity From inventories WHERE members_id=? AND items_id=?";
		ResultSet rs =null;
		Connection con = db.connect();
		int quantity=0;
		try{
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getMembersId());
			pstmt.setInt(2, dto.getItemsId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				quantity = rs.getInt("quantity");
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
		
		return quantity;
	}
	
	@Override
	public ResponseDTO insertInventory(InventoryDTO dto) {
		String SQL ="INSERT INTO inventories(members_id, items_id, price, quantity) value(?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResponseDTO response = null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getMembersId());
			pstmt.setInt(2, dto.getItemsId());
			pstmt.setInt(3, dto.getPrice());
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
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }	
		return response;
	}
	@Override
	public ResponseDTO updateInventoryprice(InventoryDTO dto) {
		String SQL ="UPDATE inventories SET price = ?, quantity =? WHERE items_id = ? AND members_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResponseDTO response = null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getPrice());
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
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }	
		return response;
	}
	@Override
	public List<PortfolioDTO> selectPortfolio(int membersId) {
		// TODO Auto-generated method stub
		String SQL = "SELECT items_id, SUM(quantity) AS quantity, SUM(quantity*price)/SUM(quantity) as average_price from inventories where members_id =? GROUP BY items_id";
		String SQlForCode = "select * from items where items_id =?";
		String SQLForPrice= "SELECT * FROM trades LEFT JOIN offers on offers.offers_id = trades.offers_id WHERE items_id = ? ORDER BY trades.trades_id DESC limit 1";
		Connection con = db.connect();
		PreparedStatement pstmt=null;
		PreparedStatement pstmtForCode=null;
		PreparedStatement pstmtForPrice=null;
		ResultSet rs = null;
		ResultSet rsForCode = null;
		ResultSet rsForPrice = null;
		List<PortfolioDTO> listDTO = new ArrayList<PortfolioDTO>();
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
			int itemsId = rs.getInt("items_id");
			pstmtForCode = con.prepareStatement(SQlForCode);
			pstmtForPrice = con.prepareStatement(SQLForPrice);
			pstmtForCode.setInt(1, itemsId);
			pstmtForPrice.setInt(1, itemsId);
			rsForPrice = pstmtForPrice.executeQuery();
			rsForCode = pstmtForCode.executeQuery();
			rsForCode.next();
			rsForPrice.next();
			PortfolioDTO dto = new PortfolioDTO();
			int price = rsForPrice.getInt("offer_price");
			int averagePrice = rs.getInt("average_price");
			int quantity = rs.getInt("quantity");
			dto.setAveragePrice(averagePrice);
			dto.setCode(rsForCode.getString("code"));
			dto.setPrice(price);
			dto.setQuantity(quantity);
			dto.setRateOfReturn((float)(price-averagePrice)/averagePrice*100);
			if(quantity !=0) listDTO.add(dto);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}	
		return listDTO;
	}
}

