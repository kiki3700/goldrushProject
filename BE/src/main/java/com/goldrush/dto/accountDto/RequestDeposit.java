package com.goldrush.dto.accountDto;

import java.util.List;

public class RequestDeposit {
	private String cntr_account_type="N";
	private String cntrt_account_num;
	private String wd_pass_phrase="None";
	private String wd_print_content ="골드러쉬 입금요청";
	private String name_check_option="on";
	private String tran_dtime;
	private String req_cont="1";
	private List<ReqList> req_list;
	
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
	public List<ReqList> getReq_list() {
		return req_list;
	}
	public void setReq_list(List<ReqList> req_list) {
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
class ReqList{
	private String tran_no;
	private String bank_tran_id;
	private String fintech_use_num;
	private String print_content="골드러쉬 입금요청";
	private String tran_amt;
	private String req_client_name;
	private String req_client_fintech_use_num;
	private String req_client_num;
	private String transfer_purpose="TR";
	
	public String getTran_no() {
		return tran_no;
	}

	public void setTran_no(String tran_no) {
		this.tran_no = tran_no;
	}

	public String getBank_tran_id() {
		return bank_tran_id;
	}

	public void setBank_tran_id(String bank_tran_id) {
		this.bank_tran_id = bank_tran_id;
	}

	public String getFintech_use_num() {
		return fintech_use_num;
	}

	public void setFintech_use_num(String fintech_use_num) {
		this.fintech_use_num = fintech_use_num;
	}

	public String getPrint_content() {
		return print_content;
	}

	public void setPrint_content(String print_content) {
		this.print_content = print_content;
	}

	public String getTran_amt() {
		return tran_amt;
	}

	public void setTran_amt(String tran_amt) {
		this.tran_amt = tran_amt;
	}

	public String getReq_client_name() {
		return req_client_name;
	}

	public void setReq_client_name(String req_client_name) {
		this.req_client_name = req_client_name;
	}

	public String getReq_client_fintech_use_num() {
		return req_client_fintech_use_num;
	}

	public void setReq_client_fintech_use_num(String req_client_fintech_use_num) {
		this.req_client_fintech_use_num = req_client_fintech_use_num;
	}

	public String getReq_client_num() {
		return req_client_num;
	}

	public void setReq_client_num(String req_client_num) {
		this.req_client_num = req_client_num;
	}

	public String getTransfer_purpose() {
		return transfer_purpose;
	}

	public void setTransfer_purpose(String transfer_purpose) {
		this.transfer_purpose = transfer_purpose;
	}

	@Override
	public String toString() {
		return "ReqList [tran_no=" + tran_no + ", bank_tran_id=" + bank_tran_id + ", fintech_use_num=" + fintech_use_num
				+ ", print_content=" + print_content + ", tran_amt=" + tran_amt + ", req_client_name=" + req_client_name
				+ ", req_client_fintech_use_num=" + req_client_fintech_use_num + ", req_client_num=" + req_client_num
				+ ", transfer_purpose=" + transfer_purpose + "]";
	}
}
