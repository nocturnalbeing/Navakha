package com.navakha.basic.response;

import java.util.List;

import com.navakha.basic.VO.PostVO;

public class PostsResponse extends BaseResponse{
	
	List<com.navakha.basic.VO.PostVO> posts;

	public List<PostVO> getPosts() {
		return posts;
	}

	public void setPosts(List<PostVO> posts) {
		this.posts = posts;
	}
	

}
