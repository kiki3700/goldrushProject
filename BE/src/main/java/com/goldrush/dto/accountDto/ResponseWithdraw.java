package com.goldrush.dto.accountDto;

public class ResponseWithdraw {
	private String api_tran_id;
	private String api_tran_dtm;
	private String rsp_code;
	private String rsp_message;
	private String dps_bank_code_std;
	private String dps_bank_code_sub;
	private String dps_bank_name;
	private String dps_account_num_masked;
	private String dps_print_content;
	private String dps_account_holder_name;
	private String bank_tran_id;
	private String bank_tran_date;
	private String bank_code_tran;
	private String bank_rsp_code;
	private String bank_rsp_message;
	private String fintech_use_num;
	private String account_alias;
	private String bank_code_std;
	private String bank_code_sub;
	private String savings_bank_name;
	private String account_num_masked;
	private String print_content;
	private String account_holder_name;
	private String tran_amt;
	private String wd_limit_remain_amt;
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
	public String getDps_bank_code_std() {
		return dps_bank_code_std;
	}
	public void setDps_bank_code_std(String dps_bank_code_std) {
		this.dps_bank_code_std = dps_bank_code_std;
	}
	public String getDps_bank_code_sub() {
		return dps_bank_code_sub;
	}
	public void setDps_bank_code_sub(String dps_bank_code_sub) {
		this.dps_bank_code_sub = dps_bank_code_sub;
	}
	public String getDps_bank_name() {
		return dps_bank_name;
	}
	public void setDps_bank_name(String dps_bank_name) {
		this.dps_bank_name = dps_bank_name;
	}
	public String getDps_account_num_masked() {
		return dps_account_num_masked;
	}
	public void setDps_account_num_masked(String dps_account_num_masked) {
		this.dps_account_num_masked = dps_account_num_masked;
	}
	public String getDps_print_content() {
		return dps_print_content;
	}
	public void setDps_print_content(String dps_print_content) {
		this.dps_print_content = dps_print_content;
	}
	public String getDps_account_holder_name() {
		return dps_account_holder_name;
	}
	public void setDps_account_holder_name(String dps_account_holder_name) {
		this.dps_account_holder_name = dps_account_holder_name;
	}
	public String getBank_tran_id() {
		return bank_tran_id;
	}
	public void setBank_tran_id(String bank_tran_id) {
		this.bank_tran_id = bank_tran_id;
	}
	public String getBank_tran_date() {
		return bank_tran_date;
	}
	public void setBank_tran_date(String bank_tran_date) {
		this.bank_tran_date = bank_tran_date;
	}
	public String getBank_code_tran() {
		return bank_code_tran;
	}
	public void setBank_code_tran(String bank_code_tran) {
		this.bank_code_tran = bank_code_tran;
	}
	public String getBank_rsp_code() {
		return bank_rsp_code;
	}
	public void setBank_rsp_code(String bank_rsp_code) {
		this.bank_rsp_code = bank_rsp_code;
	}
	public String getBank_rsp_message() {
		return bank_rsp_message;
	}
	public void setBank_rsp_message(String bank_rsp_message) {
		this.bank_rsp_message = bank_rsp_message;
	}
	public String getFintech_use_num() {
		return fintech_use_num;
	}
	public void setFintech_use_num(String fintech_use_num) {
		this.fintech_use_num = fintech_use_num;
	}
	public String getAccount_alias() {
		return account_alias;
	}
	public void setAccount_alias(String account_alias) {
		this.account_alias = account_alias;
	}
	public String getBank_code_std() {
		return bank_code_std;
	}
	public void setBank_code_std(String bank_code_std) {
		this.bank_code_std = bank_code_std;
	}
	public String getBank_code_sub() {
		return bank_code_sub;
	}
	public void setBank_code_sub(String bank_code_sub) {
		this.bank_code_sub = bank_code_sub;
	}
	public String getSavings_bank_name() {
		return savings_bank_name;
	}
	public void setSavings_bank_name(String savings_bank_name) {
		this.savings_bank_name = savings_bank_name;
	}
	public String getAccount_num_masked() {
		return account_num_masked;
	}
	public void setAccount_num_masked(String account_num_masked) {
		this.account_num_masked = account_num_masked;
	}
	public String getPrint_content() {
		return print_content;
	}
	public void setPrint_content(String print_content) {
		this.print_content = print_content;
	}
	public String getAccount_holder_name() {
		return account_holder_name;
	}
	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}
	public String getTran_amt() {
		return tran_amt;
	}
	public void setTran_amt(String tran_amt) {
		this.tran_amt = tran_amt;
	}
	public String getWd_limit_remain_amt() {
		return wd_limit_remain_amt;
	}
	public void setWd_limit_remain_amt(String wd_limit_remain_amt) {
		this.wd_limit_remain_amt = wd_limit_remain_amt;
	}
	@Override
	public String toString() {
		return "ResponseWithdraw [api_tran_id=" + api_tran_id + ", api_tran_dtm=" + api_tran_dtm + ", rsp_code="
				+ rsp_code + ", rsp_message=" + rsp_message + ", dps_bank_code_std=" + dps_bank_code_std
				+ ", dps_bank_code_sub=" + dps_bank_code_sub + ", dps_bank_name=" + dps_bank_name
				+ ", dps_account_num_masked=" + dps_account_num_masked + ", dps_print_content=" + dps_print_content
				+ ", dps_account_holder_name=" + dps_account_holder_name + ", bank_tran_id=" + bank_tran_id
				+ ", bank_tran_date=" + bank_tran_date + ", bank_code_tran=" + bank_code_tran + ", bank_rsp_code="
				+ bank_rsp_code + ", bank_rsp_message=" + bank_rsp_message + ", fintech_use_num=" + fintech_use_num
				+ ", account_alias=" + account_alias + ", bank_code_std=" + bank_code_std + ", bank_code_sub="
				+ bank_code_sub + ", savings_bank_name=" + savings_bank_name + ", account_num_masked="
				+ account_num_masked + ", print_content=" + print_content + ", account_holder_name="
				+ account_holder_name + ", tran_amt=" + tran_amt + ", wd_limit_remain_amt=" + wd_limit_remain_amt + "]";
	}
	
}
