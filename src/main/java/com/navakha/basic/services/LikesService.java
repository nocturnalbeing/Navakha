package com.navakha.basic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navakha.basic.Entities.Likes;
import com.navakha.basic.repositories.LikesRepository;
import com.navakha.basic.response.BaseResponse;
import com.navakha.basic.response.LikesResponse;

@Service
public class LikesService {
	@Autowired
	LikesRepository likesRepository;
	
	public boolean addLike(Likes like) 
	{
		List<Likes> foundLikeList = likesRepository.findByLikedUserTokenAndPostId(like.getLikedUserToken(), like.getPostId());
		if(foundLikeList.size()==0) {
			likesRepository.save(like);
			return true;
		}
		Likes foundLike = foundLikeList.get(0);
		foundLike.setStatus(like.getStatus());
		likesRepository.save(foundLike);
		return true;
	
	}
	public Long getPostLikeCount(Long postId) 
	{
		List<Likes> likesListByPostId = likesRepository.findByPostId(postId);
		long count = likesListByPostId.stream().filter(like->like.getStatus()).count();
		return count;
		
	}
	public BaseResponse makeSuccessResponse() 
	{
		LikesResponse response=new LikesResponse();
		response.setStatus("success");
		response.setMessage("like added");
		return response;
		
	}
	public BaseResponse makeFailureResponse() 
	{
		LikesResponse response=new LikesResponse();
		response.setStatus("failure");
		response.setMessage("like not added");
		return response;
		
	}

}

