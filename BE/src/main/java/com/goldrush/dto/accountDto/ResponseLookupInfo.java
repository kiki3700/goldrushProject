package com.goldrush.dto.accountDto;

import java.util.List;

public class ResponseLookupInfo {
	private String api_tran_id;
	private String api_tran_dtm;
	private String rsp_code;
	private String rsp_message;
	private String user_seq_no;
	private String user_ci;
	private String user_name;
	private String res_cnt;
	private List<LookupResList> res_list;
	
	
	public String getApi_tran_id() {
		return api_tran_id;
	}


	public void setApi_tran_id(String api_tran_id) {
		this.api_tran_id = api_tran_id;
	}


	public String getApi_tran_dtm() {
		return api_tran_dtm;
	}


	public void setApi_tran_dtm(String api_tran_dtm) {
		this.api_tran_dtm = api_tran_dtm;
	}


	public String getRsp_code() {
		return rsp_code;
	}


	public void setRsp_code(String rsp_code) {
		this.rsp_code = rsp_code;
	}


	public String getRsp_message() {
		return rsp_message;
	}


	public void setRsp_message(String rsp_message) {
		this.rsp_message = rsp_message;
	}


	public String getUser_seq_no() {
		return user_seq_no;
	}


	public void setUser_seq_no(String user_seq_no) {
		this.user_seq_no = user_seq_no;
	}


	public String getUser_ci() {
		return user_ci;
	}


	public void setUser_ci(String user_ci) {
		this.user_ci = user_ci;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getRes_cnt() {
		return res_cnt;
	}


	public void setRes_cnt(String res_cnt) {
		this.res_cnt = res_cnt;
	}


	public List<LookupResList> getRes_list() {
		return res_list;
	}


	public void setRes_list(List<LookupResList> res_list) {
		this.res_list = res_list;
	}


	@Override
	public String toString() {
		return "ResponseLookupInfo [api_tran_id=" + api_tran_id + ", api_tran_dtm=" + api_tran_dtm + ", rsp_code="
				+ rsp_code + ", rsp_message=" + rsp_message + ", user_seq_no=" + user_seq_no + ", user_ci=" + user_ci
				+ ", user_name=" + user_name + ", res_cnt=" + res_cnt + ", res_list=" + res_list + "]";
	}

	
}

