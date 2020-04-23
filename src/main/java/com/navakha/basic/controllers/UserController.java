package com.navakha.basic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navakha.basic.Entities.Likes;
import com.navakha.basic.Entities.Post;
import com.navakha.basic.Entities.UserDetails;
import com.navakha.basic.response.UserDetailsResponse;
import com.navakha.basic.services.UserDetailsService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserDetailsService userDetailsService;

	@PostMapping("/userLogin")
	public UserDetailsResponse insertUserDetails(@ModelAttribute UserDetails userDetails) {
		System.out.println("----------->" + userDetails);
		UserDetailsResponse response = userDetailsService.insertUserDetails(userDetails);
	return response;
	}

	@PostMapping("/hi")
	public String hiAll() {
		return "hi all";
	}

	@GetMapping("samples")
	public UserDetails getStubs() {
		UserDetails userDetails = new UserDetails();
		userDetails.setUser_id(1L);
		userDetails.setUserEmail("sanjay@sanjay.com");
		userDetails.setUserMobile("485551515");
	//	userDetails.setProfilePicture(profilePicture);
		return userDetails;
	}
	@GetMapping("samplePost")
	public Post getPostStubs() {
		return new Post() {
			private int wishes=10000;

			public int getWishes() {
				return wishes;
			}

			public void setWishes(int wishes) {
				this.wishes = wishes;
			}
		};
		
		
	}
	@GetMapping("samplePosts")
	public Likes getPostStubss() {
		Likes post=new Likes();
		
		return post;
	}

	
}
