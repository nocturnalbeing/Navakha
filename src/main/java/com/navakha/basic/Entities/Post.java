package com.navakha.basic.Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long postId;
	String postedUserToken;
	@Transient
	MultipartFile photoStatus;
	String textStatus;
	String photoDirectory;
	String postedAtLatttitude;
	String postedAtLongitude;
	Date timeStamp;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	Set<Comment> comments;

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

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
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
	public void addComment(Comment comment) 
	{
		if(comments==null) 
		{
			System.out.println("created hash set");
			comments=new HashSet<Comment>();
		}
		comment.setPost(this);
		comments.add(comment);
		
	}
	

}
