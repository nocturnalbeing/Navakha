package com.navakha.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import javax.persistence.Transient;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.navakha.basic.Entities.Comment;
import com.navakha.basic.Entities.Post;
import com.navakha.basic.repositories.PostRepository;
import com.navakha.basic.services.PostService;
@SpringBootTest
class NavakhaAppApplicationTests {
	@Autowired
	PostRepository postRepository;
@Autowired
PostService postService ;
	@Test
	void contextLoads() {
	}
	//@Test
	public void testPosts() 
	{
		Post post=new Post();
		post.setTextStatus("hi where can i get beer");
	//	post.setPostId(2l);
	post.setPostedUserToken("NAVAKHAUSR2");
		Comment cm1=new Comment();
		cm1.setComment("you can get backside of anna merchants");
		cm1.setByUserToken("NAVAKHAUSR3");

		Comment cm2=new Comment();
		cm2.setComment("you can get infront  of anna merchants also");
		cm2.setByUserToken("NAVAKHAUSR1");
		post.addComment(cm1);
		post.addComment(cm2);
		postRepository.save(post);
		
		
	}
	@Test
	@Transactional
	public void testUploadPost() 
	{Post post=new Post();
	System.out.println(post.getPostId());
	post.setPostedUserToken("NAVAKHAUSR3");
	post.setTextStatus("how to find ATMs in");
	Post uploadedPost = postService.uploadAPost(post);
	assertEquals(post.getPostedUserToken(), uploadedPost.getPostedUserToken());
	assertEquals(post.getTextStatus(), uploadedPost.getTextStatus());
	assertNotEquals(post.getPostId(), uploadedPost.getPostId());
			
	}
	
	
	
	
}
