package com.navakha.basic.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlagForKey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long FId;
	String keyname;
	Long tokenNumber;
	String tokenKey;
	public Long getFId() {
		return FId;
	}
	public void setFId(Long fId) {
		FId = fId;
	}
	public String getKeyname() {
		return keyname;
	}
	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}
	public Long getTokenNumber() {
		return tokenNumber;
	}
	public void setTokenNumber(Long tokenNumber) {
		this.tokenNumber = tokenNumber;
	}
	public String getTokenKey() {
		return tokenKey;
	}
	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	

}
