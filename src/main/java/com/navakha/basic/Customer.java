package com.navakha.basic;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custId;
	private String customerName;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<PhoneNumber> phoneNumbers;
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Long getId() {
		return custId;
	}
	public void setId(Long id) {
		this.custId = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void addPhoneNumber(PhoneNumber phoneNumber) 
	{	if(phoneNumber==null) {
		return;
	}
		if(phoneNumbers==null) {
			phoneNumbers=new HashSet<PhoneNumber>();
		}
		phoneNumbers.add(phoneNumber);
	}
	

}
