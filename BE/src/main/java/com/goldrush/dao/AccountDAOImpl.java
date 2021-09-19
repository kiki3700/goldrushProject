package com.goldrush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;


import com.goldrush.dto.AccountDTO;

public class AccountDAOImpl implements AccountDAO{
	DB db;

	public AccountDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDAOImpl(DB db) {
		this.db = db;
	}
	public DB getDb() {
		return db;
	}
	public void setDb(DB db) {
		this.db = db;
	}
	//
	@Override
	public int selectCount() {
		String SQL = "select COUNT(*) as count FROM accounts"
				+ " WHERE time_stamp>=CURDATE() "
				+ "AND action='deposit' OR action='withdraw'";
		Statement stmt=null;
		ResultSet rs = null;
		Connection con =db.connect();
		int count=0;
		try {
			stmt=con.createStatement();
			rs= stmt.executeQuery(SQL);
			if(rs.next()) count=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return count;
	}
	
	//잔액 조회
	@Override
	public int selectBalacne(int members_id) {
		ResultSet rs= null;
		int balance =0;
		String SQL = "select SUM(amount) AS balance FROM accounts WHERE members_id=?;";
		Connection con =db.connect();
		try{
		
			PreparedStatement pstmt =  con.prepareStatement(SQL);
			pstmt.setInt(1, members_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				balance = rs.getInt("balance");
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
		return balance;
	}
	//이거 썸 붙여야함
	//계좌 로그 확인
	@Override
	public List<AccountDTO> selectAccountLog(int membersId){
		ResultSet rs = null;
		List<AccountDTO> listAccount = new ArrayList<AccountDTO>();
		String SQL = "select * FROM accounts where members_id = ?";
		Connection con = db.connect();
		try{
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			rs=pstmt.executeQuery();
			int amount=0;
			int balance=0;
			while(rs.next()) {
			AccountDTO dto = new AccountDTO();
			dto.setAccountsId(rs.getInt("accounts_id"));
			dto.setAction(rs.getString("action"));
			dto.setAmount(rs.getInt("amount"));
			amount=rs.getInt("amount");
			balance += amount;
			dto.setMembersId(membersId);
			dto.setBalance(balance);
			dto.setTimestamp(rs.getTimestamp("time_stamp"));
			listAccount.add(dto);
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
		return listAccount;
	}
	
	//팔때
	@Override
	public int insertSellResult(int membersId, int amount) {
		String SQL = "INSERT accounts(action, members_id, amount) values('sell', ?, ?)";
		int result=0;
		Connection con = db.connect();
		try{
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			if(pstmt.execute()) result=1;
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
		return result;
	}
	
	//살때
	@Override
	public int insertBuyResult(int membersId, int amount) {
		String SQL = "INSERT accounts(action, members_id, amount) values('buy', ?, ?)";
		int result=0;
		Connection con = db.connect();
		try{
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			if(pstmt.execute()) result=1;
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
		return result;
	}
	
	//IPO
	@Override
	public int insertIpoResult(int membersId, int amount) {
		String SQL = "INSERT accounts(action, members_id, amount) values('IPO', ?, ?)";
		int result=0;
		int rs=0;
		Connection con = db.connect();
		try{
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			rs= pstmt.executeUpdate();
			if(rs==1) {
			result=1;
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
		return result;
	}
	
	//청산시
	@Override
	public int insertClearingResult(int membersId, int amount) {
		String SQL = "INSERT accounts(action, members_id, amount) values('clearing', ?, ?)";
		int result=0;
		Connection con = db.connect();
		try{
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			if(pstmt.execute()) result=1;
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
		return result;
	}
	
	//수수료부과

	@Override
	public int insertFeeResult(int membersId, int amount) {
		String SQL = "INSERT accounts(action, members_id, amount) values('fee', ?, ?)";
		int result=0;
		Connection con = db.connect();
		try{
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			if(pstmt.execute()) result=1;
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
		return result;
	}
	
	
	//입금
	@Override
	public int insertDepositResult(int membersId, int amount) {
		String SQL = "INSERT accounts(action, members_id, amount) values('deposit', ?, ?)";
		int result=0;
		Connection con = db.connect();
		try{
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			if(pstmt.execute()) result=1;
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
		return result;
	}
	
	//withdraw
	@Override
	public int insertWithdrawResult(int membersId, int amount) {
		String SQL = "INSERT accounts(action, members_id, amount) values('withdraw', ?, ?)";
		int result=0;
		Connection con = db.connect();
		try{
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			if(pstmt.execute()) result=1;
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
		return result;
	}
	@Override
	public int selectTranId() {
		String SQL = "select count(*) as count from tran_ids WHERE time_stamp>=CURDATE()";
		Statement stmt = null;
		ResultSet rs =null;
		Connection con = db.connect();
		int count=0;
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(SQL);
			if(rs.next()) {
				count = rs.getInt("count");
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
		return count;	
	}
	@Override
	public void insertTranIds() {
		String SQL ="INSERT tran_ids() values()";
		Statement stmt = null;
		int rs = 0;
		Connection con = db.connect();
		try {
			stmt=con.createStatement();
			rs=stmt.executeUpdate(SQL);
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
	}

}
