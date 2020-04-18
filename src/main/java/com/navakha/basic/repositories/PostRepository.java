package com.navakha.basic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navakha.basic.Entities.Post;
import java.lang.Long;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
List<Post> findByPostedUserToken(String userToken);
}
