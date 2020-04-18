package com.navakha.basic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PhoneNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long phId;
	private String phoneNumber;
	private String type;
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getId() {
		return phId;
	}

	public void setId(long id) {
		this.phId = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
