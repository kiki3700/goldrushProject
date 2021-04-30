package com.goldrush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.goldrush.dto.OfferDTO;
import com.goldrush.dto.OffersListDTO;
import com.goldrush.dto.ResponseDTO;

public class OfferDAOImpl {
	DB db;

	public DB getDb() {
		return db;
	}

	public void setDb(DB db) {
		this.db = db;
	}
	
	public List<OfferDTO> selectOffers() {
		String SQL = "SELECT * FROM offers";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		List<OfferDTO> listOffer = new ArrayList<OfferDTO>();
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int offersId = rs.getInt("offers_id");
				int membersId = rs.getInt("members_id");
				int itemsId= rs.getInt("items_id");
				boolean buy = rs.getBoolean("buy");
				int offerPrice = rs.getInt("offer_price");
				boolean isComplete = rs.getBoolean("is_complete");
				int quantity = rs.getInt("quantity");
				int quantityBalance = rs.getInt("quantity_balance");
				Timestamp timeStamp = rs.getTimestamp("time_stamp");
				listOffer.add(new OfferDTO(offersId, membersId, itemsId, buy, offerPrice, isComplete,
						quantity, quantityBalance, timeStamp));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listOffer;
	}
	
	public List<OfferDTO> selectOffersByPrice(int price) {
		String SQL = "SELECT * FROM offers WHERE offer_price = ? is_compelete = 0";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		List<OfferDTO> listOffer = new ArrayList<OfferDTO>();
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, price);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int offersId = rs.getInt("offers_id");
				int membersId = rs.getInt("members_id");
				int itemsId= rs.getInt("items_id");
				boolean buy = rs.getBoolean("buy");
				int offerPrice = rs.getInt("offer_price");
				boolean isComplete = rs.getBoolean("is_complete");
				int quantity = rs.getInt("quantity");
				int quantityBalance = rs.getInt("quantity_balance");
				Timestamp timeStamp = rs.getTimestamp("time_stamp");
				listOffer.add(new OfferDTO(offersId, membersId, itemsId, buy, offerPrice, isComplete,
						quantity, quantityBalance, timeStamp));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listOffer;
	}
	
	public List<OfferDTO> selectOffersByItemsId(int itemsId) {
		String SQL = "SELECT * FROM offers WHERE items_id = ? is_compelete = 0";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		List<OfferDTO> listOffer = new ArrayList<OfferDTO>();
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, itemsId);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int offersId = rs.getInt("offers_id");
				int membersId = rs.getInt("members_id");
				boolean buy = rs.getBoolean("buy");
				int offerPrice = rs.getInt("offer_price");
				boolean isComplete = rs.getBoolean("is_complete");
				int quantity = rs.getInt("quantity");
				int quantityBalance = rs.getInt("quantity_balance");
				Timestamp timeStamp = rs.getTimestamp("time_stamp");
				listOffer.add(new OfferDTO(offersId, membersId, itemsId, buy, offerPrice, isComplete,
						quantity, quantityBalance, timeStamp));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listOffer;
	}
	public ResponseDTO InsertNewOffer(OfferDTO dto) {
		String SQL = "INSERT INTO offers(members_id, itmes_id, buy, offer_price,"
				+ " quantity, quantity_balance) value(?, ?, ?, ?, ?)";
		PreparedStatement pstmt= null;
		Connection con= null;
		Boolean rs = null;
		ResponseDTO response=null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getMembersId());
			pstmt.setInt(1, dto.getItemsId());
			pstmt.setBoolean(1, dto.isBuy());
			pstmt.setInt(1, dto.getOfferPrice());
			pstmt.setInt(1, dto.getQuantity());
			rs= pstmt.execute();
			if(rs) {
				response= new ResponseDTO(1, "offer를 기록했습니다.");
			}else {
				response = new ResponseDTO(0,"offer 기록을 실패했습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public ResponseDTO deleteOffer(OfferDTO dto) {
		String SQL = "DELETE FROM offers WHERE offers_id = ?";
		PreparedStatement pstmt= null;
		Connection con= null;
		Boolean rs = null;
		ResponseDTO response=null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getOffersId());
			rs= pstmt.execute();
			if(rs) {
				response= new ResponseDTO(1, "offer를 삭제했습니다..");
			}else {
				response = new ResponseDTO(0,"offer 삭제에 실패했습니다..");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public ResponseDTO updateOfferByQuantity(OfferDTO dto) {
		String SQL = "UPDATE offers SET quantity = ?, quantity_balance= 0 , is_complete=1 WHERE offers_id = id";
		PreparedStatement pstmt= null;
		Connection con= null;
		Boolean rs = null;
		ResponseDTO response=null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getQuantity()-dto.getQuantityBalance());
			rs= pstmt.execute();
			if(rs) {
				response= new ResponseDTO(1, "업데이트를 성공했습니다.");
			}else {
				response = new ResponseDTO(0,"업데이트를 실패했습니다...");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public List<OffersListDTO> selectBuyOfferList(OfferDTO dto){
		String SQL = "SELECT * FROM offers WHERE items_id = ?, is_complete=0, buy=1 ORDER BY offer_price ASC";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		OffersListDTO offerDTO =null; 
		List<OffersListDTO> offerList = new ArrayList<OffersListDTO>(); 
		int basePrice=0;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getItemsId());
			rs= pstmt.executeQuery();
			if(rs.next()) {
				basePrice = rs.getInt("offer_price");
				int quantity = rs.getInt("quantity");
				offerDTO = new OffersListDTO(basePrice, quantity);
				while(rs.next()) {
					int price = rs.getInt("offer_price");
					quantity = rs.getInt("quantity");
					if(basePrice==price) {
						offerDTO.setQuantity(offerDTO.getQuantity()+quantity);
					}else {
						offerList.add(offerDTO);
						offerDTO = new OffersListDTO(price, quantity);
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return offerList;
	}
	
	public List<OffersListDTO> selectSellOfferList(OfferDTO dto){
		String SQL = "SELECT * FROM offers WHERE items_id = ?, is_complete=0, buy=0 ORDER BY offer_price DESC";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		OffersListDTO offerDTO =null; 
		List<OffersListDTO> offerList = new ArrayList<OffersListDTO>(); 
		int basePrice=0;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getItemsId());
			rs= pstmt.executeQuery();
			if(rs.next()) {
				basePrice = rs.getInt("offer_price");
				int quantity = rs.getInt("quantity");
				offerDTO = new OffersListDTO(basePrice, quantity);
				while(rs.next()) {
					int price = rs.getInt("offer_price");
					quantity = rs.getInt("quantity");
					if(basePrice==price) {
						offerDTO.setQuantity(offerDTO.getQuantity()+quantity);
					}else {
						offerList.add(offerDTO);
						offerDTO = new OffersListDTO(price, quantity);
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return offerList;
	}
	
}
