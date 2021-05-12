package com.goldrush.dto;

import java.sql.Timestamp;

public class AccountDTO {
	private int accountsId;
	private String action;
	private int membersId;
	private int amount;
	private int balance;
	private Timestamp timestamp;
	
	public int getAccountsId() {
		return accountsId;
	}
	public void setAccountsId(int accountsId) {
		this.accountsId = accountsId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getMembersId() {
		return membersId;
	}
	public void setMembersId(int membersId) {
		this.membersId = membersId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "AccountDTO [accountsId=" + accountsId + ", action=" + action + ", membersId=" + membersId + ", amount="
				+ amount + ", balance=" + balance + ", timestamp=" + timestamp + "]";
	}
	
	
	
}
