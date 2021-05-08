package com.goldrush.dto.accountDto;

public class RequestWithdraw {
	private String bank_tran_id="M202112022";
	private String cntr_account_type ="N";
	private String cntr_account_num ="300000000001";
	private String dps_print_content; //MembersId + withdraw
	private String fintech_use_num; //출금계좌 핀테크 이용번호
	private String wd_print_content ="골드러쉬 입급";
	private String tran_amt;  
	private String tran_dtime;
	private String req_client_fintech_use_num; // 핀테크 이용번호
	private String req_client_num;
	private String transfer_purpose;
	
	
}
