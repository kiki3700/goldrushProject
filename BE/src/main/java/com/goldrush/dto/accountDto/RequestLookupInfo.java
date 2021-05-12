package com.goldrush.dto.accountDto;

public class RequestLookupInfo {
	private String user_seq_no;

	public String getUser_seq_no() {
		return user_seq_no;
	}

	public void setUser_seq_no(String user_seq_no) {
		this.user_seq_no = user_seq_no;
	}

	@Override
	public String toString() {
		return "RequestLookupInfo [user_seq_no=" + user_seq_no + "]";
	}
}
