package com.navakha.basic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navakha.basic.Entities.UserDetails;

import java.lang.String;
import java.util.List;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>  {
	List<UserDetails> findByUserEmail(String useremail);
	List<UserDetails> findByUserToken(String usertoken);
}
