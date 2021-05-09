package com.goldrush.dto.accountDto;

public class RequestWithdraw {
	private String bank_tran_id="M202112022";
	private String cntr_account_type ="N";
	private String cntr_account_num ="100000000001";
	private String dps_print_content; //MembersId + withdraw
	private String fintech_use_num; //출금계좌 핀테크 이용번호
	private String wd_print_content ="골드러쉬 입급";
	private String tran_amt;  
	private String tran_dtime;
	private String req_client_name;
	private String req_client_fintech_use_num; // 핀테크 이용번호
	private String req_client_num;
	private String transfer_purpose="TR";
   private String recv_client_name= "이성현";
   private String recv_client_bank_code="097";
   private String recv_client_account_num= "100000000001";
public String getBank_tran_id() {
	return bank_tran_id;
}
public void setBank_tran_id(String bank_tran_id) {
	this.bank_tran_id = bank_tran_id;
}
public String getCntr_account_type() {
	return cntr_account_type;
}
public void setCntr_account_type(String cntr_account_type) {
	this.cntr_account_type = cntr_account_type;
}
public String getCntr_account_num() {
	return cntr_account_num;
}
public void setCntr_account_num(String cntr_account_num) {
	this.cntr_account_num = cntr_account_num;
}
public String getDps_print_content() {
	return dps_print_content;
}
public void setDps_print_content(String dps_print_content) {
	this.dps_print_content = dps_print_content;
}
public String getFintech_use_num() {
	return fintech_use_num;
}
public void setFintech_use_num(String fintech_use_num) {
	this.fintech_use_num = fintech_use_num;
}
public String getWd_print_content() {
	return wd_print_content;
}
public void setWd_print_content(String wd_print_content) {
	this.wd_print_content = wd_print_content;
}
public String getTran_amt() {
	return tran_amt;
}
public void setTran_amt(String tran_amt) {
	this.tran_amt = tran_amt;
}
public String getTran_dtime() {
	return tran_dtime;
}
public void setTran_dtime(String tran_dtime) {
	this.tran_dtime = tran_dtime;
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
public String getRecv_client_name() {
	return recv_client_name;
}
public void setRecv_client_name(String recv_client_name) {
	this.recv_client_name = recv_client_name;
}
public String getRecv_client_bank_code() {
	return recv_client_bank_code;
}
public void setRecv_client_bank_code(String recv_client_bank_code) {
	this.recv_client_bank_code = recv_client_bank_code;
}
public String getRecv_client_account_num() {
	return recv_client_account_num;
}
public void setRecv_client_account_num(String recv_client_account_num) {
	this.recv_client_account_num = recv_client_account_num;
}
@Override
public String toString() {
	return "RequestWithdraw [bank_tran_id=" + bank_tran_id + ", cntr_account_type=" + cntr_account_type
			+ ", cntr_account_num=" + cntr_account_num + ", dps_print_content=" + dps_print_content
			+ ", fintech_use_num=" + fintech_use_num + ", wd_print_content=" + wd_print_content + ", tran_amt="
			+ tran_amt + ", tran_dtime=" + tran_dtime + ", req_client_name=" + req_client_name
			+ ", req_client_fintech_use_num=" + req_client_fintech_use_num + ", req_client_num=" + req_client_num
			+ ", transfer_purpose=" + transfer_purpose + ", recv_client_name=" + recv_client_name
			+ ", recv_client_bank_code=" + recv_client_bank_code + ", recv_client_account_num="
			+ recv_client_account_num + "]";
}
public String getReq_client_name() {
	return req_client_name;
}
public void setReq_client_name(String req_client_name) {
	this.req_client_name = req_client_name;
}

	
}
