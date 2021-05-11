package com.goldrush.dto.accountDto;

import java.util.List;

public class ResponseDeposit {
	private String api_tran_id;
	private String api_tran_dtm;
	private String rsp_code;
	private String rsp_message;
	private String wd_bank_code_std;
	private String wd_bank_code_sub;
	private String wd_bank_name;
	private String wd_account_num_masked;
	private String wd_print_content;
	private String wd_account_holder_name;
	private String res_cnt;
	private List<ResList2> res_list;
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
	public String getWd_bank_code_std() {
		return wd_bank_code_std;
	}
	public void setWd_bank_code_std(String wd_bank_code_std) {
		this.wd_bank_code_std = wd_bank_code_std;
	}
	public String getWd_bank_code_sub() {
		return wd_bank_code_sub;
	}
	public void setWd_bank_code_sub(String wd_bank_code_sub) {
		this.wd_bank_code_sub = wd_bank_code_sub;
	}
	public String getWd_bank_name() {
		return wd_bank_name;
	}
	public void setWd_bank_name(String wd_bank_name) {
		this.wd_bank_name = wd_bank_name;
	}
	public String getWd_account_num_masked() {
		return wd_account_num_masked;
	}
	public void setWd_account_num_masked(String wd_account_num_masked) {
		this.wd_account_num_masked = wd_account_num_masked;
	}
	public String getWd_print_content() {
		return wd_print_content;
	}
	public void setWd_print_content(String wd_print_content) {
		this.wd_print_content = wd_print_content;
	}
	public String getWd_account_holder_name() {
		return wd_account_holder_name;
	}
	public void setWd_account_holder_name(String wd_account_holder_name) {
		this.wd_account_holder_name = wd_account_holder_name;
	}
	public String getRes_cnt() {
		return res_cnt;
	}
	public void setRes_cnt(String res_cnt) {
		this.res_cnt = res_cnt;
	}
	
	public List<ResList2> getRes_list() {
		return res_list;
	}
	public void setRes_list(List<ResList2> res_list) {
		this.res_list = res_list;
	}
	@Override
	public String toString() {
		return "ResponseDeposit [api_tran_id=" + api_tran_id + ", api_tran_dtm=" + api_tran_dtm + ", rsp_code="
				+ rsp_code + ", rsp_message=" + rsp_message + ", wd_bank_code_std=" + wd_bank_code_std
				+ ", wd_bank_code_sub=" + wd_bank_code_sub + ", wd_bank_name=" + wd_bank_name
				+ ", wd_account_num_masked=" + wd_account_num_masked + ", wd_print_content=" + wd_print_content
				+ ", wd_account_holder_name=" + wd_account_holder_name + ", res_cnt=" + res_cnt + ", res_list="
				+ res_list + "]";
	}

}
class ResList2{
	private String tran_no;
	private String bank_tran_id;
	private String bank_tran_date;
	private String bank_code_tran;
	private String bank_rsp_code;
	private String bank_rsp_message;
	private String fintech_use_num;
	private String account_alias;
	private String bank_code_std;
	private String bank_code_sub;
	private String bank_name;
	private String savings_bank_name;
	private String account_num_masked;
	private String print_content;
	private String account_holder_name;
	private String tran_amt;
	private String cms_num;
	
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

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
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

	public String getCms_num() {
		return cms_num;
	}

	public void setCms_num(String cms_num) {
		this.cms_num = cms_num;
	}

	@Override
	public String toString() {
		return "ResList2 [tran_no=" + tran_no + ", bank_tran_id=" + bank_tran_id + ", bank_tran_date=" + bank_tran_date
				+ ", bank_code_tran=" + bank_code_tran + ", bank_rsp_code=" + bank_rsp_code + ", bank_rsp_message="
				+ bank_rsp_message + ", fintech_use_num=" + fintech_use_num + ", account_alias=" + account_alias
				+ ", bank_code_std=" + bank_code_std + ", bank_code_sub=" + bank_code_sub + ", bank_name=" + bank_name
				+ ", savings_bank_name=" + savings_bank_name + ", account_num_masked=" + account_num_masked
				+ ", print_content=" + print_content + ", account_holder_name=" + account_holder_name + ", tran_amt="
				+ tran_amt + ", cms_num=" + cms_num + "]";
	}
	
}
