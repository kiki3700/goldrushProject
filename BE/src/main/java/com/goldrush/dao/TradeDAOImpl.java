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
				tradeDTO.setQuantity(rs.getInt("quantity"));
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
	public ResponseDTO insertTrade(TradeDTO dto) {
		String SQL = "INSERT INTO trades(quantity, offers_id, members_id) value(?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResponseDTO response=null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getQuantity());
			pstmt.setInt(2, dto.getOffersId());
			pstmt.setInt(3, dto.getMembersId());
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
