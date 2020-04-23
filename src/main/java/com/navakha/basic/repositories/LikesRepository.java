package com.navakha.basic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navakha.basic.Entities.Likes;
import java.lang.String;
import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Long> {
List<Likes> findByLikedUserTokenAndPostId(String likedusertoken,Long postId);
List<Likes> findByPostId(Long postId);

}
