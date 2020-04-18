package com.navakha.basic.response;

import com.navakha.basic.Entities.UserDetails;

public class UserDetailsResponse extends BaseResponse{
	
	UserDetails details;

	public UserDetails getDetails() {
		return details;
	}

	public void setDetails(UserDetails details) {
		this.details = details;
	}

}
