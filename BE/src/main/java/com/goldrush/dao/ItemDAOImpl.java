package com.goldrush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.goldrush.dto.ItemDTO;
import com.goldrush.dto.ResponseDTO;

public class ItemDAOImpl implements ItemDAO {
	DB db;
	public ItemDAOImpl(DBHandler db) {
		this.db = db;
	}
	public ItemDAOImpl(){

	}
	@Override
	public DB getDb() {
		return db;
	}
	@Override
	public void setDb(DB db) {
		this.db = db;
	}
	@Override
	public List<ItemDTO> selectItemList(){
		List<ItemDTO> listDTO = new ArrayList<ItemDTO>();
		String SQL = "SELECT * FROM items";
		Statement stmt= null;
		ResultSet rs = null;
		Connection con= null;
		try {
			con = db.connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			while(rs.next()) {
				int itemsId = rs.getInt("items_id");
				String code = rs.getString("code");
				String name = rs.getString("name");
				String category = rs.getString("category");
				String stage = rs.getString("stage");
				int cost = rs.getInt("cost");
				int quantity = rs.getInt("quantity");
				Timestamp openingDate = rs.getTimestamp("opening_date");
				Timestamp ipoDate = rs.getTimestamp("ipo_date");
				Timestamp tradingDate = rs.getTimestamp("trading_date");
				Timestamp clearingDate =rs.getTimestamp("clearing_date");
				String description = rs.getString("decription");
				String imgAddress = rs.getString("imgAddress");
				listDTO.add(new ItemDTO(itemsId, code, name, category, stage, cost, quantity, openingDate, ipoDate, tradingDate, clearingDate, description, imgAddress));
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
		return listDTO;
	}
	@Override
	public List<ItemDTO> selectItemListByStage(String stage){
		List<ItemDTO> listDTO = new ArrayList<ItemDTO>();
		String SQL = "SELECT * FROM items WHERE stage = ?";
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		Connection con= null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, stage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int itemsId = rs.getInt("items_id");
				String code = rs.getString("code");
				String name = rs.getString("name");
				String category = rs.getString("category");
				int cost = rs.getInt("cost");
				int quantity = rs.getInt("quantity");
				Timestamp openingDate = rs.getTimestamp("opening_date");
				Timestamp ipoDate = rs.getTimestamp("ipo_date");
				Timestamp tradingDate = rs.getTimestamp("trading_date");
				Timestamp clearingDate =rs.getTimestamp("clearing_date");
				String description = rs.getString("decription");
				String imgAddress = rs.getString("imgAddress");
				listDTO.add(new ItemDTO(itemsId, code, name, category, stage, cost, quantity, openingDate, ipoDate, tradingDate, clearingDate, description, imgAddress));
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
		return listDTO;
	}
	@Override
	public ItemDTO selectItem(int itemsId) {
		ItemDTO dto=null;
		String SQL = "SELECT * FROM items WHERE stage = ?";
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		Connection con= null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, itemsId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				String category = rs.getString("category");
				String stage = rs.getString("stage");
				int cost = rs.getInt("cost");
				int quantity = rs.getInt("quantity");
				Timestamp openingDate = rs.getTimestamp("opening_date");
				Timestamp ipoDate = rs.getTimestamp("ipo_date");
				Timestamp tradingDate = rs.getTimestamp("trading_date");
				Timestamp clearingDate =rs.getTimestamp("clearing_date");
				String description = rs.getString("decription");
				String imgAddress = rs.getString("imgAddress");
				dto = new ItemDTO(itemsId, code, name, category, stage, cost, quantity, openingDate, ipoDate, tradingDate, clearingDate, description, imgAddress);
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
	     return dto;
	}
	@Override
	public ResponseDTO insertNewItem(ItemDTO dto) {
		String SQL = "INSERT INTO items("
				+ "code, name, category, cost, quantity, opening_date, ipo_date, trading_date,"
				+ " clearing_date, description, img_address) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResponseDTO  response =null;
		try {
			con= db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, dto.getCode());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getCategory());
			pstmt.setInt(4, dto.getCost());
			pstmt.setInt(5, dto.getQuantity());
			pstmt.setTimestamp(6, dto.getOpeningDate());
			pstmt.setTimestamp(7, dto.getIpoDate());
			pstmt.setTimestamp(8, dto.getTradingDate());
			pstmt.setTimestamp(9, dto.getClearingDate());
			pstmt.setString(10, dto.getDescription());
			pstmt.setString(11, dto.getImgAddress());
			if(pstmt.executeUpdate()==1) {
				response = new ResponseDTO(1, "상품등록 완료");
			}else {
				response = new ResponseDTO(0, "상품등록 실패");
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
		return response;
	}
	@Override
	public ResponseDTO deleteItem(int itemsId) {
		String SQL = "DELETE FROM items where items_id = ?";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResponseDTO  response =null;
		try {
			con= db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, itemsId);
			int r =pstmt.executeUpdate();
			if(r==1) {
				response = new ResponseDTO(1, "상품삭제 완료");
			}else {
				response = new ResponseDTO(0, "상품삭제 실패");
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
		return response;
	}
	@Override
	public ResponseDTO updateItem(ItemDTO dto) {
		String SQL = "UPDATE items"
				+ "SET code = ?, name = ?, category= ?, cost = ?, quantity=?, opening_date =?, ipo_date=?,"
				+ "trading_date=?, clearing_date=?, description=?, img_address=?, stage =?";
		Connection con= null;
		ResponseDTO  response =null;
		PreparedStatement pstmt=null;
		try {
			con= db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, dto.getCode());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getCategory());
			pstmt.setInt(4, dto.getCost());
			pstmt.setInt(5, dto.getQuantity());
			pstmt.setTimestamp(6, dto.getOpeningDate());
			pstmt.setTimestamp(7, dto.getIpoDate());
			pstmt.setTimestamp(8, dto.getTradingDate());
			pstmt.setTimestamp(9, dto.getClearingDate());
			pstmt.setString(10, dto.getDescription());
			pstmt.setString(11, dto.getImgAddress());
			pstmt.setString(12, dto.getStage());
			if(pstmt.execute()) {
				response = new ResponseDTO(1, "상품변경 완료");
			}else {
				response = new ResponseDTO(0, "상품병경 실패");
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
		return response;
	}
}

