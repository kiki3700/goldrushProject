package com.goldrush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goldrush.dto.MemberDTO;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.dto.TradeDTO;
import com.goldrush.dto.TradeLogDTO;

public class TradeDAOImpl implements TradeDAO {
	DB db;

	public TradeDAOImpl(DB db) {
		super();
		this.db = db;
	}

	public TradeDAOImpl() {
		super();
	}
	
	public DB getDb() {
		return db;
	}

	public void setDb(DB db) {
		this.db = db;
	}
	@Override
	public List<TradeDTO> selectTrade(MemberDTO dto){
		String SQL = "SELECT * FROM trades WHERE Members_id = ?";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		List<TradeDTO> listTrade = new ArrayList<TradeDTO>();
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getMembersId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TradeDTO tradeDTO = new TradeDTO();
				tradeDTO.setTradesId(rs.getInt("trades_id"));
				tradeDTO.setMembersId(rs.getInt("members_id"));
				tradeDTO.setOffersId(rs.getInt("offers_id"));
				tradeDTO.setTimeStamp(rs.getTimestamp("time_stamp"));
				listTrade.add(tradeDTO);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }	
		return listTrade;
	}

	@Override
	public List<TradeLogDTO> selectTradeLog(int membersId){
		String SQL = "SELECT * FROM offers LEFT JOIN trades ON trades.offers_id = offers.offers_id WHERE offers.members_id = ?";
		String SQLForItem = "SELECT *FROM items WHERE items_id =?";
		PreparedStatement pstmtForItem= null;
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		ResultSet rsForItem = null;
		List<TradeLogDTO> listTrade = new ArrayList<TradeLogDTO>();
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TradeLogDTO tradeDTO = new TradeLogDTO();
				int itemsId = rs.getInt("items_id");
				pstmtForItem=con.prepareStatement(SQLForItem);
				pstmtForItem.setInt(1, itemsId);
				rsForItem = pstmtForItem.executeQuery();
				rsForItem.next();
				tradeDTO.setCode(rsForItem.getString("code"));
				tradeDTO.setName(rsForItem.getString("name"));
				tradeDTO.setTimestamp(rs.getTimestamp("time_stamp"));
				tradeDTO.setPrice(rs.getInt("offer_price"));
				tradeDTO.setBuy(rs.getBoolean("buy"));
				tradeDTO.setQuantity(rs.getInt("quantity"));
				listTrade.add(tradeDTO);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }	
		return listTrade;
	}
	@Override
	public ResponseDTO insertTrade(TradeDTO dto) {
		String SQL = "INSERT INTO trades(offers_id, members_id) value(?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResponseDTO response=null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getOffersId());
			pstmt.setInt(2, dto.getMembersId());
			if(pstmt.executeUpdate()==1) {
				response = new ResponseDTO(1, "거래에 성공했습니다.");
			}else {
				response = new ResponseDTO(0, "거래에 실패했습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			response = new ResponseDTO(0, "거래에 실패했습니다.");
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
	
}
