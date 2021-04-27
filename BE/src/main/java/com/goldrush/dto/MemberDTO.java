package com.goldrush.dto;

public class MemberDTO {
	private int membersId;
	private String usersId;
	private String name;
	private String password;
	
	public MemberDTO() {

	}
	
	public MemberDTO(int membersId, String usersId, String name, String password) {
		super();
		this.membersId = membersId;
		this.usersId = usersId;
		this.name = name;
		this.password = password;
	}
	
	//getter setter
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
	@Override
	public String toString() {
		return "MemberDTO [membersId=" + membersId + ", usersId=" + usersId + ", name=" + name + ", password="
				+ password + "]";
	}
	
	
	
}
