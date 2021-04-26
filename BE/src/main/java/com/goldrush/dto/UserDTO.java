package com.goldrush.dto;

public class UserDTO {
	private String id;
	private String name;
	private String tokeon;
	private String balance;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTokeon() {
		return tokeon;
	}
	public void setToken(String tokeon) {
		this.tokeon = tokeon;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", token=" + tokeon + ", balance=" + balance + "]";
	}
}
