package com.example.fractallab.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Token {
	
	@JsonProperty("access_token")
	private String accessToken;
	
	@JsonProperty("partner_name")
	private String partnerName;
	
	@JsonProperty("partner_id")
	private String partnerId;
	
	private Long expires;
	
	@JsonProperty("token_type")
	private String tokenType;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public Long getExpires() {
		return expires;
	}

	public void setExpires(Long expires) {
		this.expires = expires;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}


}
