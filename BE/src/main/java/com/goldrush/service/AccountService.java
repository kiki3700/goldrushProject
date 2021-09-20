package com.goldrush.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.goldrush.dao.AccountDAO;
import com.goldrush.dao.InventoryDAO;
import com.goldrush.dao.MemberDAO;
import com.goldrush.dao.OfferDAO;
import com.goldrush.dao.TradeDAO;
import com.goldrush.dto.accountDto.DepositReqList;
import com.goldrush.dto.accountDto.LookupResList;
import com.goldrush.dto.accountDto.RequestDeposit;
import com.goldrush.dto.accountDto.RequestLookupInfo;
import com.goldrush.dto.accountDto.RequestOAuth3legger;
import com.goldrush.dto.accountDto.RequestToken2legger;
import com.goldrush.dto.accountDto.RequestToken3legger;
import com.goldrush.dto.accountDto.RequestWithdraw;
import com.goldrush.dto.accountDto.ResponseDeposit;
import com.goldrush.dto.accountDto.ResponseLookupInfo;
import com.goldrush.dto.accountDto.ResponseToken2legger;
import com.goldrush.dto.accountDto.ResponseToken3legger;
import com.goldrush.dto.accountDto.ResponseWithdraw;
import com.goldrush.util.BankingUtils;
@Transactional
public class AccountService {
	private AccountDAO accountDAO;
	
