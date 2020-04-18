package com.navakha.basic.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import com.navakha.basic.Entities.Comment;
import com.navakha.basic.Entities.Post;
import com.navakha.basic.VO.CommentVO;
import com.navakha.basic.VO.PostVO;
import com.navakha.basic.miscellaneous.BASE64DecodedMultipartFile;
import com.navakha.basic.repositories.FlagforKeyRepository;
import com.navakha.basic.repositories.UserDetailsRepository;
import com.navakha.basic.services.UserDetailsService;

@Service
public class PostAndCommentUtil {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	FlagforKeyRepository flagforKeyRepository;
	public static List<CommentVO> makeCommentVOList(Set<Comment> commentList)
	{
		List<CommentVO> commentVOList=new ArrayList<CommentVO>();
		commentList.forEach(comment->{
			CommentVO commentVO=new CommentVO();
			commentVO.setComment(comment.getComment());
			commentVO.setCommentId(comment.getCommentId());
			commentVO.setByUserToken(comment.getByUserToken());
			commentVO.setPostId(comment.getPost().getPostId());
			commentVOList.add(commentVO);
		});
		
		return commentVOList;
		
	}
	public static List<PostVO> makePostVOList(List<Post> postList)
	{
		List<PostVO> postVOList=new ArrayList<PostVO>();
		postList.forEach(post->{
			PostVO postVO=new PostVO();
			postVO.setPostedUserToken(post.getPostedUserToken());
			postVO.setPostId(post.getPostId());
			postVO.setPhotoStatus(post.getPhotoStatus());
			postVO.setTextStatus(post.getTextStatus());
			postVO.setPhotoDirectory(post.getPhotoDirectory());
			postVO.setPostedAtLatttitude(post.getPostedAtLatttitude());
			postVO.setPostedAtLongitude(post.getPostedAtLongitude());
			postVO.setTimeStamp(post.getTimeStamp());
			postVO.setComments(makeCommentVOList(post.getComments()));
			postVOList.add(postVO);
		});
	//	populatePhotosPostFromDirectory(postVOList);
		
		return postVOList;
		
	}


 
}
