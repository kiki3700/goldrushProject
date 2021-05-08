package com.goldrush.service.accountService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.goldrush.dto.accountDto.RequestOAuth3legger;
import com.goldrush.dto.accountDto.RequestToken2legger;
import com.goldrush.dto.accountDto.RequestToken3legger;
import com.goldrush.dto.accountDto.ResponseToken2legger;
import com.goldrush.dto.accountDto.ResponseToken3legger;

public class AccountService {
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
	public String simpleOAuth3legged() {
		
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
		ResponseToken3legger tokenDTO = tokenDTO=restTemplate.postForObject(url, r, ResponseToken3legger.class);
		return tokenDTO;
	}
}
