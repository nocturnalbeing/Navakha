package com.navakha.basic.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long commentId;
	String comment;
	String byUserToken;

	@ManyToOne
	@JoinColumn(name = "belongs_to_post_id")
	Post post;
	public String getByUserToken() {
		return byUserToken;
	}

	public void setByUserToken(String byUserToken) {
		this.byUserToken = byUserToken;
	}


	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}


}
