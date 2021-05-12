package com.goldrush.dto.accountDto;

public class RequestToken2legger {
	private String client_id ="d8ef0825-f755-44a1-a768-f23fba7a4a52";
	private String client_secret="76c74923-3d80-4cf2-a0f5-a92216c3d235";
	private String scope = "oob";
	private String grant_type ="client_credentials";
	
	
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


	public String getScope() {
		return scope;
	}


	public void setScope(String scope) {
		this.scope = scope;
	}


	public String getGrant_type() {
		return grant_type;
	}


	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}


	@Override
	public String toString() {
		return "RequestToken2legger [client_id=" + client_id + ", client_secret=" + client_secret + ", scope=" + scope
				+ ", grant_type=" + grant_type + "]";
	}
	
	
}
