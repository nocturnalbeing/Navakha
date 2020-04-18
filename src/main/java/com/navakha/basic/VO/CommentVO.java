package com.navakha.basic.VO;

public class CommentVO {
	Long commentId;
	String comment;
	String byUserToken;
	Long postId;

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


	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getByUserToken() {
		return byUserToken;
	}

	public void setByUserToken(String byUserToken) {
		this.byUserToken = byUserToken;
	}
}
