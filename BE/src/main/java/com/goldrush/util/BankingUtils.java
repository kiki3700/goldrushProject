package com.goldrush.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.goldrush.dao.AccountDAO;
import com.goldrush.dao.AccountDAOImpl;
import com.goldrush.dao.DBHandler;

public class BankingUtils {
	private final String user_id = "M202112022";
	private String bank_tran_id;
	AccountDAO dao;
	public BankingUtils(){
		dao = new AccountDAOImpl(new DBHandler());
		this.bank_tran_id = getUser_id()+"U"+String.format("%09d", dao.selectCount()+1);

	}
	
	public String getBank_tran_id() {
		return bank_tran_id;
	}
	public void setBank_tran_id() {

	}
	public String getUser_id() {
		return user_id;
	}
	public static String getTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		return now.format(formatter);
	}

}
