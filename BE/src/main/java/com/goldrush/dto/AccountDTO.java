package com.goldrush.dto;

public class AccountDTO {
	private int accountsId;
	private String action;
	private int membersId;
	private int amount;
	private int balance;
	
	public AccountDTO() {
		super();
	}
	public AccountDTO(int accountsId, String action, int membersId, int amount, int balance) {
		super();
		this.accountsId = accountsId;
		this.action = action;
		this.membersId = membersId;
		this.amount = amount;
		this.balance = balance;
	}
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
	
	@Override
	public String toString() {
		return "AccountDTO [accountsId=" + accountsId + ", action=" + action + ", membersId=" + membersId + ", amount="
				+ amount + ", balance=" + balance + "]";
	}
}
