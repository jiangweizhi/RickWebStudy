package com.rickwebstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rickwebstudy.entity.Comment;
import com.rickwebstudy.repository.custom.CommentRepositoryCustom;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom{

}
