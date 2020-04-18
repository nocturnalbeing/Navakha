package com.navakha.basic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navakha.basic.Entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
