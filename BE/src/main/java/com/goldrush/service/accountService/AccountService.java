package com.goldrush.service.accountService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldrush.dao.AccountDAO;
import com.goldrush.dao.InventoryDAO;
import com.goldrush.dao.MemberDAO;
import com.goldrush.dao.OfferDAO;
import com.goldrush.dao.TradeDAO;
import com.goldrush.dto.accountDto.LookupResList;
import com.goldrush.dto.accountDto.RequestLookupInfo;
import com.goldrush.dto.accountDto.RequestOAuth3legger;
import com.goldrush.dto.accountDto.RequestToken2legger;
import com.goldrush.dto.accountDto.RequestToken3legger;
import com.goldrush.dto.accountDto.RequestWithdraw;
import com.goldrush.dto.accountDto.ResponseLookupInfo;
import com.goldrush.dto.accountDto.ResponseToken2legger;
import com.goldrush.dto.accountDto.ResponseToken3legger;
import com.goldrush.dto.accountDto.ResponseWithdraw;
import com.goldrush.util.BankingUtils;

public class AccountService {
	private AccountDAO accountDAO;
	
	public AccountService() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");		
		this.accountDAO = (AccountDAO) ctx.getBean("AccountDAO");
	}
	public boolean checkWithdrawCondition(boolean withdraw, int membersId, int amount) {
		if(withdraw&accountDAO.selectBalacne(membersId)<amount) return false;
		return true;
	}
	
	
	public ResponseToken2legger getTokenOAuth2legger() {
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
	public String simpleOAuth3legged(HttpServletRequest request) {
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
		UriComponentsBuilder builder  =UriComponentsBuilder.fromHttpUrl(url).queryParam("user_seq_no", token.getUser_seq_no());
		System.out.println(url);
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
		LookupResList resList = information.getRes_list().get(1);
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
		Map<String, String> map = mapper.readValue(banking,new TypeReference<Map<String, String>>(){});
		
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
		HttpEntity<MultiValueMap<String, Object>> r = new HttpEntity<>(postParameters,httpHeaders);
		ResponseWithdraw withdrawResult=restTemplate.postForObject(url, r, ResponseWithdraw.class);
		accountDAO.insertWithdrawResult(membersId, amount);
		return null;
	}
}
