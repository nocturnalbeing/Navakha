package com.navakha.basic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navakha.basic.Entities.Post;
import com.navakha.basic.Entities.UserDetails;
import com.navakha.basic.Utils.PostAndCommentUtil;
import com.navakha.basic.VO.PostVO;
import com.navakha.basic.repositories.PostRepository;
import com.navakha.basic.repositories.UserDetailsRepository;
import com.navakha.basic.response.BaseResponse;
import com.navakha.basic.response.PostsResponse;
import com.navakha.basic.services.PostService;

@RestController
@RequestMapping("api")
public class PostsController {
	@Autowired
	PostRepository postRepository;
	@Autowired
	UserDetailsRepository userDetailsRepository;
	@Autowired
	PostService postService;

	@GetMapping(path = "posts/{userToken}")
	public BaseResponse getPosts(@PathVariable("userToken") String userToken) {
		List<UserDetails> userList = userDetailsRepository.findByUserToken(userToken);
		if (userList.size() == 0) {
			BaseResponse response = new BaseResponse();
			response.setStatus("failed");
			response.setMessage("no user found as such with the given email");
			return response;
		}
		List<Post> postsOfUser = postRepository.findByPostedUserToken(userToken);
		PostsResponse response = new PostsResponse();
		response.setStatus("success");
		response.setMessage("posts are returned");
		List<PostVO> PostVOList = PostAndCommentUtil.makePostVOList(postsOfUser);
		postService.populatePhotosPostFromDirectory(PostVOList);
		response.setPosts(PostVOList);
		return response;
	}

	@PostMapping(path = "/posts")
	public BaseResponse postAPost(@ModelAttribute("post")Post post) {
		Post uploadedPost = postService.uploadAPost(post);
		try{if(uploadedPost.getPostId()!=0) 
		{
			BaseResponse response=new BaseResponse();
			response.setMessage("SUCCESS");
			response.setStatus("post has been saved");
			return response;
		}}catch(Exception e) 
		{
			BaseResponse response=new BaseResponse();
			response.setMessage("FAILURE");
			response.setStatus("post has not been saved");
			return response;
					}
		BaseResponse response=new BaseResponse();
		response.setMessage("FAILURE");
		response.setStatus("post has not been saved");
		return response;
		
	}
}
