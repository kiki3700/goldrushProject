package com.goldrush.dto.accountDto;

public class RequestToken3legger {
	private String code;
	private String client_id="d8ef0825-f755-44a1-a768-f23fba7a4a52";
	private String client_secret="76c74923-3d80-4cf2-a0f5-a92216c3d235";
	private String redirct_uri="http://3.36.216.37/bank/auth_second";
	private final String grant_type ="authorization_code";
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getClient_secret() {
		return client_secret;
	}
	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}
	public String getRedirct_uri() {
		return redirct_uri;
	}
	public void setRedirct_uri(String redirct_uri) {
		this.redirct_uri = redirct_uri;
	}
	public String getGrant_type() {
		return grant_type;
	}

	@Override
	public String toString() {
		return "RequestToken3legger [code=" + code + ", client_id=" + client_id + ", client_secret=" + client_secret
				+ ", redirct_uri=" + redirct_uri + ", grant_type=" + grant_type + "]";
	}
	
}