	public AccountService() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");		
		this.accountDAO = (AccountDAO) ctx.getBean("AccountDAO");
	}
	public boolean checkWithdrawCondition(boolean withdraw, int membersId, int amount) {
		if(withdraw&accountDAO.selectBalacne(membersId)<amount) return true;
		return false;
	}
	
	
	public ResponseToken2legger getTokenOAuth2legger() throws JsonProcessingException {
		String url = "https://testapi.openbanking.or.kr/oauth/2.0/token";
		RequestToken2legger dto = new RequestToken2legger();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");	
		MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();	
		postParameters.add("client_id", dto.getClient_id());
		postParameters.add("client_secret", dto.getClient_secret());
		postParameters.add("scope", dto.getScope());
		postParameters.add("grant_type", dto.getGrant_type());
		HttpEntity<MultiValueMap<String, Object>> r = new HttpEntity<>(postParameters,httpHeaders);
		ResponseToken2legger tokenDTO=restTemplate.postForObject(url, r, ResponseToken2legger.class);
		return tokenDTO;
	}
	public String OAuth3legged(){
		String url = "https://testapi.openbanking.or.kr/oauth/2.0/authorize";
		RequestOAuth3legger dto = new RequestOAuth3legger();
		RestTemplate restTemplate = new RestTemplate();
		dto.setAuth_type(0);
		HttpHeaders headers = new HttpHeaders();
		return url+dto.makeQuery();
	}
	public String simpleOAuth3legged(HttpServletRequest request, String banking) {
		String url = "https://testapi.openbanking.or.kr/oauth/2.0/authorize";
		RequestOAuth3legger dto = new RequestOAuth3legger();
		return null;
	}
	
	public ResponseToken3legger getToken3legger(RequestToken3legger req) {
		RestTemplate restTemplate = new RestTemplate();
		String url ="https://testapi.openbanking.or.kr/oauth/2.0/token";
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
		postParameters.add("code", req.getCode());
		postParameters.add("client_id",req.getClient_id());
		postParameters.add("client_secret", req.getClient_secret());
		postParameters.add("redirect_uri", req.getRedirct_uri());
		postParameters.add("grant_type", req.getGrant_type());
		HttpEntity<MultiValueMap<String, Object>> r = new HttpEntity<>(postParameters,httpHeaders);
		ResponseToken3legger tokenDTO =restTemplate.postForObject(url, r, ResponseToken3legger.class);
		System.out.println(req);
		System.out.println(tokenDTO);
		return tokenDTO;
	}
	public ResponseLookupInfo getUserInfo(ResponseToken3legger token) {
		String url = "https://testapi.openbanking.or.kr/v2.0/user/me";
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "Bearer "+token.getAccess_token());
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
		parameters.add("user_seq_no", token.getUser_seq_no());
		System.out.println(token.getUser_seq_no());
		System.out.println(token.getAccess_token());
		RestTemplate template = new RestTemplate();
		HttpEntity entity = new HttpEntity(httpHeaders);
		ResponseEntity<ResponseLookupInfo> info = template.exchange(url+"?user_seq_no="+token.getUser_seq_no(), HttpMethod.GET, entity, ResponseLookupInfo.class);
		ResponseLookupInfo information = info.getBody();
	
		return information;
	}
	
	public String makeCookieString(ResponseToken3legger token, ResponseLookupInfo information) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json ="";
		LookupResList resList = information.getRes_list().get(0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("access-token", token.getAccess_token());
		map.put("refresh-token", token.getRefresh_token());
		map.put("user-seq-no",token.getUser_seq_no());
		map.put("ci", information.getUser_ci());
		map.put("name",information.getUser_name());
		map.put("fintech-num", resList.getFintech_use_num());
		json= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
		return json;
	}
	
	public ResponseWithdraw withdraw(String banking, int amount, int membersId) throws JsonParseException, JsonMappingException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://testapi.openbanking.or.kr/v2.0/transfer/withdraw/fin_num";
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = mapper.readValue(banking.replace('+',' '),new TypeReference<Map<String, String>>(){});
		
		RequestWithdraw req = new RequestWithdraw();
		BankingUtils utils = new BankingUtils();
		req.setBank_tran_id(utils.getBank_tran_id());
		req.setDps_print_content(map.get("name")+"입급");// 출금 계좌 이름넣기
		req.setTran_amt(String.valueOf(amount));
		req.setFintech_use_num(map.get("fintech-num"));
		req.setReq_client_fintech_use_num(map.get("fintech-num"));
		req.setReq_client_num(String.valueOf(membersId));
		req.setTran_dtime(BankingUtils.getTime());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "Bearer "+map.get("access-token"));
		httpHeaders.set("Content-Type", "application/json; charset=UTF-8");
		MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();	

		postParameters.add("bank_tran_id",req.getBank_tran_id());
		postParameters.add("cntr_account_type",req.getCntr_account_type());
		postParameters.add("cntr_account_num",req.getCntr_account_num());
		postParameters.add("dps_print_content",req.getDps_print_content());
		postParameters.add("fintech_use_num",req.getFintech_use_num());
		postParameters.add("wd_print_content",req.getWd_print_content());
		postParameters.add("tran_amt", req.getTran_amt());
		postParameters.add("tran_dtime",req.getTran_dtime());
		postParameters.add("req_client_name",map.get("name"));
		postParameters.add("req_client_fintech_use_num",req.getFintech_use_num());
		postParameters.add("transfer_purpose","TR");
		postParameters.add("recv_client_name",req.getRecv_client_name());
		postParameters.add("recv_client_bank_code",req.getRecv_client_bank_code());
		postParameters.add("recv_client_account_num",req.getRecv_client_account_num());
		String json = mapper.writeValueAsString(postParameters).replace("[\"", "\"").replace("]\"", "\"");
		
		
		HttpEntity<String> r = new HttpEntity<>(json,httpHeaders);
		ResponseWithdraw withdrawResult=restTemplate.postForObject(url, r, ResponseWithdraw.class);
		accountDAO.insertTranIds();
		HashMap<String, Object> params = new HashMap<>();
		params.put("membersId", membersId);
		params.put("amount", -amount);
		params.put("category", "widthraw");
		accountDAO.insertResult(params);
		return withdrawResult;
	}
	
	public ResponseDeposit deposit(HttpServletRequest request,String banking, int membersId, int amount) throws JsonParseException, JsonMappingException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://testapi.openbanking.or.kr/v2.0/transfer/deposit/fin_num";
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpSession session = request.getSession();
		ResponseToken2legger goldrushToken = (ResponseToken2legger) session.getAttribute("goldrush_openbanking");
		System.out.println("sesseion : "+goldrushToken);
		ObjectMapper mapper = new ObjectMapper();
		RequestDeposit depo = new RequestDeposit();
		Map<String, String> map = mapper.readValue(banking.replace('+',' '),new TypeReference<Map<String, String>>(){});
		System.out.println(map);

		ResponseToken2legger dto = getTokenOAuth2legger();
		
		httpHeaders.set("Authorization", "Bearer "+dto.getAccess_token());
		httpHeaders.set("Content-Type", "application/json; charset=UTF-8");
		MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
		BankingUtils utils = new BankingUtils();
		System.out.println(dto.getAccess_token());
		parameters.add("tran_no", "1");
		parameters.add("bank_tran_id", utils.getBank_tran_id());
		parameters.add("fintech_use_num",map.get("fintech-num"));
		parameters.add("print_content","goldrush");
		parameters.add("tran_amt",String.valueOf(amount));
		parameters.add("req_client_name",map.get("name"));
		parameters.add("req_client_num",String.valueOf(membersId));
		parameters.add("req_client_fintech_use_num",map.get("fintech-num"));
		parameters.add("transfer_purpose","TR");

		postParameters.add("cntr_account_type","N");
		postParameters.add("cntr_account_num",depo.getCntrt_account_num());
		postParameters.add("wd_pass_phrase","NONE");
		postParameters.add("wd_print_content",membersId+" 출금");
		postParameters.add("name_check_option","on");
		postParameters.add("tran_dtime",BankingUtils.getTime());
		postParameters.add("req_cnt","1");
		postParameters.add("req_list",parameters);
		System.out.println(postParameters);
		String json = mapper.writeValueAsString(postParameters);
		System.out.println(json.replace("[\"", "\"").replace("\"]","\""));
		HttpEntity<String> r = new HttpEntity<>(json.replace("[\"", "\"").replace("\"]","\""),httpHeaders);
		ResponseDeposit depositResult=restTemplate.postForObject(url, r, ResponseDeposit.class);
		depositResult.getRes_list();
		accountDAO.insertTranIds();
		HashMap<String, Object> params = new HashMap<>();
		params.put("membersId", membersId);
		params.put("amount", -amount);
		params.put("category", "deposit");
		accountDAO.insertResult(params);
		System.out.println(depositResult);
		return depositResult;
	}
}
