package com.navakha.basic.VO;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PostVO {
	
	Long postId;
	String postedUserToken;
	MultipartFile photoStatus;
	String textStatus;
	String photoDirectory;
	String postedAtLatttitude;
	String postedAtLongitude;
	Date timeStamp;
	
	List<CommentVO> comments;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}


	public String getPostedUserToken() {
		return postedUserToken;
	}

	public void setPostedUserToken(String postedUserToken) {
		this.postedUserToken = postedUserToken;
	}


	public MultipartFile getPhotoStatus() {
		return photoStatus;
	}

	public void setPhotoStatus(MultipartFile photoStatus) {
		this.photoStatus = photoStatus;
	}

	public String getTextStatus() {
		return textStatus;
	}

	public void setTextStatus(String textStatus) {
		this.textStatus = textStatus;
	}

	public String getPhotoDirectory() {
		return photoDirectory;
	}

	public void setPhotoDirectory(String photoDirectory) {
		this.photoDirectory = photoDirectory;
	}

	public String getPostedAtLatttitude() {
		return postedAtLatttitude;
	}

	public void setPostedAtLatttitude(String postedAtLatttitude) {
		this.postedAtLatttitude = postedAtLatttitude;
	}

	public String getPostedAtLongitude() {
		return postedAtLongitude;
	}

	public void setPostedAtLongitude(String postedAtLongitude) {
		this.postedAtLongitude = postedAtLongitude;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public List<CommentVO> getComments() {
		return comments;
	}

	public void setComments(List<CommentVO> comments) {
		this.comments = comments;
	}

}
