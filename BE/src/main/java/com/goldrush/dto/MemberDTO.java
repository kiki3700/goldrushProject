package com.goldrush.dto;

public class MemberDTO {
	private int membersId;
	private String userId;
	private String name;
	private String password;
	
	
	public MemberDTO() {
		super();
	}
	public MemberDTO(int membersId, String userId, String name, String password) {
		super();
		this.membersId = membersId;
		this.userId = userId;
		this.name = name;
		this.password = password;
	}
	
	public int getMembersId() {
		return membersId;
	}
	public void setMembersId(int membersId) {
		this.membersId = membersId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	@Override
	public String toString() {
		return "MemberDTO [membersId=" + membersId + ", userId=" + userId + ", name=" + name + ", password=" + password
				+ "]";
	}
}
