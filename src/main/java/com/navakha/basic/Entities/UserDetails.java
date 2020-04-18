package com.navakha.basic.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long user_id;
	@Column(name = "user_email")
	String userEmail;
		@Column(name = "user_mobile")
	String userMobile;
	@Column(name = "user_latitide")
	String userLatitide;
	@Column(name = "user_longitude")
	String userLongitude;
	@Column(name = "user_token")
	String userToken;
	@Column(name = "user_profile_pic")
	String userProfilePic;
	
	/*
	 * @Transient MultipartFile profilePicture;
	 */

	public String getUserProfilePic() {
		return userProfilePic;
	}

	public void setUserProfilePic(String userProfilePic) {
		this.userProfilePic = userProfilePic;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	/*
	 * public MultipartFile getProfilePicture() { return profilePicture; }
	 * 
	 * public void setProfilePicture(MultipartFile profilePicture) {
	 * this.profilePicture = profilePicture; }
	 */

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserLatitide() {
		return userLatitide;
	}

	public void setUserLatitide(String userLatitide) {
		this.userLatitide = userLatitide;
	}

	public String getUserLongitude() {
		return userLongitude;
	}

	public void setUserLongitude(String userLongitude) {
		this.userLongitude = userLongitude;
	}
	@Override
	public String toString() {
		return "UserDetails [user_id=" + user_id + ", userEmail=" + userEmail + ", userMobile=" + userMobile
				+ ", userLatitide=" + userLatitide + ", userLongitude=" + userLongitude + ", userToken=" + userToken
				+ ", userProfilePic=" + userProfilePic + "]";
	}

}
