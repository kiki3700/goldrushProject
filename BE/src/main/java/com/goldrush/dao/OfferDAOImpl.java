package com.goldrush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.goldrush.dto.OfferDTO;
import com.goldrush.dto.OfferLogDTO;
import com.goldrush.dto.OffersListDTO;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.dto.TraderDTO;

public class OfferDAOImpl implements OfferDAO {
	DB db;

	public OfferDAOImpl() {
		
	}
	
	public OfferDAOImpl(DB db) {
		// TODO Auto-generated constructor stub
		this.db = db;
	}

	public DB getDb() {
		return db;
	}

	public void setDb(DB db) {
		this.db = db;
	}
	
	@Override
	public OfferDTO selectOfferBytrade(TraderDTO traderdto) {
		String SQL = "SELECT * FROM offers WHERE items_id = ? AND offer_price =? AND is_complete=false AND buy =? ORDER BY time_stamp ASC limit 1";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		OfferDTO dto = new OfferDTO();
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, traderdto.getItemsId());
			pstmt.setInt(2, traderdto.getPrice());
			pstmt.setBoolean(3, !traderdto.isBuy());
			rs= pstmt.executeQuery();
			while(rs.next()) {
				dto.setItemsId(rs.getInt("items_id"));
				dto.setOffersId(rs.getInt("offers_id"));
				dto.setBuy(rs.getBoolean("buy"));
				dto.setOfferPrice(rs.getInt("offer_price"));
				dto.setMembersId(rs.getInt("members_id"));
				dto.setTimeStamp(rs.getTimestamp("time_stamp"));
				dto.setComplete(rs.getBoolean("is_complete"));
				dto.setQuantity(rs.getInt("quantity"));
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
	public OfferDTO selectOffer(OfferDTO offerDTO) {
		String SQL = "SELECT * FROM offers WHERE offers_id = ?";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		OfferDTO dto = new OfferDTO();
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, offerDTO.getOffersId());
			rs= pstmt.executeQuery();
			while(rs.next()) {
				dto.setItemsId(rs.getInt("items_id"));
				dto.setOffersId(rs.getInt("offers_id"));
				dto.setBuy(rs.getBoolean("buy"));
				dto.setMembersId(rs.getInt("members_id"));
				dto.setTimeStamp(rs.getTimestamp("time_stamp"));
				dto.setComplete(rs.getBoolean("is_complete"));
				dto.setQuantity(rs.getInt("quantity"));
				System.out.println(dto);
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
	public OfferDTO selectOfferForClearing(OfferDTO offerDTO) {
		String SQL = "SELECT * FROM offers WHERE items_id = ? AND members_id = ? AND buy =false AND is_complete = true AND quantity = ? ORDER BY offers_id LIMIT 1";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		OfferDTO dto = new OfferDTO();
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, offerDTO.getItemsId());
			pstmt.setInt(2, offerDTO.getMembersId());
			pstmt.setInt(3,offerDTO.getQuantity());
			rs= pstmt.executeQuery();
			if(rs.next()) {
				dto.setItemsId(rs.getInt("items_id"));
				dto.setOffersId(rs.getInt("offers_id"));
				dto.setBuy(rs.getBoolean("buy"));
				dto.setMembersId(rs.getInt("members_id"));
				dto.setTimeStamp(rs.getTimestamp("time_stamp"));
				dto.setComplete(rs.getBoolean("is_complete"));
				dto.setQuantity(rs.getInt("quantity"));
				System.out.println(dto);
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
	public List<OfferDTO> selectOffersForIpo(int itemsId) {
		String SQL = "SELECT * FROM offers WHERE items_Id = ? AND buy = true AND is_complete=false";
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
				Timestamp timeStamp = rs.getTimestamp("time_stamp");
				listOffer.add(new OfferDTO(offersId, membersId, itemsId, buy, offerPrice, isComplete,
						quantity, timeStamp));
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
		return listOffer;
	}
	
	@Override
	public ResponseDTO deleteOffersForClearing(int itemsId) {
		String SQL = "delete FROM offers WHERE items_id = ? AND is_complete = false";
		PreparedStatement pstmt= null;
		Connection con= null;
		int rs = 0;
		ResponseDTO response=null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, itemsId);
			rs= pstmt.executeUpdate();
			if(rs != 0) {
				response = new ResponseDTO(1,rs+"개의 offer를 취소 시켰습니다.");
			}else {
				response = new ResponseDTO(0, "offer를 취소할 수 없었습니다..");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			response = new ResponseDTO(0, "offer를 취소할 수 없었습니다..");
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
				Timestamp timeStamp = rs.getTimestamp("time_stamp");
				listOffer.add(new OfferDTO(offersId, membersId, itemsId, buy, offerPrice, isComplete,
						quantity, timeStamp));
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
		return listOffer;
	}
	@Override
	public List<OfferDTO> selectOffersByPrice(int price) {
		String SQL = "SELECT * FROM offers WHERE offer_price = ? is_compelete = false";
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
				Timestamp timeStamp = rs.getTimestamp("time_stamp");
				listOffer.add(new OfferDTO(offersId, membersId, itemsId, buy, offerPrice, isComplete,
						quantity, timeStamp));
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
		return listOffer;
	}
	@Override
	public List<OfferDTO> selectOffersByItemsId(int itemsId) {
		String SQL = "SELECT * FROM offers WHERE items_id = ? is_compelete = false";
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
				Timestamp timeStamp = rs.getTimestamp("time_stamp");
				listOffer.add(new OfferDTO(offersId, membersId, itemsId, buy, offerPrice, isComplete,
						quantity, timeStamp));
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
		return listOffer;
	}
	

	@Override
	public List<OfferLogDTO> selectOffersByMembersId(int membersId) {
		String SQL = "SELECT * FROM offers LEFT JOIN items on offers.items_id = items.items_id WHERE members_id = ? AND is_complete = false";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		List<OfferLogDTO> listOffer = new ArrayList<OfferLogDTO>();
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int offersId = rs.getInt("offers_id");
				int itemsId = rs.getInt("items_id");
				String code = rs.getString("code");
				String name	= rs.getString("name");
				boolean buy = rs.getBoolean("buy");
				int offerPrice = rs.getInt("offer_price");
				int quantity = rs.getInt("quantity");
				Timestamp timeStamp = rs.getTimestamp("time_stamp");
				OfferLogDTO dto = new OfferLogDTO();
				dto.setBuy(buy);
				dto.setOfferPrice(offerPrice);
				dto.setOffersId(offersId);
				dto.setCode(code);
				dto.setName(name);
				dto.setTimeStamp(timeStamp);
				dto.setMembersId(membersId);
				dto.setItemsId(itemsId);	
				dto.setQuantity(quantity);
				listOffer.add(dto);
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
		return listOffer;
	}
	
	@Override
	public ResponseDTO insertNewOffer(OfferDTO dto) {
		String SQL = "INSERT INTO offers(members_id, items_id, buy, offer_price,"
				+ " quantity) value(?, ?, ?, ?, ?)";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResponseDTO response=null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getMembersId());
			pstmt.setInt(2, dto.getItemsId());
			pstmt.setBoolean(3, dto.isBuy());
			pstmt.setInt(4, dto.getOfferPrice());
			pstmt.setInt(5, dto.getQuantity());
			
			if(pstmt.executeUpdate()==1) {
				response= new ResponseDTO(1, "offer를 기록했습니다.");
			}else {
				response = new ResponseDTO(0,"offer 기록을 실패했습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			response = new ResponseDTO(0,"offer 기록을 실패했습니다.");
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
	public ResponseDTO insertOfferForClear(OfferDTO dto) {
		String SQL = "INSERT INTO offers(members_id, items_id, buy, offer_price,"
				+ " quantity, is_complete) value(?, ?, ?, ?, ?, true)";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResponseDTO response=null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getMembersId());
			pstmt.setInt(2, dto.getItemsId());
			pstmt.setBoolean(3, dto.isBuy());
			pstmt.setInt(4, dto.getOfferPrice());
			pstmt.setInt(5, dto.getQuantity());
			
			if(pstmt.executeUpdate()==1) {
				response= new ResponseDTO(1, "offer를 기록했습니다.");
			}else {
				response = new ResponseDTO(0,"offer 기록을 실패했습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			response = new ResponseDTO(0,"offer 기록을 실패했습니다.");
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
	public ResponseDTO insertOffer(OfferDTO dto) {
		String SQL = "INSERT INTO offers(members_id, items_id, buy, offer_price,"
				+ " quantity, time_stamp) value(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResponseDTO response=null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getMembersId());
			pstmt.setInt(2, dto.getItemsId());
			pstmt.setBoolean(3, dto.isBuy());
			pstmt.setInt(4, dto.getOfferPrice());
			pstmt.setInt(5, dto.getQuantity());
			pstmt.setTimestamp(6, dto.getTimeStamp());
			if(pstmt.executeUpdate()==1) {
				response= new ResponseDTO(1, "offer를 기록했습니다.");
			}else {
				response = new ResponseDTO(0,"offer 기록을 실패했습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			response = new ResponseDTO(0,"offer 기록을 실패했습니다.");
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
			if(pstmt.executeUpdate()==1) {
				response= new ResponseDTO(1, "offer를 삭제했습니다..");
			}else {
				response = new ResponseDTO(0,"offer 삭제에 실패했습니다..");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			response = new ResponseDTO(0,"offer 삭제에 실패했습니다..");
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
	public ResponseDTO updateCompeleteOffer(OfferDTO dto) {
		String SQL = "UPDATE offers SET is_complete= true WHERE offers_id = ?";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResponseDTO response=null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getOffersId());
			if(pstmt.executeUpdate()==1) {
				response= new ResponseDTO(1, "오퍼를 닫았습니다..");
			}else {
				response = new ResponseDTO(0,"오퍼 종결에 실패했습니다...");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			response = new ResponseDTO(0,"오퍼 종결에 실패했습니다...");
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
	public ResponseDTO updateOfferByTrade(OfferDTO dto) {
		String SQL = "UPDATE offers SET quantity= ?,is_complete= true WHERE offers_id = ?";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResponseDTO response=null;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dto.getQuantity());
			pstmt.setInt(2, dto.getOffersId());
			if(pstmt.executeUpdate()==1) {
				response= new ResponseDTO(1, "오퍼를 닫았습니다..");
			}else {
				response = new ResponseDTO(0,"오퍼 종결에 실패했습니다...");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			response = new ResponseDTO(0,"오퍼 종결에 실패했습니다...");
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
	public List<OffersListDTO> selectBuyOfferList(OfferDTO dto){
		String SQL = "SELECT * FROM offers WHERE items_id = ? AND is_complete=false AND buy=true ORDER BY offer_price DESC";
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
					basePrice =rs.getInt("offer_price"); 
				}
				offerList.add(offerDTO);
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
		return offerList;
	}
	@Override
	public List<OffersListDTO> selectSellOfferList(OfferDTO dto){
		String SQL = "SELECT * FROM offers WHERE items_id = ? AND is_complete=0 AND buy=false ORDER BY offer_price ASC";
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
					basePrice =rs.getInt("offer_price"); 
				}
				offerList.add(offerDTO);
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
		return offerList;
	}
	
	@Override
	public int checkEnoughBalance(int membersId){
		String SQL = "SELECT * FROM offers WHERE members_id = ? AND is_complete=false AND buy=true";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		int moneyToBuy=0;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int price = rs.getInt("offer_price");
				int quantity = rs.getInt("quantity");
				moneyToBuy += price*quantity;
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
		return moneyToBuy;
	}

	@Override
	public int checkOfferedQuantity(int membersId, int itemsId) {
		String SQL = "SELECT * FROM offers WHERE members_id = ? AND is_complete=false AND buy=false AND items_id = ?";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		int offeredQuantity=0;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, itemsId);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int quantity = rs.getInt("quantity");
				offeredQuantity += quantity;
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
		return offeredQuantity;
	}

	@Override
	public int checkQuantityBalance(int itemsId) {
		String SQL = "SELECT * FROM offers WHERE is_complete=false AND buy=true AND items_id = ?";
		PreparedStatement pstmt= null;
		Connection con= null;
		ResultSet rs = null;
		int offeredQuantity=0;
		try {
			con = db.connect();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, itemsId);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int quantity = rs.getInt("quantity");
				offeredQuantity += quantity;
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
		return offeredQuantity;
	}
}
