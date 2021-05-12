package com.goldrush.dto.accountDto;

import java.util.List;

public class RequestDeposit {
	private String cntr_account_type="N";
	private String cntrt_account_num="100000000001";
	private String wd_pass_phrase="None";
	private String wd_print_content ="골드러쉬 입금요청";
	private String name_check_option="on";
	private String tran_dtime;
	private String req_cont="1";
	private List<DepositReqList> req_list;
	
	public String getCntr_account_type() {
		return cntr_account_type;
	}
	public void setCntr_account_type(String cntr_account_type) {
		this.cntr_account_type = cntr_account_type;
	}
	public String getCntrt_account_num() {
		return cntrt_account_num;
	}
	public void setCntrt_account_num(String cntrt_account_num) {
		this.cntrt_account_num = cntrt_account_num;
	}
	public String getWd_pass_phrase() {
		return wd_pass_phrase;
	}
	public void setWd_pass_phrase(String wd_pass_phrase) {
		this.wd_pass_phrase = wd_pass_phrase;
	}
	public String getWd_print_content() {
		return wd_print_content;
	}
	public void setWd_print_content(String wd_print_content) {
		this.wd_print_content = wd_print_content;
	}
	public String getName_check_option() {
		return name_check_option;
	}
	public void setName_check_option(String name_check_option) {
		this.name_check_option = name_check_option;
	}
	public String getTran_dtime() {
		return tran_dtime;
	}
	public void setTran_dtime(String tran_dtime) {
		this.tran_dtime = tran_dtime;
	}
	public String getReq_cont() {
		return req_cont;
	}
	public void setReq_cont(String req_cont) {
		this.req_cont = req_cont;
	}

	public List<DepositReqList> getReq_list() {
		return req_list;
	}
	public void setReq_list(List<DepositReqList> req_list) {
		this.req_list = req_list;
	}
	@Override
	public String toString() {
		return "RequestDeposit [cntr_account_type=" + cntr_account_type + ", cntrt_account_num=" + cntrt_account_num
				+ ", wd_pass_phrase=" + wd_pass_phrase + ", wd_print_content=" + wd_print_content
				+ ", name_check_option=" + name_check_option + ", tran_dtime=" + tran_dtime + ", req_cont=" + req_cont
				+ ", req_list=" + req_list + "]";
	}
	
}


