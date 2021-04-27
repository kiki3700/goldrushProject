package com.goldrush.dto;

public class MemberDTO {
	private int membersId;
	private String usersId;
	private String name;
	private String password;
	private int balance;
	
	public MemberDTO() {

	}
	
	public MemberDTO(int membersId, String usersId, String name, String password, int balance) {
		super();
		this.membersId = membersId;
		this.usersId = usersId;
		this.name = name;
		this.password = password;
		this.balance = balance;
	}
	
	public int getMembersId() {
		return membersId;
	}
	public void setMembersId(int membersId) {
		this.membersId = membersId;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [membersId=" + membersId + ", usersId=" + usersId + ", name=" + name + ", password="
				+ password + ", balance=" + balance + "]";
	}
	
}
