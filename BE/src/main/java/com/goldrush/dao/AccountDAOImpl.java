package com.goldrush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	//잔액 조회
	@Override
	public int selectBalacne(int members_id) {
		ResultSet rs= null;
		int balance =0;
		String SQL = "select balance from accounts WHERE members_id=? order time_stamp desc limit 1";
		try(Connection con = db.connect()){
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
		return balance;
	}
	
	//계좌 로그 확인
	@Override
	public List<AccountDTO> selectAccountLog(int membersId){
		ResultSet rs = null;
		List<AccountDTO> listAccount = new ArrayList<AccountDTO>();
		String SQL = "select * from accounts where members_id = ?";
		try(Connection con = db.connect()){
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
			int accountsId = rs.getInt("accounts_id");
			String action = rs.getString("action");
			int amount = rs.getInt("amount");
			int balance = rs.getInt("balance");
			listAccount.add(new AccountDTO(accountsId, action, membersId, amount, balance));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAccount;
	}
	
	//팔때
	@Override
	public int insertSellResult(int membersId, int amount, int balance) {
		String SQL = "INSERT accounts(action, members_id, amount, balance) values('sell', ?, ?, ?)";
		int result=0;
		try(Connection con = db.connect()){
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, balance);
			if(pstmt.execute()) result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//살때
	@Override
	public int insertBuyResult(int membersId, int amount, int balance) {
		String SQL = "INSERT accounts(action, members_id, amount, balance) values('buy', ?, ?, ?)";
		int result=0;
		try(Connection con = db.connect()){
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, balance);
			if(pstmt.execute()) result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//IPO
	@Override
	public int insertIpoResult(int membersId, int amount, int balance) {
		String SQL = "INSERT accounts(action, members_id, amount, balance) values('IPO', ?, ?, ?)";
		int result=0;
		try(Connection con = db.connect()){
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, balance);
			if(pstmt.execute()) result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//청산시
	@Override
	public int insertClearingResult(int membersId, int amount, int balance) {
		String SQL = "INSERT accounts(action, members_id, amount, balance) values('clearing', ?, ?, ?)";
		int result=0;
		try(Connection con = db.connect()){
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, balance);
			if(pstmt.execute()) result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//수수료부과
	@Override
	public int insertFeeResult(int membersId, int amount, int balance) {
		String SQL = "INSERT accounts(action, members_id, amount, balance) values('fee', ?, ?, ?)";
		int result=0;
		try(Connection con = db.connect()){
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, balance);
			if(pstmt.execute()) result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	//입금
	@Override
	public int insertDepositResult(int membersId, int amount, int balance) {
		String SQL = "INSERT accounts(action, members_id, amount, balance) values('deposit', ?, ?, ?)";
		int result=0;
		try(Connection con = db.connect()){
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, balance);
			if(pstmt.execute()) result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//withdraw
	@Override
	public int insertWithdrawResult(int membersId, int amount, int balance) {
		String SQL = "INSERT accounts(action, members_id, amount, balance) values('withdraw', ?, ?, ?)";
		int result=0;
		try(Connection con = db.connect()){
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, membersId);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, balance);
			if(pstmt.execute()) result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
