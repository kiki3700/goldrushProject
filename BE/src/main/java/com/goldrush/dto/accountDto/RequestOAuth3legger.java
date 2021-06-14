package com.goldrush.dto.accountDto;

import org.springframework.context.support.GenericXmlApplicationContext;

public class RequestOAuth3legger {
	
	
	private String response_type;
	private String client_id;
	private String redirect_uri;
	private String scope ;
	private String state;
	private int auth_type;
	private String Kftc_Bfop_UserSeqNo;
	private String Kftc_Bfop_UserCI;
	private String Kftc_Bfop_AccessToken;

	
	
	public RequestOAuth3legger() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:env.xml");
		this.response_type="code";
		this.client_id="d8ef0825-f755-44a1-a768-f23fba7a4a52";
		this.redirect_uri=(String) ctx.getBean("ip")+"bank/auth_second";
		this.scope="login inquiry transfer";
		this.state="b80BLsfigm9OokPTjy03elbJqRHOfGSY";
		
	}
	public String getResponse_type() {
		return response_type;
	}
	public void setResponse_type(String response_type) {
		this.response_type = response_type;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getRedirect_uri() {
		return redirect_uri;
	}
	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAuth_type() {
		return auth_type;
	}
	public void setAuth_type(int auth_type) {
		this.auth_type = auth_type;
	}
	public String getKftc_Bfop_UserSeqNo() {
		return Kftc_Bfop_UserSeqNo;
	}
	public void setKftc_Bfop_UserSeqNo(String kftc_Bfop_UserSeqNo) {
		Kftc_Bfop_UserSeqNo = kftc_Bfop_UserSeqNo;
	}
	public String getKftc_Bfop_UserCI() {
		return Kftc_Bfop_UserCI;
	}
	public void setKftc_Bfop_UserCI(String kftc_Bfop_UserCI) {
		Kftc_Bfop_UserCI = kftc_Bfop_UserCI;
	}
	public String getKftc_Bfop_AccessToken() {
		return Kftc_Bfop_AccessToken;
	}
	public void setKftc_Bfop_AccessToken(String kftc_Bfop_AccessToken) {
		Kftc_Bfop_AccessToken = kftc_Bfop_AccessToken;
	}
	@Override
	public String toString() {
		return "RequestOAuth3legger [response_type=" + response_type + ", redirect_uri=" + redirect_uri + ", scope="
				+ scope + ", auth_type=" + auth_type + ", Kftc_Bfop_UserSeqNo=" + Kftc_Bfop_UserSeqNo
				+ ", Kftc_Bfop_UserCI=" + Kftc_Bfop_UserCI + ", Kftc_Bfop_AccessToken=" + Kftc_Bfop_AccessToken + "]";
	}
	public String makeQuery() {
		return "?response_type="+response_type+"&client_id="+client_id+"&redirect_uri="+redirect_uri+"&scope="+scope+"&state="+state+"&auth_type="+auth_type;
	}
	
}
