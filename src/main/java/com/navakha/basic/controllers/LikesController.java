package com.navakha.basic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navakha.basic.Entities.Likes;
import com.navakha.basic.response.BaseResponse;
import com.navakha.basic.services.LikesService;


@RestController
@RequestMapping(path = "api")
public class LikesController {
	@Autowired
public	LikesService likesService;
	
	
	@PostMapping("likes")
	public BaseResponse makeALike(@RequestBody Likes like) 
	{	
		boolean status = likesService.addLike(like);
		
		if(status) 
		{
			return likesService.makeSuccessResponse();
		}else 
		{
			return likesService.makeFailureResponse();
		}
		
	}
	@GetMapping("likes/{postId}")
	public BaseResponse getLikesCount(@PathVariable("postId") Long postId)
	{
		BaseResponse response=new BaseResponse() {
			
			
			Long likesCount=likesService.getPostLikeCount(postId);

			public Long getLikesCount() {
				return likesCount;
			}

			public void setLikesCount(Long likesCount) {
				this.likesCount = likesCount;
			}
			
			
		};
		response.setMessage("like count received");
		response.setStatus("success");
		return response;
	}

}
