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
import com.goldrush.dto.ItemListDTO;
import com.goldrush.dto.PriceGraph;
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
				Timestamp clearingDate =rs.getTimestamp("clearing_date");
				String description = rs.getString("description");
				String imgAddress = rs.getString("img_address");
				listDTO.add(new ItemDTO(itemsId, code, name, category, stage, cost, quantity, openingDate, ipoDate, clearingDate, description, imgAddress));
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
				Timestamp clearingDate =rs.getTimestamp("clearing_date");
				String description = rs.getString("description");
				String imgAddress = rs.getString("img_address");
				listDTO.add(new ItemDTO(itemsId, code, name, category, stage, cost, quantity, openingDate, ipoDate, clearingDate, description, imgAddress));
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
		String SQL = "SELECT * FROM items WHERE items_id = ?";
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
				Timestamp clearingDate =rs.getTimestamp("clearing_date");
				String description = rs.getString("description");
				String imgAddress = rs.getString("img_address");
				dto = new ItemDTO(itemsId, code, name, category, stage, cost, quantity, openingDate, ipoDate, clearingDate, description, imgAddress);
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
	public ItemListDTO selectItemForView(int itemsId) {
		ItemListDTO dto=null;
		List<PriceGraph> priceGraph = new ArrayList<PriceGraph>();
		String SQL = "SELECT * FROM items WHERE items_id = ?";
		String SQLForBuyOffer = "SELECT * FROM offers WHERE items_id = ? AND is_complete = false AND buy =true ORDER BY offer_price ASC LIMIT 1";
		String SQLForSellOffer = "SELECT * FROM offers WHERE items_id = ? AND is_complete = false AND buy =false ORDER BY offer_price DESC LIMIT 1";
		String SQLForPrice = "SELECT * FROM offers LEFT JOIN trades ON offers.offers_id = trades.offers_id where offers.items_id = ? ORDER BY trades.trades_id desc LIMIT 1";
		String SQLForBalance="SELECT * FROM offers WHERE is_complete=false AND buy=true AND items_id = ?";
		String SQLForGraph = "select DATE(trades.time_stamp) as date, avg(offer_price) as price  from trades left join offers on trades.offers_id = offers.offers_id where offers.items_id= ? Group BY date";
		
		PreparedStatement pstmt= null;
		PreparedStatement pstmtForBuyOffer= null;
		PreparedStatement pstmtForSellOffer= null;
		PreparedStatement pstmtForPrice= null;
		PreparedStatement pstmtForGraph = null;
		
		ResultSet rs = null;
		ResultSet rsForBuyOffer = null;
		ResultSet rsForSellOffer = null;
		ResultSet rsForPrice = null;
		ResultSet rsForBalance = null;
		ResultSet rsForGraph= null;
		PreparedStatement pstmtForBalance=null;
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
				Timestamp clearingDate =rs.getTimestamp("clearing_date");
				String description = rs.getString("description");
				String imgAddress = rs.getString("img_address");
				pstmtForBuyOffer = con.prepareStatement(SQLForBuyOffer);
				pstmtForBuyOffer.setInt(1, itemsId);
				rsForBuyOffer=pstmtForBuyOffer.executeQuery();
				pstmtForBalance = con.prepareStatement(SQLForBalance);
				pstmtForBalance.setInt(1, itemsId);
				rsForBalance = pstmtForBalance.executeQuery();
				int buyOffer = cost/quantity;
				if(rsForBuyOffer.next()) {
					buyOffer = rsForBuyOffer.getInt("offer_price"); 
				}
			
				pstmtForSellOffer = con.prepareStatement(SQLForSellOffer);
				pstmtForSellOffer.setInt(1, itemsId);
				rsForSellOffer=pstmtForSellOffer.executeQuery();
				int sellOffer = 0;
				if(rsForSellOffer.next()) {
					sellOffer = rsForSellOffer.getInt("offer_price"); 
				}
				
				pstmtForPrice = con.prepareStatement(SQLForPrice);
				pstmtForPrice.setInt(1, itemsId);
				rsForPrice = pstmtForPrice.executeQuery();
				int price = 0;
				if(rsForPrice.next()) {
					price = rsForPrice.getInt("offer_price");
				}
				int consumedAmount=0;
				while(rsForBalance.next()) {
					consumedAmount += rsForBalance.getInt("quantity");
				}
				pstmtForGraph = con.prepareStatement(SQLForGraph);
				pstmtForGraph.setInt(1,itemsId);
				rsForGraph = pstmtForGraph.executeQuery();
				while(rsForGraph.next()) {
					PriceGraph data = new PriceGraph();
					data.setDate(rsForGraph.getTimestamp("data"));
					data.setPrice(rs.getInt("price"));
					priceGraph.add(data);					
				}
				
					
				dto = new ItemListDTO();
				dto.setItemsId(itemsId);
				dto.setCode(code);
				dto.setName(name);
				dto.setCategory(category);
				dto.setStage(stage);
				dto.setCost(cost);
				dto.setQuantity(quantity);
				dto.setOpeningDate(openingDate);
				dto.setIpoDate(ipoDate);
				dto.setClearingDate(clearingDate);
				dto.setDescription(description);
				dto.setImgAddress(imgAddress);
				dto.setPrice(price);
				dto.setBuyOffer(buyOffer);
				dto.setSellOffer(sellOffer);
				dto.setRemainingAmount(quantity-consumedAmount);
				dto.setPriceGraph(priceGraph);
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
	public List<ItemListDTO> selectItemListForView() {
		List<ItemListDTO> itemList = new ArrayList<ItemListDTO>();
		String SQL = "SELECT * FROM items";
		String SQLForBuyOffer = "SELECT * FROM offers WHERE items_id = ? AND is_complete = false AND buy =true ORDER BY offer_price ASC LIMIT 1";
		String SQLForSellOffer = "SELECT * FROM offers WHERE items_id = ? AND is_complete = false AND buy =false ORDER BY offer_price DESC LIMIT 1";
		String SQLForPrice = "SELECT * FROM offers LEFT JOIN trades ON offers.offers_id = trades.offers_id where offers.items_id = ? ORDER BY trades.trades_id desc LIMIT 1";
		String SQLForBalance="SELECT * FROM offers WHERE is_complete=false AND buy=true AND items_id = ?";
		PreparedStatement pstmt= null;
		PreparedStatement pstmtForBuyOffer= null;
		PreparedStatement pstmtForSellOffer= null;
		PreparedStatement pstmtForPrice= null;
		ResultSet rs = null;
		ResultSet rsForBuyOffer = null;
		ResultSet rsForSellOffer = null;
		ResultSet rsForPrice = null;
		ResultSet rsForBalance = null;
		PreparedStatement pstmtForBalance=null;
		Connection con= null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
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
				Timestamp clearingDate =rs.getTimestamp("clearing_date");
				String description = rs.getString("description");
				String imgAddress = rs.getString("img_address");
				pstmtForBuyOffer = con.prepareStatement(SQLForBuyOffer);
				pstmtForBuyOffer.setInt(1, itemsId);
				rsForBuyOffer=pstmtForBuyOffer.executeQuery();
				rsForBuyOffer=pstmtForBuyOffer.executeQuery();
				pstmtForBalance = con.prepareStatement(SQLForBalance);
				pstmtForBalance.setInt(1, itemsId);
				rsForBalance = pstmtForBalance.executeQuery();
				int buyOffer = cost/quantity;
				if(rsForBuyOffer.next()) {
					buyOffer = rsForBuyOffer.getInt("offer_price"); 
				}
			
				pstmtForSellOffer = con.prepareStatement(SQLForSellOffer);
				pstmtForSellOffer.setInt(1, itemsId);
				rsForSellOffer=pstmtForSellOffer.executeQuery();
				int sellOffer = 0;
				if(rsForSellOffer.next()) {
					sellOffer = rsForSellOffer.getInt("offer_price"); 
				}
				int consumedAmount=0;
				while(rsForBalance.next()) {
					consumedAmount += rsForBalance.getInt("quantity");
				}
				pstmtForPrice = con.prepareStatement(SQLForPrice);
				pstmtForPrice.setInt(1, itemsId);
				rsForPrice = pstmtForPrice.executeQuery();
				int price = 0;
				if(rsForPrice.next()) {
					price = rsForPrice.getInt("offer_price");
				}
				
					
				ItemListDTO dto = new ItemListDTO();
				dto.setItemsId(itemsId);
				dto.setCode(code);
				dto.setName(name);
				dto.setCategory(category);
				dto.setStage(stage);
				dto.setCost(cost);
				dto.setQuantity(quantity);
				dto.setOpeningDate(openingDate);
				dto.setIpoDate(ipoDate);
				dto.setClearingDate(clearingDate);
				dto.setDescription(description);
				dto.setImgAddress(imgAddress);
				dto.setPrice(price);
				dto.setBuyOffer(buyOffer);
				dto.setSellOffer(sellOffer);
				dto.setRemainingAmount(quantity-consumedAmount);
				itemList.add(dto);
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
	     return itemList;
	}

	@Override
	public List<ItemListDTO> selectItemListForViewByStage(String stage) {
		List<ItemListDTO> itemList = new ArrayList<ItemListDTO>();
		String SQL = "SELECT * FROM items WHERE stage = ?";
		String SQLForBuyOffer = "SELECT * FROM offers WHERE items_id = ? AND is_complete = false AND buy =true ORDER BY offer_price ASC LIMIT 1";
		String SQLForSellOffer = "SELECT * FROM offers WHERE items_id = ? AND is_complete = false AND buy =false ORDER BY offer_price DESC LIMIT 1";
		String SQLForPrice = "SELECT * FROM offers LEFT JOIN trades ON offers.offers_id = trades.offers_id where offers.items_id = ? ORDER BY trades.trades_id desc LIMIT 1";
		String SQLForBalance="SELECT * FROM offers WHERE is_complete=false AND buy=true AND items_id = ?";
		PreparedStatement pstmt= null;
		PreparedStatement pstmtForBuyOffer= null;
		PreparedStatement pstmtForSellOffer= null;
		PreparedStatement pstmtForPrice= null;
		ResultSet rs = null;
		ResultSet rsForBuyOffer = null;
		ResultSet rsForSellOffer = null;
		ResultSet rsForPrice = null;
		ResultSet rsForBalance = null;
		PreparedStatement pstmtForBalance=null;
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
				Timestamp clearingDate =rs.getTimestamp("clearing_date");
				String description = rs.getString("description");
				String imgAddress = rs.getString("img_address");
				pstmtForBuyOffer = con.prepareStatement(SQLForBuyOffer);
				pstmtForBuyOffer.setInt(1, itemsId);
				rsForBuyOffer=pstmtForBuyOffer.executeQuery();
				
				rsForBuyOffer=pstmtForBuyOffer.executeQuery();
				pstmtForBalance = con.prepareStatement(SQLForBalance);
				pstmtForBalance.setInt(1, itemsId);
				rsForBalance = pstmtForBalance.executeQuery();
				int buyOffer = cost/quantity;
				if(rsForBuyOffer.next()) {
					buyOffer = rsForBuyOffer.getInt("offer_price"); 
				}
			
				pstmtForSellOffer = con.prepareStatement(SQLForSellOffer);
				pstmtForSellOffer.setInt(1, itemsId);
				rsForSellOffer=pstmtForSellOffer.executeQuery();
				int sellOffer = 0;
				if(rsForSellOffer.next()) {
					sellOffer = rsForSellOffer.getInt("offer_price"); 
				}
				int consumedAmount=0;
				while(rsForBalance.next()) {
					consumedAmount += rsForBalance.getInt("quantity");
				}
				pstmtForPrice = con.prepareStatement(SQLForPrice);
				pstmtForPrice.setInt(1, itemsId);
				rsForPrice = pstmtForPrice.executeQuery();
				int price = 0;
				if(rsForPrice.next()) {
					price = rsForPrice.getInt("offer_price");
				}
				
					
				ItemListDTO dto = new ItemListDTO();
				dto.setItemsId(itemsId);
				dto.setCode(code);
				dto.setName(name);
				dto.setCategory(category);
				dto.setStage(stage);
				dto.setCost(cost);
				dto.setQuantity(quantity);
				dto.setOpeningDate(openingDate);
				dto.setIpoDate(ipoDate);
				dto.setClearingDate(clearingDate);
				dto.setDescription(description);
				dto.setImgAddress(imgAddress);
				dto.setPrice(price);
				dto.setBuyOffer(buyOffer);
				dto.setSellOffer(sellOffer);
				dto.setRemainingAmount(quantity-consumedAmount);
				itemList.add(dto);
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
	     return itemList;
	}
	
	@Override
	public ResponseDTO insertNewItem(ItemDTO dto) {
		String SQL = "INSERT INTO items("
				+ "code, name, category, cost, quantity, opening_date, ipo_date, clearing_date, description, img_address) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			pstmt.setTimestamp(8, dto.getClearingDate());
			pstmt.setString(9, dto.getDescription());
			pstmt.setString(10, dto.getImgAddress());
			if(pstmt.executeUpdate()==1) {
				response = new ResponseDTO(1, "상품등록 완료");
			}else {
				response = new ResponseDTO(0, "상품등록 실패");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			response = new ResponseDTO(0, "상품등록 실패");
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
		String SQL = "UPDATE items SET code = ?, name = ?, category= ?, cost = ?, quantity = ?, opening_date = ?, ipo_date=?, clearing_date=?, description = ?, img_address = ?, stage = ? WHERE items_id = ?";
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
			pstmt.setTimestamp(8, dto.getClearingDate());
			pstmt.setString(9, dto.getDescription());
			pstmt.setString(10, dto.getImgAddress());
			pstmt.setString(11, dto.getStage());
			pstmt.setInt(12, dto.getItemsId());
			if(pstmt.executeUpdate()==1) {
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

	@Override
	public ResponseDTO updateStage(String stage, int itemsId) {
		String SQL = "UPDATE items SET stage = ? WHERE items_id = ?";
		Connection con= null;
		ResponseDTO  response =null;
		PreparedStatement pstmt=null;
		try {
			con= db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, stage);
			pstmt.setInt(2,itemsId);
			if(pstmt.executeUpdate()==1) {
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

