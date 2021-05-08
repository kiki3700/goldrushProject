package com.goldrush.dto.accountDto;

public class ResponseToken2legger {
	private String access_token;
	private String token_type ="Bearer";
	private int expires_in;
	private String scope = "oob";
	private String client_use_code=	"F001234560";
	
	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getClient_use_code() {
		return client_use_code;
	}

	public void setClient_use_code(String client_use_code) {
		this.client_use_code = client_use_code;
	}

	@Override
	public String toString() {
		return "ResponseToken2legger [access_token=" + access_token + ", token_type=" + token_type + ", expires_in="
				+ expires_in + ", scope=" + scope + ", client_use_code=" + client_use_code + "]";
	}
	
}
